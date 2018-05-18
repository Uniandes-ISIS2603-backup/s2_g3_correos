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
                data: {
                    requireLogin: false
                },
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
                data: {
                    requireLogin: true,
                    roles:['administrador']
                },
                views: {
                    'listView': {
                        templateUrl: basePath + 'cuentasBancarias.list.html',
                        controller: 'cuentaBancariaCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            }).state('cuentaBancariaCreate',
                {
                    url:'/create',
                    parent:'cuentasBancarias',
                    data: {
                    requireLogin: true,
                    roles:['cliente','mensajero']
                },
                    views:
                            {
                                'detailView':
                                {
                                    controller:'cuentasBancariasCreateCtrl',
                                    controllerAs:'ctrl',
                                    templateUrl:basePath+ '/create/cuentasBancarias.create.html'
                                }
                                
                            }
                }).state('cuentaBancariaUpdate',{
                    url:'update/{cuentaBancariaId}',
                    parent:'cuentasBancarias',
                    data: {
                    requireLogin: true,
                    roles:['cliente','mensajero']
                },
                    param:
                            {
                                cuentaBancariaId:null
                            },
                    views:
                            {
                                'detailView':
                                {
                                    templateUrl:basePath+'/create/cuentasBancarias.create.html',
                                    controller:'cuentasBancariasUpdateCtrl',
                                    controllerAs:'ctrl'
                                }
                            }
                }).state('cuentaBancariaDetail',{
                    url: '/{cuentaBancariaId:int}/detail',
                    parent: 'cuentasBancarias',
                    data: {
                    requireLogin: true,
                    roles:['cliente','mensajero']
                },
                    param: {
                        cuentaBancariaId: null
                    },
                    views: {
                       
                        'detailView': {
                        templateUrl: basePath + 'cuentasBancarias.detail.html',
                        controller: 'cuentasBancariasDetailCtrl',
                        controllerAs: 'ctrl'
                    }

                }
                }).state('cuentaBancariaDelete',{
                    url:'/delete/{cuentaBancariaId:int}',
                    parent:'cuentasBancarias',
                    data: {
                    requireLogin: true,
                    roles:['cliente','mensajero']
                },
                    param:
                            {
                                cuentaBancariaId:null
                            },
                    views:
                            {
                              'detailView':
                              {
                                  templateUrl:basePath+'/delete/cuentasBancarias.delete.html',
                                  controller:'cuentaBancariaDeleteCtrl',
                                  controllerAs:'Ctrl'
                              }  
                            }
                });
        }]);
})(window.angular);
