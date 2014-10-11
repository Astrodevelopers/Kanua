define(['model/_tallerMasterModel'], function() { 
    App.Model.TallerMasterModel = App.Model._TallerMasterModel.extend({

    });

    App.Model.TallerMasterList = App.Model._TallerMasterList.extend({
        model: App.Model.TallerMasterModel
    });

    return  App.Model.TallerMasterModel;

});