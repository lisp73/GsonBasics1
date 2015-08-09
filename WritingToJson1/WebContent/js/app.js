var app = angular.module('app', []);
app.controller('MainController', function($scope, $http){
	
	$scope.country = {};

	$scope.addCountry = function() {
		console.log($scope.country);
		$http({
			method : 'POST',
			url : 'GSONWritingToFileExample',
			headers : {
				'Content-Type' : 'application/json'
			},
			data : $scope.country //this is window to which the data from any source is coming from, user(any user!)
		}).success(function(data, status, headers, config) {
			$scope.status = data;
			console.log('success', status)
			console.log(data)
		});
	};
	
})