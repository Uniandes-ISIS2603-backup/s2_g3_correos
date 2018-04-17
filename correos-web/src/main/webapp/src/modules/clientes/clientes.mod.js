/**
 * @ngdoc overview
 * @name clientes.module:clientesModule
 * @description
 * Definición del módulo de Angular de Clientes. El módulo encapsula todos los 
 * controladores y los templates HTML que estén relacionados con los Clientes 
 * directamente. En la configuración del módulo se injecta la dependencia de 
 * ui.router que es la que se utiliza para la configuración de las URLs bajo las
 * cuales se accede al módulo. Por ejemplo, para mostrar los libros en la 
 * URL: 'localhost:8080/clientes/list' es necesario configurar el router por 
 * medio del stateProvider que informa a AngularJS de la relación entre la URL, 
 * un estado definido (estado de mostrar Clientes), el controlador y la vista 
 * correspondiente. Los estados definidos en este modulo son:
 * ```
 * | ESTADO          | URL                        | VISTAS                 |
 * |-----------------|----------------------------|------------------------|
 * | clientesList  | /list                      | listView:              |
 * |                 |                            | clientes.list.html   |
 * |                 |                            |                        |
 * | clienteDetail | /{clienteId:int}/detail  | listView:              |
 * |                 |                            | clientes.list.html   |
 * |                 |                            | detailView:            |
 * |                 |                            | clientes.detail.html |
 * |                 |                            |                        |
 * | clienteCreate | /create                    | detailView: (/create)  |
 * |                 |                            | /clientes.create.html|
 * |                 |                            |                        |
 * | clienteUpdate | /update/{clienteId:int}  | detailView: (/new)     |
 * |                 |                            | /clientes.new.html   |
 * |                 |                            |                        |
 * | clienteDelete | /delete/{clienteId:int}  | detailView: (/delete)  |
 * |                 |                            | /clientes.delete.html|
 * |                 |                            |                        |
 * |-----------------|----------------------------|------------------------|
 *```
 */
(function(ng)
    {
        var mod=ng.module("clientesModule",[]);
        mod.constant("clientesContext","api/clientes");
        mod.config(['$stateProvider','$urlRouterProvider',function($stateProvider,$urlRouterProvider)
            {
                var basePath='src/modules/clientes/';
                $urlRouterProvider.otherwise("/clientesList");
                
            $stateProvider.state('clientes', {
               url: '/clientes',
               abstract: true,
                views: {
                    'mainView': {
                        templateUrl: basePath + 'clientes.html',
                        controller: 'clientesCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            }).state('clientesList',
                {
                    url:'/list',
                    parent:'clientes',
                    views:
                            {
                                'listView':
                                {
                                    templateUrl:basePath+ 'clientes.list.html'
                                }
                            }
                    
                }).state('clienteCreate',
                {
                    url:'/create',
                    parent:'clientes',
                    views:
                            {
                                'detailView':
                                {
                                    controller:'clientesCreateCtrl',
                                    controllerAs:'ctrl',
                                    templateUrl:basePath+ '/create/clientes.create.html'
                                }
                                
                            }
                }).state('clienteUpdate',{
                    url:'update/{clienteId}',
                    parent:'clientes',
                    param:
                            {
                                clienteId:null
                            },
                    views:
                            {
                                'detailView':
                                {
                                    templateUrl:basePath+'/create/clientes.create.html',
                                    controller:'clientesUpdateCtrl',
                                    controllerAs:'ctrl'
                                }
                            }
                }).state('clienteDelete',{
                    url:'/delete/{clienteId:int}',
                    parent:'clientes',
                    param:
                            {
                                clienteId:null
                            },
                    views:
                            {
                              'detailView':
                              {
                                  templateUrl:basePath+'/delete/clientes.delete.html',
                                  controller:'clienteDeleteCtrl',
                                  controllerAs:'Ctrl'
                              }  
                            }
                }).state('clienteDetail',{
                    url: '/{clienteId:int}/detail',
                    parent: 'clientes',
                    param: {
                        clienteId: null
                    },
                    views: {
                       
                        'detailView': {
                        templateUrl: basePath + 'clientes.detail.html',
                        controller: 'clientesDetailCtrl',
                        controllerAs: 'ctrl'
                    }

                }
                });
            }]);
    })(window.angular);


