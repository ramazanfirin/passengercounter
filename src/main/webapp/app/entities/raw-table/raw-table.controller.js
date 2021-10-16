(function() {
    'use strict';

    angular
        .module('passengercounter2App')
        .controller('RawTableController', RawTableController);

    RawTableController.$inject = ['RawTable'];

    function RawTableController(RawTable) {

        var vm = this;

        vm.rawTables = [];

        loadAll();

        function loadAll() {
            RawTable.query(function(result) {
                vm.rawTables = result;
                vm.searchQuery = null;
            });
        }
    }
})();
