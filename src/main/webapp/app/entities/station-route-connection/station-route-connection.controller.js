(function() {
    'use strict';

    angular
        .module('passengercounter2App')
        .controller('StationRouteConnectionController', StationRouteConnectionController);

    StationRouteConnectionController.$inject = ['StationRouteConnection'];

    function StationRouteConnectionController(StationRouteConnection) {

        var vm = this;

        vm.stationRouteConnections = [];

        loadAll();

        function loadAll() {
            StationRouteConnection.query(function(result) {
                vm.stationRouteConnections = result;
                vm.searchQuery = null;
            });
        }
    }
})();
