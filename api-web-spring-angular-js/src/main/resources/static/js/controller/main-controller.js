appCliente.controller("mainController", function($scope, $route, $location, $routeParams){
	$scope.$route = $route;
	$scope.$location = $location;
	$scope.$routeParams = $routeParams;
});