'use strict';

angular.module('app').controller('ChatMessageListController', function($scope, $http, $routeParams) {
	$http.get('/api/chat_rooms/' + $routeParams.id + '/chat_messages')
		.success(function(data) {
		$scope.chatMessages = data;
	});
});
