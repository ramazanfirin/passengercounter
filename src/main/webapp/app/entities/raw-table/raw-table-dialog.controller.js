(function() {
    'use strict';

    angular
        .module('passengercounter2App')
        .controller('RawTableDialogController', RawTableDialogController);

    RawTableDialogController.$inject = ['$timeout', '$scope', '$stateParams', '$uibModalInstance', 'entity', 'RawTable', 'Device', 'ScheduledVoyage', 'Station'];

    function RawTableDialogController ($timeout, $scope, $stateParams, $uibModalInstance, entity, RawTable, Device, ScheduledVoyage, Station) {
        var vm = this;

        vm.rawTable = entity;
        vm.clear = clear;
        vm.datePickerOpenStatus = {};
        vm.openCalendar = openCalendar;
        vm.save = save;
        vm.devices = Device.query();
        vm.scheduledvoyages = ScheduledVoyage.query();
        vm.stations = Station.query();

        $timeout(function (){
            angular.element('.form-group:eq(1)>input').focus();
        });

        function clear () {
            $uibModalInstance.dismiss('cancel');
        }

        function save () {
            vm.isSaving = true;
            if (vm.rawTable.id !== null) {
                RawTable.update(vm.rawTable, onSaveSuccess, onSaveError);
            } else {
                RawTable.save(vm.rawTable, onSaveSuccess, onSaveError);
            }
        }

        function onSaveSuccess (result) {
            $scope.$emit('passengercounter2App:rawTableUpdate', result);
            $uibModalInstance.close(result);
            vm.isSaving = false;
        }

        function onSaveError () {
            vm.isSaving = false;
        }

        vm.datePickerOpenStatus.insertDate = false;

        function openCalendar (date) {
            vm.datePickerOpenStatus[date] = true;
        }
    }
})();
