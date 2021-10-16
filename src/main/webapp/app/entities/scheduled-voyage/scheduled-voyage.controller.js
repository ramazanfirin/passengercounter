(function() {
    'use strict';

    angular
        .module('passengercounter2App')
        .controller('ScheduledVoyageController', ScheduledVoyageController);

    ScheduledVoyageController.$inject = ['ScheduledVoyage'];

    function ScheduledVoyageController(ScheduledVoyage) {

        var vm = this;

        vm.scheduledVoyages = [];

        loadAll();

        function loadAll() {
            ScheduledVoyage.query(function(result) {
                vm.scheduledVoyages = result;
                vm.searchQuery = null;
            });
        }
    }
})();
