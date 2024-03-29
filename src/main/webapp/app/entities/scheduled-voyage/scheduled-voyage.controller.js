(function() {
    'use strict';

    angular
        .module('passengercounter2App')
        .controller('ScheduledVoyageController', ScheduledVoyageController);

    ScheduledVoyageController.$inject = ['$state', 'ScheduledVoyage', 'ParseLinks', 'AlertService', 'paginationConstants', 'pagingParams','Route'];

    function ScheduledVoyageController($state, ScheduledVoyage, ParseLinks, AlertService, paginationConstants, pagingParams,Route) {

        var vm = this;

        vm.loadPage = loadPage;
        vm.predicate = pagingParams.predicate;
        vm.reverse = pagingParams.ascending;
        vm.transition = transition;
        vm.itemsPerPage = paginationConstants.itemsPerPage;
        vm.routes = Route.query();
        vm.findByRoute = findByRoute;
        vm.datePickerOpenStatus = {};
        vm.openCalendar = openCalendar;
        loadAll();

        function loadAll () {
            ScheduledVoyage.query({
                page: pagingParams.page - 1,
                size: vm.itemsPerPage,
                sort: sort()
            }, onSuccess, onError);
            function sort() {
                var result = [vm.predicate + ',' + (vm.reverse ? 'asc' : 'desc')];
                if (vm.predicate !== 'id') {
                    result.push('id');
                }
                return result;
            }
            function onSuccess(data, headers) {
                vm.links = ParseLinks.parse(headers('link'));
                vm.totalItems = headers('X-Total-Count');
                vm.queryCount = vm.totalItems;
                vm.scheduledVoyages = data;
                vm.page = pagingParams.page;
            }
            function onError(error) {
                AlertService.error(error.data.message);
            }
        }

		function findByRoute() {
			vm.input= {};
			vm.input.routeId = vm.route.id;
			vm.input.date = vm.scheduledTime;
			ScheduledVoyage.findByRouteId(vm.input, onfindByRouteSuccess, onfindByRouteError);
            
        }
        
        function onfindByRouteSuccess(data, headers) {
			vm.scheduledVoyages = data;
		}
		
		function onfindByRouteError(error) {
			 AlertService.error(error.data.message);
		}

        function loadPage(page) {
            vm.page = page;
            vm.transition();
        }

        function transition() {
            $state.transitionTo($state.$current, {
                page: vm.page,
                sort: vm.predicate + ',' + (vm.reverse ? 'asc' : 'desc'),
                search: vm.currentSearch
            });
        }
        
        vm.datePickerOpenStatus.scheduledTime = false;

        function openCalendar (date) {
            vm.datePickerOpenStatus[date] = true;
        }
    }
})();
