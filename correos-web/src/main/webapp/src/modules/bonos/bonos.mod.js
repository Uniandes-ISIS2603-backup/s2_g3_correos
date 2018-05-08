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
 * | bonos           | /bonos                     | mainView:              |
 * |                 |                            | bonos.html             |
 * |                 |                            |                        |
 * | bonosList       | /list                      | listView:              |
 * |                 |                            | bonos.list.html        |
 * |                 |                            |                        |
 * |-----------------|----------------------------|------------------------|
 *```
 */
(function (ng) {
    var mod = ng.module("bonosModule", ['clientesModule', 'ui.router']);
    mod.constant("bonosContext", "bonos");
    mod.constant("clientesContext", "api/clientes");

    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/bonos/';
            $urlRouterProvider.otherwise("/bonosList");

            $stateProvider.state('bonos', {
                url: '/bonos',
                abstract: true,
                parent: 'clienteDetail',
                views: {
                    childrenView: {
                        templateUrl: basePath + 'bonos.html'
                    }
                }
            }).state('bonosList', {
                url: '/list',
                parent: 'bonos',
                views: {
                    'listView': {
                        templateUrl: basePath + 'bonos.list.html',
                        controller: 'bonoCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            }).state('bonosCreate', {
                url: '/create',
                parent: 'bonos',
                views: {
                    'listView': {
                        templateUrl: basePath + 'create/bonos.create.html',
                        controller: 'bonosCreateCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            }).state('bonoUpdate', {
                url: '/update',
                parent: 'bonos',
                params:{bonoId:null},
                views: {
                    'listView': {
                        templateUrl: basePath + 'create/bonos.create.html',
                        controller: 'bonosUpdateCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            }).state('bonosDelete', {
                url: '/delete',
                parent: 'bonos',
                params:{bonoId:null},
                views: {
                    'listView': {
                        templateUrl: basePath + 'delete/bonos.delete.html',
                        controller: 'bonosDeleteCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            });
        }]);
})(window.angular);
