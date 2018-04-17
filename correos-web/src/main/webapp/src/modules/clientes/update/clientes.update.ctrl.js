(function(ng){
    
    var mod=ng.module("clientesModule");
    mod.constant("clientesContext","api/clientes");
    
    mod.controller('clientesUpdateCtrl',['$scope','$http','clientesContext','$state','$rootScope',
        /**
         * @ngdoc controller
         * @name clientes.controller:clientesUpdateCtrl
         * @description
         * Definición del controlador auxiliar para actualizar Clientes. 
         * @param {Object} $scope Referencia injectada al Scope definida para este
         * controlador, el scope es el objeto que contiene las variables o 
         * funciones que se definen en este controlador y que son utilizadas 
         * desde el HTML.
         * @param {Object} $http Objeto injectado para la manejar consultas HTTP
         * @param {Object} clientesContext Constante injectada que contiene la ruta
         * donde se encuentra el API de Editoriales en el Backend.
         * @param {Object} $state Dependencia injectada en la que se recibe el 
         * estado actual de la navegación definida en el módulo.
         */
        function($scope, $http , clientesContext, $state, $rootScope)
        {
            $rootScope.edit=true;
            $scope.data={};
            var idCliente=$state.params.clienteId;
            /**
             * @ngdoc function
             * @name getClienteID
             * @methodOf clientes.controller:clientesUpdateCtrl
             * @description
             * Esta función utiliza el protocolo HTTP para obtener el recurso 
             * donde se encuentra la editorial por ID en formato JSON.
             * @param {String} URL Dirección donde se encuentra el recurso
             * del cliente o API donde se puede consultar.
             */
            $http.get(clientesContext+'/'+idCliente).then(function(response)
            {
                var cliente=response.data;
                $scope.data.nombre=cliente.nombre;
            
            });
            
            /**
             * @ngdoc function
             * @name createCliente
             * @methodOf clientes.controller:clienteUpdateCtrl
             * @description
             * Esta función utiliza el protocolo HTTP para actualizar el Cliente 
             * por ID en formato JSON.
             * @param {String} id El ID del cliente que se va a actualizar.
             * @param {Object} cliente Objeto con la información nueva del cliente.
             */
            $scope.createCliente=function()
            {
                $http.put(clientesContext+'/'+idCliente,$scope.data).then(function(response)
                {
                    $state.go('clientesList',{clienteId:response.data.id},{reload:true});
                });
            };
        }
    ]);
    
})(window.angular);


