'use strict';

(function () {
	var app = angular.module('app', ['ngRoute', 'ngMessages']);

	app.config(function ($routeProvider) {
		$routeProvider
			.when('/', {
				templateUrl: 'views/chatRoomList.html',
				controller: 'ChatRoomListController'
			})
			.when('/ChatMessageList/:id', {
				templateUrl: 'views/chatMessageList.html',
				controller: 'ChatMessageListController'
			})
			.otherwise({
				redirectTo: '/'
			});
	});

})();
