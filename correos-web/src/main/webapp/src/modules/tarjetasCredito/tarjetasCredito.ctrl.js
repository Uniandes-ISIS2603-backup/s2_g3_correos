(function (ng) {
    var mod = ng.module("tarjetasCreditoModule");
    mod.constant("tarjetasCreditoContext", "tarjetasCredito");
    mod.constant("clientesContext", "api/clientes");
    mod.controller('tarjetaCreditoCtrl', ['$scope', '$http', 'clientesContext', '$state', 'tarjetasCreditoContext',
        /**
         * @ngdoc controller
         * @name tarjetaCredito.controller:tarjetaCreditoCtrl
         * @description
         * Definición del controlador de Angular del módulo tarjetasCredito. 
         * Se crea el controlador con el cual se maneja el módulo.
         * En el controlador se definen los atributos y métodos que pueden
         * ser accedidos desde el HTML utilizando el $scope.
         * @param {Object} $scope Referencia injectada al Scope definida para este
         * controlador, el scope es el objeto que contiene las variables o 
         * funciones que se definen en este controlador y que son utilizadas 
         * desde el HTML.
         * @param {Object} $http Objeto injectado para la manejar consultas HTTP
         * @param {Object} clienteContext Constante injectada que contiene la ruta
         * donde se encuentra el API de Libros en el Backend.
         * @param {Object} $state Dependencia injectada en la que se recibe el 
         * estado actual de la navegación definida en el módulo.
         * @param {Object} tarjetaCreditoContext Constante injectada que contiene la ruta
         * donde se encuentra el API de TarjetaCredito en el Backend.
         */
        function ($scope, $http, clientesContext, $state, tarjetasCreditoContext) {
            $http.get(clientesContext + '/' + $state.params.clienteId + '/' + tarjetasCreditoContext).then(function (response) {
                $scope.tarjetaCreditoRecords = response.data;
            });
        }
    ]);
}
)(window.angular);