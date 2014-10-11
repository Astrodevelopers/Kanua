define(['controller/selectionController', 'model/cacheModel', 'model/charlaMasterModel', 'component/_CRUDComponent', 'controller/tabController', 'component/charlaComponent',
 'component/tagComponent'
 
 ],function(SelectionController, CacheModel, CharlaMasterModel, CRUDComponent, TabController, CharlaComponent,
 tag_charlaComponent
 ) {
    App.Component.CharlaMasterComponent = App.Component.BasicComponent.extend({
        initialize: function() {
            var self = this;
            this.configuration = App.Utils.loadComponentConfiguration('charlaMaster');
            var uComponent = new CharlaComponent();
            uComponent.initialize();
            uComponent.render('main');
            Backbone.on(uComponent.componentId + '-post-charla-create', function(params) {
                self.renderChilds(params);
            });
            Backbone.on(uComponent.componentId + '-post-charla-edit', function(params) {
                self.renderChilds(params);
            });
            Backbone.on(uComponent.componentId + '-pre-charla-list', function() {
                self.hideChilds();
            });
            Backbone.on('charla-master-model-error', function(error) {
                Backbone.trigger(uComponent.componentId + '-' + 'error', {event: 'charla-master-save', view: self, message: error});
            });
            Backbone.on(uComponent.componentId + '-instead-charla-save', function(params) {
                self.model.set('charlaEntity', params.model);
                if (params.model) {
                    self.model.set('id', params.model.id);
                } else {
                    self.model.unset('id');
                }
                var tag_charlaModels = self.tag_charlaComponent.componentController.tagModelList;
                self.model.set('listtag_charla', []);
                self.model.set('createtag_charla', []);
                self.model.set('updatetag_charla', []);
                self.model.set('deletetag_charla', []);
                for (var i = 0; i < tag_charlaModels.models.length; i++) {
                    var m =tag_charlaModels.models[i];
                    var modelCopy = m.clone();
                    if (m.isCreated()) {
                        //set the id to null
                        modelCopy.unset('id');
                        self.model.get('createtag_charla').push(modelCopy.toJSON());
                    } else if (m.isUpdated()) {
                        self.model.get('updatetag_charla').push(modelCopy.toJSON());
                    }
                }
                for (var i = 0; i < tag_charlaModels.deletedModels.length; i++) {
                    var m = tag_charlaModels.deletedModels[i];
                    self.model.get('deletetag_charla').push(m.toJSON());
                }
                self.model.save({}, {
                    success: function() {
                        Backbone.trigger(uComponent.componentId + '-post-charla-save', self);
                    },
                    error: function(error) {
                        Backbone.trigger(self.componentId + '-' + 'error', {event: 'charla-master-save', view: self, error: error});
                    }
                });
            });
        },
        renderChilds: function(params) {
            var self = this;
            this.tabModel = new App.Model.TabModel(
                    {
                        tabs: [
                            {label: "Tag_charla", name: "tag_charla", enable: true},
                        ]
                    }
            );

            this.tabs = new TabController({model: this.tabModel});

            this.tabs.render('tabs');
            App.Model.CharlaMasterModel.prototype.urlRoot = this.configuration.context;
            var options = {
                success: function() {
					self.tag_charlaComponent = new tag_charlaComponent();
                    self.tag_charlaModels = App.Utils.convertToModel(App.Utils.createCacheModel(App.Model.TagModel), self.model.get('listtag_charla'));
                    self.tag_charlaComponent.initialize({
                        modelClass: App.Utils.createCacheModel(App.Model.TagModel),
                        listModelClass: App.Utils.createCacheList(App.Model.TagModel, App.Model.TagList, self.tag_charlaModels)
                    });
                    self.tag_charlaComponent.render(self.tabs.getTabHtmlId('tag_charla'));
                    Backbone.on(self.tag_charlaComponent.componentId + '-post-tag-create', function(params) {
                        params.view.currentTagModel.setCacheList(params.view.tagModelList);
                    });
                    self.tag_charlaToolbarModel = self.tag_charlaComponent.toolbarModel.set(App.Utils.Constans.referenceToolbarConfiguration);
                    self.tag_charlaComponent.setToolbarModel(self.tag_charlaToolbarModel);                    
                	
                     
                
                    $('#tabs').show();
                },
                error: function() {
                    Backbone.trigger(self.componentId + '-' + 'error', {event: 'charla-edit', view: self, id: id, data: data, error: error});
                }
            };
            if (params.id) {
                self.model = new App.Model.CharlaMasterModel({id: params.id});
                self.model.fetch(options);
            } else {
                self.model = new App.Model.CharlaMasterModel();
                options.success();
            }


        },
        hideChilds: function() {
            $('#tabs').hide();
        }
    });

    return App.Component.CharlaMasterComponent;
});