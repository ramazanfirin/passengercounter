(function() {
    'use strict';

    angular
        .module('passengercounter2App')
        .controller('RawTableDetailController', RawTableDetailController);

    RawTableDetailController.$inject = ['$scope', '$rootScope', '$stateParams', 'previousState', 'entity', 'RawTable', 'Device', 'ScheduledVoyage', 'Station'];

    function RawTableDetailController($scope, $rootScope, $stateParams, previousState, entity, RawTable, Device, ScheduledVoyage, Station) {
        var vm = this;

        vm.rawTable = entity;
        vm.previousState = previousState.name;

        var unsubscribe = $rootScope.$on('passengercounter2App:rawTableUpdate', function(event, result) {
            vm.rawTable = result;
        });
        $scope.$on('$destroy', unsubscribe);
    }
})();
