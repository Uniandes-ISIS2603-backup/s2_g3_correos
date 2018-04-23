/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


(function (ng) {
    var mod = ng.module("cuentasBancariasModule",[]);
    mod.constant("cuentasBancariasContext", "api/cuentasBancarias");

    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/cuentasBancarias/';
            $urlRouterProvider.otherwise("/cuentasBancariasList");

            $stateProvider.state('cuentasBancarias', {
                url: '/cuentasBancarias',
                abstract: true,
                views: {
                    'mainView': {
                        templateUrl: basePath + 'cuentasBancarias.html',
                        controller:'cuentaBancariaCtrl',
                        controllerAs:'ctrl'
                    }
                }
            }).state('cuentasBancariasList', {
                url: '/list',
                parent: 'cuentasBancarias',
                views: {
                    'listView': {
                        templateUrl: basePath + 'cuentasBancarias.list.html',
                        controller: 'cuentaBancariaCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            });
        }]);
})(window.angular);
