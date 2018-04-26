(function(ng)
    {
        var mod=ng.module("pagosModule",['cuentasBancariasModule','ui.router']);
   mod.constant("pagosContext","pagos");
   mod.constant("cuentasBancariasContext","api/cuentasBancarias");
        mod.config(['$stateProvider','$urlRouterProvider',function($stateProvider,$urlRouterProvider)
            {
                var basePath='src/modules/pagos/';
                $urlRouterProvider.otherwise("/pagosList");
                
            $stateProvider.state('pagos', {
               url: '/pagos',
               abstract: true,
                parent: 'cuentaBancariaDetail',
                views: {
                    childrenView: {
                        templateUrl: basePath + 'pagos.html'
                    }
                }
            }).state('pagosList',
                {
                    url:'/list',
                    parent:'pagos',
                    views:
                            {
                                'listView':
                                {
                                    templateUrl:basePath+ 'pagos.list.html',
                                    controller: 'pagoCtrl',
                                    controllerAs: 'ctrl'
                                }
                            }
                    
                }).state('pagoCreate',
                {
                    url:'/create',
                    parent:'pagos',
                    views:
                            {
                                'detailView':
                                {
                                    controller:'pagosCreateCtrl',
                                    controllerAs:'ctrl',
                                    templateUrl:basePath+ '/create/pagos.create.html'
                                }
                                
                            }
                }).state('pagoDetail',{
                    url: '/{pagoId:int}/detail',
                    parent: 'pagos',
                    param: {
                        pagoId: null
                    },
                    views: {
                       
                        'detailView': {
                        templateUrl: basePath + 'pagos.detail.html',
                        controller: 'pagosDetailCtrl',
                        controllerAs: 'ctrl'
                    }

                }
                }).state('pagoDelete',{
                    url:'/delete/{pagoId:int}',
                    parent:'pagos',
                    param:
                            {
                                pagoId:null
                            },
                    views:
                            {
                              'detailView':
                              {
                                  templateUrl:basePath+'/delete/pagos.delete.html',
                                  controller:'pagoDeleteCtrl',
                                  controllerAs:'Ctrl'
                              }  
                            }
                }).state('pagoUpdate',{
                    url:'update/{pagoId}',
                    parent:'pagos',
                    param:
                            {
                                pagoId:null
                            },
                    views:
                            {
                                'detailView':
                                {
                                    templateUrl:basePath+'/create/pagos.create.html',
                                    controller:'pagosUpdateCtrl',
                                    controllerAs:'ctrl'
                                }
                            }
                });
            }]);
    })(window.angular);
