var app = angular.module('demoApp',['ngRoute', 'ngAnimate']);
        
        app.config(function($routeProvider) {
            $routeProvider.when('/',
            {
                controller: 'SvcProviderController',
                templateUrl: 'partials/provider-short-details.html'
            })
            .when('/orders/:customerId',
            {
                controller: 'OrdersController',
                templateUrl: 'app/views/orders.html'
            })
        });
        
        app.controller('SvcProviderController', function($scope, svcProviedersFactory) {
            $scope.svcProviders = null;
            console.log('in controller');
            function init() {
            	svcProviedersFactory.getSvcProviders().success(function(custs) {
                    $scope.svcProviders = custs;
                    alert(custs.data.length);
                });
            }
            
            init();
        });
        
        app.controller('OrdersController', function($scope, $routeParams) {
            $scope.customerId = $routeParams.customerId;
        });
        
        app.factory('svcProviedersFactory', function($http) { 
            var factory = {};
            console.log('calling svc');
            factory.getSvcProviders = function() {
                return $http.get('http://localhost:9000/svcproviders');
            };
            return factory;
        });