/**
 * @ngdoc overview
 * @name paquetes.module:paqueteModule
 * @description
 * Definición del módulo de Angular de Paquete. El módulo encapsula todos los 
 * controladores y los templates HTML que estén relacionados con el paquete 
 * directamente. En la configuración del módulo se injecta la dependencia de 
 * ui.router que es la que se utiliza para la configuración de las URLs bajo las
 * cuales se accede al módulo. Por ejemplo, para mostrar las editoriales en la 
 * URL: 'localhost:8080/paquetes/list' es necesario configurar el router por 
 * medio del stateProvider que informa a AngularJS de la relación entre la URL, 
 * un estado definido (estado de mostrar editoriales), el controlador y la vista 
 * correspondiente. Los estados definidos en este modulo son:
 * ```
 * | ESTADO          | URL                        | VISTAS                 |
 * |-----------------|----------------------------|------------------------|
 * | paquetes        | /paquetes                  | mainView:              |
 * |                 |                            | paquetes.html          |
 * |                 |                            |                        |
 * | paquetesList    | /list                      | listView:              |
 * |                 |                            | paquetes.list.html     |
 * |                 |                            |                        |
 * |-----------------|----------------------------|------------------------|
 *```
 */
(function (ng) {
    var mod = ng.module("paquetesModule", ['enviosModule', 'ui.router']);
    mod.constant("paquetesContext", "paquetes");
    mod.constant("enviosContext", "api/envios");

    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/paquetes/';
            $urlRouterProvider.otherwise("/paquetesList");

            $stateProvider.state('paquetes', {
                url: '/paquetes',
                abstract: true,
                parent: 'envioDetail',
                views: {
                    childrenView: {
                        templateUrl: basePath + 'paquetes.html'
                    }
                }
            }).state('paquetesList', {
                url: '/list',
                parent: 'paquetes',
                views: {
                    'listView': {
                        templateUrl: basePath + 'paquetes.list.html',
                        controller: 'paqueteCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            });
        }]);
})(window.angular);


