(function(ng){
    var mod=ng.module("zonasModule");
    mod.constant("zonasContext","api/zonas");
    mod.controller('zonasCreateCtrl',['$scope','$http','zonasContext','$state','$rootScope',
         /**
         * @ngdoc controller
         * @name zonas.controller:zonasCreateCtrl
         * @description
         * Definición del controlador auxiliar para crear zonas. 
         * @param {Object} $scope Referencia injectada al Scope definida para este
         * controlador, el scope es el objeto que contiene las variables o 
         * funciones que se definen en este controlador y que son utilizadas 
         * desde el HTML.
         * @param {Object} $http Objeto injectado para la manejar consultas HTTP
         * @param {Object} editorialContext Constante injectada que contiene la ruta
         * donde se encuentra el API de Zonas en el Backend.
         * @param {Object} $state Dependencia injectada en la que se recibe el 
         * estado actual de la navegación definida en el módulo.
         * @param {Object} $rootScope Referencia injectada al Scope definida para
         * toda la aplicación.
         */
        function($scope,$http,zonasContext,$state,$rootScope)
        {
            $rootScope.edit=false;
            $scope.data={};
            
            /**
             * @ngdoc function
             * @name createZona
             * @methodOf zonas.controller:zonaCreate
             * @description
             * Esta función utiliza el protocolo HTTP para crear la zona.
             * @param {Object} zona Objeto con la nueva zona.
             */
            $scope.createZona=function()
            {
                $http.post(zonasContext,$scope.data).then(function(response)
                {
                    $state.go('zonasList',{zonaId:response.data.id}, {reload:true});
                });
            };
        }
        
    ]);
})(window.angular);

