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
    $scope.busquedas = [{imagen: 'https://fbcdn-profile-a.akamaihd.net/hprofile-ak-xpf1/v/t1.0-1/p100x100/10409378_10152842279159313_3427085901855005094_n.jpg?oh=a8648d0f87237ac6bcf95ee336c093bb&oe=55080C6F&__gda__=1427656215_df9680e74b0e64815119facc856645a3', name: 'Nombre', descripcion: 'Descripcion'}];
    
    $scope.query = $location.search()['q'];
    
    if($location.search()['q']) {
        $scope.ifr = false;
    } else {
        $scope.ifr = true;
    }
    
    $scope.getCosas = function() {
        $http.get('/KanuaUML12.web/webresources/BuscarNoticias').success(function (data) {
            $scope.busquedas = data;
            $log.log(data);
        });
    };
    
    $scope.getCosas();
})