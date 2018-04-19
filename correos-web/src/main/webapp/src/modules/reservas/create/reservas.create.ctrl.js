(function(ng){
    var mod=ng.module("reservasModule");
    mod.constant("reservasContext","api/reservas");
    mod.controller('reservasCreateCtrl',['$scope','$http','reservasContext','$state','$rootScope',
         /**
         * @ngdoc controller
         * @name reservas.controller:reservasCreateCtrl
         * @description
         * Definición del controlador auxiliar para crear Reservas. 
         * @param {Object} $scope Referencia injectada al Scope definida para este
         * controlador, el scope es el objeto que contiene las variables o 
         * funciones que se definen en este controlador y que son utilizadas 
         * desde el HTML.
         * @param {Object} $http Objeto injectado para la manejar consultas HTTP
         * @param {Object} editorialContext Constante injectada que contiene la ruta
         * donde se encuentra el API de Reservas en el Backend.
         * @param {Object} $state Dependencia injectada en la que se recibe el 
         * estado actual de la navegación definida en el módulo.
         * @param {Object} $rootScope Referencia injectada al Scope definida para
         * toda la aplicación.
         */
        function($scope,$http,reservasContext,$state,$rootScope)
        {
            $rootScope.edit=false;
            $scope.hola="";
            
            /**
             * @ngdoc function
             * @name createReserva
             * @methodOf reservas.controller:reservaNewCtrl
             * @description
             * Esta función utiliza el protocolo HTTP para crear el Reserva.
             * @param {Object} Reserva Objeto con el nuevo Reserva.
             */
            $scope.createReserva=function()
            {
                console.log($scope.hola);
                $scope.data = {"fecha":$scope.hola}
                $http.post(reservasContext,$scope.data).then(function(response)
                {
                    $state.go('reservasList',{reservaId:response.data.id}, {reload:true});
                });
            };
        }
        
    ]);
})(window.angular);


