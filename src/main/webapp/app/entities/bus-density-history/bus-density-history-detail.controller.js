(function() {
    'use strict';

    angular
        .module('passengercounter2App')
        .controller('BusDensityHistoryDetailController', BusDensityHistoryDetailController);

    BusDensityHistoryDetailController.$inject = ['$scope', '$rootScope', '$stateParams', 'previousState', 'entity', 'BusDensityHistory', 'ScheduledVoyage', 'Bus', 'Station', 'Route', 'RawTable'];

    function BusDensityHistoryDetailController($scope, $rootScope, $stateParams, previousState, entity, BusDensityHistory, ScheduledVoyage, Bus, Station, Route, RawTable) {
        var vm = this;

        vm.busDensityHistory = entity;
        vm.previousState = previousState.name;

        var unsubscribe = $rootScope.$on('passengercounter2App:busDensityHistoryUpdate', function(event, result) {
            vm.busDensityHistory = result;
        });
        $scope.$on('$destroy', unsubscribe);
    }
})();
