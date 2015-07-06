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
