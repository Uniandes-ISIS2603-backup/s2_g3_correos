/**
 * @ngdoc overview
 * @name envios.module:enviosModule
 * @description
 * Definición del módulo de Angular de Envios. El módulo encapsula todos los 
 * controladores y los templates HTML que estén relacionados con los Envios 
 * directamente. En la configuración del módulo se injecta la dependencia de 
 * ui.router que es la que se utiliza para la configuración de las URLs bajo las
 * cuales se accede al módulo. Por ejemplo, para mostrar los libros en la 
 * URL: 'localhost:8080/envios/list' es necesario configurar el router por 
 * medio del stateProvider que informa a AngularJS de la relación entre la URL, 
 * un estado definido (estado de mostrar Envios), el controlador y la vista 
 * correspondiente. Los estados definidos en este modulo son:
 * ```
 * | ESTADO          | URL                        | VISTAS                 |
 * |-----------------|----------------------------|------------------------|
 * | enviosList      | /list                      | listView:              |
 * |                 |                            | envios.list.html       |
 * |                 |                            |                        |
 * | envioDetail     | /{envioId:int}/detail      | listView:              |
 * |                 |                            | envios.list.html       |
 * |                 |                            | detailView:            |
 * |                 |                            | envios.detail.html     |
 * |                 |                            |                        |
 * | envioCreate     | /create                    | detailView: (/create)  |
 * |                 |                            | /envios.create.html    |
 * |                 |                            |                        |
 * |                 |                            |                        |
 * | envioUpdate     | /update/{envioId:int}      | detailView: (/new)     |
 * |                 |                            | /envios.new.html       |
 * |                 |                            |                        |
 * | envioDelete     | /delete/{envioId:int}      | detailView: (/delete)  |
 * |                 |                            | /envios.delete.html    |
 * |                 |                            |                        |
 * |-----------------|----------------------------|------------------------|
 * |-----------------|----------------------------|------------------------|
 *```
 */
(function(ng)
    {
        var mod=ng.module("enviosModule",[]);
        mod.constant("enviosContext","api/envios");
        mod.config(['$stateProvider','$urlRouterProvider',function($stateProvider,$urlRouterProvider)
            {
                var basePath='src/modules/envios/';
                $urlRouterProvider.otherwise("/enviosList");
                
            $stateProvider.state('envios', {
               url: '/envios',
               abstract: true,
                views: {
                    'mainView': {
                        templateUrl: basePath + 'envios.html',
                        controller: 'enviosCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            }).state('enviosList',
                {
                    url:'/list',
                    parent:'envios',
                    views:
                            {
                                'listView':
                                {
                                    templateUrl:basePath+ 'envios.list.html'
                                }
                            }
                    
                }).state('envioCreate',
                {
                    url:'/create',
                    parent:'envios',
                    views:
                            {
                                'detailView':
                                {
                                    controller:'enviosCreateCtrl',
                                    controllerAs:'ctrl',
                                    templateUrl:basePath+ '/create/envios.create.html'
                                }
                                
                            }
                            }).state('envioUpdate',{
                    url:'update/{envioId}',
                    parent:'envios',
                    param:
                            {
                                envioId:null
                            },
                    views:
                            {
                                'detailView':
                                {
                                    templateUrl:basePath+'/create/envios.create.html',
                                    controller:'enviosUpdateCtrl',
                                    controllerAs:'ctrl'
                                }
                            }
                }).state('envioDelete',{
                    url:'/delete/{envioId:int}',
                    parent:'envios',
                    param:
                            {
                                envioId:null
                            },
                    views:
                            {
                              'detailView':
                              {
                                  templateUrl:basePath+'/delete/envios.delete.html',
                                  controller:'envioDeleteCtrl',
                                  controllerAs:'Ctrl'
                              }  
                            }
                }).state('envioDetail',{
                    url: '/{envioId:int}/detail',
                    parent: 'envios',
                    param: {
                        enviosId: null
                    },
                    views: {                        
                        'detailView': {
                        templateUrl: basePath + 'envios.detail.html',
                        controller: 'enviosDetailCtrl',
                        controllerAs: 'ctrl'
                    }

                }
                });
            }]);
    })(window.angular);


