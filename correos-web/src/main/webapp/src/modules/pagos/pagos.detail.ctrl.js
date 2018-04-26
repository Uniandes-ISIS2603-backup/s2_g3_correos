

(function (ng) {
    var mod = ng.module("pagosModule");
    mod.constant("pagosContext", "pagos");
    mod.constant("cuentasBancariasContext","api/cuentasBancarias");
    mod.controller('pagosDetailCtrl', ['$scope','$http','cuentasBancariasContext', 'pagosContext', '$state',
         /**
         * @ngdoc controller
         * @name pagos.controller:pagosDetailCtrl
         * @description
         * Definición de un controlador auxiliar del módulo pagos. 
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
        function($scope,$http, cuentasBancariasContext, pagosContext,$state)
        {
            if($state.params.pagoId!==null&&$state.params.pagoId!==undefined)
            {
                 /**
                * @ngdoc function
                * @name getPagoID
                * @methodOf Pagos.controller:pagosDetailCtrl
                * @description
                * Esta función utiliza el protocolo HTTP para obtener el recurso 
                * donde se encuentra la pago por ID en formato JSON.
                * @param {String} URL Dirección donde se encuentra el recurso
                * de la pago o API donde se puede consultar.
                */
                $http.get(cuentasBancariasContext+'/'+$state.params.cuentaBancariaId+'/'+pagosContext+"/"+$state.params.pagoId).then(function(response)
                {
                    $scope.pagoActual=response.data;
                });
            }
        }
    ]);
})(window.angular);

