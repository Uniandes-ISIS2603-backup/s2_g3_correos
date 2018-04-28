(function(ng){
    
    var mod=ng.module("tarjetasCreditoModule");
    mod.constant("tarjetasCreditoContext","api/tarjetasCredito");
    mod.constant("clientesContext","api/clientes");
    
    mod.controller('tarjetasCreditoUpdateCtrl',['$scope','$http','tarjetasCreditoContext','clientesContext','$state','$rootScope',
        /**
         * @ngdoc controller
         * @name tarjetasCredito.controller:tarjetasCreditoUpdateCtrl
         * @description
         * Definición del controlador auxiliar para actualizar tarjetasCredito. 
         * @param {Object} $scope Referencia injectada al Scope definida para este
         * controlador, el scope es el objeto que contiene las variables o 
         * funciones que se definen en este controlador y que son utilizadas 
         * desde el HTML.
         * @param {Object} $http Objeto injectado para la manejar consultas HTTP
         * @param {Object} tarjetasCreditoContext Constante injectada que contiene la ruta
         * donde se encuentra el API de Editoriales en el Backend.
         * @param {Object} $state Dependencia injectada en la que se recibe el 
         * estado actual de la navegación definida en el módulo.
         */
        function($scope, $http , tarjetasCreditoContext,clientesContext, $state, $rootScope)
        {
            $rootScope.edit=true;
            $scope.data={};
            var idtarjetaCredito=$state.params.tarjetaCreditoId;
            /**
             * @ngdoc function
             * @name gettarjetaCreditoID
             * @methodOf tarjetasCredito.controller:tarjetasCreditoUpdateCtrl
             * @description
             * Esta función utiliza el protocolo HTTP para obtener el recurso 
             * donde se encuentra la editorial por ID en formato JSON.
             * @param {String} URL Dirección donde se encuentra el recurso
             * del tarjetaCredito o API donde se puede consultar.
             */
            $http.get(clientesContext+'/'+$state.params.clienteId+'/'+tarjetasCreditoContext+'/'+idtarjetaCredito).then(function(response)
            {
                var tarjetaCredito=response.data;
                $scope.data.numero=tarjetaCredito.numero;
                $scope.data.fecha=tarjetaCredito.fecha;
            });
            
            /**
             * @ngdoc function
             * @name createtarjetaCredito
             * @methodOf tarjetasCredito.controller:tarjetaCreditoUpdateCtrl
             * @description
             * Esta función utiliza el protocolo HTTP para actualizar el tarjetaCredito 
             * por ID en formato JSON.
             * @param {String} id El ID del tarjetaCredito que se va a actualizar.
             * @param {Object} tarjetaCredito Objeto con la información nueva del tarjetaCredito.
             */
            $scope.createtarjetaCredito=function()
            {
                $http.put(clientesContext+'/'+$state.params.clienteId+'/'+tarjetasCreditoContext+'/'+idtarjetaCredito,$scope.data).then(function(response)
                {
                    $state.go('tarjetasCreditoList',{tarjetaCreditoId:response.params.id},{reload:true});
                });
            };
        }
    ]);
    
})(window.angular);