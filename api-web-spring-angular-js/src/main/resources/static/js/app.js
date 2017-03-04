//module principal
var appCliente = angular.module("appCliente",['ngRoute']);

//recording configuration function to route
appCliente.config(function($routeProvider){
	$routeProvider
	.when('/', {templateUrl:'view/cliente.html', controller:'clienteController'})
	.otherwise({redirectTo:'/'});
});

