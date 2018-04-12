/**
 * @ngdoc overview
 * @name reservas.module:reservaModule
 * @description
 * Definición del módulo de Angular de Editorial. El módulo encapsula todos los 
 * controladores y los templates HTML que estén relacionados con el reserva 
 * directamente. En la configuración del módulo se injecta la dependencia de 
 * ui.router que es la que se utiliza para la configuración de las URLs bajo las
 * cuales se accede al módulo. Por ejemplo, para mostrar las editoriales en la 
 * URL: 'localhost:8080/reservas/list' es necesario configurar el router por 
 * medio del stateProvider que informa a AngularJS de la relación entre la URL, 
 * un estado definido (estado de mostrar transportes), el controlador y la vista 
 * correspondiente. Los estados definidos en este modulo son:
 * ```
 * | ESTADO          | URL                        | VISTAS                 |
 * |-----------------|----------------------------|------------------------|
 * | reservas        | /reservas                  | mainView:              |
 * |                 |                            | reservas.html          |
 * |                 |                            |                        |
 * | reservasList    | /list                      | listView:              |
 * |                 |                            | reservas.list.html     |
 * |                 |                            |                        |
 * |-----------------|----------------------------|------------------------|
 *```
 */
(function (ng) {
    var mod = ng.module("reservasModule", ['mensajerosModule', 'ui.router']);
    mod.constant("reservasContext", "reservas");
    mod.constant("mensajerosContext", "api/mensajeros");

    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/reservas/';
            $urlRouterProvider.otherwise("/reservasList");

            $stateProvider.state('reservas', {
                url: '/reservas',
                abstract: true,
                parent: 'mensajeroDetail',
                views: {
                    childrenView: {
                        templateUrl: basePath + 'reservas.html'
                    }
                }
            }).state('reservasList', {
                url: '/list',
                parent: 'reservas',
                views: {
                    'listView': {
                        templateUrl: basePath + 'reservas.list.html',
                        controller: 'reservaCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            });
        }]);
})(window.angular);




