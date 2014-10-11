define(['model/_noticiaMasterModel'], function() { 
    App.Model.NoticiaMasterModel = App.Model._NoticiaMasterModel.extend({

    });

    App.Model.NoticiaMasterList = App.Model._NoticiaMasterList.extend({
        model: App.Model.NoticiaMasterModel
    });

    return  App.Model.NoticiaMasterModel;

});