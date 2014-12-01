var app = angular.module('kanua', []);

app.config(function($locationProvider) {
    $locationProvider.html5Mode(true);
})

app.controller('proyectos', function($scope, $http, $log, $location) {
    $scope.proyectos = [];

    $scope.getProyectos = function() {
        $http.get('/KanuaUML12.web/webresources/Proyecto').success(function(data) {
            $scope.proyectos = data;
        });
    };

    $scope.getProyectos();
});

app.controller('mc', function($scope, $http, $log, $location) {
    $scope.busquedas = [];

    $scope.query = '';
    $scope.ifr = true;

    $scope.actualizar = function() {
        if ($scope.query.length > 1) {
            $scope.getCosas();
            $scope.ifr = false;
        } else {
            $scope.ifr = true;
        }
    };

    $scope.getCosas = function() {
        $http.get('/KanuaUML12.web/webresources/NoticiaMaster/buscarNoticias?tag=' + $scope.query).success(function(data) {
            $scope.busquedas = data;
        }).error(function(data) {
            alert('Error en la solicitud');
            $log.log(data);
        });
    };
})