(function(ng){
    var mod=ng.module("paquetesModule");
    mod.constant("paquetesContext","api/paquetes");
    mod.constant("enviosContext","api/envios");
    mod.controller('paquetesCreateCtrl',['$scope','$http','paquetesContext','enviosContext','$state','$rootScope',
         /**
         * @ngdoc controller
         * @name paquetes.controller:paquetesCreateCtrl
         * @description
         * Definición del controlador auxiliar para crear Paquetes. 
         * @param {Object} $scope Referencia injectada al Scope definida para este
         * controlador, el scope es el objeto que contiene las variables o 
         * funciones que se definen en este controlador y que son utilizadas 
         * desde el HTML.
         * @param {Object} $http Objeto injectado para la manejar consultas HTTP
         * @param {Object} editorialContext Constante injectada que contiene la ruta
         * donde se encuentra el API de Paquetes en el Backend.
         * @param {Object} $state Dependencia injectada en la que se recibe el 
         * estado actual de la navegación definida en el módulo.
         * @param {Object} $rootScope Referencia injectada al Scope definida para
         * toda la aplicación.
         */
        function($scope,$http,paquetesContext, enviosContext,$state,$rootScope)
        {
            $rootScope.edit=false;
            $scope.data={};
            
            /**
             * @ngdoc function
             * @name createPaquete
             * @methodOf paquetes.controller:paqueteNewCtrl
             * @description
             * Esta función utiliza el protocolo HTTP para crear el Paquete.
             * @param {Object} Paquete Objeto con el nuevo Paquete.
             */
            $scope.createPaquete=function()
            {
                alert("hola")
                $http.post(enviosContext+'/'+$state.params.envioId+'/'+paquetesContext,$scope.data).then(function(response)
                {
                     alert(response)
                    $state.go('paquetesList',{paqueteId:response.data.id}, {reload:true});
                });
            };
        }
        
    ]);
})(window.angular);


