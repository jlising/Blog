//Module specific routings
(function(){
	'use strict';
	
	angular.module('user.module')
		.config(routeConfig);
	
	routeConfig.$inject = ['$stateProvider'];
	
	function routeConfig($stateProvider){
			$stateProvider
	        .state('user', {
                url: '/user',
                templateUrl: './module/user/view/user/index.html',
                controller: "UserController",
                controllerAs: "userController"
            });
	}
})();