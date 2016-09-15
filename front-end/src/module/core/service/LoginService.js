(function(){
	'use strict';
	
	angular.module('core.module')
		.factory('LoginService', LoginService);
	
	LoginService.$inject = ['ENVIRONMENT', 'ResourceFactory'];
	
	function LoginService(ENVIRONMENT, ResourceFactory){
		var url = ENVIRONMENT.proxyUrl + "/login";
		
		//Custom methods here
		var methods = {
				'login' : {
					method : 'POST',
					params : { username : '@username', password : '@password'}
					//isArray : true
					//headers: {'X-CSRF-TOKEN': 'anything'}
				}
		};
		
		//Return new object. Passed arguments will be catch in .apply()
		return new ResourceFactory(url, {}, methods);
	}	
})();