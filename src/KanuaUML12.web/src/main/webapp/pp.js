var app = angular.module('kanua',[]);

app.controller('proyectos', function($scope, $http) {
    $scope.proyectos = [];

    $scope.getProyectos = function() {
        $http.get('/KanuaUML12.web/webresources/Proyecto').success(function (data) {
            $scope.proyectos = data;
        });
    };

    $scope.getProyectos();
});