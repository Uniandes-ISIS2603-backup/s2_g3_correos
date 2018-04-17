(function(ng)
{
   var mod=ng.module("cuentasBancariasModule");
   mod.constant("cuentasBancariasContext","api/cuentasBancarias");
   mod.controller('cuentaBancariaCtrl',['$scope', '$http', 'cuentasBancariasContext', '$state',
   
         
        function($scope,$http, cuentasBancariasContext,$state)
        {
           
            $http.get(cuentasBancariasContext).then(function(response)
            {
                $scope.cuentasBancariasRecords=response.data;
            });
        }
        
   ]);
}
)(window.angular);


