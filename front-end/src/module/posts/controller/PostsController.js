(function(){
	'use strict';
	
	angular.module('posts.module')
		.controller('PostsController', PostsController);
	
	PostsController.$inject = ['$scope', '$log','PostsService'];
	
	function PostsController($scope, $log, PostsService){

		var postsController = this;		
		
		angular.extend(postsController, { 
						posts: [],
                        currentPage : 1,
                        totalElements : 0,
                        pageSize : 6
		});
		
		/**
		 * Get the posts
		 */
		postsController.getPosts = function(){
			PostsService.get({size: postsController.pageSize, page: postsController.currentPage}, function(response){
                postsController.posts = response.results;
                postsController.totalElements =  response.totalElements;

            },function(error){
                $log.debug(error.status + " " + error.statusText);
            });
		};

	    $scope.$watch("postsController.currentPage", function(oldValue, newValue){
                    postsController.getPosts();
        });
	}
})();