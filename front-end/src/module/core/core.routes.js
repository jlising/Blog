//Module specific routings
(function(){
	'use strict';
	
	angular.module('core.module')
		.config(routeConfig);
	
	routeConfig.$inject = ['$stateProvider', '$urlRouterProvider'];
	
	function routeConfig($stateProvider, $urlRouterProvider){
		$urlRouterProvider
	        .when('', '/posts')
	        .when('/', '/posts')
	        .otherwise('/page-not-found');
		
		$stateProvider
		    .state('login', {
                url: '/login',
                templateUrl: './module/core/view/login/index.html',
                controller: "LoginController",
                controllerAs: "loginController"
            })
            .state('logout', {
                url: '/logout',
                controller: ['LoginService', '$log','$rootScope', function(LoginService, $log, $rootScope){
                        LoginService.logout({},function(response){
                                                    $log.debug("Successful logout");
                                                    $rootScope.$broadcast("logout-success");
                                                },function(error){
                                                    $log.debug(error.status + " " + error.statusText);
                                                });
                }]
            })
	        .state('404', {
	            url: '/page-not-found',
	            templateUrl: './module/core/view/error/404.html'
	        })
	        .state('home', {
                url: '/',
                templateUrl: './module/core/view/default/index.html',
                controller: "DefaultController",
                controllerAs: "defaultController"
            });
	}
})();