
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
        'analiticaModule'
       


    ]);
    ng.toString();
    // Resuelve problemas de las promesas
    app.config(['$qProvider', function ($qProvider) {
            $qProvider.errorOnUnhandledRejections(false);
        }]).config(function(uiGmapGoogleMapApiProvider) {
    uiGmapGoogleMapApiProvider.configure({
        //    key: 'your api key',
        v: '3.20', //defaults to latest 3.X anyhow
        libraries: 'weather,geometry,visualization'
    });
});
})(window.angular);

