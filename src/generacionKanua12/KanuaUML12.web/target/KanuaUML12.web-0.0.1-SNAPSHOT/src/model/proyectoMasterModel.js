define(['model/_proyectoMasterModel'], function() { 
    App.Model.ProyectoMasterModel = App.Model._ProyectoMasterModel.extend({

    });

    App.Model.ProyectoMasterList = App.Model._ProyectoMasterList.extend({
        model: App.Model.ProyectoMasterModel
    });

    return  App.Model.ProyectoMasterModel;

});