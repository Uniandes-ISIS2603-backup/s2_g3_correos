(function (ng) {
    var mod = ng.module("eventosModule");
    mod.constant("eventosContext", "eventos");
    mod.constant("enviosContext","api/envios")
    mod.controller('eventosDetailCtrl', ['$scope', '$http','enviosContext', 'eventosContext', '$state',
         /**
         * @ngdoc controller
         * @name eventos.controller:eventosDetailCtrl
         * @description
         * Definición de un controlador auxiliar del módulo Eventos. 
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
        function($scope,$http, enviosContext, eventosContext,$state)
        {
            if($state.params.eventoId!==null&&$state.params.eventoId!==undefined)
            {
                 /**
                * @ngdoc function
                * @name getEventoID
                * @methodOf Eventos.controller:eventosDetailCtrl
                * @description
                * Esta función utiliza el protocolo HTTP para obtener el recurso 
                * donde se encuentra el evento por ID en formato JSON.
                * @param {String} URL Dirección donde se encuentra el recurso
                * del evento o API donde se puede consultar.
                */
                $http.get(enviosContext+'/'+$state.params.envioId+'/'+eventosContext+"/"+$state.params.eventoId).then(function(response)
                {
                    $scope.eventoActual=response.data;
                });
            }
        }
    ]);
})(window.angular);

