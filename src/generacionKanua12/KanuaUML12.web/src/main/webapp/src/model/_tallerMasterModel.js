define([], function() {
    App.Model._TallerMasterModel = Backbone.Model.extend({
		initialize: function() {
            this.on('invalid', function(model,error) {
                Backbone.trigger('taller-master-model-error', error);
            });
        },
        validate: function(attrs, options){
        	var modelMaster = new App.Model.TallerModel();
        	if(modelMaster.validate){
            	return modelMaster.validate(attrs.tallerEntity,options);
            }
        }
    });

    App.Model._TallerMasterList = Backbone.Collection.extend({
        model: App.Model._TallerMasterModel,
        initialize: function() {
        }

    });
    return App.Model._TallerMasterModel;
    
});