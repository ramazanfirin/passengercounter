(function() {
    'use strict';

    angular
        .module('passengercounter2App')
        .controller('DeviceDetailController', DeviceDetailController);

    DeviceDetailController.$inject = ['$scope', '$rootScope', '$stateParams', 'previousState', 'entity', 'Device', 'Bus'];

    function DeviceDetailController($scope, $rootScope, $stateParams, previousState, entity, Device, Bus) {
        var vm = this;

        vm.device = entity;
        vm.previousState = previousState.name;

        var unsubscribe = $rootScope.$on('passengercounter2App:deviceUpdate', function(event, result) {
            vm.device = result;
        });
        $scope.$on('$destroy', unsubscribe);
    }
})();
