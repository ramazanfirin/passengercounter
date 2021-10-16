(function() {
    'use strict';

    angular
        .module('passengercounter2App')
        .controller('ScheduledVoyageDialogController', ScheduledVoyageDialogController);

    ScheduledVoyageDialogController.$inject = ['$timeout', '$scope', '$stateParams', '$uibModalInstance', 'entity', 'ScheduledVoyage', 'Route', 'Bus'];

    function ScheduledVoyageDialogController ($timeout, $scope, $stateParams, $uibModalInstance, entity, ScheduledVoyage, Route, Bus) {
        var vm = this;

        vm.scheduledVoyage = entity;
        vm.clear = clear;
        vm.datePickerOpenStatus = {};
        vm.openCalendar = openCalendar;
        vm.save = save;
        vm.routes = Route.query();
        vm.buses = Bus.query();

        $timeout(function (){
            angular.element('.form-group:eq(1)>input').focus();
        });

        function clear () {
            $uibModalInstance.dismiss('cancel');
        }

        function save () {
            vm.isSaving = true;
            if (vm.scheduledVoyage.id !== null) {
                ScheduledVoyage.update(vm.scheduledVoyage, onSaveSuccess, onSaveError);
            } else {
                ScheduledVoyage.save(vm.scheduledVoyage, onSaveSuccess, onSaveError);
            }
        }

        function onSaveSuccess (result) {
            $scope.$emit('passengercounter2App:scheduledVoyageUpdate', result);
            $uibModalInstance.close(result);
            vm.isSaving = false;
        }

        function onSaveError () {
            vm.isSaving = false;
        }

        vm.datePickerOpenStatus.scheduledTime = false;

        function openCalendar (date) {
            vm.datePickerOpenStatus[date] = true;
        }
    }
})();
