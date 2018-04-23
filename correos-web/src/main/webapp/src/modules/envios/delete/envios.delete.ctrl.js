(function(ng)
{
    var mod=ng.module("enviosModule");
    mod.constant("enviosContext","api/envios");
    
    mod.controller("envioDeleteCtrl",['$scope','$state','enviosContext','$http',
    
        /**
         * @ngdoc controller
         * @name envios.controller:envioDeleteCtrl
         * @description
         * Definición del controlador auxiliar para eliminar Envios. 
         * @param {Object} $scope Referencia injectada al Scope definida para este
         * controlador, el scope es el objeto que contiene las variables o 
         * funciones que se definen en este controlador y que son utilizadas 
         * desde el HTML.
         * @param {Object} $http Objeto injectado para la manejar consultas HTTP
         * @param {Object} envioContext Constante injectada que contiene la ruta
         * donde se encuentra el API de Envios en el Backend.
         * @param {Object} $state Dependencia injectada en la que se recibe el 
         * estado actual de la navegación definida en el módulo.
         * @param {Object} $rootScope Referencia injectada al Scope definida para
         * toda la aplicación.
         */
        function($scope,$state,$http,enviosContext)
        {
            var idEnvio=$state.params.envioId;
            
            /**
             * @ngdoc function
             * @name deleteEnvio
             * @methodOf envios.controller:enviosDeleteCtrl
             * @description
             * Esta función utiliza el protocolo HTTP para eliminar el envio.
             * @param {String} id El ID del envio a eliminar.
             */
            $scope.deleteEnvio=function()
            {
                $http.delete(enviosContext + '/' + idEnvio, {}).then(function (response) {
                    $state.go('enviosList', {envioId: response.data.id}, {reload: true});
                });
            };
        }
        
    ]);
    
})(window.angular);
