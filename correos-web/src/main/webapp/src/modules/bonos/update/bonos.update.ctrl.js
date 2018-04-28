(function(ng){
    
    var mod=ng.module("bonosModule");
    mod.constant("bonosContext","api/bonos");
    mod.constant("clientesContext","api/clientes");
    
    mod.controller('bonosUpdateCtrl',['$scope','$http','bonosContext','clientesContext','$state','$rootScope',
        /**
         * @ngdoc controller
         * @name bonos.controller:bonosUpdateCtrl
         * @description
         * Definición del controlador auxiliar para actualizar Bonos. 
         * @param {Object} $scope Referencia injectada al Scope definida para este
         * controlador, el scope es el objeto que contiene las variables o 
         * funciones que se definen en este controlador y que son utilizadas 
         * desde el HTML.
         * @param {Object} $http Objeto injectado para la manejar consultas HTTP
         * @param {Object} bonosContext Constante injectada que contiene la ruta
         * donde se encuentra el API de Editoriales en el Backend.
         * @param {Object} $state Dependencia injectada en la que se recibe el 
         * estado actual de la navegación definida en el módulo.
         */
        function($scope, $http , bonosContext,clientesContext, $state, $rootScope)
        {
            $rootScope.edit=true;
            $scope.data={};
            var idBono=$state.params.bonoId;
            /**
             * @ngdoc function
             * @name getBonoID
             * @methodOf bonos.controller:bonosUpdateCtrl
             * @description
             * Esta función utiliza el protocolo HTTP para obtener el recurso 
             * donde se encuentra la editorial por ID en formato JSON.
             * @param {String} URL Dirección donde se encuentra el recurso
             * del bono o API donde se puede consultar.
             */
            $http.get(clientesContext+'/'+$state.params.envioId+'/'+clientesContext+'/'+idBono).then(function(response)
            {
                var bono=response.data;
                $scope.data.descripcion=bono.descripcion;
                $scope.data.descuento=bono.descuento;
                $scope.data.condicion=bono.condicion;
                $scope.data.fechaDeVencimiento=bono.fechaDeVencimiento;
            });
            
            /**
             * @ngdoc function
             * @name createBono
             * @methodOf bonos.controller:bonoUpdateCtrl
             * @description
             * Esta función utiliza el protocolo HTTP para actualizar el Bono 
             * por ID en formato JSON.
             * @param {String} id El ID del bono que se va a actualizar.
             * @param {Object} bono Objeto con la información nueva del bono.
             */
            $scope.createBono=function()
            {
                $http.put(clientesContext+'/'+$state.params.envioId+'/'+bonosContext+'/'+idBono,$scope.data).then(function(response)
                {
                    $state.go('bonosList',{bonoId:$state.params.id},{reload:true});
                });
            };
        }
    ]);
    
})(window.angular);


