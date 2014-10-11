define(['controller/selectionController', 'model/cacheModel', 'model/equipoMasterModel', 'component/_CRUDComponent', 'controller/tabController', 'component/equipoComponent',
 'component/solicitudComponent'
 ,
 'component/usuarioComponent'
 
 ],function(SelectionController, CacheModel, EquipoMasterModel, CRUDComponent, TabController, EquipoComponent,
 solicitud_proyectoComponent
 ,
 usuario_equipoComponent
 ) {
    App.Component.EquipoMasterComponent = App.Component.BasicComponent.extend({
        initialize: function() {
            var self = this;
            this.configuration = App.Utils.loadComponentConfiguration('equipoMaster');
            var uComponent = new EquipoComponent();
            uComponent.initialize();
            uComponent.render('main');
            Backbone.on(uComponent.componentId + '-post-equipo-create', function(params) {
                self.renderChilds(params);
            });
            Backbone.on(uComponent.componentId + '-post-equipo-edit', function(params) {
                self.renderChilds(params);
            });
            Backbone.on(uComponent.componentId + '-pre-equipo-list', function() {
                self.hideChilds();
            });
            Backbone.on('equipo-master-model-error', function(error) {
                Backbone.trigger(uComponent.componentId + '-' + 'error', {event: 'equipo-master-save', view: self, message: error});
            });
            Backbone.on(uComponent.componentId + '-instead-equipo-save', function(params) {
                self.model.set('equipoEntity', params.model);
                if (params.model) {
                    self.model.set('id', params.model.id);
                } else {
                    self.model.unset('id');
                }
                var solicitud_proyectoModels = self.solicitud_proyectoComponent.componentController.solicitudModelList;
                self.model.set('listsolicitud_proyecto', []);
                self.model.set('createsolicitud_proyecto', []);
                self.model.set('updatesolicitud_proyecto', []);
                self.model.set('deletesolicitud_proyecto', []);
                for (var i = 0; i < solicitud_proyectoModels.models.length; i++) {
                    var m =solicitud_proyectoModels.models[i];
                    var modelCopy = m.clone();
                    if (m.isCreated()) {
                        //set the id to null
                        modelCopy.unset('id');
                        self.model.get('createsolicitud_proyecto').push(modelCopy.toJSON());
                    } else if (m.isUpdated()) {
                        self.model.get('updatesolicitud_proyecto').push(modelCopy.toJSON());
                    }
                }
                for (var i = 0; i < solicitud_proyectoModels.deletedModels.length; i++) {
                    var m = solicitud_proyectoModels.deletedModels[i];
                    self.model.get('deletesolicitud_proyecto').push(m.toJSON());
                }
                var usuario_equipoModels = self.usuario_equipoComponent.componentController.usuarioModelList;
                self.model.set('listusuario_equipo', []);
                self.model.set('createusuario_equipo', []);
                self.model.set('updateusuario_equipo', []);
                self.model.set('deleteusuario_equipo', []);
                for (var i = 0; i < usuario_equipoModels.models.length; i++) {
                    var m =usuario_equipoModels.models[i];
                    var modelCopy = m.clone();
                    if (m.isCreated()) {
                        //set the id to null
                        modelCopy.unset('id');
                        self.model.get('createusuario_equipo').push(modelCopy.toJSON());
                    } else if (m.isUpdated()) {
                        self.model.get('updateusuario_equipo').push(modelCopy.toJSON());
                    }
                }
                for (var i = 0; i < usuario_equipoModels.deletedModels.length; i++) {
                    var m = usuario_equipoModels.deletedModels[i];
                    self.model.get('deleteusuario_equipo').push(m.toJSON());
                }
                self.model.save({}, {
                    success: function() {
                        Backbone.trigger(uComponent.componentId + '-post-equipo-save', self);
                    },
                    error: function(error) {
                        Backbone.trigger(self.componentId + '-' + 'error', {event: 'equipo-master-save', view: self, error: error});
                    }
                });
            });
        },
        renderChilds: function(params) {
            var self = this;
            this.tabModel = new App.Model.TabModel(
                    {
                        tabs: [
                            {label: "Solicitud_proyecto", name: "solicitud_proyecto", enable: true},
                            ,
                            {label: "Usuario_equipo", name: "usuario_equipo", enable: true},
                        ]
                    }
            );

            this.tabs = new TabController({model: this.tabModel});

            this.tabs.render('tabs');
            App.Model.EquipoMasterModel.prototype.urlRoot = this.configuration.context;
            var options = {
                success: function() {
					self.solicitud_proyectoComponent = new solicitud_proyectoComponent();
                    self.solicitud_proyectoModels = App.Utils.convertToModel(App.Utils.createCacheModel(App.Model.SolicitudModel), self.model.get('listsolicitud_proyecto'));
                    self.solicitud_proyectoComponent.initialize({
                        modelClass: App.Utils.createCacheModel(App.Model.SolicitudModel),
                        listModelClass: App.Utils.createCacheList(App.Model.SolicitudModel, App.Model.SolicitudList, self.solicitud_proyectoModels)
                    });
                    self.solicitud_proyectoComponent.render(self.tabs.getTabHtmlId('solicitud_proyecto'));
                    Backbone.on(self.solicitud_proyectoComponent.componentId + '-post-solicitud-create', function(params) {
                        params.view.currentSolicitudModel.setCacheList(params.view.solicitudModelList);
                    });
					self.usuario_equipoComponent = new usuario_equipoComponent();
                    self.usuario_equipoModels = App.Utils.convertToModel(App.Utils.createCacheModel(App.Model.UsuarioModel), self.model.get('listusuario_equipo'));
                    self.usuario_equipoComponent.initialize({
                        modelClass: App.Utils.createCacheModel(App.Model.UsuarioModel),
                        listModelClass: App.Utils.createCacheList(App.Model.UsuarioModel, App.Model.UsuarioList, self.usuario_equipoModels)
                    });
                    self.usuario_equipoComponent.render(self.tabs.getTabHtmlId('usuario_equipo'));
                    Backbone.on(self.usuario_equipoComponent.componentId + '-post-usuario-create', function(params) {
                        params.view.currentUsuarioModel.setCacheList(params.view.usuarioModelList);
                    });
                    self.solicitud_proyectoToolbarModel = self.solicitud_proyectoComponent.toolbarModel.set(App.Utils.Constans.referenceToolbarConfiguration);
                    self.solicitud_proyectoComponent.setToolbarModel(self.solicitud_proyectoToolbarModel);                    
                    self.usuario_equipoToolbarModel = self.usuario_equipoComponent.toolbarModel.set(App.Utils.Constans.containmentToolbarConfiguration);
                    self.usuario_equipoComponent.setToolbarModel(self.usuario_equipoToolbarModel);
                	
                     
                
                    Backbone.on(self.usuario_equipoComponent.componentId + '-toolbar-add', function() {
                        var selection = new App.Controller.SelectionController({"componentId":"usuario_equipoComponent"});
                        App.Utils.getComponentList('usuarioComponent', function(componentName, model) {
                            if (model.models.length == 0) {
                                alert('There is no Usuario_equipos to select.');
                            } else {
                                selection.showSelectionList({list: model, name: 'name', title: 'Usuario_equipo List'});
                            }
                            ;
                        });
                    });
                    Backbone.on('usuario_equipoComponent-post-selection', function(models) {
                        var cacheusuario_equipoModel = App.Utils.createCacheModel(App.Model.UsuarioModel);
                        models = App.Utils.convertToModel(cacheusuario_equipoModel, models);
                        for (var i = 0; i < models.length; i++) {
                        	var model = models[i];
                        	model.setCacheList(self.usuario_equipoComponent.componentController.usuarioModelList);
                        	model.save('',{});
                        }
                        self.usuario_equipoComponent.componentController.showEdit=false;
                        self.usuario_equipoComponent.componentController.list();
                        
                    });
                    $('#tabs').show();
                },
                error: function() {
                    Backbone.trigger(self.componentId + '-' + 'error', {event: 'equipo-edit', view: self, id: id, data: data, error: error});
                }
            };
            if (params.id) {
                self.model = new App.Model.EquipoMasterModel({id: params.id});
                self.model.fetch(options);
            } else {
                self.model = new App.Model.EquipoMasterModel();
                options.success();
            }


        },
        hideChilds: function() {
            $('#tabs').hide();
        }
    });

    return App.Component.EquipoMasterComponent;
});