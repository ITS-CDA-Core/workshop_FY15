'use strict';

angular.module('app').controller('SignUpFormController', function($scope, $http, $location) {
	// model
	$scope.user = {};
	$scope.result = {};

	$scope.avaters = (function () {
		var tempArray = [];
		for (var i=1;i<=81;i++) {
			tempArray.push(("0"+i).slice(-2));
		}
		return tempArray;
	})();

	// validator (sync)
	$scope.validators = {
		password: {
			joe: function (modelValue, viewValue) {
				var value = modelValue || viewValue;
				var user = $scope.user || {};

				return value != user.userName;
			}
		}
	};

	// validator (async)
	$scope.asyncValidators = {

	};

	$scope.$watch('user.userName', function () {
		$scope.userForm.password.$validate();
	});

	$scope.back  = function() {
		$location.path("/");
	};

	$scope.submit = function () {
		if ($scope.userForm.$invalid) {
			$scope.userForm.$setDirty();
			return;
		}

		$http.post('/api/users', $scope.user)
			.success(function (data, status, headers, config) {
				$scope.$parent.$parent.isLoggedIn = true;
				$scope.$parent.$parent.loginUserInfo = data;
				$scope.user = {};
				$location.path("/");
			})
			.error(function (data, status, headers, config) {
				alert("error");
			});
	};
});

angular.module('app').directive('appValidators', function() {
	return {
		require: 'ngModel',
		scope: {
			appValidators: '='
		},
		link: function (scope, elem, attrs, ctrl) {
			var validators = scope.appValidators || {};
			angular.forEach(validators, function (val, key){
				ctrl.$validators[key] = val;
			});
		}
	};
});
