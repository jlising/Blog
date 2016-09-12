(function(){
	'use strict';
	
	angular.module('core.module')
		.controller('DefaultController', DefaultController);
	
	DefaultController.$inject = ['$log'];
	
	function DefaultController($log){
		//ControllerAs scope variable
		var DefaultController = this;		
		
		angular.extend(DefaultController, {
			/** variables here...**/
			message : ""});
		
		DefaultController.hello = function(){
			DefaultController.message = "Hello!";
			$log.debug("Hello!");
		};

		//DefaultController.hello();
	}
})();