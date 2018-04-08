(function(ng){
    var mod=ng.module("mensajerosModule");
    
    mod.controller("mensajerosCtrl",['$scope','$state','$stateParams','$http','mensajerosContext',function($scope,$state,$stateParams,$http,context)
    {
        $scope.records={};
        
        $http.get(context).then(function(response)
        {
            $scope.records= response.data;
        });
        
        if($stateParams.mensajeroId!==null && $stateParams.mensajeroId!==undefined)
        {
            id=$stateParams.mensajeroId;
            $http.get(context+"/"+id).then(function(response)
            {
                $scope.currentRecord=response.data;
            });
            
        }
        else
        {
            $scope.currentRecord=
                    {
                        id:undefined,
                        name:''
                    };
             $scope.alerts=[];
        }
        this.saveRecord=function(id)
        {
            currentRecord=$scope.currentRecord;
            
            if(id===null || id===undefined)
            {
                return $http.post(context,currentRecord)
                        .then(function()
                {
                    $state.go('mensajerosList');
                });
            }
            else
            {
                return $http.put(context+"/"+currentRecord.id, currentRecord)
                        .then(function()
                            {
                                $state.go('mensajerosList');
                            });
            }
            ;
        };
        this.deleteRecord=function(id)
        {
            $http.delete(context+"/"+id);
            $state.reload('citiesList');
        };
    }]);
    
})(window.angular);


