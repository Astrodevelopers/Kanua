define([], function() {
    App.Model._NoticiaMasterModel = Backbone.Model.extend({
		initialize: function() {
            this.on('invalid', function(model,error) {
                Backbone.trigger('noticia-master-model-error', error);
            });
        },
        validate: function(attrs, options){
        	var modelMaster = new App.Model.NoticiaModel();
        	if(modelMaster.validate){
            	return modelMaster.validate(attrs.noticiaEntity,options);
            }
        }
    });

    App.Model._NoticiaMasterList = Backbone.Collection.extend({
        model: App.Model._NoticiaMasterModel,
        initialize: function() {
        }

    });
    return App.Model._NoticiaMasterModel;
    
});