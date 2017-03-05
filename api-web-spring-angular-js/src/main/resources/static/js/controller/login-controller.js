appCliente.controller("loginController", function($scope, $http){
	$scope.usuario={};
	$scope.login={}
	$scope.token="";
	$scope.autenticar = function(){
		
		$http.post('/autenticar', $scope.usuario)
				.then(function(response){
					$scope.token = "Bearer " + response.data.token;
					//$scope.usuario = response.data;
					//window.alert("Bem vindo " + $scope.usuario.id + " | " + $scope.usuario.nome)
					//window.alert("Bem vindo " + $scope.login.token);
					//console.log("Sucesso: " +response.status);	
					}, function(response){
						window.alert("usuario ou senha inválidos.")
						//console.log("Falha: " +response.status);
						});
		
/*		console.log("Chamou autenticar.");
		console.log("Usuário: " + $scope.usuario.nome);
		console.log("Senha: " + $scope.usuario.senha);
*/	};
});