(function(ng){
    
    var mod=ng.module("eventosModule");
    mod.constant("eventosContext","api/eventos");
    
    mod.controller('eventosUpdateCtrl',['$scope','$http','eventosContext','$state','$rootScope',
        /**
         * @ngdoc controller
         * @name eventos.controller:eventosUpdateCtrl
         * @description
         * Definición del controlador auxiliar para actualizar Eventos. 
         * @param {Object} $scope Referencia injectada al Scope definida para este
         * controlador, el scope es el objeto que contiene las variables o 
         * funciones que se definen en este controlador y que son utilizadas 
         * desde el HTML.
         * @param {Object} $http Objeto injectado para la manejar consultas HTTP
         * @param {Object} eventosContext Constante injectada que contiene la ruta
         * donde se encuentra el API de Editoriales en el Backend.
         * @param {Object} $state Dependencia injectada en la que se recibe el 
         * estado actual de la navegación definida en el módulo.
         */
        function($scope, $http , eventosContext, $state, $rootScope)
        {
            $rootScope.edit=true;
            $scope.data={};
            var idEvento=$state.params.eventoId;
            /**
             * @ngdoc function
             * @name getEventoID
             * @methodOf eventos.controller:eventosUpdateCtrl
             * @description
             * Esta función utiliza el protocolo HTTP para obtener el recurso 
             * donde se encuentra la editorial por ID en formato JSON.
             * @param {String} URL Dirección donde se encuentra el recurso
             * del evento o API donde se puede consultar.
             */
            $http.get(eventosContext+'/'+idEvento).then(function(response)
            {
                var evento=response.data;
                $scope.data.name=evento.name;
                $scope.data.ubicacion=evento.ubicacion;
                $scope.data.detalle=evento.detalle;
            });
            
            /**
             * @ngdoc function
             * @name createEvento
             * @methodOf eventos.controller:eventoUpdateCtrl
             * @description
             * Esta función utiliza el protocolo HTTP para actualizar el Evento 
             * por ID en formato JSON.
             * @param {String} id El ID del evento que se va a actualizar.
             * @param {Object} evento Objeto con la información nueva del evento.
             */
            $scope.createEvento=function()
            {
                $http.put(eventosContext+'/'+idEvento,$scope.data).then(function(response)
                {
                    $state.go('eventosList',{eventoId:response.data.id},{reload:true});
                });
            };
        }
    ]);
    
})(window.angular);


