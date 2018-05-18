
(function (ng) {
    var app = angular.module('mainApp', [
        // External dependencies
        'ui.router',
         'uiGmapgoogle-maps',
         
       
        // Internal modules dependencies       
        
        'mensajerosModule',
        'transportesModule',
        'reservasModule',
        'eventosModule',
        'cuentasBancariasModule',
        'pagosModule',

        'enviosModule',
        'paquetesModule',        
        'clientesModule',
        'tarjetasCreditoModule',

        'zonasModule',
        'clientesModule',
        'calificacionesModule',
        'bonosModule',

        'webModule',

        'loginModule'



    ]);
    ng.toString();
    // Resuelve problemas de las promesas
    app.run(['$rootScope', '$transitions', function ($rootScope, $transitions) {

            $transitions.onSuccess({to: '*'}, function (trans) {

                var $state = trans.router.stateService;
                var requireLogin = $state.current.data.requireLogin;
                var roles = $state.current.data.roles;

                /**
                 * @ngdoc function
                 * @name isAuthenticated
                 * @methodOf mainApp.module:mainApp
                 * @description Esta función define si el usuario se encuentra
                 * dentro de su cuenta.
                 * @returns {Boolean} Verdadero si está dentro de su cuenta.
                 */
                $rootScope.isAuthenticated = function () {
                    console.log("lul");
                    if (sessionStorage.getItem("correo") != null) {
                        $rootScope.currentUser = sessionStorage.getItem("nombre");
                        $rootScope.correo = sessionStorage.getItem("correo");
                        $rootScope.rol = sessionStorage.getItem("rol");
                        return true;
                        
                    } else {
                        return false;
                    }
                };
                
                /**
                 * @ngdoc function
                 * @name hasPermissions
                 * @methodOf mainApp.module:mainApp
                 * @description Esta función define si el usuario tiene permisos
                 * para acceder a la aplicación.
                 * @returns {Boolean} Verdadero si el usuario tiene permisos.
                 */
                $rootScope.hasPermissions = function () {
                    if (($rootScope.isAuthenticated) && (roles.indexOf(sessionStorage.getItem("rol")) > -1)) {
                        return true;
                    } else {
                        return false;
                    }
                };


                if (requireLogin && (sessionStorage.getItem("correo") === null)) {
                    event.preventDefault();
                    $state.go('login', $state.params);
                }

            });

        }]);
    app.config(['$qProvider',"$locationProvider", function ($qProvider, $locationProvider) {
            $qProvider.errorOnUnhandledRejections(false);
            $locationProvider.hashPrefix('!');
        }]).config(function(uiGmapGoogleMapApiProvider) {
    uiGmapGoogleMapApiProvider.configure({
        //    key: 'your api key',
        v: '3.20', //defaults to latest 3.X anyhow
        libraries: 'weather,geometry,visualization'
    });
    
    
    
});


 


})(window.angular);

