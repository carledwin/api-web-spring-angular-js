//recording controller
appCliente.controller("clienteController", function($scope, $http){
	$scope.clientes=[];
	$scope.cliente = {};
	$scope.carregarClientes = function(){
		
		$http.defaults.headers.common.Authorization = 'Bearer ' + localStorage.getItem("userToken") ;
		
		$http({method:"GET", url:"admin/clientes"})
			.then(function(response){
				$scope.clientes=response.data;
				console.log("Status: " + response.status);
				}, function(response){
					console.log("Status: " + response.status);
					});
	};
	
	$scope.carregarClientes();
	
	$scope.salvarCliente = function(){
		
		if($scope.frmCliente.$valid){
		$http({method:"POST", url:"http://localhost:8080/admin/clientes", data:$scope.cliente})
			.then(function(response){
				$scope.clientes.push(response.data)
				$scope.cliente = {};
				console.log("Status: " + response.status);
				}, function(response){
					console.log("Status: " + response.status);
					});
		$scope.frmCliente.$setPristine(true);
	}else{
		window.alert("Dados inválidos!");
	}
	};
	
	$scope.deletarCliente = function(cliente){
		$http({method:"DELETE",url:"http://localhost:8080/admin/clientes/"+cliente.id})
			.then(function(response){
					/*
					for(index = 0; index < $scope.clientes.length; index++){
						if(cliente.id == $scope.clientes[index].id){
							$scope.clientes.splice(index,1);
							break;
						}
					} 
					*/

					$scope.clientes.splice($scope.clientes.indexOf(cliente),1);
				
					console.log(response.status);
				}, function(response){
						console.log(response.status);
					});
	};
	
	$scope.prepareAterarCliente = function(cliente){
		$scope.cliente = angular.copy(cliente);
	};
	
	$scope.alterarCliente = function(cliente){
		
		if($scope.frmCliente.$valid){
			$http({method:"PUT", url:"admin/clientes", data:$scope.cliente})
				.then(function(response){
					$scope.carregarClientes();
					$scope.cliente = {};
					console.log("Status: " + response.status);
				}, function(response){
					console.log("Status: " + response.status);
					});
			$scope.frmCliente.$setPristine(true);
		}else{
			window.alert("Dados inválidos!");
		}
	};
	
	$scope.limparCliente = function(){
		$scope.cliente = {};
	}
	
	$scope.cancelarAlteracaoCliente = function(){
		$scope.limparCliente();
	}
});
