appCliente.factory("tokenInterceptor", function($q, $location){
		return {
			'request':function(config){
				config.headers.Authorization = 'Bearer ' + localStorage.getItem("userToken");
				return config;
			},
			'response':function(response){
				if(response.status==401){
					$location.path("/login");
				}
				return response;
			},
			'responseError':function(rejection){
				/*if(canRecover(rejection)){
					return responseOrNewPromise
				}*/

				if(rejection.data.status == 401){
					$location.path("/login");	
				}

				$location.path("/login");
				return $q.reject(rejection);
			}
		};
});