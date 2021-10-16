(function() {
    'use strict';

    angular
        .module('passengercounter2App')
        .controller('StationRouteConnectionDetailController', StationRouteConnectionDetailController);

    StationRouteConnectionDetailController.$inject = ['$scope', '$rootScope', '$stateParams', 'previousState', 'entity', 'StationRouteConnection', 'Station', 'Route'];

    function StationRouteConnectionDetailController($scope, $rootScope, $stateParams, previousState, entity, StationRouteConnection, Station, Route) {
        var vm = this;

        vm.stationRouteConnection = entity;
        vm.previousState = previousState.name;

        var unsubscribe = $rootScope.$on('passengercounter2App:stationRouteConnectionUpdate', function(event, result) {
            vm.stationRouteConnection = result;
        });
        $scope.$on('$destroy', unsubscribe);
    }
})();
