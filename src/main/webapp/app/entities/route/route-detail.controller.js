(function() {
    'use strict';

    angular
        .module('passengercounter2App')
        .controller('RouteDetailController', RouteDetailController);

    RouteDetailController.$inject = ['$scope', '$rootScope', '$stateParams', 'previousState', 'entity', 'Route'];

    function RouteDetailController($scope, $rootScope, $stateParams, previousState, entity, Route) {
        var vm = this;

        vm.route = entity;
        vm.previousState = previousState.name;

        var unsubscribe = $rootScope.$on('passengercounter2App:routeUpdate', function(event, result) {
            vm.route = result;
        });
        $scope.$on('$destroy', unsubscribe);
    }
})();
