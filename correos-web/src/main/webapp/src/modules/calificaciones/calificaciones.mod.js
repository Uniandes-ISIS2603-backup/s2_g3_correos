/**
 * @ngdoc overview
 * @name calificaciones.module:calificacionModule
 * @description
 * Definición del módulo de Angular de Editorial. El módulo encapsula todos los 
 * controladores y los templates HTML que estén relacionados con la calificacion
 * directamente. En la configuración del módulo se injecta la dependencia de 
 * ui.router que es la que se utiliza para la configuración de las URLs bajo las
 * cuales se accede al módulo. Por ejemplo, para mostrar las editoriales en la 
 * URL: 'localhost:8080/calificaciones/list' es necesario configurar el router por 
 * medio del stateProvider que informa a AngularJS de la relación entre la URL, 
 * un estado definido (estado de mostrar calificaciones), el controlador y la vista 
 * correspondiente. Los estados definidos en este modulo son:
 * ```
 * | ESTADO            | URL                        | VISTAS                  |
 * |-------------------|----------------------------|-------------------------|
 * | calificaciones    | /calificaciones            | mainView:               |
 * |                   |                            | calificaciones.html     |
 * |                   |                            |                         |
 * | calificacionesList| /list                      | listView:               |
 * |                   |                            | calificaciones.list.html|
 * |                   |                            |                         |
 * |-------------------|----------------------------|-------------------------|
 *```
 */
(function (ng) {
    var mod = ng.module("calificacionesModule", ['mensajerosModule', 'ui.router']);
    mod.constant("calificacionesContext", "calificaciones");
    mod.constant("mensajerosContext", "api/mensajeros");

    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/calificaciones/';
            $urlRouterProvider.otherwise("/calificacionesList");

            $stateProvider.state('calificaciones', {
                url: '/calificaciones',
                abstract: true,
                parent: 'mensajeroDetail',
                views: {
                    childrenView: {
                        templateUrl: basePath + 'calificaciones.html'
                    }
                }
            }).state('calificacionesList', {
                url: '/list',
                parent: 'calificaciones',
                views: {
                    'listView': {
                        templateUrl: basePath + 'calificaciones.list.html',
                        controller: 'calificacionCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            }).state('califiacionUpdate',{
                    url:'update/{califiacionId}',
                    parent:'califiaciones',
                    param:
                            {
                                zonaId:null
                            },
                    views:
                            {
                                'detailView':
                                {
                                    templateUrl:basePath+'/update/califiaciones.update.html',
                                    controller:'calificaionesUpdateCtrl',
                                    controllerAs:'ctrl'
                                }
                            }
                });
        }]);
})(window.angular);


