(function (ng) {
    var mod = ng.module("enviosModule");
    mod.constant("enviosContext", "api/envios");
    mod.controller('enviosDetailCtrl', ['$scope', '$http', 'enviosContext', '$state',
         /**
         * @ngdoc controller
         * @name envios.controller:enviosDetailCtrl
         * @description
         * Definición de un controlador auxiliar del módulo Envios. 
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
        function($scope,$http, enviosContext,$state)
        {
            if($state.params.envioId!==null&&$state.params.envioId!==undefined)
            {
                 /**
                * @ngdoc function
                * @name getEnvioID
                * @methodOf Envios.controller:enviosDetailCtrl
                * @description
                * Esta función utiliza el protocolo HTTP para obtener el recurso 
                * donde se encuentra el envio por ID en formato JSON.
                * @param {String} URL Dirección donde se encuentra el recurso
                * del envio o API donde se puede consultar.
                */
                $http.get(enviosContext+"/"+$state.params.envioId).then(function(response)
                {
                    $scope.envioActual=response.data;
                });
            }
        }
    ]);
})(window.angular);

