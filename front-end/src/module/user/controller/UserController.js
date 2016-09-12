(function(){
	'use strict';
	
	angular.module('user.module')
		.controller('UserController', UserController);
	
	UserController.$inject = ['$scope','$log','UserService'];
	
	function UserController($scope, $log, UserService){
		
		var userController = this;
		
		angular.extend(userController, {
						users: [],
						currentPage : 0,
						totalElements : 0,
						pageSize : 4
		});
		
		/**
		 * Get the user thumbnails
		 */
		userController.getUsers = function(){
			UserService.get({size: userController.pageSize, page: userController.currentPage -1}, function(response){
				userController.users = response.results;
				userController.totalElements =  response.totalElements;
				userController.currentPage = response.currentPage + 1;
			},function(error){
				$log.debug(error.status + " " + error.statusText);
			});
		};

		$scope.$watch("userController.currentPage", function(oldValue, newValue){
            userController.getUsers();
		});
	}
})();