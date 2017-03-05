//module principal
var appCliente = angular.module("appCliente",['ngRoute']);

//recording configuration function to route
appCliente.config(function($routeProvider, $locationProvider){
	$routeProvider
	.when('/clientes', {templateUrl:'view/cliente.html', controller:'clienteController'})
	.when('/login', {templateUrl:'view/login.html', controller:'loginController'})
	.when('/estado', {templateUrl:'view/estado.html', controller:'estadoController'})
	.when('/clientes/:id', {templateUrl:'view/cliente-detalhe.html', controller:'clienteDetalheController'})
	.otherwise({redirectTo:'/'});
	
	$locationProvider.html5Mode(true);//para remover o # http://localhost:8080/#/clientes
});

appCliente.config(function($httpProvider){
	$httpProvider.interceptors.push("tokenInterceptor");
});

