(function (ng) {
    var app = angular.module('mainApp', [
        // External dependencies
        'ui.router',
       
        // Internal modules dependencies       
        'citiesModule',
        'mensajerosModule',
        'transportesModule',
        'reservasModule',
        'eventosModule',
        'cuentasBancariasModule',
        'pagosModule',

        'enviosModule',
        'paquetesModule',        
        'clientesModule',

        'zonasModule',
        'clientesModule',
        'calificacionesModule'



    ]);
    // Resuelve problemas de las promesas
    app.config(['$qProvider', function ($qProvider) {
            $qProvider.errorOnUnhandledRejections(false);
        }]);
})(window.angular);

