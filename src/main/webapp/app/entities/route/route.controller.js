(function() {
    'use strict';

    angular
        .module('passengercounter2App')
        .controller('RouteController', RouteController);

    RouteController.$inject = ['Route'];

    function RouteController(Route) {

        var vm = this;

        vm.routes = [];

        loadAll();

        function loadAll() {
            Route.query(function(result) {
                vm.routes = result;
                vm.searchQuery = null;
            });
        }
    }
})();
