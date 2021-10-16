(function() {
    'use strict';

    angular
        .module('passengercounter2App')
        .controller('StationRouteConnectionDeleteController',StationRouteConnectionDeleteController);

    StationRouteConnectionDeleteController.$inject = ['$uibModalInstance', 'entity', 'StationRouteConnection'];

    function StationRouteConnectionDeleteController($uibModalInstance, entity, StationRouteConnection) {
        var vm = this;

        vm.stationRouteConnection = entity;
        vm.clear = clear;
        vm.confirmDelete = confirmDelete;

        function clear () {
            $uibModalInstance.dismiss('cancel');
        }

        function confirmDelete (id) {
            StationRouteConnection.delete({id: id},
                function () {
                    $uibModalInstance.close(true);
                });
        }
    }
})();
