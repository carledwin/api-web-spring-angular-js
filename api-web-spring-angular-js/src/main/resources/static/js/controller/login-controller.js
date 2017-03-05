appCliente.controller("loginController", function($scope, $http){
	$scope.usuario={};
	$scope.login={}
	$scope.token="";
	$scope.autenticar = function(){
		$http.post('/autenticar', $scope.usuario)
				.then(function(response){
					$scope.token = "Bearer " + response.data.token;
					localStorage.setItem("userToken",  response.data.token);
					}, function(response){
						window.alert("usuario ou senha inválidos.")
						});
		};
});