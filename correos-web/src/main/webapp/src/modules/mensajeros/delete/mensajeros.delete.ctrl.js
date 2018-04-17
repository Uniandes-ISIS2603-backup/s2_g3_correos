(function(ng)
{
    var mod=ng.module("mensajerosModule");
    mod.constant("mensajerosContext","api/mensajeros");
    
    mod.controller("mensajeroDeleteCtrl",['$scope','$state','mensajerosContext','$http',
    
        /**
         * @ngdoc controller
         * @name mensajeros.controller:mensajeroDeleteCtrl
         * @description
         * Definición del controlador auxiliar para eliminar Mensajeros. 
         * @param {Object} $scope Referencia injectada al Scope definida para este
         * controlador, el scope es el objeto que contiene las variables o 
         * funciones que se definen en este controlador y que son utilizadas 
         * desde el HTML.
         * @param {Object} $http Objeto injectado para la manejar consultas HTTP
         * @param {Object} mensajerosContext Constante injectada que contiene la ruta
         * donde se encuentra el API de Mensajeros en el Backend.
         * @param {Object} $state Dependencia injectada en la que se recibe el 
         * estado actual de la navegación definida en el módulo.
         * @param {Object} $rootScope Referencia injectada al Scope definida para
         * toda la aplicación.
         */
        function($scope,$state,mensajerosContext,$http)
        {
            var idMensajero=$state.params.mensajeroId;
            
            /**
             * @ngdoc function
             * @name deleteMensajero
             * @methodOf mensajeros.controller:mensajerosDeleteCtrl
             * @description
             * Esta función utiliza el protocolo HTTP para eliminar la editorial.
             * @param {String} id El ID de la editorial a eliminar.
             */
            $scope.deleteMensajero=function()
            {
                $http.delete(mensajerosContext + '/' + idMensajero, {}).then(function (response) {
                    $state.go('mensajerosList', {mensajeroId: response.data.id}, {reload: true});
                });
            };
        }
        
    ]);
    
})(window.angular);
