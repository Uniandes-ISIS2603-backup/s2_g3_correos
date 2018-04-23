(function(ng){
    var mod=ng.module("clientesModule");
    mod.constant("clientesContext","api/clientes");
    mod.controller('clientesCreateCtrl',['$scope','$http','clientesContext','$state','$rootScope',
         /**
         * @ngdoc controller
         * @name clientes.controller:clientesCreateCtrl
         * @description
         * Definición del controlador auxiliar para crear Clientes. 
         * @param {Object} $scope Referencia injectada al Scope definida para este
         * controlador, el scope es el objeto que contiene las variables o 
         * funciones que se definen en este controlador y que son utilizadas 
         * desde el HTML.
         * @param {Object} $http Objeto injectado para la manejar consultas HTTP
         * @param {Object} editorialContext Constante injectada que contiene la ruta
         * donde se encuentra el API de Clientes en el Backend.
         * @param {Object} $state Dependencia injectada en la que se recibe el 
         * estado actual de la navegación definida en el módulo.
         * @param {Object} $rootScope Referencia injectada al Scope definida para
         * toda la aplicación.
         */
        function($scope,$http,clientesContext,$state,$rootScope)
        {
            $rootScope.edit=false;
            $scope.data={};
            
            /**
             * @ngdoc function
             * @name createCliente
             * @methodOf clientes.controller:clienteNewCtrl
             * @description
             * Esta función utiliza el protocolo HTTP para crear el Cliente.
             * @param {Object} Cliente Objeto con el nuevo Cliente.
             */
            $scope.createCliente=function()
            {
                $http.post(clientesContext,$scope.data).then(function(response)
                {
                    $state.go('clientesList',{clienteId:response.data.id}, {reload:true});
                });
            };
        }
        
    ]);
})(window.angular);

