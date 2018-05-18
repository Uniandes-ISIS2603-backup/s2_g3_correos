
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
        'loginModule'
       


    ]);
    ng.toString();
    // Resuelve problemas de las promesas
    app.config(['$qProvider',"$locationProvider", function ($qProvider, $locationProvider) {
            $qProvider.errorOnUnhandledRejections(false);
            $locationProvider.hashPrefix('!');
        }]).config(function(uiGmapGoogleMapApiProvider) {
    uiGmapGoogleMapApiProvider.configure({
        //    key: 'your api key',
        v: '3.20', //defaults to latest 3.X anyhow
        libraries: 'weather,geometry,visualization'
    });
    
    app.run(['$rootScope', '$transitions', function ($rootScope, $transitions) {

            $transitions.onSuccess({to: '*'}, function (trans) {

                var $state = trans.router.stateService;
                var requireLogin = $state.current.data.requireLogin
                var roles = $state.current.data.roles
               

                /**
                 * @ngdoc function
                 * @name isAuthenticated
                 * @methodOf mainApp.module:mainApp
                 * @description Esta función define si el usuario se encuentra
                 * dentro de su cuenta.
                 * @returns {Boolean} Verdadero si está dentro de su cuenta.
                 */
                $rootScope.isAuthenticated = function () {

                    if (sessionStorage.getItem("correo") !== null) {
                        $rootScope.currentUser = sessionStorage.getItem("nombre");
                        return true;
                        console.log("el acmin 100% rial no feil");
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


                if (requireLogin && (sessionStorage.getItem("username") === null)) {
                    event.preventDefault();
                    $state.go('login', $state.params);
                }

            });

        }]);
    
});


 


})(window.angular);

