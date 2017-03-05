appCliente.controller("loginController", function($scope, $http){
	$scope.usuario={};
	$scope.autenticar = function(){
		
		$http.post('/autenticar', $scope.usuario)
				.then(function(response){
					$scope.usuario = response.data;
					window.alert("Bem vindo " + $scope.usuario.id + " | " + $scope.usuario.nome)
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