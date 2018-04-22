(function (ng) {
    var mod = ng.module("reservasModule");
    mod.constant("reservasContext", "api/reservas");
    mod.controller('reservasDetailCtrl', ['$scope', '$http', 'reservasContext', '$state',
         /**
         * @ngdoc controller
         * @name reservas.controller:reservasDetailCtrl
         * @description
         * Definición de un controlador auxiliar del módulo Reservas. 
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
        function($scope,$http, reservasContext,$state)
        {
            if($state.params.reservaId!==null&&$state.params.reservaId!==undefined)
            {
                 /**
                * @ngdoc function
                * @name getReservaID
                * @methodOf Reservas.controller:reservasDetailCtrl
                * @description
                * Esta función utiliza el protocolo HTTP para obtener el recurso 
                * donde se encuentra el reserva por ID en formato JSON.
                * @param {String} URL Dirección donde se encuentra el recurso
                * del reserva o API donde se puede consultar.
                */
                $http.get(reservasContext+"/"+$state.params.reservaId).then(function(response)
                {
                    $scope.reservaActual=response.data;
                });
            }
        }
    ]);
})(window.angular);
