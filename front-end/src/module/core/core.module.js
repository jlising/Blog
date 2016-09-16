//Initialize module and add specific settings here...
(function(){
	'use strict';
	
	 angular.module("core.module", [])
		 .constant( 'ENVIRONMENT', {
			 proxyUrl : '/proxy'
		 })
		 .config(['$httpProvider', function($httpProvider){
                $httpProvider.interceptors.push('HttpInterceptor');
		 }])
		 .run(['$rootScope','$state', function($rootScope, $state){
		    $rootScope.$on('authorized', function() {
                //main.currentUser = UserService.getCurrentUser();
            });

            $rootScope.$on('unauthorized', function() {
                //main.currentUser = UserService.setCurrentUser(null);
                $state.go('login');
            });

            $rootScope.$on('login-success', function() {
                //main.currentUser = UserService.setCurrentUser(null);
                $state.go('posts');
             });

             $rootScope.$on('logout-success', function() {
             //main.currentUser = UserService.setCurrentUser(null);
             $state.go('login');
          });
		 }])
})();