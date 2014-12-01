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
        var ans = [];
        // Noticias
        var request = new XMLHttpRequest();
        request.open('GET', '/KanuaUML12.web/webresources/NoticiaMaster/buscarNoticias?tag=' + $scope.query, false);  // `false` makes the request synchronous
        request.send(null);
        if (request.status === 200) {
            ans = ans.concat(JSON.parse(request.responseText));
        }
        else
            alert('Error en la solicitud');
        var xhr = new XMLHttpRequest();
        xhr.ontimeout = function () {
            console.error("The request for " + url + " timed out.");
        };
        // Proyectos
        var request = new XMLHttpRequest();
        request.open('GET', '/KanuaUML12.web/webresources/ProyectoMaster/buscarProyectos?tag=' + $scope.query, false);  // `false` makes the request synchronous
        request.send(null);
        if (request.status === 200) {
            ans = ans.concat(JSON.parse(request.responseText));
        }
        else
            alert('Error en la solicitud');
        var xhr = new XMLHttpRequest();
        xhr.ontimeout = function () {
            console.error("The request for " + url + " timed out.");
        };
        // Charlas
        var request = new XMLHttpRequest();
        request.open('GET', '/KanuaUML12.web/webresources/CharlaMaster/buscarCharlas?tag=' + $scope.query, false);  // `false` makes the request synchronous
        request.send(null);
        if (request.status === 200) {
            ans = ans.concat(JSON.parse(request.responseText));
        }
        else
            alert('Error en la solicitud');
        var xhr = new XMLHttpRequest();
        xhr.ontimeout = function () {
            console.error("The request for " + url + " timed out.");
        };
        // Talleres
        $scope.busquedas = ans;
    };
})