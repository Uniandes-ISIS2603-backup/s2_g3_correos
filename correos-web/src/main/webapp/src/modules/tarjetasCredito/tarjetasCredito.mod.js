/**
 * @ngdoc overview
 * @name tarjetasCredito.module:tarjetaCreditoModule
 * @description
 * Definición del módulo de Angular de Editorial. El módulo encapsula todos los 
 * controladores y los templates HTML que estén relacionados con el tarjetaCredito 
 * directamente. En la configuración del módulo se injecta la dependencia de 
 * ui.router que es la que se utiliza para la configuración de las URLs bajo las
 * cuales se accede al módulo. Por ejemplo, para mostrar las editoriales en la 
 * URL: 'localhost:8080/tarjetasCredito/list' es necesario configurar el router por 
 * medio del stateProvider que informa a AngularJS de la relación entre la URL, 
 * un estado definido (estado de mostrar tarjetasCredito), el controlador y la vista 
 * correspondiente. Los estados definidos en este modulo son:
 * ```
 * | ESTADO          | URL                        | VISTAS                 |
 * |-----------------|----------------------------|------------------------|
 * | tarjetasCredito     | /tarjetasCredito               | mainView:              |
 * |                 |                            | tarjetasCredito.html       |
 * |                 |                            |                        |
 * | tarjetasCreditoList | /list                      | listView:              |
 * |                 |                            | tarjetasCredito.list.html  |
 * |                 |                            |                        |
 * |-----------------|----------------------------|------------------------|
 *```
 */
(function (ng) {
    var mod = ng.module("tarjetasCreditoModule", ['clientesModule', 'ui.router']);
    mod.constant("tarjetasCreditoContext", "tarjetasCredito");
    mod.constant("clientesContext", "api/clientes");

    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/tarjetasCredito/';
            $urlRouterProvider.otherwise("/tarjetasCreditoList");

            $stateProvider.state('tarjetasCredito', {
                url: '/tarjetasCredito',
                abstract: true,
                parent: 'clienteDetail',
                views: {
                    childrenView: {
                        templateUrl: basePath + 'tarjetasCredito.html'
                    }
                }
            }).state('tarjetasCreditoList', {
                url: '/list',
                parent: 'tarjetasCredito',
                views: {
                    'listView': {
                        templateUrl: basePath + 'tarjetasCredito.list.html',
                        controller: 'tarjetaCreditoCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            }).state('tarjetasCreditoCreate', {
                url: '/create',
                parent: 'tarjetasCredito',
                views: {
                    'listView': {
                        templateUrl: basePath + 'create/tarjetasCredito.create.html',
                        controller: 'tarjetasCreditoCreateCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            }).state('tarjetasCreditoUpdate', {
                url: 'update/{tarjetaCreditoId}',
                parent: 'tarjetasCredito',
                param:{tarjetaCreditoId:null},
                views: {
                    'listView': {
                        templateUrl: basePath + 'create/tarjetasCredito.create.html',
                        controller: 'tarjetasCreditoUpdateCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            }).state('tarjetasCreditoDelete', {
                url: '/delete',
                parent: 'tarjetasCredito',
                params:{tarjetaCreditoId:null},
                views: {
                    'listView': {
                        templateUrl: basePath + 'delete/tarjetasCredito.delete.html',
                        controller: 'tarjetasCreditoDeleteCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            });
        }]);
})(window.angular);


