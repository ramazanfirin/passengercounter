(function() {
    'use strict';

    angular
        .module('passengercounter2App')
        .controller('BusDensityHistoryDialogController', BusDensityHistoryDialogController);

    BusDensityHistoryDialogController.$inject = ['$timeout', '$scope', '$stateParams', '$uibModalInstance', 'entity', 'BusDensityHistory', 'ScheduledVoyage', 'Bus', 'Station', 'Route', 'RawTable'];

    function BusDensityHistoryDialogController ($timeout, $scope, $stateParams, $uibModalInstance, entity, BusDensityHistory, ScheduledVoyage, Bus, Station, Route, RawTable) {
        var vm = this;

        vm.busDensityHistory = entity;
        vm.clear = clear;
        vm.datePickerOpenStatus = {};
        vm.openCalendar = openCalendar;
        vm.save = save;
        vm.scheduledvoyages = ScheduledVoyage.query();
        vm.buses = Bus.query();
        vm.stations = Station.query();
        vm.routes = Route.query();
        vm.rawtables = RawTable.query();

        $timeout(function (){
            angular.element('.form-group:eq(1)>input').focus();
        });

        function clear () {
            $uibModalInstance.dismiss('cancel');
        }

        function save () {
            vm.isSaving = true;
            if (vm.busDensityHistory.id !== null) {
                BusDensityHistory.update(vm.busDensityHistory, onSaveSuccess, onSaveError);
            } else {
                BusDensityHistory.save(vm.busDensityHistory, onSaveSuccess, onSaveError);
            }
        }

        function onSaveSuccess (result) {
            $scope.$emit('passengercounter2App:busDensityHistoryUpdate', result);
            $uibModalInstance.close(result);
            vm.isSaving = false;
        }

        function onSaveError () {
            vm.isSaving = false;
        }

        vm.datePickerOpenStatus.recordDate = false;

        function openCalendar (date) {
            vm.datePickerOpenStatus[date] = true;
        }
    }
})();
