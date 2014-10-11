define([], function() {
    App.Model._CharlaMasterModel = Backbone.Model.extend({
		initialize: function() {
            this.on('invalid', function(model,error) {
                Backbone.trigger('charla-master-model-error', error);
            });
        },
        validate: function(attrs, options){
        	var modelMaster = new App.Model.CharlaModel();
        	if(modelMaster.validate){
            	return modelMaster.validate(attrs.charlaEntity,options);
            }
        }
    });

    App.Model._CharlaMasterList = Backbone.Collection.extend({
        model: App.Model._CharlaMasterModel,
        initialize: function() {
        }

    });
    return App.Model._CharlaMasterModel;
    
});