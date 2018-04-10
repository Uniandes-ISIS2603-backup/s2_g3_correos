/**
 * @ngdoc overview
 * @name mensajeros.module:mensajerosModule
 * @description
 * Definición del módulo de Angular de Mensajeros. El módulo encapsula todos los 
 * controladores y los templates HTML que estén relacionados con los Mensajeros 
 * directamente. En la configuración del módulo se injecta la dependencia de 
 * ui.router que es la que se utiliza para la configuración de las URLs bajo las
 * cuales se accede al módulo. Por ejemplo, para mostrar los libros en la 
 * URL: 'localhost:8080/mensajeros/list' es necesario configurar el router por 
 * medio del stateProvider que informa a AngularJS de la relación entre la URL, 
 * un estado definido (estado de mostrar Mensajeros), el controlador y la vista 
 * correspondiente. Los estados definidos en este modulo son:
 * ```
 * | ESTADO          | URL                        | VISTAS                 |
 * |-----------------|----------------------------|------------------------|
 * | mensajerosList  | /list                      | listView:              |
 * |                 |                            | mensajeros.list.html   |
 * |                 |                            |                        |
 * | mensajeroDetail | /{mensajeroId:int}/detail  | listView:              |
 * |                 |                            | mensajeros.list.html   |
 * |                 |                            | detailView:            |
 * |                 |                            | mensajeros.detail.html |
 * |                 |                            |                        |
 * | mensajeroCreate | /create                    | detailView: (/create)  |
 * |                 |                            | /mensajeros.create.html|
 * |                 |                            |                        |
 * | mensajeroUpdate | /update/{mensajeroId:int}  | detailView: (/new)     |
 * |                 |                            | /mensajeros.new.html   |
 * |                 |                            |                        |
 * | mensajeroDelete | /delete/{mensajeroId:int}  | detailView: (/delete)  |
 * |                 |                            | /mensajeros.delete.html|
 * |                 |                            |                        |
 * |-----------------|----------------------------|------------------------|
 *```
 */
(function(ng)
    {
        var mod=ng.module("mensajerosModule",[]);
        mod.constant("mensajerosContext","api/mensajeros");
        mod.config(['$stateProvider','$urlRouterProvider',function($stateProvider,$urlRouterProvider)
            {
                var basePath='src/modules/mensajeros/';
                $urlRouterProvider.otherwise("/mensajerosList");
                
            $stateProvider.state('mensajeros', {
               url: '/mensajeros',
               abstract: true,
                views: {
                    'mainView': {
                        templateUrl: basePath + 'mensajeros.html',
                        controller: 'mensajerosCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            }).state('mensajerosList',
                {
                    url:'/list',
                    parent:'mensajeros',
                    views:
                            {
                                'listView':
                                {
                                    templateUrl:basePath+ 'mensajeros.list.html'
                                }
                            }
                    
                }).state('mensajeroCreate',
                {
                    url:'/create',
                    parent:'mensajeros',
                    views:
                            {
                                'detailView':
                                {
                                    controller:'mensajerosCreateCtrl',
                                    controllerAs:'ctrl',
                                    templateUrl:basePath+ '/create/mensajeros.create.html'
                                }
                                
                            }
                }).state('mensajeroUpdate',{
                    url:'update/{mensajeroId}',
                    parent:'mensajeros',
                    param:
                            {
                                mensajeroId:null
                            },
                    views:
                            {
                                'detailView':
                                {
                                    templateUrl:basePath+'/create/mensajeros.create.html',
                                    controller:'mensajerosUpdateCtrl',
                                    controllerAs:'ctrl'
                                }
                            }
                }).state('mensajeroDelete',{
                    url:'/delete/{mensajeroId:int}',
                    parent:'mensajeros',
                    param:
                            {
                                mensajeroId:null
                            },
                    views:
                            {
                              'detailView':
                              {
                                  templateUrl:basePath+'/delete/mensajeros.delete.html',
                                  controller:'mensajeroDeleteCtrl',
                                  controllerAs:'Ctrl'
                              }  
                            }
                }).state('mensajeroDetail',{
                    url: '/{mensajeroId:int}/detail',
                    parent: 'mensajeros',
                    param: {
                        mensajeroId: null
                    },
                    views: {
                       
                        'detailView': {
                        templateUrl: basePath + 'mensajeros.detail.html',
                        controller: 'mensajerosDetailCtrl',
                        controllerAs: 'ctrl'
                    }

                }
                });
            }]);
    })(window.angular);


