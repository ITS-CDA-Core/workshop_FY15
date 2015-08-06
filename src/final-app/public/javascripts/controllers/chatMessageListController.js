'use strict';

angular.module('app').controller('ChatMessageListController', function($scope, $http, $routeParams, socket) {
	$http.get('/api/chat_rooms/' + $routeParams.chatRoomId + '/chat_messages')
		.success(function(data) {
		$scope.chatMessages = data;
	});

	$scope.chatMessageForPost = {};

	$scope.submit = function () {

		if ($scope.chatMessageForm.$invalid) {
			$scope.chatMessageForm.$setDirty();
			return;
		}

		$scope.chatMessageForPost.chatRoomId = $routeParams.chatRoomId;
		$scope.chatMessageForPost.createdByUserId = $scope.$parent.loginUserInfo._id;
		$scope.chatMessageForPost.createdByUserName = $scope.$parent.loginUserInfo.userName;
		$scope.chatMessageForPost.createdByUserAvatarId = $scope.$parent.loginUserInfo.avatarId;

		$http.post('/api/chat_messages', $scope.chatMessageForPost)
			.success(function(data, status, headers, config){
				socket.emit('chatMessage:add', data);
				$scope.chatMessageForPost = {};
			})
			.error(function(data, status, headers, config){
				alert("error");
			});
	};

	socket.on('chatMessage:add', function (data) {
		if (data.chatRoomId == $routeParams.chatRoomId) {
			$scope.chatMessages.push(data);
		}
	});
});
