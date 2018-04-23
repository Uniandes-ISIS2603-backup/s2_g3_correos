(function(ng)
{
    var mod=ng.module("paquetesModule");
    mod.constant("paquetesContext","/paquetes");
    mod.constant("enviosContext","api/envios");
    mod.controller("paquetesDeleteCtrl",['$scope','$state','paquetesContext','enviosContext','$http',
    
        /**
         * @ngdoc controller
         * @name paquetes.controller:paqueteDeleteCtrl
         * @description
         * Definición del controlador auxiliar para eliminar Paquetes. 
         * @param {Object} $scope Referencia injectada al Scope definida para este
         * controlador, el scope es el objeto que contiene las variables o 
         * funciones que se definen en este controlador y que son utilizadas 
         * desde el HTML.
         * @param {Object} $http Objeto injectado para la manejar consultas HTTP
         * @param {Object} paquetesContext Constante injectada que contiene la ruta
         * donde se encuentra el API de Paquetes en el Backend.
         * @param {Object} $state Dependencia injectada en la que se recibe el 
         * estado actual de la navegación definida en el módulo.
         * @param {Object} $rootScope Referencia injectada al Scope definida para
         * toda la aplicación.
         */
        function($scope,$state,paquetesContext,enviosContext,$http)
        {
            var idPaquete=$state.params.paqueteId;
            $scope.envioId=$state.params.envioId;
            /**
             * @ngdoc function
             * @name deletePaquete
             * @methodOf paquetes.controller:paquetesDeleteCtrl
             * @description
             * Esta función utiliza el protocolo HTTP para eliminar la editorial.
             * @param {String} id El ID de la editorial a eliminar.
             */
            $scope.deletePaquete=function()
            {
                $http.delete(enviosContext+'/'+$state.params.envioId+'/'+paquetesContext + '/' + idPaquete, {}).then(function (response) {
                    $state.go('paquetesList', {paqueteId: response.data.id}, {reload: true});
                });
            };
        }
        
    ]);
    
})(window.angular);

