(function(ng){
    
    var mod=ng.module("enviosModule");
    mod.constant("enviosContext","api/envios");
    
    mod.controller('enviosUpdateCtrl',['$scope','$http','enviosContext','$state','$rootScope',
        /**
         * @ngdoc controller
         * @name envios.controller:enviosUpdateCtrl
         * @description
         * Definición del controlador auxiliar para actualizar Envios. 
         * @param {Object} $scope Referencia injectada al Scope definida para este
         * controlador, el scope es el objeto que contiene las variables o 
         * funciones que se definen en este controlador y que son utilizadas 
         * desde el HTML.
         * @param {Object} $http Objeto injectado para la manejar consultas HTTP
         * @param {Object} enviosContext Constante injectada que contiene la ruta
         * donde se encuentra el API de Envios en el Backend.
         * @param {Object} $state Dependencia injectada en la que se recibe el 
         * estado actual de la navegación definida en el módulo.
         */
        function($scope, $http , enviosContext, $state, $rootScope)
        {
            $rootScope.edit=true;
            $scope.data={};
            var idEnvio=$state.params.envioId;
            /**
             * @ngdoc function
             * @name getEnvioID
             * @methodOf envios.controller:enviosUpdateCtrl
             * @description
             * Esta función utiliza el protocolo HTTP para obtener el recurso 
             * donde se encuentra el envio por ID en formato JSON.
             * @param {String} URL Dirección donde se encuentra el recurso
             * del envio o API donde se puede consultar.
             */
            $http.get(enviosContext+'/'+idEnvio).then(function(response)
            {
                var envio=response.data;
                $scope.data.estado=envio.estado;
                $scope.data.horaInicio=envio.horaInicio;
                $scope.data.horaFinal=envio.horaFinal;
                $scope.data.direccionEntrega=envio.direccionEntrega;
                $scope.data.direccionRecogida=envio.direccionRecogida;
            });
            
            /**
             * @ngdoc function
             * @name createEnvio
             * @methodOf envios.controller:envioUpdateCtrl
             * @description
             * Esta función utiliza el protocolo HTTP para actualizar el Envio 
             * por ID en formato JSON.
             * @param {String} id El ID del envio que se va a actualizar.
             * @param {Object} envio Objeto con la información nueva del envio.
             */
            $scope.createEnvio=function()
            {
                $http.put(enviosContext+'/'+idEnvio,$scope.data).then(function(response)
                {
                    $state.go('enviosList',{envioId:response.data.id},{reload:true});
                });
            };
        }
    ]);
    
})(window.angular);



