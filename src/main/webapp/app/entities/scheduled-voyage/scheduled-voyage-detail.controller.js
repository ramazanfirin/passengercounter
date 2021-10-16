(function() {
    'use strict';

    angular
        .module('passengercounter2App')
        .controller('ScheduledVoyageDetailController', ScheduledVoyageDetailController);

    ScheduledVoyageDetailController.$inject = ['$scope', '$rootScope', '$stateParams', 'previousState', 'entity', 'ScheduledVoyage', 'Route', 'Bus'];

    function ScheduledVoyageDetailController($scope, $rootScope, $stateParams, previousState, entity, ScheduledVoyage, Route, Bus) {
        var vm = this;

        vm.scheduledVoyage = entity;
        vm.previousState = previousState.name;

        var unsubscribe = $rootScope.$on('passengercounter2App:scheduledVoyageUpdate', function(event, result) {
            vm.scheduledVoyage = result;
        });
        $scope.$on('$destroy', unsubscribe);
    }
})();
