(function(ng){
    
    var mod=ng.module("reservasModule");
    mod.constant("reservasContext","api/reservas");
    
    mod.controller('reservasUpdateCtrl',['$scope','$http','reservasContext','$state','$rootScope',
        /**
         * @ngdoc controller
         * @name reservas.controller:reservasUpdateCtrl
         * @description
         * Definición del controlador auxiliar para actualizar Reservas. 
         * @param {Object} $scope Referencia injectada al Scope definida para este
         * controlador, el scope es el objeto que contiene las variables o 
         * funciones que se definen en este controlador y que son utilizadas 
         * desde el HTML.
         * @param {Object} $http Objeto injectado para la manejar consultas HTTP
         * @param {Object} reservasContext Constante injectada que contiene la ruta
         * donde se encuentra el API de Editoriales en el Backend.
         * @param {Object} $state Dependencia injectada en la que se recibe el 
         * estado actual de la navegación definida en el módulo.
         */
        function($scope, $http , reservasContext, $state, $rootScope)
        {
            $rootScope.edit=true;
            $scope.data={};
            var idReserva=$state.params.reservaId;
            /**
             * @ngdoc function
             * @name getReservaID
             * @methodOf reservas.controller:reservasUpdateCtrl
             * @description
             * Esta función utiliza el protocolo HTTP para obtener el recurso 
             * donde se encuentra la editorial por ID en formato JSON.
             * @param {String} URL Dirección donde se encuentra el recurso
             * del reserva o API donde se puede consultar.
             */
            $http.get(reservasContext+'/'+idReserva).then(function(response)
            {
                var reserva=response.data;
                $scope.data.fecha=reserva.fecha;
                $scope.data.hora=reserva.hora;
            });
            
            /**
             * @ngdoc function
             * @name createReserva
             * @methodOf reservas.controller:reservaUpdateCtrl
             * @description
             * Esta función utiliza el protocolo HTTP para actualizar el Reserva 
             * por ID en formato JSON.
             * @param {String} id El ID del reserva que se va a actualizar.
             * @param {Object} reserva Objeto con la información nueva del reserva.
             */
            $scope.createReserva=function()
            {
                $http.put(reservasContext+'/'+idReserva,$scope.data).then(function(response)
                {
                    $state.go('reservasList',{reservaId:response.data.id},{reload:true});
                });
            };
        }
    ]);
    
})(window.angular);
