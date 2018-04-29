(function (ng) {
    var mod = ng.module("detallePaquetesModule");
    mod.constant("detallePaquetesContext", "detallePaquetes");
    mod.constant("paquetesContext", "api/paquetes");
    mod.controller('detallePaqueteCtrl', ['$scope', '$http', 'paquetesContext', '$state', 'detallePaquetesContext',
        /**
         * @ngdoc controller
         * @name detallePaquete.controller:detallePaqueteCtrl
         * @description
         * Definición del controlador de Angular del módulo detallePaquetes. 
         * Se crea el controlador con el cual se maneja el módulo.
         * En el controlador se definen los atributos y métodos que pueden
         * ser accedidos desde el HTML utilizando el $scope.
         * @param {Object} $scope Referencia injectada al Scope definida para este
         * controlador, el scope es el objeto que contiene las variables o 
         * funciones que se definen en este controlador y que son utilizadas 
         * desde el HTML.
         * @param {Object} $http Objeto injectado para la manejar consultas HTTP
         * @param {Object} envioContext Constante injectada que contiene la ruta
         * donde se encuentra el API de Libros en el Backend.
         * @param {Object} $state Dependencia injectada en la que se recibe el 
         * estado actual de la navegación definida en el módulo.
         * @param {Object} detallePaqueteContext Constante injectada que contiene la ruta
         * donde se encuentra el API de detallePaquetes en el Backend.
         */
        function ($scope, $http, paquetesContext, $state, detallePaquetesContext) {
            $http.get(paquetesContext + '/' + $state.params.envioId + '/' + detallePaquetesContext).then(function (response) {
                $scope.detallePaqueteRecords = response.data;
            });
        }
    ]);
}
)(window.angular);