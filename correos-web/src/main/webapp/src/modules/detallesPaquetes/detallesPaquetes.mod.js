/**
 * @ngdoc overview
 * @name paquetes.module:paqueteModule
 * @description
 * Definición del módulo de Angular de Editorial. El módulo encapsula todos los 
 * controladores y los templates HTML que estén relacionados con el paquete 
 * directamente. En la configuración del módulo se injecta la dependencia de 
 * ui.router que es la que se utiliza para la configuración de las URLs bajo las
 * cuales se accede al módulo. Por ejemplo, para mostrar las editoriales en la 
 * URL: 'localhost:8080/paquetes/list' es necesario configurar el router por 
 * medio del stateProvider que informa a AngularJS de la relación entre la URL, 
 * un estado definido (estado de mostrar paquetes), el controlador y la vista 
 * correspondiente. Los estados definidos en este modulo son:
 * ```
 * | ESTADO          | URL                        | VISTAS                 |
 * |-----------------|----------------------------|------------------------|
 * | detallePaquetes | /detallePaquetes           | mainView:              |
 * |                 |                            | detallePaquetes.html   |
 * |                 |                            |                        |
 * | detallePaquetesList  /list                   | listView:              |
 * |                 |                            | detallePaquetes.list.html     
 * |                 |                            |                        |
 * |-----------------|----------------------------|------------------------|
 *```
 */
(function (ng) {
    var mod = ng.module("detallePaquetesModule", ['paquetesModule', 'ui.router']);
    mod.constant("detallePaquetesContext", "detallePaquetes");
    mod.constant("paquetesContext", "api/paquetes");

    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/detallePaquetes/';
            $urlRouterProvider.otherwise("/detallePaquetesText");

            $stateProvider.state('detallePaquetes', {
                url: '/detallePaquetes',
                abstract: true,
                parent: 'paqueteDetail',
                views: {
                    childrenView: {
                        templateUrl: basePath + 'detallePaquetes.html'
                    }
                }
            }).state('detallePaquetesText', {
                url: '/text',
                parent: 'detallePaquetes',
                views: {
                    'listView': {
                        templateUrl: basePath + 'detallePaquetes.text.html',
                        controller: 'detallePaqueteCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            }).state('detallePaquetesCreate', {
                url: '/create',
                parent: 'detallePaquetes',
                views: {
                    'listView': {
                        templateUrl: basePath + 'create/detallePaquetes.create.html',
                        controller: 'detallePaquetesCreateCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            }).state('detallePaquetesUpdate', {
                url: '/update',
                parent: 'detallePaquetes',
                params:{paqueteId:null},
                views: {
                    'listView': {
                        templateUrl: basePath + 'create/detallePaquetes.create.html',
                        controller: 'detallePaquetesUpdateCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            }).state('detallePaquetesDelete', {
                url: '/delete',
                parent: 'detallePaquetes',
                params:{paqueteId:null},
                views: {
                    'listView': {
                        templateUrl: basePath + 'delete/detallePaquetes.delete.html',
                        controller: 'detallePaquetesDeleteCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            });
        }]);
})(window.angular);