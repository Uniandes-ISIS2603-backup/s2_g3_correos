(function(ng)
{
    var mod=ng.module("clientesModule");
    mod.constant("clientesContext","api/clientes");
    
    mod.controller("clienteDeleteCtrl",['$scope','$state','clientesContext','$http',
    
        /**
         * @ngdoc controller
         * @name clientes.controller:clienteDeleteCtrl
         * @description
         * Definición del controlador auxiliar para eliminar Clientes. 
         * @param {Object} $scope Referencia injectada al Scope definida para este
         * controlador, el scope es el objeto que contiene las variables o 
         * funciones que se definen en este controlador y que son utilizadas 
         * desde el HTML.
         * @param {Object} $http Objeto injectado para la manejar consultas HTTP
         * @param {Object} clientesContext Constante injectada que contiene la ruta
         * donde se encuentra el API de Clientes en el Backend.
         * @param {Object} $state Dependencia injectada en la que se recibe el 
         * estado actual de la navegación definida en el módulo.
         * @param {Object} $rootScope Referencia injectada al Scope definida para
         * toda la aplicación.
         */
        function($scope,$state,clientesContext,$http)
        {
            var idCliente=$state.params.clienteId;
            
            /**
             * @ngdoc function
             * @name deleteCliente
             * @methodOf clientes.controller:clientesDeleteCtrl
             * @description
             * Esta función utiliza el protocolo HTTP para eliminar la editorial.
             * @param {String} id El ID de la editorial a eliminar.
             */
            $scope.deleteCliente=function()
            {
                $http.delete(clientesContext + '/' + idCliente, {}).then(function (response) {
                    $state.go('clientesList', {clienteId: response.data.id}, {reload: true});
                });
            };
        }
        
    ]);
    
})(window.angular);
