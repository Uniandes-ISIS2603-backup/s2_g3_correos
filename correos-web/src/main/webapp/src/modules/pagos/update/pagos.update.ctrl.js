(function(ng){
    
    var mod=ng.module("pagosModule");
    mod.constant("pagosContext","api/pagos");
    mod.constant("cuentasBancariasContext","api/cuentasBancarias");
    mod.controller('pagosUpdateCtrl',['$scope','$http','pagosContext','cuentasBancariasContext','$state','$rootScope',
        /**
         * @ngdoc controller
         * @name pagos.controller:pagosUpdateCtrl
         * @description
         * Definición del controlador auxiliar para actualizar Pagos. 
         * @param {Object} $scope Referencia injectada al Scope definida para este
         * controlador, el scope es el objeto que contiene las variables o 
         * funciones que se definen en este controlador y que son utilizadas 
         * desde el HTML.
         * @param {Object} $http Objeto injectado para la manejar consultas HTTP
         * @param {Object} pagosContext Constante injectada que contiene la ruta
         * donde se encuentra el API de Editoriales en el Backend.
         * @param {Object} $state Dependencia injectada en la que se recibe el 
         * estado actual de la navegación definida en el módulo.
         */
        function($scope, $http , pagosContext,cuentasBancariasContext, $state, $rootScope)
        {
            $rootScope.edit=true;
            $scope.data={};
            var idPago=$state.params.pagoId;
            /**
             * @ngdoc function
             * @name getPagoID
             * @methodOf pagos.controller:pagosUpdateCtrl
             * @description
             * Esta función utiliza el protocolo HTTP para obtener el recurso 
             * donde se encuentra la editorial por ID en formato JSON.
             * @param {String} URL Dirección donde se encuentra el recurso
             * del pago o API donde se puede consultar.
             */
            $http.get(cuentasBancariasContext+'/'+$state.params.cuentaBancariaId+'/'+pagosContext+'/'+idPago).then(function(response)
            {
                var pago=response.data;
                $scope.data.name=pago.name;
                $scope.data.valor=pago.valor;
                $scope.data.fecha=pago.fecha;
            });
            
            /**
             * @ngdoc function
             * @name createPago
             * @methodOf pagos.controller:pagoUpdateCtrl
             * @description
             * Esta función utiliza el protocolo HTTP para actualizar el Pago 
             * por ID en formato JSON.
             * @param {String} id El ID del pago que se va a actualizar.
             * @param {Object} pago Objeto con la información nueva del pago.
             */
            $scope.createPago=function()
            {
                $http.put(cuentasBancariasContext+'/'+$state.params.cuentaBancariaId+'/'+pagosContext+'/'+idPago,$scope.data).then(function(response)
                {
                    $state.go('pagosList',{pagoId:response.data.id},{reload:true});
                });
            };
        }
    ]);
    
})(window.angular);


