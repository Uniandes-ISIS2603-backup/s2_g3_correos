(function(ng){
    var mod=ng.module("transportesModule");
    mod.constant("transportesContext","api/transportes");
    mod.constant("mensajerosContext","api/mensajeros");
    mod.controller('transportesCreateCtrl',['$scope','$http','transportesContext','mensajerosContext','$state','$rootScope',
         /**
         * @ngdoc controller
         * @name transportes.controller:transportesCreateCtrl
         * @description
         * Definición del controlador auxiliar para crear Transportes. 
         * @param {Object} $scope Referencia injectada al Scope definida para este
         * controlador, el scope es el objeto que contiene las variables o 
         * funciones que se definen en este controlador y que son utilizadas 
         * desde el HTML.
         * @param {Object} $http Objeto injectado para la manejar consultas HTTP
         * @param {Object} editorialContext Constante injectada que contiene la ruta
         * donde se encuentra el API de Transportes en el Backend.
         * @param {Object} $state Dependencia injectada en la que se recibe el 
         * estado actual de la navegación definida en el módulo.
         * @param {Object} $rootScope Referencia injectada al Scope definida para
         * toda la aplicación.
         */
        function($scope,$http,transportesContext, mensajerosContext,$state,$rootScope)
        {
            $rootScope.edit=false;
            $scope.data={};
            
            /**
             * @ngdoc function
             * @name createTransporte
             * @methodOf transportes.controller:transporteNewCtrl
             * @description
             * Esta función utiliza el protocolo HTTP para crear el Transporte.
             * @param {Object} Transporte Objeto con el nuevo Transporte.
             */
            $scope.createTransporte=function()
            {
                $http.post(mensajerosContext+'/'+$state.params.mensajeroId+'/'+transportesContext,$scope.data).then(function(response)
                {
                    $state.go('transportesList',{transporteId:response.data.id}, {reload:true});
                });
            };
        }
        
    ]);
})(window.angular);


