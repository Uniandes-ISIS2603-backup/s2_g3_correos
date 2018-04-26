(function(ng)
{
    var mod=ng.module("eventosModule");
    mod.constant("eventosContext","api/eventos");
    
    mod.controller("eventoDeleteCtrl",['$scope','$state','eventosContext','$http',
    
        /**
         * @ngdoc controller
         * @name eventos.controller:eventoDeleteCtrl
         * @description
         * Definición del controlador auxiliar para eliminar Eventos. 
         * @param {Object} $scope Referencia injectada al Scope definida para este
         * controlador, el scope es el objeto que contiene las variables o 
         * funciones que se definen en este controlador y que son utilizadas 
         * desde el HTML.
         * @param {Object} $http Objeto injectado para la manejar consultas HTTP
         * @param {Object} eventosContext Constante injectada que contiene la ruta
         * donde se encuentra el API de Eventos en el Backend.
         * @param {Object} $state Dependencia injectada en la que se recibe el 
         * estado actual de la navegación definida en el módulo.
         * @param {Object} $rootScope Referencia injectada al Scope definida para
         * toda la aplicación.
         */
        function($scope,$state,eventosContext,$http)
        {
            var idEvento=$state.params.eventoId;
            
            /**
             * @ngdoc function
             * @name deleteEvento
             * @methodOf eventos.controller:eventosDeleteCtrl
             * @description
             * Esta función utiliza el protocolo HTTP para eliminar la editorial.
             * @param {String} id El ID de la editorial a eliminar.
             */
            $scope.deleteEvento=function()
            {
                $http.delete(eventosContext + '/' + idEvento, {}).then(function (response) {
                    $state.go('eventosList', {eventoId: response.data.id}, {reload: true});
                });
            };
        }
        
    ]);
    
})(window.angular);
