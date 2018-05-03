(function(ng)
    {
        var mod=ng.module("gmapsModule",[]);
        mod.config(['$stateProvider','$urlRouterProvider',function($stateProvider,$urlRouterProvider)
            {
                var basePath='src/modules/gmaps/';
                $urlRouterProvider.otherwise("/gmaps");
                
            $stateProvider.state('gmaps', {
               url: '/gmaps',
               abstract: true,
                views: {
                    'mainView': {
                        templateUrl: basePath + 'gmaps.html',
                        controller: 'gmapsCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            });
            }]);
    })(window.angular);




