(function(ng){
    
    var mod=ng.module("transportesModule");
    mod.constant("transportesContext","api/transportes");
    mod.constant("mensajerosContext","api/mensajeros");
    
    mod.controller('transportesUpdateCtrl',['$scope','$http','transportesContext','mensajerosContext','$state','$rootScope',
        /**
         * @ngdoc controller
         * @name transportes.controller:transportesUpdateCtrl
         * @description
         * Definición del controlador auxiliar para actualizar Transportes. 
         * @param {Object} $scope Referencia injectada al Scope definida para este
         * controlador, el scope es el objeto que contiene las variables o 
         * funciones que se definen en este controlador y que son utilizadas 
         * desde el HTML.
         * @param {Object} $http Objeto injectado para la manejar consultas HTTP
         * @param {Object} transportesContext Constante injectada que contiene la ruta
         * donde se encuentra el API de Editoriales en el Backend.
         * @param {Object} $state Dependencia injectada en la que se recibe el 
         * estado actual de la navegación definida en el módulo.
         */
        function($scope, $http , transportesContext,mensajerosContext, $state, $rootScope)
        {
            $rootScope.edit=true;
            $scope.data={};
            var idTransporte=$state.params.transporteId;
            /**
             * @ngdoc function
             * @name getTransporteID
             * @methodOf transportes.controller:transportesUpdateCtrl
             * @description
             * Esta función utiliza el protocolo HTTP para obtener el recurso 
             * donde se encuentra la editorial por ID en formato JSON.
             * @param {String} URL Dirección donde se encuentra el recurso
             * del transporte o API donde se puede consultar.
             */
            $http.get(mensajerosContext+'/'+$state.params.mensajeroId+'/'+transportesContext+'/'+idTransporte).then(function(response)
            {
                var transporte=response.data;
                $scope.data.tipo=transporte.tipo;
                $scope.data.capacidad=transporte.capacidad;
            });
            
            /**
             * @ngdoc function
             * @name createTransporte
             * @methodOf transportes.controller:transporteUpdateCtrl
             * @description
             * Esta función utiliza el protocolo HTTP para actualizar el Transporte 
             * por ID en formato JSON.
             * @param {String} id El ID del transporte que se va a actualizar.
             * @param {Object} transporte Objeto con la información nueva del transporte.
             */
            $scope.createTransporte=function()
            {
                $http.put(mensajerosContext+'/'+$state.params.mensajeroId+'/'+transportesContext+'/'+idTransporte,$scope.data).then(function(response)
                {
                    $state.go('transportesList',{transporteId:$state.params.id},{reload:true});
                });
            };
        }
    ]);
    
})(window.angular);