(function(ng)
{
   var mod=ng.module("cuentasBancariasModule");
   mod.constant("cuentasBancariasContext","api/cuentasBancarias");
   mod.controller('cuentaBancariaCtrl',['$scope', '$http', 'cuentasBancariasContext', 
   
         
        function($scope,$http, cuentasBancariasContext)
        {
           
            $http.get(cuentasBancariasContext).then(function(response)
            {
                $scope.cuentasBancariasRecords=response.data;
            });
        }
        
   ]);
}
)(window.angular);


