(function(){
	'use strict';
	
	angular.module('core.module')
		.controller('LoginController', LoginController);
	
	LoginController.$inject = ['$log','LoginService','$rootScope'];
	
	function LoginController($log, LoginService, $rootScope){
		//ControllerAs scope variable
		var loginController = this;
		
		angular.extend(loginController, {
			/** variables here...**/
			message : "",
			username: "",
			password: ""});

        loginController.login = function(){
            LoginService.login({},{username : loginController.username, password: loginController.password},
                        function(response){
                            $log.debug("Successful login");
                            $rootScope.$broadcast("login-success");
                        },function(error){
                            $log.debug(error.status + " " + error.statusText);
                        });
        };
	}
})();