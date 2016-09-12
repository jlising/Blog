(function(){
	'use strict';
	
	angular.module('posts.module')
		.factory('PostsService', PostsService);
	
	PostsService.$inject = ['ENVIRONMENT', 'ResourceFactory'];
	
	function PostsService(ENVIRONMENT, ResourceFactory){
		var url = ENVIRONMENT.proxyUrl + "/posts";
		
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