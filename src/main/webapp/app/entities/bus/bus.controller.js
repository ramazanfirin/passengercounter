(function() {
    'use strict';

    angular
        .module('passengercounter2App')
        .controller('BusController', BusController);

    BusController.$inject = ['Bus'];

    function BusController(Bus) {

        var vm = this;

        vm.buses = [];

        loadAll();

        function loadAll() {
            Bus.query(function(result) {
                vm.buses = result;
                vm.searchQuery = null;
            });
        }
    }
})();
