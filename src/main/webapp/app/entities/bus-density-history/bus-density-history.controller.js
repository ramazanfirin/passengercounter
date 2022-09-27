(function() {
    'use strict';

    angular
        .module('passengercounter2App')
        .controller('BusDensityHistoryController', BusDensityHistoryController);

    BusDensityHistoryController.$inject = ['$state', 'BusDensityHistory', 'ParseLinks', 'AlertService', 'paginationConstants', 'pagingParams','Station','Route','ScheduledVoyage'];

    function BusDensityHistoryController($state, BusDensityHistory, ParseLinks, AlertService, paginationConstants, pagingParams,Station,Route,ScheduledVoyage ) {

        var vm = this;

        vm.loadPage = loadPage;
        vm.predicate = pagingParams.predicate;
        vm.reverse = pagingParams.ascending;
        vm.transition = transition;
        vm.itemsPerPage = paginationConstants.itemsPerPage;
		vm.analyze = analyze;
		vm.tempStation ;
		vm.stations = Station.query();
		vm.debug=true;
		vm.formatTime = formatTime;
		vm.routes = Route.query();
		vm.openCalendar = openCalendar;
		vm.search = search;

 		vm.datePickerOpenStatus = {};
 		vm.getScheduledList = getScheduledList;
 		vm.showMap = showMap;
        //loadAll();
        vm.idOfFirtRecord="";
        
        function formatTime(date){
	        var result = new Date(date);
			result.setHours(result.getHours()-8);
			return result;
		}

        function loadAll () {
            BusDensityHistory.query({
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
                vm.busDensityHistories = data;
                vm.page = pagingParams.page;
            }
            function onError(error) {
                AlertService.error(error.data.message);
            }
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

		function analyze(){
			BusDensityHistory.analyze({
                tempStationId: vm.tempStation.stationId
            }, onSuccess, onError);
            
            function onSuccess(data, headers) {
            }
            function onError(error) {
                AlertService.error(error.data.message);
            }
		}
		
		vm.datePickerOpenStatus.scheduledTime = false;

        function openCalendar (date) {
            vm.datePickerOpenStatus[date] = true;
        }
        
        
        function getScheduledList(){
			findByRoute();
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
		
		function search() {
			vm.input= {};
			vm.input.routeId = vm.route.id;
			vm.input.date = vm.scheduledTimeValue.scheduledTime;
			vm.input.scheduledVoyageId = vm.scheduledTimeValue.id;
			vm.idOfFirtRecord = "";
			BusDensityHistory.findByRouteAndScheduledTime(vm.input, onSearchSuccess, onSearchError);
            
        }
        
        function onSearchSuccess(data, headers) {
			vm.busDensityHistories = data;
			if(vm.busDensityHistories.length>0)
				vm.idOfFirtRecord = vm.busDensityHistories[0].id;	
			
		}
		
		function onSearchError(error) {
			 AlertService.error(error.data.message);
		}
		
		function showMap(){
			 $state.go('bus-density-history.edit', { routeId: vm.route.id ,scheduledVoyageId:vm.scheduledTimeValue.id });
		}
    }
})();
