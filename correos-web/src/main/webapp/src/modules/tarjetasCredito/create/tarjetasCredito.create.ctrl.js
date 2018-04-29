(function(ng){
    var mod=ng.module("tarjetasCreditoModule");
    mod.constant("tarjetasCreditoContext","api/tarjetasCredito");
    mod.constant("clientesContext","api/clientes");
    mod.controller('tarjetasCreditoCreateCtrl',['$scope','$http','tarjetasCreditoContext','clientesContext','$state','$rootScope',
         /**
         * @ngdoc controller
         * @name tarjetasCredito.controller:tarjetasCreditoCreateCtrl
         * @description
         * Definición del controlador auxiliar para crear TarjetasCredito. 
         * @param {Object} $scope Referencia injectada al Scope definida para este
         * controlador, el scope es el objeto que contiene las variables o 
         * funciones que se definen en este controlador y que son utilizadas 
         * desde el HTML.
         * @param {Object} $http Objeto injectado para la manejar consultas HTTP
         * @param {Object} editorialContext Constante injectada que contiene la ruta
         * donde se encuentra el API de TarjetasCredito en el Backend.
         * @param {Object} $state Dependencia injectada en la que se recibe el 
         * estado actual de la navegación definida en el módulo.
         * @param {Object} $rootScope Referencia injectada al Scope definida para
         * toda la aplicación.
         */
        function($scope,$http,tarjetasCreditoContext, clientesContext,$state,$rootScope)
        {
            $rootScope.edit=false;
            $scope.data={};
            
            /**
             * @ngdoc function
             * @name createTarjetaCredito
             * @methodOf tarjetasCredito.controller:tarjetaCreditoNewCtrl
             * @description
             * Esta función utiliza el protocolo HTTP para crear el TarjetaCredito.
             * @param {Object} TarjetaCredito Objeto con el nuevo TarjetaCredito.
             */
            $scope.createTarjetaCredito=function()
            {
                $http.post(clientesContext+'/'+$state.params.clienteId+'/'+tarjetasCreditoContext,$scope.data).then(function(response)
                {
                    $state.go('tarjetasCreditoList',{tarjetaCreditoId:response.data.id}, {reload:true});
                });
            };
        }
        
    ]);
})(window.angular);


