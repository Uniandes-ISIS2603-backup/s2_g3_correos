(function(ng)
{
   var mod=ng.module("eventosModule");
   mod.constant("eventosContext","eventos");
   mod.constant("enviosContext","api/envios");
   mod.controller('eventoCtrl',['$scope', '$http', 'enviosContext', '$state','eventosContext',
   
          /**
         * @ngdoc controller
         * @name eventos.controller:eventosCtrl
         * @description
         * Definición del controlador de Angular del módulo eventos. 
         * Se crea el controlador con el cual se maneja el módulo.
         * En el controlador se definen los atributos y métodos que pueden
         * ser accedidos desde el HTML utilizando el $scope.
         * @param {Object} $scope Referencia injectada al Scope definida para este
         * controlador, el scope es el objeto que contiene las variables o 
         * funciones que se definen en este controlador y que son utilizadas 
         * desde el HTML.
         * @param {Object} $http Objeto injectado para la manejar consultas HTTP
         * @param {Object} eventos Context Constante injectada que contiene la ruta
         * donde se encuentra el API de Correos en el Backend.
         * @param {Object} $state Dependencia injectada en la que se recibe el 
         * estado actual de la navegación definida en el módulo.
         */
        function($scope,$http, enviosContext,$state,eventosContext)
        {
            /**
             * @ngdoc function
             * @name getEventos
             * @methodOf eventos.controller:eventosCtrl
             * @description
             * Esta función utiliza el protocolo HTTP para obtener el recurso 
             * donde se encuentran los eventos en formato JSON. El recurso
             * puede ser un archivo o un API Rest. La función se ejecuta
             * automáticamente cuando el controlador es accedido desde el
             * navegador.
             * @param {String} URL Dirección donde se encuentra el recurso
             * de los eventos o API donde se puede consultar.
             */
            $http.get(enviosContext+'/'+$state.params.envioId+'/'+eventosContext).then(function(response)
            {
                $scope.eventosRecords=response.data;
            });
        }
        
   ]);
}
)(window.angular);

