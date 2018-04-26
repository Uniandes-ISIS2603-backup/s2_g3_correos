(function(ng)
{
    var mod=ng.module("pagosModule");
    mod.constant("pagosContext","/pagos");
    mod.constant("cuentasBancariasContext","api/cuentasBancarias");
    mod.controller("pagoDeleteCtrl",['$scope','$state','pagosContext','cuentasBancariasContext','$http',
    
        /**
         * @ngdoc controller
         * @name pagos.controller:pagoDeleteCtrl
         * @description
         * Definición del controlador auxiliar para eliminar Pagos. 
         * @param {Object} $scope Referencia injectada al Scope definida para este
         * controlador, el scope es el objeto que contiene las variables o 
         * funciones que se definen en este controlador y que son utilizadas 
         * desde el HTML.
         * @param {Object} $http Objeto injectado para la manejar consultas HTTP
         * @param {Object} pagosContext Constante injectada que contiene la ruta
         * donde se encuentra el API de Pagos en el Backend.
         * @param {Object} $state Dependencia injectada en la que se recibe el 
         * estado actual de la navegación definida en el módulo.
         * @param {Object} $rootScope Referencia injectada al Scope definida para
         * toda la aplicación.
         */
        function($scope,$state,pagosContext,cuentasBancariasContext,$http)
        {
            var idPago=$state.params.pagoId;
            
            /**
             * @ngdoc function
             * @name deletePago
             * @methodOf pagos.controller:pagosDeleteCtrl
             * @description
             * Esta función utiliza el protocolo HTTP para eliminar la editorial.
             * @param {String} id El ID de la editorial a eliminar.
             */
            $scope.deletePago=function()
            {
                $http.delete(cuentasBancariasContext+'/'+$state.params.cuentaBancariaId+'/'+pagosContext + '/' + idPago, {}).then(function (response) {
                    $state.go('pagosList', {pagoId: response.data.id}, {reload: true});
                });
            };
        }
        
    ]);
    
})(window.angular);
