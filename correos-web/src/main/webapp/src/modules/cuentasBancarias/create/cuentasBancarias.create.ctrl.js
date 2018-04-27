(function(ng){
    var mod=ng.module("cuentasBancariasModule");
    mod.constant("cuentasBancariasContext","api/cuentasBancarias");
    mod.controller('cuentasBancariasCreateCtrl',['$scope','$http','cuentasBancariasContext','$state','$rootScope',
         /**
         * @ngdoc controller
         * @name cuentasBancarias.controller:cuentasBancariasCreateCtrl
         * @description
         * Definición del controlador auxiliar para crear CuentasBancarias. 
         * @param {Object} $scope Referencia injectada al Scope definida para este
         * controlador, el scope es el objeto que contiene las variables o 
         * funciones que se definen en este controlador y que son utilizadas 
         * desde el HTML.
         * @param {Object} $http Objeto injectado para la manejar consultas HTTP
         * @param {Object} editorialContext Constante injectada que contiene la ruta
         * donde se encuentra el API de CuentasBancarias en el Backend.
         * @param {Object} $state Dependencia injectada en la que se recibe el 
         * estado actual de la navegación definida en el módulo.
         * @param {Object} $rootScope Referencia injectada al Scope definida para
         * toda la aplicación.
         */
        function($scope,$http,cuentasBancariasContext,$state,$rootScope)
        {
            $rootScope.edit=false;
            $scope.data={};
            
            /**
             * @ngdoc function
             * @name createCuentaBancaria
             * @methodOf cuentasBancarias.controller:cuentaBancariaNewCtrl
             * @description
             * Esta función utiliza el protocolo HTTP para crear el CuentaBancaria.
             * @param {Object} CuentaBancaria Objeto con el nuevo CuentaBancaria.
             */
            $scope.createCuentaBancaria=function()
            {
                $http.post(cuentasBancariasContext,$scope.data).then(function(response)
                {
                    $state.go('cuentasBancariasList',{cuentaBancariaId:response.data.id}, {reload:true});
                });
            };
        }
        
    ]);
})(window.angular);

