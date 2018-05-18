/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


(function (ng) {
    var mod = ng.module("loginModule");
    mod.controller('loginCtrl', ['$scope', '$http', '$state', '$rootScope',
        /**
         * @ngdoc controller
         * @name login.controller:loginCtrl
         * @description
         * Definición del controlador de Angular del módulo Login. 
         * Se crea el controlador con el cual se maneja el módulo.
         * En el controlador se definen los atributos y métodos que pueden
         * ser accedidos desde el HTML utilizando el $scope.
         * @param {Object} $scope Referencia injectada al Scope definida para este
         * controlador, el scope es el objeto que contiene las variables o 
         * funciones que se definen en este controlador y que son utilizadas 
         * desde el HTML.
         * @param {Object} $http Objeto injectado para la manejar consultas HTTP
         * @param {Object} $state Dependencia injectada en la que se recibe el 
         * estado actual de la navegación definida en el módulo.
         * @param {Object} $rootScope Referencia injectada al Scope definido
         * para toda la aplicación.
         */
        function ($scope, $http, $state, $rootScope) {

            $scope.users = {};
            $scope.data = {};
            $scope.user={};
            $scope.user.token=1;
            
            $scope.autenticar = function () {
                if($scope.data.role===undefined)
                {
                    $rootScope.alerts.push({type: "danger", msg: "Alto!, debes escoger un rol!"});
                    return;
                }
                else if($scope.data.role=="cliente")
                    $http.get('api/clientes').then(function (response) {
                        $scope.users = response.data;
                    });
                else if($scope.data.role=="mensajero")
                     $http.get('api/mensajeros').then(function (response) {
                        $scope.users = response.data;
                    });
                else if($scope.data.role=='administrador')
                    $http.get('data/users.json').then(function (response) {
                        console.log(response.data);
                        $scope.users = response.data;
                    });
                
                console.log($scope.data);
                var flag = false;
                

                for (var item in $scope.users) {
                    if ($scope.users[item].correo == $scope.data.correo && $scope.users[item].password == $scope.data.password) {
                        flag = true;
                        $scope.user = $scope.users[item];
                        $state.go('home', {}, {reload: true});
                        break;
                    }
                }
                if (!flag) {
                    $rootScope.alerts.push({type: "danger", msg: "Incorrect username or password."});
                } else {
                    sessionStorage.token = $scope.user.token;
                    sessionStorage.setItem("correo", $scope.user.correo);
                    sessionStorage.setItem("nombre", $scope.user.nombre);
                    sessionStorage.setItem("rol", $scope.data.role);
                    $rootScope.currentUser = $scope.user.nombre; 
                }
                
            };
           
           
        }
    ]);
}
)(window.angular);
