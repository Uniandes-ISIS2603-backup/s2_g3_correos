(function(ng)
{
    var mod=ng.module("tarjetasCreditoModule");
    mod.constant("tarjetasCreditoContext","/tarjetasCredito");
    mod.constant("clientesContext","api/clientes");
    mod.controller("tarjetasCreditoDeleteCtrl",['$scope','$state','tarjetasCreditoContext','clientesContext','$http',
    
        /**
         * @ngdoc controller
         * @name tarjetasCredito.controller:tarjetaCreditoDeleteCtrl
         * @description
         * Definición del controlador auxiliar para eliminar TarjetasCredito. 
         * @param {Object} $scope Referencia injectada al Scope definida para este
         * controlador, el scope es el objeto que contiene las variables o 
         * funciones que se definen en este controlador y que son utilizadas 
         * desde el HTML.
         * @param {Object} $http Objeto injectado para la manejar consultas HTTP
         * @param {Object} tarjetasCreditoContext Constante injectada que contiene la ruta
         * donde se encuentra el API de TarjetasCredito en el Backend.
         * @param {Object} $state Dependencia injectada en la que se recibe el 
         * estado actual de la navegación definida en el módulo.
         * @param {Object} $rootScope Referencia injectada al Scope definida para
         * toda la aplicación.
         */
        function($scope,$state,tarjetasCreditoContext,clientesContext,$http)
        {
            var idTarjetaCredito=$state.params.tarjetaCreditoId;
            $scope.clienteId=$state.params.clienteId;
            /**
             * @ngdoc function
             * @name deleteTarjetaCredito
             * @methodOf tarjetasCredito.controller:tarjetasCreditoDeleteCtrl
             * @description
             * Esta función utiliza el protocolo HTTP para eliminar la tarjeta.
             * @param {String} id El ID de la tarjeta a eliminar.
             */
            $scope.deleteTarjetaCredito=function()
            {
                $http.delete(clientesContext+'/'+$state.params.clienteId+'/'+tarjetasCreditoContext + '/' + idTarjetaCredito, {}).then(function (response) {
                    $state.go('tarjetasCreditoList', {tarjetaCreditoId: response.data.id}, {reload: true});
                });
            };
        }
        
    ]);
    
})(window.angular);

