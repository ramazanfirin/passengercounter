(function() {
    'use strict';

    angular
        .module('passengercounter2App')
        .controller('RawTableDeleteController',RawTableDeleteController);

    RawTableDeleteController.$inject = ['$uibModalInstance', 'entity', 'RawTable'];

    function RawTableDeleteController($uibModalInstance, entity, RawTable) {
        var vm = this;

        vm.rawTable = entity;
        vm.clear = clear;
        vm.confirmDelete = confirmDelete;

        function clear () {
            $uibModalInstance.dismiss('cancel');
        }

        function confirmDelete (id) {
            RawTable.delete({id: id},
                function () {
                    $uibModalInstance.close(true);
                });
        }
    }
})();
