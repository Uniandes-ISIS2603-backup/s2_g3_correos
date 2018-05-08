(function(ng){
    var mod=ng.module("bonosModule");
    mod.constant("bonosContext","api/bonos");
    mod.constant("clientesContext","api/clientes");
    mod.controller('bonosAmigoCreateCtrl',['$scope','$http','bonosContext','clientesContext','$state','$rootScope',
         /**
         * @ngdoc controller
         * @name bonos.controller:bonosCreateCtrl
         * @description
         * Definición del controlador auxiliar para crear bonos. 
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
        function($scope,$http,bonosContext, clientesContext,$state,$rootScope)
        {
            $rootScope.edit=false;
            $scope.data={};
            
            /**
             * @ngdoc function
             * @name createBono
             * @methodOf bonos.controller:bonoNewCtrl
             * @description
             * Esta función utiliza el protocolo HTTP para crear el Bono.
             * @param {Object} Bono Objeto con el nuevo Bono.
             */
            $scope.createBonoAmigo=function()
            {
                $http.post(clientesContext+'/'+$state.params.idAmigo+'/'+bonosContext).then(function(response)
                {
                    $state.go('bonosList',{bonoId:response.data.id}, {reload:true});
                });
            };
        }
        
    ]);
})(window.angular);

