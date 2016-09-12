(function(){
	'use strict';
	
	angular.module('user.module')
		.factory('UserService', UserService);
	
	UserService.$inject = ['ENVIRONMENT', 'ResourceFactory'];
	
	function UserService(ENVIRONMENT, ResourceFactory){
		var url = ENVIRONMENT.proxyUrl + "/users";
		
		//Custom methods here
		var methods = {
				'get' : {
					method : 'GET',
					isArray : false
				}
		};
		
		//Return new object. Passed arguments will be catch in .apply()
		return new ResourceFactory(url, {}, methods);
	}	
})();