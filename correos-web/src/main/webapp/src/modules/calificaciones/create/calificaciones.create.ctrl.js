(function(ng){
    
    var mod = ng.module("calificacionesModule");
    mod.constant("calificacionesContext", "calificaciones");
    mod.constant("mensajerosContext", "api/mensajeros");
    mod.controller('calificacionesCreateCtrl', ['$scope', '$http', 'mensajerosContext', '$state', 'calificacionesContext',
        /**
         * @ngdoc controller
         * @name calificaciones.controller:calificacionesUpdateCtrl
         * @description
         * Definición del controlador auxiliar para actualizar Calificacioness. 
         * @param {Object} $scope Referencia injectada al Scope definida para este
         * controlador, el scope es el objeto que contiene las variables o 
         * funciones que se definen en este controlador y que son utilizadas 
         * desde el HTML.
         * @param {Object} $http Objeto injectado para la manejar consultas HTTP
         * @param {Object} CalifiacionesContext Constante injectada que contiene la ruta
         * donde se encuentra el API de Editoriales en el Backend.
         * @param {Object} $state Dependencia injectada en la que se recibe el 
         * estado actual de la navegación definida en el módulo.
         */
        function($scope, $http , mensajerosContext , $state, $rootScope, calificacionesContext)
        {
            $rootScope.edit=false;
            $scope.data={};
            
            /**
             * @ngdoc function
             * @name createZona
             * @methodOf zonas.controller:ZonaUpdateCtrl
             * @description
             * Esta función utiliza el protocolo HTTP para actualizar la zona 
             * por ID en formato JSON.
             * @param {String} id El ID de la zona que se va a actualizar.
             * @param {Object} zona Objeto con la información nueva de la zona.
             */
            $scope.createCalificacion=function()
            {
                
                $http.post(mensajerosContext  + "/"+$state.params.mensajeroId + "/calificaciones",$scope.data ).then(function(response)
                {
                    $state.go('calificacionesList',{calificacionId:response.data.id},{reload:true});
                });
            };
        }
    ]);
    
})(window.angular);

