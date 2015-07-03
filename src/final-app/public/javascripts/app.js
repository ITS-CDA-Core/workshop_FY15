'use strict';

(function () {
	var app = angular.module('app', ['ngRoute', 'ngMessages']);

	app.config(function ($routeProvider) {
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

})();
