define([], function() {
	App.Model.ToolbarModel = Backbone.Model.extend({
		defaults : {
			componentId : '',
			name : '-',
			title : '',
			icon : 'globe',
			showTitle : true,
			createName : 'Crear',
			showCreate : true,
			saveName : 'Guardar',
			showSave : false,
			cancelName : 'Cancelar',
			showCancel : false,
			refreshName : 'Actualizar',
			showRefresh : true,
			searchName : 'Buscar',
			searchIcon : 'glyphicon-search',
			showSearch : true,
			printName : 'Imprimir',
			printIcon : 'glyphicon-print',
			showPrint : true,
			showAddButton : false,
			addName : 'Adicionar',
			buttons : []
		},
		initialize : function() {
			this.set('buttons', new Array());
		}
	});
	return App.Model.ToolbarModel;
});