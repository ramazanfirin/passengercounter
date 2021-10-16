(function() {
    'use strict';

    angular
        .module('passengercounter2App')
        .controller('StationDetailController', StationDetailController);

    StationDetailController.$inject = ['$scope', '$rootScope', '$stateParams', 'previousState', 'entity', 'Station'];

    function StationDetailController($scope, $rootScope, $stateParams, previousState, entity, Station) {
        var vm = this;

        vm.station = entity;
        vm.previousState = previousState.name;

        var unsubscribe = $rootScope.$on('passengercounter2App:stationUpdate', function(event, result) {
            vm.station = result;
        });
        $scope.$on('$destroy', unsubscribe);
    }
})();
