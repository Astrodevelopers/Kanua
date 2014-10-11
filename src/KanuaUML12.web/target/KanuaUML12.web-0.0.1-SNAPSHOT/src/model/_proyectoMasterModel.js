define([], function() {
    App.Model._ProyectoMasterModel = Backbone.Model.extend({
		initialize: function() {
            this.on('invalid', function(model,error) {
                Backbone.trigger('proyecto-master-model-error', error);
            });
        },
        validate: function(attrs, options){
        	var modelMaster = new App.Model.ProyectoModel();
        	if(modelMaster.validate){
            	return modelMaster.validate(attrs.proyectoEntity,options);
            }
        }
    });

    App.Model._ProyectoMasterList = Backbone.Collection.extend({
        model: App.Model._ProyectoMasterModel,
        initialize: function() {
        }

    });
    return App.Model._ProyectoMasterModel;
    
});