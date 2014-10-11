define(['model/_equipoMasterModel'], function() { 
    App.Model.EquipoMasterModel = App.Model._EquipoMasterModel.extend({

    });

    App.Model.EquipoMasterList = App.Model._EquipoMasterList.extend({
        model: App.Model.EquipoMasterModel
    });

    return  App.Model.EquipoMasterModel;

});