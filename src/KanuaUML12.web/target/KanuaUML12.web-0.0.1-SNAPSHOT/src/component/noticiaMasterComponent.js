define(['controller/selectionController', 'model/cacheModel', 'model/noticiaMasterModel', 'component/_CRUDComponent', 'controller/tabController', 'component/noticiaComponent',
 'component/tagComponent'
 
 ],function(SelectionController, CacheModel, NoticiaMasterModel, CRUDComponent, TabController, NoticiaComponent,
 tag_noticiaComponent
 ) {
    App.Component.NoticiaMasterComponent = App.Component.BasicComponent.extend({
        initialize: function() {
            var self = this;
            this.configuration = App.Utils.loadComponentConfiguration('noticiaMaster');
            var uComponent = new NoticiaComponent();
            uComponent.initialize();
            uComponent.render('main');
            Backbone.on(uComponent.componentId + '-post-noticia-create', function(params) {
                self.renderChilds(params);
            });
            Backbone.on(uComponent.componentId + '-post-noticia-edit', function(params) {
                self.renderChilds(params);
            });
            Backbone.on(uComponent.componentId + '-pre-noticia-list', function() {
                self.hideChilds();
            });
            Backbone.on('noticia-master-model-error', function(error) {
                Backbone.trigger(uComponent.componentId + '-' + 'error', {event: 'noticia-master-save', view: self, message: error});
            });
            Backbone.on(uComponent.componentId + '-instead-noticia-save', function(params) {
                self.model.set('noticiaEntity', params.model);
                if (params.model) {
                    self.model.set('id', params.model.id);
                } else {
                    self.model.unset('id');
                }
                var tag_noticiaModels = self.tag_noticiaComponent.componentController.tagModelList;
                self.model.set('listtag_noticia', []);
                self.model.set('createtag_noticia', []);
                self.model.set('updatetag_noticia', []);
                self.model.set('deletetag_noticia', []);
                for (var i = 0; i < tag_noticiaModels.models.length; i++) {
                    var m =tag_noticiaModels.models[i];
                    var modelCopy = m.clone();
                    if (m.isCreated()) {
                        //set the id to null
                        modelCopy.unset('id');
                        self.model.get('createtag_noticia').push(modelCopy.toJSON());
                    } else if (m.isUpdated()) {
                        self.model.get('updatetag_noticia').push(modelCopy.toJSON());
                    }
                }
                for (var i = 0; i < tag_noticiaModels.deletedModels.length; i++) {
                    var m = tag_noticiaModels.deletedModels[i];
                    self.model.get('deletetag_noticia').push(m.toJSON());
                }
                self.model.save({}, {
                    success: function() {
                        Backbone.trigger(uComponent.componentId + '-post-noticia-save', self);
                    },
                    error: function(error) {
                        Backbone.trigger(self.componentId + '-' + 'error', {event: 'noticia-master-save', view: self, error: error});
                    }
                });
            });
        },
        renderChilds: function(params) {
            var self = this;
            this.tabModel = new App.Model.TabModel(
                    {
                        tabs: [
                            {label: "Tag_noticia", name: "tag_noticia", enable: true},
                        ]
                    }
            );

            this.tabs = new TabController({model: this.tabModel});

            this.tabs.render('tabs');
            App.Model.NoticiaMasterModel.prototype.urlRoot = this.configuration.context;
            var options = {
                success: function() {
					self.tag_noticiaComponent = new tag_noticiaComponent();
                    self.tag_noticiaModels = App.Utils.convertToModel(App.Utils.createCacheModel(App.Model.TagModel), self.model.get('listtag_noticia'));
                    self.tag_noticiaComponent.initialize({
                        modelClass: App.Utils.createCacheModel(App.Model.TagModel),
                        listModelClass: App.Utils.createCacheList(App.Model.TagModel, App.Model.TagList, self.tag_noticiaModels)
                    });
                    self.tag_noticiaComponent.render(self.tabs.getTabHtmlId('tag_noticia'));
                    Backbone.on(self.tag_noticiaComponent.componentId + '-post-tag-create', function(params) {
                        params.view.currentTagModel.setCacheList(params.view.tagModelList);
                    });
                    self.tag_noticiaToolbarModel = self.tag_noticiaComponent.toolbarModel.set(App.Utils.Constans.containmentToolbarConfiguration);
                    self.tag_noticiaComponent.setToolbarModel(self.tag_noticiaToolbarModel);
                	
                     
                
                    Backbone.on(self.tag_noticiaComponent.componentId + '-toolbar-add', function() {
                        var selection = new App.Controller.SelectionController({"componentId":"tag_noticiaComponent"});
                        App.Utils.getComponentList('tagComponent', function(componentName, model) {
                            if (model.models.length == 0) {
                                alert('There is no Tag_noticias to select.');
                            } else {
                                selection.showSelectionList({list: model, name: 'name', title: 'Tag_noticia List'});
                            }
                            ;
                        });
                    });
                    Backbone.on('tag_noticiaComponent-post-selection', function(models) {
                        var cachetag_noticiaModel = App.Utils.createCacheModel(App.Model.TagModel);
                        models = App.Utils.convertToModel(cachetag_noticiaModel, models);
                        for (var i = 0; i < models.length; i++) {
                        	var model = models[i];
                        	model.setCacheList(self.tag_noticiaComponent.componentController.tagModelList);
                        	model.save('',{});
                        }
                        self.tag_noticiaComponent.componentController.showEdit=false;
                        self.tag_noticiaComponent.componentController.list();
                        
                    });
                    $('#tabs').show();
                },
                error: function() {
                    Backbone.trigger(self.componentId + '-' + 'error', {event: 'noticia-edit', view: self, id: id, data: data, error: error});
                }
            };
            if (params.id) {
                self.model = new App.Model.NoticiaMasterModel({id: params.id});
                self.model.fetch(options);
            } else {
                self.model = new App.Model.NoticiaMasterModel();
                options.success();
            }


        },
        hideChilds: function() {
            $('#tabs').hide();
        }
    });

    return App.Component.NoticiaMasterComponent;
});