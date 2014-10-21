define(['controller/selectionController', 'model/cacheModel', 'model/proyectoMasterModel', 'component/_CRUDComponent', 'controller/tabController', 'component/proyectoComponent',
 'component/tagComponent'
 ,
 'component/objetivoComponent'
 ,
 'model/equipoMasterModel'
 ],function(SelectionController, CacheModel, ProyectoMasterModel, CRUDComponent, TabController, ProyectoComponent,
 tag_proyectoComponent
 ,
 objetivo_proyectoComponent
 ,
 EquipoMasterModel
 ) {
    App.Component.ProyectoMasterComponent = App.Component.BasicComponent.extend({
        initialize: function() {
            var self = this;
            this.configuration = App.Utils.loadComponentConfiguration('proyectoMaster');
            var uComponent = new ProyectoComponent();
            uComponent.initialize();
            uComponent.render('main');

            Backbone.on(uComponent.componentId + '-post-proyecto-mostrar-info', function(params) {
                configurationEquipoMaster = App.Utils.loadComponentConfiguration('equipoMaster');
                App.Model.EquipoMasterModel.prototype.urlRoot = configurationEquipoMaster.context;
                modelEquipoMaster = new App.Model.EquipoMasterModel({id: params.equipoId});
                var options = {
                    success: function() {
                        usuariosEquipo=modelEquipoMaster.get('listusuario_equipo');
                        cadena = '<div style="font-weight: bold; color: #338585; font-size: 14px;">Integrantes:</div>';
                        cadena += '<table width="100%">';
                        cadena += '<tr>';
                        cadena += '<th>Nombre</th>';
                        cadena += '<th>Correo</th>';
                        cadena += '</tr>';
                        for (var i = 0; i < usuariosEquipo.length; i++) {
                           usuarioEquipo = usuariosEquipo[i];
                           cadena += '<tr>';
                           cadena += '<td>'+usuarioEquipo.name+'</td>';
                           cadena += '<td>'+usuarioEquipo.email+'</td>';
                           cadena += '</tr>';
                        }
                        cadena += '</table>';
                        $('#informacion-usuarios-equipo').html(cadena);
                    },
                    error: function() {
                    }
                };
                modelEquipoMaster.fetch(options);
            });
            
            Backbone.on('buscarProyectosPorTag', function(params) {
                listaProyectos=uComponent.componentController.proyectoModelList.models;
                for (var j = 0; j < listaProyectos.length; j++) {
                    proyecto=listaProyectos[j];
                    $('#celda-proyecto-'+proyecto.id).hide();
                }
                // https://www.inkling.com/read/javascript-definitive-guide-david-flanagan-6th/chapter-18/getting-an-http-response
                var tag=$('#tagbusqueda').val();
                var request = new XMLHttpRequest();
                request.open("GET", "/KanuaUML12.web/webresources/ProyectoMaster/buscarProyectosPorTag?tag="+tag);
                request.onreadystatechange = function() {
                    // http://www.w3schools.com/ajax/ajax_xmlhttprequest_onreadystatechange.asp
                    if (request.readyState === 4 && request.status === 200) {
                        respuesta=request.responseText;
                        ids=respuesta.split(',');
                        for (u=0; u<ids.length; u++) {
                           id=ids[u];
                           if (id!="") {
                               $('#celda-proyecto-'+id).show();
                           }
                        }
                    }
                };
                request.send(null);
            }); 
            
            Backbone.on('procesarContacto', function(params) {
                var name = $('#nombre_contacto').val();
                var email = $('#email_contacto').val();
                var text = $('#styled').val();                
                var url = "/KanuaUML12.web/webresources/ProyectoMaster"; // TODO
                var parameters = "name=" + name + "&email=" + email + "&text=" + text;
                alert(parameters);
                
                /**
                http.open("POST", url, true);

                //Send the proper header information along with the request
                http.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
                http.setRequestHeader("Content-length", params.length);
                http.setRequestHeader("Connection", "close");

                http.onreadystatechange = function() {//Call a function when the state changes.
                        if(http.readyState == 4 && http.status == 200) {
                                alert(http.responseText);
                        }
                }
                http.send(params);
                **/
            });

            Backbone.on(uComponent.componentId + '-generar-contacto', function(params) {
                $('#'+uComponent.componentId+'-main-toolbar').html("");
                uComponent.componentController.generarContacto(params);
            });

            //Esto recibe el disparo de backbone y llama al controlador para que ejecute mostrarInfoProyecto
            Backbone.on(uComponent.componentId + '-proyecto-mostrar-info', function(params) {
                $('#'+uComponent.componentId+'-main-toolbar').html("");
                uComponent.componentController.mostrarInfoProyecto(params);
            });
            
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