(function (ng) {
    var mod = ng.module("cuentasBancariasModule");
    mod.constant("cuentasBancariasContext", "api/cuentasBancarias");
    mod.controller('cuentasBancariasDetailCtrl', ['$scope', '$http', 'cuentasBancariasContext', '$state',
         /**
         * @ngdoc controller
         * @name cuentasBancarias.controller:cuentasBancariasDetailCtrl
         * @description
         * Definición de un controlador auxiliar del módulo CuentasBancarias. 
         * Se crea el controlador con el cual se manejan las vistas de detalle
         * del módulo.
         * @param {Object} $scope Referencia injectada al Scope definida para este
         * controlador, el scope es el objeto que contiene las variables o 
         * funciones que se definen en este controlador y que son utilizadas 
         * desde el HTML.
         * @param {Object} $http Objeto injectado para la manejar consultas HTTP
         * @param {Object} booksContext Constante injectada que contiene la ruta
         * donde se encuentra el API de Correos en el Backend.
         * @param {Object} $state Dependencia injectada en la que se recibe el 
         * estado actual de la navegación definida en el módulo.
         */
        function($scope,$http, cuentasBancariasContext,$state)
        {
            if($state.params.cuentaBancariaId!==null&&$state.params.cuentaBancariaId!==undefined)
            {
                 /**
                * @ngdoc function
                * @name getCuentaBancariaID
                * @methodOf CuentasBancarias.controller:cuentasBancariasDetailCtrl
                * @description
                * Esta función utiliza el protocolo HTTP para obtener el recurso 
                * donde se encuentra el cuentaBancaria por ID en formato JSON.
                * @param {String} URL Dirección donde se encuentra el recurso
                * del cuentaBancaria o API donde se puede consultar.
                */
                $http.get(cuentasBancariasContext+"/"+$state.params.cuentaBancariaId).then(function(response)
                {
                    $scope.cuentaBancariaActual=response.data;
                });
            }
        }
    ]);
})(window.angular);

