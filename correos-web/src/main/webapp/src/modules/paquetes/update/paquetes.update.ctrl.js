(function(ng){
    
    var mod=ng.module("paquetesModule");
    mod.constant("paquetesContext","api/paquetes");
    mod.constant("enviosContext","api/envios");
    
    mod.controller('paquetesUpdateCtrl',['$scope','$http','paquetesContext','enviosContext','$state','$rootScope',
        /**
         * @ngdoc controller
         * @name paquetes.controller:paquetesUpdateCtrl
         * @description
         * Definición del controlador auxiliar para actualizar Paquetes. 
         * @param {Object} $scope Referencia injectada al Scope definida para este
         * controlador, el scope es el objeto que contiene las variables o 
         * funciones que se definen en este controlador y que son utilizadas 
         * desde el HTML.
         * @param {Object} $http Objeto injectado para la manejar consultas HTTP
         * @param {Object} paquetesContext Constante injectada que contiene la ruta
         * donde se encuentra el API de Editoriales en el Backend.
         * @param {Object} $state Dependencia injectada en la que se recibe el 
         * estado actual de la navegación definida en el módulo.
         */
        function($scope, $http , paquetesContext,enviosContext, $state, $rootScope)
        {
            $rootScope.edit=true;
            $scope.data={};
            var idPaquete=$state.params.paqueteId;
            /**
             * @ngdoc function
             * @name getPaqueteID
             * @methodOf paquetes.controller:paquetesUpdateCtrl
             * @description
             * Esta función utiliza el protocolo HTTP para obtener el recurso 
             * donde se encuentra la editorial por ID en formato JSON.
             * @param {String} URL Dirección donde se encuentra el recurso
             * del paquete o API donde se puede consultar.
             */
            $http.get(enviosContext+'/'+$state.params.envioId+'/'+paquetesContext+'/'+idPaquete).then(function(response)
            {
                var paquete=response.data;
                $scope.data.tipo=paquete.tipo;
                $scope.data.peso=paquete.peso;
                $scope.data.dimensionA=paquete.dimensionA;
                $scope.data.dimensionB=paquete.dimensionB;
                $scope.data.dimensionC=paquete.dimensionC;
            });
            
            /**
             * @ngdoc function
             * @name createPaquete
             * @methodOf paquetes.controller:paqueteUpdateCtrl
             * @description
             * Esta función utiliza el protocolo HTTP para actualizar el Paquete 
             * por ID en formato JSON.
             * @param {String} id El ID del paquete que se va a actualizar.
             * @param {Object} paquete Objeto con la información nueva del paquete.
             */
            $scope.createPaquete=function()
            {
                $http.put(enviosContext+'/'+$state.params.envioId+'/'+paquetesContext+'/'+idPaquete,$scope.data).then(function()
                {
                    $state.go('paquetesList',{paqueteId:$state.params.id},{reload:true});
                });
            };
        }
    ]);
    
})(window.angular);