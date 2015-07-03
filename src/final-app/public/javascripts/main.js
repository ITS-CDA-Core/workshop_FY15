(function () {
	var app = angular.module('app', ['ngMessages']);

	app.controller('ChatRoomListController', function($scope, $http) {
		$http.get('/api/chat_rooms')
			.success(function(data) {
			$scope.chatRooms = data;
		});
	});
})();
