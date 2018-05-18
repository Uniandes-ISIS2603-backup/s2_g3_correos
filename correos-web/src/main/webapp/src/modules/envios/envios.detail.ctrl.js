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
            $scope.map = {center: {latitude: 4.6449116, longitude: -74.0769849}, zoom: 11};

            $scope.options = {scrollwheel: false};
            $scope.coordsUpdates = 0;
            $scope.dynamicMoveCtr = 0;

            // instantiate google map objects for directions
            var directionsDisplay = new google.maps.DirectionsRenderer();
            var directionsService = new google.maps.DirectionsService();
            //var geocoder = new google.maps.Geocoder();

            // directions object -- with defaults
            $scope.directions = {
                origin: "",
                destination: "",
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
                        $scope.cordi=response.routes[0].legs[0].start_location.toJSON();
                        $scope.cordf=response.routes[0].legs[0].end_location.toJSON();
                        directionsDisplay.setPanel(document.getElementById('directionsList'));
                        $scope.directions.showList = true;
                    } else {
                        $scope.error_ruta = "no fue posible identificar las direcicones";
                    }
                    
                    $scope.marker1 = {
                        id: 0,
                        coords: {
                            latitude: $scope.cordi.lat,
                            longitude:  $scope.cordi.lng
                        },
                        options: {draggable: true,icon:'src/images/start.png'},
                        events: {
                            dragend: function (marker, eventName, args) {
                                $log.log('marker dragend');
                                var lat = marker.getPosition().lat();
                                var lon = marker.getPosition().lng();
                                $log.log(lat);
                                $log.log(lon);

                                $scope.marker.options = {
                                    draggable: true,
                                    labelContent: "lat: " + $scope.marker.coords.latitude + ' ' + 'lon: ' + $scope.marker.coords.longitude,
                                    labelAnchor: "100 0",
                                    labelClass: "marker-labels"
                                };
                            }
                        }
                    };
                    $scope.marker2 = {
                        id: 1,
                        coords: {
                            latitude: $scope.cordf.lat,
                            longitude: $scope.cordf.lng
                        },
                        options: {draggable: true,icon:'src/images/end.png'},
                        events: {
                            dragend: function (marker, eventName, args) {
                                $log.log('marker dragend');
                                var lat = marker.getPosition().lat();
                                var lon = marker.getPosition().lng();
                                $log.log(lat);
                                $log.log(lon);

                                $scope.marker.options = {
                                    draggable: true,
                                    labelContent: "lat: " + $scope.marker.coords.latitude + ' ' + 'lon: ' + $scope.marker.coords.longitude,
                                    labelAnchor: "100 0",
                                    labelClass: "marker-labels"
                                };
                            }
                        }
                    };

                });

            }
            $scope.getDirections = getDirections();

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

