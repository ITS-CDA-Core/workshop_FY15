'use strict';

angular.module('app').controller('ChatRoomListController', function($scope, $http, socket) {
	$http.get('/api/chat_rooms')
		.success(function(data) {
		$scope.chatRooms = data;
	});

	$scope.chatRoomForPost = {};

	$scope.submit = function () {

		if ($scope.chatRoomForm.$invalid) {
			$scope.chatRoomForm.$setDirty();
			return;
		}

		$scope.chatRoomForPost.createdByUserId = $scope.$parent.loginUserInfo._id;
		$scope.chatRoomForPost.createdByUserName = $scope.$parent.loginUserInfo.userName;
		$scope.chatRoomForPost.createdByUserAvatarId = $scope.$parent.loginUserInfo.avatarId;

		$http.post('/api/chat_rooms', $scope.chatRoomForPost)
			.success(function(data, status, headers, config){
				socket.emit('chatRoom:add', data);
				$scope.chatRoomForPost = {};
			})
			.error(function(data, status, headers, config){
				alert("error");
			});

	};

	socket.on('chatRoom:add', function (data) {
		$scope.chatRooms.push(data);
	});
});
