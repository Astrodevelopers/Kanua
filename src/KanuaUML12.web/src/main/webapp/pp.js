var app = angular.module('kanua',[]);

app.config(function($locationProvider) {
  $locationProvider.html5Mode(true);
})

app.controller('proyectos', function($scope, $http, $log, $location) {
    $scope.proyectos = [];

    $scope.getProyectos = function() {
        $http.get('/KanuaUML12.web/webresources/Proyecto').success(function (data) {
            $scope.proyectos = data;
        });
    };
    
    $scope.getProyectos();
});

app.controller('mc',  function($scope, $http, $log, $location) {
    $scope.busquedas = [{name: 'Taller 1', content: 'Blas Blas Blas'},{name: "Noticia 3", content: 'Blas Blas Blas'}];
    
    $scope.query = $location.search()['q'];
    
    if($location.search()['q']) {
        $scope.ifr = false;
    } else {
        $scope.ifr = true;
    }
})