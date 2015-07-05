'use strict';

(function () {
	angular.module('app', ['ngRoute', 'ngMessages']);

	angular.module('app').config(function ($routeProvider) {
		$routeProvider
			.when('/', {
				templateUrl: 'views/ChatRoomList.html',
				controller: 'ChatRoomListController'
			})
			.when('/SignUpForm', {
				templateUrl: 'views/SignUpForm.html',
				controller: 'SignUpFormController'
			})
			.when('/ChatMessageList/:id', {
				templateUrl: 'views/ChatMessageList.html',
				controller: 'ChatMessageListController'
			})
			.otherwise({
				redirectTo: '/'
			});
	});

	angular.module('app').controller('HeaderMenuController', function($scope) {
		$scope.loginButtonOnClick = function() {
		};
	});

})();
