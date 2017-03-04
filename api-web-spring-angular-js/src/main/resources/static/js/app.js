//module principal
var appCliente = angular.module("appCliente",[]);

//recording controllers
appCliente.controller("index-controller", function($scope, $http){
	
	$scope.nome = "Carl Edwin Antonio";
	$scope.sobrenome ="Nascimento";
	$scope.clientes=[];
	
	$http({method:"GET", url:"http://localhost:8080/clientes"})
		.then(function(response){
			$scope.clientes=response.data;
			console.log("Data: " + response.data + " Status: " + response.status);
		}
			, function(response){
				console.log("Data: " + response.data + " Status: " + response.status);	
			});
});
