(function(ng){
    
    var mod=ng.module("cuentasBancariasModule");
    mod.constant("cuentasBancariasContext","api/cuentasBancarias");
    
    mod.controller('cuentasBancariasUpdateCtrl',['$scope','$http','cuentasBancariasContext','$state','$rootScope',
        /**
         * @ngdoc controller
         * @name cuentasBancarias.controller:cuentasBancariasUpdateCtrl
         * @description
         * Definición del controlador auxiliar para actualizar CuentasBancarias. 
         * @param {Object} $scope Referencia injectada al Scope definida para este
         * controlador, el scope es el objeto que contiene las variables o 
         * funciones que se definen en este controlador y que son utilizadas 
         * desde el HTML.
         * @param {Object} $http Objeto injectado para la manejar consultas HTTP
         * @param {Object} cuentasBancariasContext Constante injectada que contiene la ruta
         * donde se encuentra el API de Editoriales en el Backend.
         * @param {Object} $state Dependencia injectada en la que se recibe el 
         * estado actual de la navegación definida en el módulo.
         */
        function($scope, $http , cuentasBancariasContext, $state, $rootScope)
        {
            $rootScope.edit=true;
            $scope.data={};
            var idCuentaBancaria=$state.params.cuentaBancariaId;
            /**
             * @ngdoc function
             * @name getCuentaBancariaID
             * @methodOf cuentasBancarias.controller:cuentasBancariasUpdateCtrl
             * @description
             * Esta función utiliza el protocolo HTTP para obtener el recurso 
             * donde se encuentra la editorial por ID en formato JSON.
             * @param {String} URL Dirección donde se encuentra el recurso
             * del cuentaBancaria o API donde se puede consultar.
             */
            $http.get(cuentasBancariasContext+'/'+idCuentaBancaria).then(function(response)
            {
                var cuentaBancaria=response.data;
                $scope.data.name=cuentaBancaria.name;
                $scope.data.numero=cuentaBancaria.numero;
                $scope.data.banco=cuentaBancaria.banco;
                $scope.data.tipoTarjeta=cuentaBancaria.tipoTarjeta;
            });
            
            /**
             * @ngdoc function
             * @name createCuentaBancaria
             * @methodOf cuentasBancarias.controller:cuentaBancariaUpdateCtrl
             * @description
             * Esta función utiliza el protocolo HTTP para actualizar el CuentaBancaria 
             * por ID en formato JSON.
             * @param {String} id El ID del cuentaBancaria que se va a actualizar.
             * @param {Object} cuentaBancaria Objeto con la información nueva del cuentaBancaria.
             */
            $scope.createCuentaBancaria=function()
            {
                $http.put(cuentasBancariasContext+'/'+idCuentaBancaria,$scope.data).then(function(response)
                {
                    $state.go('cuentasBancariasList',{cuentaBancariaId:response.data.id},{reload:true});
                });
            };
        }
    ]);
    
})(window.angular);


