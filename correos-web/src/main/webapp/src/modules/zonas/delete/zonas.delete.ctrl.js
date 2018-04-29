(function(ng)
{
    var mod=ng.module("zonasModule");
    mod.constant("zonasContext","api/zonas");
    
    mod.controller("zonasDeleteCtrl",['$scope','$state','zonasContext','$http',
    
        /**
         * @ngdoc controller
         * @name zonas.controller:zonaDeleteCtrl
         * @description
         * Definición del controlador auxiliar para eliminar zonas. 
         * @param {Object} $scope Referencia injectada al Scope definida para este
         * controlador, el scope es el objeto que contiene las variables o 
         * funciones que se definen en este controlador y que son utilizadas 
         * desde el HTML.
         * @param {Object} $http Objeto injectado para la manejar consultas HTTP
         * @param {Object} zonasContext Constante injectada que contiene la ruta
         * donde se encuentra el API de zonas en el Backend.
         * @param {Object} $state Dependencia injectada en la que se recibe el 
         * estado actual de la navegación definida en el módulo.
         * @param {Object} $rootScope Referencia injectada al Scope definida para
         * toda la aplicación.
         */
        function($scope,$state,zonasContext,$http)
        {
            var idZona=$state.params.zonaId;
            
            /**
             * @ngdoc function
             * @name deleteZona
             * @methodOf zonas.controller:zonasDeleteCtrl
             * @description
             * Esta función utiliza el protocolo HTTP para eliminar la editorial.
             * @param {String} id El ID de la editorial a eliminar.
             */
            $scope.deleteZona=function()
            {
                $http.delete(zonasContext + '/' + idZona, {}).then(function (response) {
                    $state.go('zonasList', {zonaId: response.data.id}, {reload: true});
                });
            };
        }
        
    ]);
    
})(window.angular);
