//recording controller
appCliente.controller("estadoController", function($scope, $http){
	$scope.estados=[];
	$scope.estado = {};
	$scope.carregarTodos= function(){
		$http({method:"GET", url:"http://localhost:8080/estados"})
			.then(function(response){
				$scope.estados=response.data;
				console.log("Status: " + response.status);
				}, function(response){
					console.log("Status: " + response.status);
					});
	};
	});
