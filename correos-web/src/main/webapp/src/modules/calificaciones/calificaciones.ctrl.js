(function (ng) {
    var mod = ng.module("calificacionesModule");
    mod.constant("calificacionesContext", "calificaciones");
    mod.constant("mensajerosContext", "api/mensajeros");
    mod.controller('calificacionCtrl', ['$scope', '$http', 'mensajerosContext', '$state', 'calificacionesContext',
        /**
         * @ngdoc controller
         * @name calificaciones.controller:calificacionesCtrl
         * @description
         * Definición del controlador de Angular del módulo calificaciones. 
         * Se crea el controlador con el cual se maneja el módulo.
         * En el controlador se definen los atributos y métodos que pueden
         * ser accedidos desde el HTML utilizando el $scope.
         * @param {Object} $scope Referencia injectada al Scope definida para este
         * controlador, el scope es el objeto que contiene las variables o 
         * funciones que se definen en este controlador y que son utilizadas 
         * desde el HTML.
         * @param {Object} $http Objeto injectado para la manejar consultas HTTP
         * @param {Object} mensajeroContext Constante injectada que contiene la ruta
         * donde se encuentra el API de Libros en el Backend.
         * @param {Object} $state Dependencia injectada en la que se recibe el 
         * estado actual de la navegación definida en el módulo.
         * @param {Object} calificacionContext Constante injectada que contiene la ruta
         * donde se encuentra el API de calificaciones en el Backend.
         */
        function ($scope, $http, mensajerosContext, $state, calificacionesContext) {
            
            $http.get(mensajerosContext + '/' + $state.params.mensajeroId + '/' + calificacionesContext).then(function (response) {
               
                $scope.calificacionesRecords = response.data;
            });
        }
    ]);
}
)(window.angular);