define(['controller/selectionController', 'model/cacheModel', 'model/tallerMasterModel', 'component/_CRUDComponent', 'controller/tabController', 'component/tallerComponent',
 'component/tagComponent'
 ,
 'component/usuarioComponent'
 
 ],function(SelectionController, CacheModel, TallerMasterModel, CRUDComponent, TabController, TallerComponent,
 tag_tallerComponent
 ,
 usuarioComponent
 ) {
    App.Component.TallerMasterComponent = App.Component.BasicComponent.extend({
        initialize: function() {
            var self = this;
            this.configuration = App.Utils.loadComponentConfiguration('tallerMaster');
            var uComponent = new TallerComponent();
            uComponent.initialize();
            uComponent.render('main');
            Backbone.on(uComponent.componentId + '-post-taller-create', function(params) {
                self.renderChilds(params);
            });
            Backbone.on(uComponent.componentId + '-post-taller-edit', function(params) {
                self.renderChilds(params);
            });
            Backbone.on(uComponent.componentId + '-pre-taller-list', function() {
                self.hideChilds();
            });
            Backbone.on('taller-master-model-error', function(error) {
                Backbone.trigger(uComponent.componentId + '-' + 'error', {event: 'taller-master-save', view: self, message: error});
            });
            Backbone.on(uComponent.componentId + '-instead-taller-save', function(params) {
                self.model.set('tallerEntity', params.model);
                if (params.model) {
                    self.model.set('id', params.model.id);
                } else {
                    self.model.unset('id');
                }
                var tag_tallerModels = self.tag_tallerComponent.componentController.tagModelList;
                self.model.set('listtag_taller', []);
                self.model.set('createtag_taller', []);
                self.model.set('updatetag_taller', []);
                self.model.set('deletetag_taller', []);
                for (var i = 0; i < tag_tallerModels.models.length; i++) {
                    var m =tag_tallerModels.models[i];
                    var modelCopy = m.clone();
                    if (m.isCreated()) {
                        //set the id to null
                        modelCopy.unset('id');
                        self.model.get('createtag_taller').push(modelCopy.toJSON());
                    } else if (m.isUpdated()) {
                        self.model.get('updatetag_taller').push(modelCopy.toJSON());
                    }
                }
                for (var i = 0; i < tag_tallerModels.deletedModels.length; i++) {
                    var m = tag_tallerModels.deletedModels[i];
                    self.model.get('deletetag_taller').push(m.toJSON());
                }
                var usuarioModels = self.usuarioComponent.componentController.usuarioModelList;
                self.model.set('listusuario', []);
                self.model.set('createusuario', []);
                self.model.set('updateusuario', []);
                self.model.set('deleteusuario', []);
                for (var i = 0; i < usuarioModels.models.length; i++) {
                    var m =usuarioModels.models[i];
                    var modelCopy = m.clone();
                    if (m.isCreated()) {
                        //set the id to null
                        modelCopy.unset('id');
                        self.model.get('createusuario').push(modelCopy.toJSON());
                    } else if (m.isUpdated()) {
                        self.model.get('updateusuario').push(modelCopy.toJSON());
                    }
                }
                for (var i = 0; i < usuarioModels.deletedModels.length; i++) {
                    var m = usuarioModels.deletedModels[i];
                    self.model.get('deleteusuario').push(m.toJSON());
                }
                self.model.save({}, {
                    success: function() {
                        Backbone.trigger(uComponent.componentId + '-post-taller-save', self);
                    },
                    error: function(error) {
                        Backbone.trigger(self.componentId + '-' + 'error', {event: 'taller-master-save', view: self, error: error});
                    }
                });
            });
        },
        renderChilds: function(params) {
            var self = this;
            this.tabModel = new App.Model.TabModel(
                    {
                        tabs: [
                            {label: "Tag_taller", name: "tag_taller", enable: true},
                            ,
                            {label: "Usuario", name: "usuario", enable: true},
                        ]
                    }
            );

            this.tabs = new TabController({model: this.tabModel});

            this.tabs.render('tabs');
            App.Model.TallerMasterModel.prototype.urlRoot = this.configuration.context;
            var options = {
                success: function() {
					self.tag_tallerComponent = new tag_tallerComponent();
                    self.tag_tallerModels = App.Utils.convertToModel(App.Utils.createCacheModel(App.Model.TagModel), self.model.get('listtag_taller'));
                    self.tag_tallerComponent.initialize({
                        modelClass: App.Utils.createCacheModel(App.Model.TagModel),
                        listModelClass: App.Utils.createCacheList(App.Model.TagModel, App.Model.TagList, self.tag_tallerModels)
                    });
                    self.tag_tallerComponent.render(self.tabs.getTabHtmlId('tag_taller'));
                    Backbone.on(self.tag_tallerComponent.componentId + '-post-tag-create', function(params) {
                        params.view.currentTagModel.setCacheList(params.view.tagModelList);
                    });
					self.usuarioComponent = new usuarioComponent();
                    self.usuarioModels = App.Utils.convertToModel(App.Utils.createCacheModel(App.Model.UsuarioModel), self.model.get('listusuario'));
                    self.usuarioComponent.initialize({
                        modelClass: App.Utils.createCacheModel(App.Model.UsuarioModel),
                        listModelClass: App.Utils.createCacheList(App.Model.UsuarioModel, App.Model.UsuarioList, self.usuarioModels)
                    });
                    self.usuarioComponent.render(self.tabs.getTabHtmlId('usuario'));
                    Backbone.on(self.usuarioComponent.componentId + '-post-usuario-create', function(params) {
                        params.view.currentUsuarioModel.setCacheList(params.view.usuarioModelList);
                    });
                    self.tag_tallerToolbarModel = self.tag_tallerComponent.toolbarModel.set(App.Utils.Constans.referenceToolbarConfiguration);
                    self.tag_tallerComponent.setToolbarModel(self.tag_tallerToolbarModel);                    
                    self.usuarioToolbarModel = self.usuarioComponent.toolbarModel.set(App.Utils.Constans.containmentToolbarConfiguration);
                    self.usuarioComponent.setToolbarModel(self.usuarioToolbarModel);
                	
                     
                
                    Backbone.on(self.usuarioComponent.componentId + '-toolbar-add', function() {
                        var selection = new App.Controller.SelectionController({"componentId":"usuarioComponent"});
                        App.Utils.getComponentList('usuarioComponent', function(componentName, model) {
                            if (model.models.length == 0) {
                                alert('There is no Usuarios to select.');
                            } else {
                                selection.showSelectionList({list: model, name: 'name', title: 'Usuario List'});
                            }
                            ;
                        });
                    });
                    Backbone.on('usuarioComponent-post-selection', function(models) {
                        var cacheusuarioModel = App.Utils.createCacheModel(App.Model.UsuarioModel);
                        models = App.Utils.convertToModel(cacheusuarioModel, models);
                        for (var i = 0; i < models.length; i++) {
                        	var model = models[i];
                        	model.setCacheList(self.usuarioComponent.componentController.usuarioModelList);
                        	model.save('',{});
                        }
                        self.usuarioComponent.componentController.showEdit=false;
                        self.usuarioComponent.componentController.list();
                        
                    });
                    $('#tabs').show();
                },
                error: function() {
                    Backbone.trigger(self.componentId + '-' + 'error', {event: 'taller-edit', view: self, id: id, data: data, error: error});
                }
            };
            if (params.id) {
                self.model = new App.Model.TallerMasterModel({id: params.id});
                self.model.fetch(options);
            } else {
                self.model = new App.Model.TallerMasterModel();
                options.success();
            }


        },
        hideChilds: function() {
            $('#tabs').hide();
        }
    });

    return App.Component.TallerMasterComponent;
});