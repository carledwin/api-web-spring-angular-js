//module principal
var appCliente = angular.module("appCliente",['ngRoute']);

//recording configuration function to route
appCliente.config(function($routeProvider, $locationProvider){
	$routeProvider
	.when('/clientes', {templateUrl:'view/cliente.html', controller:'clienteController'})
	.when('/estados', {templateUrl:'view/estado.html', controller:'estadoController'})
	.when('/cidades', {templateUrl:'view/cidade.html', controller:'cidadeController'})
	.when('/clientes/:id', {templateUrl:'view/cliente-detalhe.html', controller:'clienteDetalheController'})
	.otherwise({redirectTo:'/'});
	
	$locationProvider.html5Mode(true);//para remover o # http://localhost:8080/#/clientes
});

