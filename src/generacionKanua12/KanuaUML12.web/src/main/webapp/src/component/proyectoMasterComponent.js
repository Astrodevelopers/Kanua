define(['controller/selectionController', 'model/cacheModel', 'model/proyectoMasterModel', 'component/_CRUDComponent', 'controller/tabController', 'component/proyectoComponent',
 'component/tagComponent'
 ,
 'component/objetivoComponent'
 
 ],function(SelectionController, CacheModel, ProyectoMasterModel, CRUDComponent, TabController, ProyectoComponent,
 tag_proyectoComponent
 ,
 objetivo_proyectoComponent
 ) {
    App.Component.ProyectoMasterComponent = App.Component.BasicComponent.extend({
        initialize: function() {
            var self = this;
            this.configuration = App.Utils.loadComponentConfiguration('proyectoMaster');
            var uComponent = new ProyectoComponent();
            uComponent.initialize();
            uComponent.render('main');
            Backbone.on(uComponent.componentId + '-post-proyecto-create', function(params) {
                self.renderChilds(params);
            });
            Backbone.on(uComponent.componentId + '-post-proyecto-edit', function(params) {
                self.renderChilds(params);
            });
            Backbone.on(uComponent.componentId + '-pre-proyecto-list', function() {
                self.hideChilds();
            });
            Backbone.on('proyecto-master-model-error', function(error) {
                Backbone.trigger(uComponent.componentId + '-' + 'error', {event: 'proyecto-master-save', view: self, message: error});
            });
            Backbone.on(uComponent.componentId + '-instead-proyecto-save', function(params) {
                self.model.set('proyectoEntity', params.model);
                if (params.model) {
                    self.model.set('id', params.model.id);
                } else {
                    self.model.unset('id');
                }
                var tag_proyectoModels = self.tag_proyectoComponent.componentController.tagModelList;
                self.model.set('listtag_proyecto', []);
                self.model.set('createtag_proyecto', []);
                self.model.set('updatetag_proyecto', []);
                self.model.set('deletetag_proyecto', []);
                for (var i = 0; i < tag_proyectoModels.models.length; i++) {
                    var m =tag_proyectoModels.models[i];
                    var modelCopy = m.clone();
                    if (m.isCreated()) {
                        //set the id to null
                        modelCopy.unset('id');
                        self.model.get('createtag_proyecto').push(modelCopy.toJSON());
                    } else if (m.isUpdated()) {
                        self.model.get('updatetag_proyecto').push(modelCopy.toJSON());
                    }
                }
                for (var i = 0; i < tag_proyectoModels.deletedModels.length; i++) {
                    var m = tag_proyectoModels.deletedModels[i];
                    self.model.get('deletetag_proyecto').push(m.toJSON());
                }
                var objetivo_proyectoModels = self.objetivo_proyectoComponent.componentController.objetivoModelList;
                self.model.set('listobjetivo_proyecto', []);
                self.model.set('createobjetivo_proyecto', []);
                self.model.set('updateobjetivo_proyecto', []);
                self.model.set('deleteobjetivo_proyecto', []);
                for (var i = 0; i < objetivo_proyectoModels.models.length; i++) {
                    var m =objetivo_proyectoModels.models[i];
                    var modelCopy = m.clone();
                    if (m.isCreated()) {
                        //set the id to null
                        modelCopy.unset('id');
                        self.model.get('createobjetivo_proyecto').push(modelCopy.toJSON());
                    } else if (m.isUpdated()) {
                        self.model.get('updateobjetivo_proyecto').push(modelCopy.toJSON());
                    }
                }
                for (var i = 0; i < objetivo_proyectoModels.deletedModels.length; i++) {
                    var m = objetivo_proyectoModels.deletedModels[i];
                    self.model.get('deleteobjetivo_proyecto').push(m.toJSON());
                }
                self.model.save({}, {
                    success: function() {
                        Backbone.trigger(uComponent.componentId + '-post-proyecto-save', self);
                    },
                    error: function(error) {
                        Backbone.trigger(self.componentId + '-' + 'error', {event: 'proyecto-master-save', view: self, error: error});
                    }
                });
            });
        },
        renderChilds: function(params) {
            var self = this;
            this.tabModel = new App.Model.TabModel(
                    {
                        tabs: [
                            {label: "Tag_proyecto", name: "tag_proyecto", enable: true},
                            ,
                            {label: "Objetivo_proyecto", name: "objetivo_proyecto", enable: true},
                        ]
                    }
            );

            this.tabs = new TabController({model: this.tabModel});

            this.tabs.render('tabs');
            App.Model.ProyectoMasterModel.prototype.urlRoot = this.configuration.context;
            var options = {
                success: function() {
					self.tag_proyectoComponent = new tag_proyectoComponent();
                    self.tag_proyectoModels = App.Utils.convertToModel(App.Utils.createCacheModel(App.Model.TagModel), self.model.get('listtag_proyecto'));
                    self.tag_proyectoComponent.initialize({
                        modelClass: App.Utils.createCacheModel(App.Model.TagModel),
                        listModelClass: App.Utils.createCacheList(App.Model.TagModel, App.Model.TagList, self.tag_proyectoModels)
                    });
                    self.tag_proyectoComponent.render(self.tabs.getTabHtmlId('tag_proyecto'));
                    Backbone.on(self.tag_proyectoComponent.componentId + '-post-tag-create', function(params) {
                        params.view.currentTagModel.setCacheList(params.view.tagModelList);
                    });
					self.objetivo_proyectoComponent = new objetivo_proyectoComponent();
                    self.objetivo_proyectoModels = App.Utils.convertToModel(App.Utils.createCacheModel(App.Model.ObjetivoModel), self.model.get('listobjetivo_proyecto'));
                    self.objetivo_proyectoComponent.initialize({
                        modelClass: App.Utils.createCacheModel(App.Model.ObjetivoModel),
                        listModelClass: App.Utils.createCacheList(App.Model.ObjetivoModel, App.Model.ObjetivoList, self.objetivo_proyectoModels)
                    });
                    self.objetivo_proyectoComponent.render(self.tabs.getTabHtmlId('objetivo_proyecto'));
                    Backbone.on(self.objetivo_proyectoComponent.componentId + '-post-objetivo-create', function(params) {
                        params.view.currentObjetivoModel.setCacheList(params.view.objetivoModelList);
                    });
                    self.tag_proyectoToolbarModel = self.tag_proyectoComponent.toolbarModel.set(App.Utils.Constans.referenceToolbarConfiguration);
                    self.tag_proyectoComponent.setToolbarModel(self.tag_proyectoToolbarModel);                    
                    self.objetivo_proyectoToolbarModel = self.objetivo_proyectoComponent.toolbarModel.set(App.Utils.Constans.referenceToolbarConfiguration);
                    self.objetivo_proyectoComponent.setToolbarModel(self.objetivo_proyectoToolbarModel);                    
                	
                     
                
                    $('#tabs').show();
                },
                error: function() {
                    Backbone.trigger(self.componentId + '-' + 'error', {event: 'proyecto-edit', view: self, id: id, data: data, error: error});
                }
            };
            if (params.id) {
                self.model = new App.Model.ProyectoMasterModel({id: params.id});
                self.model.fetch(options);
            } else {
                self.model = new App.Model.ProyectoMasterModel();
                options.success();
            }


        },
        hideChilds: function() {
            $('#tabs').hide();
        }
    });

    return App.Component.ProyectoMasterComponent;
});