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
			.when('/ChatMessageList/:chatRoomId', {
				templateUrl: 'views/ChatMessageList.html',
				controller: 'ChatMessageListController'
			})
			.otherwise({
				redirectTo: '/'
			});
	});

	angular.module('app').factory('socket', function ($rootScope) {
		var socket = io.connect();

		return {
			on: function (eventName, callback) {
				socket.on(eventName, function () {
					var args = arguments;

					$rootScope.$apply(function () {
						callback.apply(socket, args);
					});
				});
			},
			emit: function (eventName, data, callback) {
				socket.emit(eventName, data, function () {
					var args = arguments;

					$rootScope.$apply(function () {
						if (callback) {
							callback.apply(socket, args);
						}
					});
				});
			}
		};
	});


	angular.module('app').controller('RootController', function($scope, $http) {
		$scope.isLoggedIn = false;
		$scope.loginUserInfo = {};
	});

	angular.module('app').controller('HeaderMenuController', function($scope, $http) {
		$scope.loginInfo = {};
		$scope.showLoginForm = false;

		$scope.loginButtonOnClick = function() {
			$scope.showLoginForm = ($scope.showLoginForm) ? false : true;
		};

		$scope.submit = function () {
			if ($scope.loginForm.$invalid) {
				$scope.loginForm.$setDirty();
				return;
			}

			$http.post('/api/login', $scope.loginInfo)
				.success(function(data, status, headers, config){
					if (data != null && data.length > 0) {
						$scope.showLoginForm = false;
						$scope.$parent.isLoggedIn = true;
						$scope.$parent.loginUserInfo = data[0];
					} else {
						alert("ユーザ名またはパスワードが不正です");
					}
				})
				.error(function(data, status, headers, config){
					alert("error");
				});
		};

		$scope.logoutButtonOnClick = function() {
			$scope.$parent.isLoggedIn = false;
			$scope.$parent.loginUserInfo = {};
		};

	});

})();
