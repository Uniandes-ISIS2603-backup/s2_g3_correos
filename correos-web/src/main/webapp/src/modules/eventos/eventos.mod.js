(function(ng)
    {
        var mod=ng.module("eventosModule",[]);
        mod.constant("eventosContext","api/eventos");
        mod.config(['$stateProvider','$urlRouterProvider',function($stateProvider,$urlRouterProvider)
            {
                var basePath='src/modules/eventos/';
                $urlRouterProvider.otherwise("/eventosList");
                
            $stateProvider.state('eventos', {
               url: '/eventos',
               abstract: true,
                views: {
                    'mainView': {
                        templateUrl: basePath + 'eventos.html',
                        controller: 'eventoCtrl',
                        controllerAs: 'ctrl'
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
                    
                });
            }]);
    })(window.angular);
