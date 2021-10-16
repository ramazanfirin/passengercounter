(function() {
    'use strict';

    angular
        .module('passengercounter2App')
        .controller('ScheduledVoyageDeleteController',ScheduledVoyageDeleteController);

    ScheduledVoyageDeleteController.$inject = ['$uibModalInstance', 'entity', 'ScheduledVoyage'];

    function ScheduledVoyageDeleteController($uibModalInstance, entity, ScheduledVoyage) {
        var vm = this;

        vm.scheduledVoyage = entity;
        vm.clear = clear;
        vm.confirmDelete = confirmDelete;

        function clear () {
            $uibModalInstance.dismiss('cancel');
        }

        function confirmDelete (id) {
            ScheduledVoyage.delete({id: id},
                function () {
                    $uibModalInstance.close(true);
                });
        }
    }
})();
