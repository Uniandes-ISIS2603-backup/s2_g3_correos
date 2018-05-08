(function (ng) {
    var mod = ng.module("zonasModule");
    mod.constant("zonasContext", "api/zonas");
    mod.controller('zonasDetailCtrl', ['$scope', '$http', 'zonasContext', '$state',
         /**
         * @ngdoc controller
         * @name zonas.controller:zonasDetailCtrl
         * @description
         * Definición de un controlador auxiliar del módulo zonas. 
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
        function($scope,$http, zonasContext,$state)
        {
           $scope.map = { center: {latitude: 51.219053, longitude: 4.404418 }, zoom: 14 };
                    
                   
            if($state.params.zonaId!==null&&$state.params.zonaId!==undefined)
            {
                 /**
                * @ngdoc function
                * @name getZonaID
                * @methodOf Zonas.controller:zonasDetailCtrl
                * @description
                * Esta función utiliza el protocolo HTTP para obtener el recurso 
                * donde se encuentra la zona por ID en formato JSON.
                * @param {String} URL Dirección donde se encuentra el recurso
                * de la zona o API donde se puede consultar.
                */
                $http.get(zonasContext+"/"+$state.params.zonaId).then(function(response)
                {
                   
                    
                    $scope.zonaActual=response.data;
                    $scope.map.center.latitude=$scope.zonaActual.latitud;
                    $scope.map.center.longitude=$scope.zonaActual.longitud;
                    
                   
               });
            }
        }
    ]);
})(window.angular);

