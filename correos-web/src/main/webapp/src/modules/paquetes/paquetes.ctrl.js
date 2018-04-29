(function (ng) {
    var mod = ng.module("paquetesModule");
    mod.constant("paquetesContext", "paquetes");
    mod.constant("enviosContext", "api/envios");
    mod.controller('paqueteCtrl', ['$scope', '$http', 'enviosContext', '$state', 'paquetesContext',
        /**
         * @ngdoc controller
         * @name paquete.controller:paqueteCtrl
         * @description
         * Definición del controlador de Angular del módulo paquetes. 
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
         * @param {Object} paqueteContext Constante injectada que contiene la ruta
         * donde se encuentra el API de Paquetes en el Backend.
         */
        function ($scope, $http, enviosContext, $state, paquetesContext) {
            $http.get(enviosContext + '/' + $state.params.envioId + '/' + paquetesContext).then(function (response) {
                $scope.paqueteRecords = response.data;
            });
        }
    ]);
}
)(window.angular);
