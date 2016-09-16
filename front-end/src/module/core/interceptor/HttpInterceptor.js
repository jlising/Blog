(function(){
	'use strict';
	
	angular.module('core.module')
		.factory('HttpInterceptor', HttpInterceptor);
	
	HttpInterceptor.$inject = ['ENVIRONMENT','$q','$log', '$rootScope'];
	
	function HttpInterceptor(ENVIRONMENT, $q, $log, $rootScope){
		return {
            'request': function(config) {
              return config;
            },

           'requestError': function(rejection) {
              return $q.reject(rejection);
            },

            'response': function(response) {
              return response;
            },

           'responseError': function(rejection) {
              //Unauthorized access, should be logged in
              if(rejection.status === 401){
                $rootScope.$broadcast('unauthorized');
              }

              return $q.reject(rejection);
            }
          };
	}	
})();