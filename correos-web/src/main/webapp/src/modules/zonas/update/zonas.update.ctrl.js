(function(ng){
    
    var mod=ng.module("zonasModule");
    mod.constant("zonasContext","api/zonas");
    
    mod.controller('zonasUpdateCtrl',['$scope','$http','zonasContext','$state','$rootScope',
        /**
         * @ngdoc controller
         * @name zonas.controller:zonasUpdateCtrl
         * @description
         * Definición del controlador auxiliar para actualizar Zonas. 
         * @param {Object} $scope Referencia injectada al Scope definida para este
         * controlador, el scope es el objeto que contiene las variables o 
         * funciones que se definen en este controlador y que son utilizadas 
         * desde el HTML.
         * @param {Object} $http Objeto injectado para la manejar consultas HTTP
         * @param {Object} zonasContext Constante injectada que contiene la ruta
         * donde se encuentra el API de Editoriales en el Backend.
         * @param {Object} $state Dependencia injectada en la que se recibe el 
         * estado actual de la navegación definida en el módulo.
         */
        function($scope, $http , zonasContext, $state, $rootScope)
        {
            $rootScope.edit=true;
            $scope.data={};
            var idZona=$state.params.zonaId;
            /**
             * @ngdoc function
             * @name getZonaID
             * @methodOf zonas.controller:zonasUpdateCtrl
             * @description
             * Esta función utiliza el protocolo HTTP para obtener el recurso 
             * donde se encuentra la editorial por ID en formato JSON.
             * @param {String} URL Dirección donde se encuentra el recurso
             * del zona o API donde se puede consultar.
             */
            $http.get(zonasContext+'/'+idZona).then(function(response)
            {
                var zona=response.data;
                $scope.data.id=idZona;
                $scope.data.latitud=zona.latitud;
                $scope.data.longitud=zona.longitud;
            });
            
            /**
             * @ngdoc function
             * @name createZona
             * @methodOf zonas.controller:ZonaUpdateCtrl
             * @description
             * Esta función utiliza el protocolo HTTP para actualizar la zona 
             * por ID en formato JSON.
             * @param {String} id El ID de la zona que se va a actualizar.
             * @param {Object} zona Objeto con la información nueva de la zona.
             */
            $scope.updateZona=function()
            {
                console.log($scope.data.id);
                $http.put(zonasContext+'/'+idZona,$scope.data).then(function(response)
                {
                    $state.go('zonasList',{zonaId:response.data.id},{reload:true});
                });
            };
        }
    ]);
    
})(window.angular);


