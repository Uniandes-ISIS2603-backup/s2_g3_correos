(function(ng){
    var mod=ng.module("mensajerosModule");
    mod.constant("mensajerosContext","api/mensajeros");
    mod.controller('mensajerosCreateCtrl',['$scope','$http','mensajerosContext','$state','$rootScope',
         /**
         * @ngdoc controller
         * @name mensajeros.controller:mensajerosCreateCtrl
         * @description
         * Definición del controlador auxiliar para crear Mensajeros. 
         * @param {Object} $scope Referencia injectada al Scope definida para este
         * controlador, el scope es el objeto que contiene las variables o 
         * funciones que se definen en este controlador y que son utilizadas 
         * desde el HTML.
         * @param {Object} $http Objeto injectado para la manejar consultas HTTP
         * @param {Object} editorialContext Constante injectada que contiene la ruta
         * donde se encuentra el API de Mensajeros en el Backend.
         * @param {Object} $state Dependencia injectada en la que se recibe el 
         * estado actual de la navegación definida en el módulo.
         * @param {Object} $rootScope Referencia injectada al Scope definida para
         * toda la aplicación.
         */
        function($scope,$http,mensajerosContext,$state,$rootScope)
        {
            $rootScope.edit=false;
            $scope.currentRecord={};
            
            /**
             * @ngdoc function
             * @name createMensajero
             * @methodOf mensajeros.controller:mensajeroNewCtrl
             * @description
             * Esta función utiliza el protocolo HTTP para crear el Mensajero.
             * @param {Object} Mensajero Objeto con el nuevo Mensajero.
             */
            $scope.createMensajero=function()
            {
                $http.post(mensajerosContext,$scope.currentRecord).then(function(response)
                {
                    $state.go('mensajerosList',{mensajeroId:response.data.id}, {reload:true});
                });
            };
        }
        
    ]);
})(window.angular);

