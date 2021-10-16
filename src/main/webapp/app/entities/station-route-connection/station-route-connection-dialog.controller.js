(function() {
    'use strict';

    angular
        .module('passengercounter2App')
        .controller('StationRouteConnectionDialogController', StationRouteConnectionDialogController);

    StationRouteConnectionDialogController.$inject = ['$timeout', '$scope', '$stateParams', '$uibModalInstance', 'entity', 'StationRouteConnection', 'Station', 'Route'];

    function StationRouteConnectionDialogController ($timeout, $scope, $stateParams, $uibModalInstance, entity, StationRouteConnection, Station, Route) {
        var vm = this;

        vm.stationRouteConnection = entity;
        vm.clear = clear;
        vm.save = save;
        vm.stations = Station.query();
        vm.routes = Route.query();

        $timeout(function (){
            angular.element('.form-group:eq(1)>input').focus();
        });

        function clear () {
            $uibModalInstance.dismiss('cancel');
        }

        function save () {
            vm.isSaving = true;
            if (vm.stationRouteConnection.id !== null) {
                StationRouteConnection.update(vm.stationRouteConnection, onSaveSuccess, onSaveError);
            } else {
                StationRouteConnection.save(vm.stationRouteConnection, onSaveSuccess, onSaveError);
            }
        }

        function onSaveSuccess (result) {
            $scope.$emit('passengercounter2App:stationRouteConnectionUpdate', result);
            $uibModalInstance.close(result);
            vm.isSaving = false;
        }

        function onSaveError () {
            vm.isSaving = false;
        }


    }
})();
