(function(ng)
{
    var mod=ng.module("bonosModule");
    mod.constant("bonosContext","/bonos");
    mod.constant("clientesContext","api/clientes");
    mod.controller("bonosDeleteCtrl",['$scope','$state','bonosContext','clientesContext','$http',
    
        /**
         * @ngdoc controller
         * @name bonos.controller:bonoDeleteCtrl
         * @description
         * Definición del controlador auxiliar para eliminar bonos. 
         * @param {Object} $scope Referencia injectada al Scope definida para este
         * controlador, el scope es el objeto que contiene las variables o 
         * funciones que se definen en este controlador y que son utilizadas 
         * desde el HTML.
         * @param {Object} $http Objeto injectado para la manejar consultas HTTP
         * @param {Object} bonosContext Constante injectada que contiene la ruta
         * donde se encuentra el API de bonos en el Backend.
         * @param {Object} $state Dependencia injectada en la que se recibe el 
         * estado actual de la navegación definida en el módulo.
         * @param {Object} $rootScope Referencia injectada al Scope definida para
         * toda la aplicación.
         */
        function($scope,$state,paquetesContext,clientesContext,$http)
        {
            var idBono=$state.params.bonoId;
            $scope.clienteId=$state.params.clienteId;
            /**
             * @ngdoc function
             * @name deleteBono
             * @methodOf bonos.controller:bonosDeleteCtrl
             * @description
             * Esta función utiliza el protocolo HTTP para eliminar la editorial.
             * @param {String} id El ID de la editorial a eliminar.
             */
            $scope.deleteBono=function()
            {
                $http.delete(clientesContext+'/'+$state.params.envioId+'/'+bonosContext + '/' + idBono, {}).then(function (response) {
                    $state.go('bonosList', {bonoId: response.data.id}, {reload: true});
                });
            };
        }
        
    ]);
    
})(window.angular);


