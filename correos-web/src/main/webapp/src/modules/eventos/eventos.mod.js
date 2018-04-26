(function(ng)
    {
        var mod=ng.module("eventosModule",['enviosModule','ui.router']);
        mod.constant("eventosContext","eventos");
        mod.constant("enviosContext","api/envios")
        mod.config(['$stateProvider','$urlRouterProvider',function($stateProvider,$urlRouterProvider)
            {
                var basePath='src/modules/eventos/';
                $urlRouterProvider.otherwise("/eventosList");
                
            $stateProvider.state('eventos', {
               url: '/eventos',
               abstract: true,
               parent: 'envioDetail',
                views: {
                    childrenView: {
                        templateUrl: basePath + 'eventos.html'
                    }
                }
            }).state('eventosList',
                {
                    url:'/list',
                    parent:'eventos',
                    views:
                            {
                                'listView':
                                {
                                    templateUrl:basePath+ 'eventos.list.html',
                                    controller: 'eventoCtrl',
                                    controllerAs: 'ctrl'
                                }
                            }
                    
                }).state('eventoCreate',
                {
                    url:'/create',
                    parent:'eventos',
                    views:
                            {
                                'detailView':
                                {
                                    controller:'eventosCreateCtrl',
                                    controllerAs:'ctrl',
                                    templateUrl:basePath+ '/create/eventos.create.html'
                                }
                                
                            }
                }).state('eventoUpdate',{
                    url:'update/{eventoId}',
                    parent:'eventos',
                    param:
                            {
                                eventoId:null
                            },
                    views:
                            {
                                'detailView':
                                {
                                    templateUrl:basePath+'/create/eventos.create.html',
                                    controller:'eventosUpdateCtrl',
                                    controllerAs:'ctrl'
                                }
                            }
                }).state('eventoDelete',{
                    url:'/delete/{eventoId:int}',
                    parent:'eventos',
                    param:
                            {
                                eventoId:null
                            },
                    views:
                            {
                              'detailView':
                              {
                                  templateUrl:basePath+'/delete/eventos.delete.html',
                                  controller:'eventoDeleteCtrl',
                                  controllerAs:'Ctrl'
                              }  
                            }
                }).state('eventoDetail',{
                    url: '/{eventoId:int}/detail',
                    parent: 'eventos',
                    param: {
                        eventoId: null
                    },
                    views: {
                       
                        'detailView': {
                        templateUrl: basePath + 'eventos.detail.html',
                        controller: 'eventosDetailCtrl',
                        controllerAs: 'ctrl'
                    }

                }
                });
            }]);
    })(window.angular);
