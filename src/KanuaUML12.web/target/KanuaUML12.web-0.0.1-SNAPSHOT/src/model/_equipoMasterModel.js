define([], function() {
    App.Model._EquipoMasterModel = Backbone.Model.extend({
		initialize: function() {
            this.on('invalid', function(model,error) {
                Backbone.trigger('equipo-master-model-error', error);
            });
        },
        validate: function(attrs, options){
        	var modelMaster = new App.Model.EquipoModel();
        	if(modelMaster.validate){
            	return modelMaster.validate(attrs.equipoEntity,options);
            }
        }
    });

    App.Model._EquipoMasterList = Backbone.Collection.extend({
        model: App.Model._EquipoMasterModel,
        initialize: function() {
        }

    });
    return App.Model._EquipoMasterModel;
    
});