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
        function ($scope, $http, enviosContext, $state)
        {
            $scope.map = {
                control: {},
                center: {
                    latitude: -37.812150,
                    longitude: 144.971008
                },
                zoom: 14
            };

            // marker object
            $scope.marker = {
                center: {
                    latitude: -37.812150,
                    longitude: 144.971008
                }
            }

            // instantiate google map objects for directions
            var directionsDisplay = new google.maps.DirectionsRenderer();
            var directionsService = new google.maps.DirectionsService();
            var geocoder = new google.maps.Geocoder();

            // directions object -- with defaults
            $scope.directions = {
                origin: "Collins St, Melbourne, Australia",
                destination: "MCG Melbourne, Australia",
                showList: true
            }
            
            // get directions using google maps api
            getDirections = function () {
                var request = {
                    origin: $scope.directions.origin,
                    destination: $scope.directions.destination,
                    travelMode: google.maps.DirectionsTravelMode.WALKING
                };
                directionsService.route(request, function (response, status) {
                    if (status === google.maps.DirectionsStatus.OK) {
                        directionsDisplay.setDirections(response);
                        $scope.ruta_info = response.routes[0].legs[0];
                        directionsDisplay.setPanel(document.getElementById('directionsList'));
                        $scope.directions.showList = true;
                    } else {
                        alert('Google route unsuccesfull!');
                    }
                     $scope.ruta_info = response.routes[0].legs[0];
                });
               
            }
            $scope.getDirections= getDirections();

            if ($state.params.envioId !== null && $state.params.envioId !== undefined)
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




                $http.get(enviosContext + "/" + $state.params.envioId).then(function (response)
                {
                    $scope.envioActual = response.data;
                    $scope.directions = {
                        origin: "bogota " + $scope.envioActual.direccionRecogida,
                        destination: "bogota " + $scope.envioActual.direccionEntrega

                    }
                    getDirections()


                });
            }

        }
    ]);
})(window.angular);

