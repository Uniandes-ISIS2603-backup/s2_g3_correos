/**
 * @ngdoc overview
 * @name zonas.module:zonasModule
 * @description
 * Definición del módulo de Angular de zonas. El módulo encapsula todos los 
 * controladores y los templates HTML que estén relacionados con las zonas 
 * directamente. En la configuración del módulo se injecta la dependencia de 
 * ui.router que es la que se utiliza para la configuración de las URLs bajo las
 * cuales se accede al módulo. Por ejemplo, para mostrar los libros en la 
 * URL: 'localhost:8080/zonas/list' es necesario configurar el router por 
 * medio del stateProvider que informa a AngularJS de la relación entre la URL, 
 * un estado definido (estado de mostrar zonas), el controlador y la vista 
 * correspondiente. Los estados definidos en este modulo son:
 * ```
 * | ESTADO          | URL                        | VISTAS                 |
 * |-----------------|----------------------------|------------------------|
 * | zonasList       | /list                      | listView:              |
 * |                 |                            | zonas.list.html        |
 * |                 |                            |                        |
 * | zonaDetail      | /{zonaId:int}/detail       | listView:              |
 * |                 |                            | zonas.list.html        |
 * |                 |                            | detailView:            |
 * |                 |                            | zonas.detail.html      |
 * |                 |                            |                        |
 * | zonaCreate      | /create                    | detailView: (/create)  |
 * |                 |                            | /zonas.create.html     |
 * |                 |                            |                        |
 * | zonaUpdate      | /update/{zonaId:int}       | detailView: (/new)     |
 * |                 |                            | /zonas.new.html        |
 * |                 |                            |                        |
 * |-----------------|----------------------------|------------------------|
 *```
 */
(function(ng)
    {
        var mod=ng.module("zonasModule",[]);
        mod.constant("zonasContext","api/zonas");
        mod.config(['$stateProvider','$urlRouterProvider',function($stateProvider,$urlRouterProvider)
            {
                var basePath='src/modules/zonas/';
                $urlRouterProvider.otherwise("/zonasList");
                
            $stateProvider.state('zonas', {
               url: '/zonas',
               abstract: true,
                views: {
                    'mainView': {
                        templateUrl: basePath + 'zonas.html',
                        controller: 'zonasCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            }).state('zonasList',
                {
                    url:'/list',
                    parent:'zonas',
                    views:
                            {
                                'listView':
                                {
                                    templateUrl:basePath+ 'zonas.list.html'
                                }
                            }
                    
                }).state('zonaCreate',
                {
                    url:'/create',
                    parent:'zonas',
                    views:
                            {
                                'detailView':
                                {
                                    controller:'zonasCreateCtrl',
                                    controllerAs:'ctrl',
                                    templateUrl:basePath+ '/create/zonas.create.html'
                                }
                                
                            }
                }).state('zonaUpdate',{
                    url:'update/{zonaId}',
                    parent:'zonas',
                    param:
                            {
                                zonaId:null
                            },
                    views:
                            {
                                'detailView':
                                {
                                    templateUrl:basePath+'/create/zonas.create.html',
                                    controller:'zonasUpdateCtrl',
                                    controllerAs:'ctrl'
                                }
                            }
                }).state('zonaDetail',{
                    url: '/{zonaId:int}/detail',
                    parent: 'zonas',
                    param: {
                       zonaId: null
                    },
                    views: {
                       
                        'detailView': {
                        templateUrl: basePath + 'zonas.detail.html',
                        controller: 'zonasDetailCtrl',
                        controllerAs: 'ctrl'
                    }

                }
                });
            }]);
    })(window.angular);


