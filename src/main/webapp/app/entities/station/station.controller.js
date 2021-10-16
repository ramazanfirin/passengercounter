(function() {
    'use strict';

    angular
        .module('passengercounter2App')
        .controller('StationController', StationController);

    StationController.$inject = ['Station'];

    function StationController(Station) {

        var vm = this;

        vm.stations = [];

        loadAll();

        function loadAll() {
            Station.query(function(result) {
                vm.stations = result;
                vm.searchQuery = null;
            });
        }
    }
})();
