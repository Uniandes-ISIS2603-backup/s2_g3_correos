 
(function(ng)
    {
        var mod=ng.module("webModule",[]);
        mod.config(['$stateProvider','$urlRouterProvider',function($stateProvider,$urlRouterProvider)
            {
                var basePath='src/modules/web/';
                $urlRouterProvider.otherwise("/web");
                
            $stateProvider.state('home', {
               url: '/webIndex',
                views: {
                    'mainView': {
                        templateUrl: basePath + 'web.home.html',
                        controller: 'webHomeCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            });
            }]);
    })(window.angular);

