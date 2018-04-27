(function(ng)
{
    var mod=ng.module("cuentasBancariasModule");
    mod.constant("cuentasBancariasContext","api/cuentasBancarias");
    
    mod.controller("cuentaBancariaDeleteCtrl",['$scope','$state','cuentasBancariasContext','$http',
    
        /**
         * @ngdoc controller
         * @name cuentasBancarias.controller:cuentaBancariaDeleteCtrl
         * @description
         * Definición del controlador auxiliar para eliminar CuentasBancarias. 
         * @param {Object} $scope Referencia injectada al Scope definida para este
         * controlador, el scope es el objeto que contiene las variables o 
         * funciones que se definen en este controlador y que son utilizadas 
         * desde el HTML.
         * @param {Object} $http Objeto injectado para la manejar consultas HTTP
         * @param {Object} cuentasBancariasContext Constante injectada que contiene la ruta
         * donde se encuentra el API de CuentasBancarias en el Backend.
         * @param {Object} $state Dependencia injectada en la que se recibe el 
         * estado actual de la navegación definida en el módulo.
         * @param {Object} $rootScope Referencia injectada al Scope definida para
         * toda la aplicación.
         */
        function($scope,$state,cuentasBancariasContext,$http)
        {
            var idCuentaBancaria=$state.params.cuentaBancariaId;
            
            /**
             * @ngdoc function
             * @name deleteCuentaBancaria
             * @methodOf cuentasBancarias.controller:cuentasBancariasDeleteCtrl
             * @description
             * Esta función utiliza el protocolo HTTP para eliminar la editorial.
             * @param {String} id El ID de la editorial a eliminar.
             */
            $scope.deleteCuentaBancaria=function()
            {
                $http.delete(cuentasBancariasContext + '/' + idCuentaBancaria, {}).then(function (response) {
                    $state.go('cuentasBancariasList', {cuentaBancariaId: response.data.id}, {reload: true});
                });
            };
        }
        
    ]);
    
})(window.angular);
