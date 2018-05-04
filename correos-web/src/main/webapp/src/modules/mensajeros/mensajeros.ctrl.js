(function(ng)
{
   var mod=ng.module("mensajerosModule");
   mod.constant("mensajerosContext","api/mensajeros");
   mod.controller('mensajerosCtrl',['$scope', '$http', 'mensajerosContext',
   
          /**
         * @ngdoc controller
         * @name mensajeros.controller:mensajerosCtrl
         * @description
         * Definición del controlador de Angular del módulo mensajeros. 
         * Se crea el controlador con el cual se maneja el módulo.
         * En el controlador se definen los atributos y métodos que pueden
         * ser accedidos desde el HTML utilizando el $scope.
         * @param {Object} $scope Referencia injectada al Scope definida para este
         * controlador, el scope es el objeto que contiene las variables o 
         * funciones que se definen en este controlador y que son utilizadas 
         * desde el HTML.
         * @param {Object} $http Objeto injectado para la manejar consultas HTTP
         * @param {Object} mensajeros Context Constante injectada que contiene la ruta
         * donde se encuentra el API de Correos en el Backend.
         * @param {Object} $state Dependencia injectada en la que se recibe el 
         * estado actual de la navegación definida en el módulo.
         */
        function($scope,$http, mensajerosContext)
        {
            /**
             * @ngdoc function
             * @name getMensajeros
             * @methodOf mensajeros.controller:mensajerosCtrl
             * @description
             * Esta función utiliza el protocolo HTTP para obtener el recurso 
             * donde se encuentran los mensajeros en formato JSON. El recurso
             * puede ser un archivo o un API Rest. La función se ejecuta
             * automáticamente cuando el controlador es accedido desde el
             * navegador.
             * @param {String} URL Dirección donde se encuentra el recurso
             * de los mensajeros o API donde se puede consultar.
             */
            $http.get(mensajerosContext).then(function(response)
            {
                $scope.mensajerosRecords=response.data;
            });
        }
        
   ]);
}
)(window.angular);

