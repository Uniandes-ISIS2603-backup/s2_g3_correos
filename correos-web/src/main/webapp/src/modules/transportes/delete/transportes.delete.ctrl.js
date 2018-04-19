(function(ng)
{
    var mod=ng.module("transportesModule");
    mod.constant("transportesContext","/transportes");
    mod.constant("mensajerosContext","api/mensajeros");
    mod.controller("transportesDeleteCtrl",['$scope','$state','transportesContext','mensajerosContext','$http',
    
        /**
         * @ngdoc controller
         * @name transportes.controller:transporteDeleteCtrl
         * @description
         * Definición del controlador auxiliar para eliminar Transportes. 
         * @param {Object} $scope Referencia injectada al Scope definida para este
         * controlador, el scope es el objeto que contiene las variables o 
         * funciones que se definen en este controlador y que son utilizadas 
         * desde el HTML.
         * @param {Object} $http Objeto injectado para la manejar consultas HTTP
         * @param {Object} transportesContext Constante injectada que contiene la ruta
         * donde se encuentra el API de Transportes en el Backend.
         * @param {Object} $state Dependencia injectada en la que se recibe el 
         * estado actual de la navegación definida en el módulo.
         * @param {Object} $rootScope Referencia injectada al Scope definida para
         * toda la aplicación.
         */
        function($scope,$state,transportesContext,mensajerosContext,$http)
        {
            var idTransporte=$state.params.transporteId;
            $scope.mensajeroId=$state.params.mensajeroId;
            /**
             * @ngdoc function
             * @name deleteTransporte
             * @methodOf transportes.controller:transportesDeleteCtrl
             * @description
             * Esta función utiliza el protocolo HTTP para eliminar la editorial.
             * @param {String} id El ID de la editorial a eliminar.
             */
            $scope.deleteTransporte=function()
            {
                $http.delete(mensajerosContext+'/'+$state.params.mensajeroId+'/'+transportesContext + '/' + idTransporte, {}).then(function (response) {
                    $state.go('transportesList', {transporteId: response.data.id}, {reload: true});
                });
            };
        }
        
    ]);
    
})(window.angular);

