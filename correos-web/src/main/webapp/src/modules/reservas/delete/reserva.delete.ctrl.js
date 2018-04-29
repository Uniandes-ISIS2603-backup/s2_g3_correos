(function(ng)
{
    var mod=ng.module("reservasModule");
    mod.constant("reservasContext","api/reservas");
    
    mod.controller("reservaDeleteCtrl",['$scope','$state','reservasContext','$http',
    
        /**
         * @ngdoc controller
         * @name reservas.controller:reservaDeleteCtrl
         * @description
         * Definición del controlador auxiliar para eliminar Reservas. 
         * @param {Object} $scope Referencia injectada al Scope definida para este
         * controlador, el scope es el objeto que contiene las variables o 
         * funciones que se definen en este controlador y que son utilizadas 
         * desde el HTML.
         * @param {Object} $http Objeto injectado para la manejar consultas HTTP
         * @param {Object} reservasContext Constante injectada que contiene la ruta
         * donde se encuentra el API de Reservas en el Backend.
         * @param {Object} $state Dependencia injectada en la que se recibe el 
         * estado actual de la navegación definida en el módulo.
         * @param {Object} $rootScope Referencia injectada al Scope definida para
         * toda la aplicación.
         */
        function($scope,$state,reservasContext,$http)
        {
            var idReserva=$state.params.reservaId;
            
            /**
             * @ngdoc function
             * @name deleteReserva
             * @methodOf reservas.controller:reservasDeleteCtrl
             * @description
             * Esta función utiliza el protocolo HTTP para eliminar la editorial.
             * @param {String} id El ID de la editorial a eliminar.
             */
            $scope.deleteReserva=function()
            {
                $http.delete(reservasContext + '/' + idReserva, {}).then(function (response) {
                    $state.go('reservasList', {reservaId: response.data.id}, {reload: true});
                });
            };
        }
        
    ]);
    
})(window.angular);

