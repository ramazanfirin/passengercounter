(function() {
    'use strict';

    angular
        .module('passengercounter2App')
        .controller('BusDensityHistoryDeleteController',BusDensityHistoryDeleteController);

    BusDensityHistoryDeleteController.$inject = ['$uibModalInstance', 'entity', 'BusDensityHistory'];

    function BusDensityHistoryDeleteController($uibModalInstance, entity, BusDensityHistory) {
        var vm = this;

        vm.busDensityHistory = entity;
        vm.clear = clear;
        vm.confirmDelete = confirmDelete;

        function clear () {
            $uibModalInstance.dismiss('cancel');
        }

        function confirmDelete (id) {
            BusDensityHistory.delete({id: id},
                function () {
                    $uibModalInstance.close(true);
                });
        }
    }
})();
