(function (ng) {
    var mod = ng.module("clientesModule");
    mod.constant("clientesContext", "api/clientes");
    mod.controller('clientesDetailCtrl', ['$scope', '$http', 'clientesContext', '$state',
         /**
         * @ngdoc controller
         * @name clientes.controller:clientesDetailCtrl
         * @description
         * Definición de un controlador auxiliar del módulo Clientes. 
         * Se crea el controlador con el cual se manejan las vistas de detalle
         * del módulo.
         * @param {Object} $scope Referencia injectada al Scope definida para este
         * controlador, el scope es el objeto que contiene las variables o 
         * funciones que se definen en este controlador y que son utilizadas 
         * desde el HTML.
         * @param {Object} $http Objeto injectado para la manejar consultas HTTP
         * @param {Object} booksContext Constante injectada que contiene la ruta
         * donde se encuentra el API de Correos en el Backend.
         * @param {Object} $state Dependencia injectada en la que se recibe el 
         * estado actual de la navegación definida en el módulo.
         */
        function($scope,$http, clientesContext,$state)
        {
            if($state.params.clienteId!==null&&$state.params.clienteId!==undefined)
            {
                 /**
                * @ngdoc function
                * @name getClienteID
                * @methodOf Clientes.controller:clientesDetailCtrl
                * @description
                * Esta función utiliza el protocolo HTTP para obtener el recurso 
                * donde se encuentra el cliente por ID en formato JSON.
                * @param {String} URL Dirección donde se encuentra el recurso
                * del cliente o API donde se puede consultar.
                */
                $http.get(clientesContext+"/"+$state.params.clienteId).then(function(response)
                {
                    $scope.clienteActual=response.data;
                });
            }
        }
    ]);
})(window.angular);

