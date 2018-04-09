(function (ng) {
    var mod = ng.module("mensajerosModule");
    mod.constant("mensajerosContext", "api/mensajeros");
    mod.controller('mensajerosDetailCtrl', ['$scope', '$http', 'mensajerosContext', '$state',
         /**
         * @ngdoc controller
         * @name mensajeros.controller:mensajerosDetailCtrl
         * @description
         * Definición de un controlador auxiliar del módulo Mensajeros. 
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
        function($scope,$http, mensajerosContext,$state)
        {
            if($state.params.mensajeroId!==null&&$state.params.mensajeroId!==undefined)
            {
                 /**
                * @ngdoc function
                * @name getMensajeroID
                * @methodOf Mensajeros.controller:mensajerosDetailCtrl
                * @description
                * Esta función utiliza el protocolo HTTP para obtener el recurso 
                * donde se encuentra el mensajero por ID en formato JSON.
                * @param {String} URL Dirección donde se encuentra el recurso
                * del mensajero o API donde se puede consultar.
                */
                $http.get(mensajerosContext+"/"+$state.params.mensajeroId).then(function(response)
                {
                    $scope.mensajeroActual=response.data;
                });
            }
        }
    ]);
})(window.angular);

