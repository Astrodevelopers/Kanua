define(['model/_charlaMasterModel'], function() { 
    App.Model.CharlaMasterModel = App.Model._CharlaMasterModel.extend({

    });

    App.Model.CharlaMasterList = App.Model._CharlaMasterList.extend({
        model: App.Model.CharlaMasterModel
    });

    return  App.Model.CharlaMasterModel;

});