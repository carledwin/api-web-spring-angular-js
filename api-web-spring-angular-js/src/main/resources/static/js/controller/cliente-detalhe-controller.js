appCliente.controller("clienteDetalheController", function($scope, $http, $route){
	
	$http.get("admin/clientes/" +$route.current.params.id) 
			.then(function(response){
			$scope.cliente = response.data;
			console.log("Status: " + response.status);
			}, 
				function(response){
				console.log("Status: " + response.status);
				});
	});
