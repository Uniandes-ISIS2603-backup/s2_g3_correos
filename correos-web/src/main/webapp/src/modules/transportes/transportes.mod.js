/**
 * @ngdoc overview
 * @name transportes.module:transporteModule
 * @description
 * Definición del módulo de Angular de Editorial. El módulo encapsula todos los 
 * controladores y los templates HTML que estén relacionados con el transporte 
 * directamente. En la configuración del módulo se injecta la dependencia de 
 * ui.router que es la que se utiliza para la configuración de las URLs bajo las
 * cuales se accede al módulo. Por ejemplo, para mostrar las editoriales en la 
 * URL: 'localhost:8080/transportes/list' es necesario configurar el router por 
 * medio del stateProvider que informa a AngularJS de la relación entre la URL, 
 * un estado definido (estado de mostrar transportes), el controlador y la vista 
 * correspondiente. Los estados definidos en este modulo son:
 * ```
 * | ESTADO          | URL                        | VISTAS                 |
 * |-----------------|----------------------------|------------------------|
 * | transportes     | /transportes               | mainView:              |
 * |                 |                            | transportes.html       |
 * |                 |                            |                        |
 * | transportesList | /list                      | listView:              |
 * |                 |                            | transportes.list.html  |
 * |                 |                            |                        |
 * |-----------------|----------------------------|------------------------|
 *```
 */
(function (ng) {
    var mod = ng.module("transportesModule", ['mensajerosModule', 'ui.router']);
    mod.constant("transportesContext", "transportes");
    mod.constant("mensajerosContext", "api/mensajeros");

    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/transportes/';
            $urlRouterProvider.otherwise("/transportesList");

            $stateProvider.state('transportes', {
                url: '/transportes',
                abstract: true,
                parent: 'mensajeroDetail',
                views: {
                    childrenView: {
                        templateUrl: basePath + 'transportes.html'
                    }
                }
            }).state('transportesList', {
                url: '/list',
                parent: 'transportes',
                views: {
                    'listView': {
                        templateUrl: basePath + 'transportes.list.html',
                        controller: 'transporteCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            }).state('transportesCreate', {
                url: '/create',
                parent: 'transportes',
                views: {
                    'listView': {
                        templateUrl: basePath + 'create/transportes.create.html',
                        controller: 'transportesCreateCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            });
        }]);
})(window.angular);


