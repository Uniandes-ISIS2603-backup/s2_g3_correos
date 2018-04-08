(function(ng)
    {
        var mod=ng.module("mensajerosModule",[]);
        mod.constant("mensajerosContext","api/mensajeros");
        mod.config(['$stateProvider','$urlRouterProvider',function($stateProvider,$urlRouterProvider)
            {
                var basePath='src/modules/mensajeros/';
                $urlRouterProvider.otherwise("/mensajerosList");
                
                $stateProvider.state('mensajerosList',
                {
                    url:'/mensajeros',
                    views:
                            {
                                'mainView':
                                {
                                    controller:'mensajerosCtrl',
                                    controllerAs:'ctrl',
                                    templateUrl:basePath+ 'mensajeros.list.html'
                                }
                            }
                    
                }).state('mensajeroCreate',
                {
                    url:'/mensajeros/create',
                    views:
                            {
                                'mainView':
                                {
                                    controller:'mensajerosCtrl',
                                    controllerAs:'ctrl',
                                    templateUrl:basePath+ 'mensajeros.create.html'
                                }
                                
                            }
                });
            }]);
    })(window.angular);


