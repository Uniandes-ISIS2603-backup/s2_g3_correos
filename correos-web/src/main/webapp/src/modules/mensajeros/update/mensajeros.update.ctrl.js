(function(ng){
    
    var mod=ng.module("mensajerosModule");
    mod.constant("mensajerosContext","api/mensajeros");
    
    mod.controller('mensajerosUpdateCtrl',['$scope','$http','mensajerosContext','$state','$rootScope',
        /**
         * @ngdoc controller
         * @name mensajeros.controller:mensajerosUpdateCtrl
         * @description
         * Definición del controlador auxiliar para actualizar Mensajeros. 
         * @param {Object} $scope Referencia injectada al Scope definida para este
         * controlador, el scope es el objeto que contiene las variables o 
         * funciones que se definen en este controlador y que son utilizadas 
         * desde el HTML.
         * @param {Object} $http Objeto injectado para la manejar consultas HTTP
         * @param {Object} mensajerosContext Constante injectada que contiene la ruta
         * donde se encuentra el API de Editoriales en el Backend.
         * @param {Object} $state Dependencia injectada en la que se recibe el 
         * estado actual de la navegación definida en el módulo.
         */
        function($scope, $http , mensajerosContext, $state, $rootScope)
        {
            $rootScope.edit=true;
            $scope.data={};
            var idMensajero=$state.params.mensajeroId;
            /**
             * @ngdoc function
             * @name getMensajeroID
             * @methodOf mensajeros.controller:mensajerosUpdateCtrl
             * @description
             * Esta función utiliza el protocolo HTTP para obtener el recurso 
             * donde se encuentra la editorial por ID en formato JSON.
             * @param {String} URL Dirección donde se encuentra el recurso
             * del mensajero o API donde se puede consultar.
             */
            $http.get(mensajerosContext+'/'+idMensajero).then(function(response)
            {
                var mensajero=response.data;
                $scope.data.nombre=mensajero.nombre;
                $scope.data.correo=mensajero.correo;
                $scope.data.celular=mensajero.celular;
                $scope.data.ocupado=mensajero.ocupado;
                $scope.data.calificacionPromedio=mensajero.calificacionPromedio;
            });
            
            /**
             * @ngdoc function
             * @name createMensajero
             * @methodOf mensajeros.controller:mensajeroUpdateCtrl
             * @description
             * Esta función utiliza el protocolo HTTP para actualizar el Mensajero 
             * por ID en formato JSON.
             * @param {String} id El ID del mensajero que se va a actualizar.
             * @param {Object} mensajero Objeto con la información nueva del mensajero.
             */
            $scope.createMensajero=function()
            {
                $http.put(mensajerosContext+'/'+idMensajero,$scope.data).then(function(response)
                {
                    $state.go('mensajerosList',{mensajeroId:response.data.id},{reload:true});
                });
            };
        }
    ]);
    
})(window.angular);


