/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


(function(ng)
    {
        var mod=ng.module("analiticaModule",[]);
        mod.constant("analiticaContext","api/analitica");
        mod.config(['$stateProvider','$urlRouterProvider',function($stateProvider,$urlRouterProvider)
            {
                var basePath='src/modules/analitica/';
                $urlRouterProvider.otherwise("/analiticaList");
                
            $stateProvider.state('analitica', {
               url: '/analitica',
               abstract: true,
                views: {
                    'mainView': {
                        templateUrl: basePath + 'analitica.html',
                        controller: 'analiticaCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            }).state('analiticaList',
                {
                    url:'/list',
                    parent:'analitica',
                    views:
                            {
                                'listView':
                                {
                                    templateUrl:basePath+ '/analitica.list.html'
                                }
                            }
                    
                });
            }]);
    })(window.angular);
            