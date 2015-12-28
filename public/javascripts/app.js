var app = angular.module('demoApp', [ 'ngRoute' ]);

app.config(function($routeProvider) {

	$routeProvider.when('/', {
		controller : 'SvcProviderController',
		templateUrl : 'partials/svcprovider-list.html'
	}).when('/orders/:customerId', {
		controller : 'OrdersController',
		templateUrl : 'app/views/orders.html'
	})
});

app.controller('SvcProviderController', function($scope, svcProviedersFactory) {
	function init() {

		$scope.svcProviders = null;
		svcProviedersFactory.getSvcProviders().success(function(custs) {
			$scope.svcProviders = custs;
		});
	}

	init();
});


app.controller('CategoriesController', function($scope, categoriesFactory) {
	function init() {

		$scope.categories = null;
		categoriesFactory.getCategories().success(function(custs) {
			$scope.categories = custs;
		});
	}

	init();
});

app.controller('OrdersController', function($scope, $routeParams) {
	$scope.customerId = $routeParams.customerId;
});

app.factory('svcProviedersFactory', function($http) {

	var factory = {};
	factory.getSvcProviders = function() {
		return $http.get('http://localhost:9000/svcproviders');
	};
	return factory;
});


app.factory('categoriesFactory', function($http) {

	var factory = {};
	factory.getCategories = function() {
		return $http.get('http://localhost:9000/categories');
	};
	return factory;
});
