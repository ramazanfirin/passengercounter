(function() {
	'use strict';

	angular
		.module('passengercounter2App')
		.controller('BusChartsController', BusChartsController);

	BusChartsController.$inject = ['$state', 'Bus', 'ParseLinks', 'AlertService', 'paginationConstants', 'pagingParams', 'Route','BusDensityHistory','ScheduledVoyage'];

	function BusChartsController($state, Bus, ParseLinks, AlertService, paginationConstants, pagingParams, Route,BusDensityHistory,ScheduledVoyage ) {

		var vm = this;

		vm.loadPage = loadPage;
		vm.predicate = pagingParams.predicate;
		vm.reverse = pagingParams.ascending;
		vm.transition = transition;
		vm.itemsPerPage = paginationConstants.itemsPerPage;
		vm.openCalendar = openCalendar;
		vm.search = search;
		vm.routes = Route.query();
		vm.datePickerOpenStatus = {};
		vm.datePickerOpenStatus.scheduledTime = false;
		vm.getScheduledList = getScheduledList;

		function search() {
			vm.input = {};
			vm.input.routeId = vm.route.id;
			vm.input.date = vm.scheduledTimeValue.scheduledTime;
			vm.input.scheduledVoyageId = vm.scheduledTimeValue.id;
			BusDensityHistory.findDailyChartData(vm.input, onSearchSuccess, onSearchError);
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


		function onSearchSuccess(data, headers) {
			vm.labels =  data.labels;
			vm.series = data.series;	
			vm.data = data.datas;
			prepareHighCharts(data);
		}
		
		function onSearchError(error) {
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

		function openCalendar(date) {
			vm.datePickerOpenStatus[date] = true;
		}

		vm.onClick = function(points, evt) {
			console.log(points, evt);
		};
		vm.datasetOverride = [{ yAxisID: 'y-axis-1' }, { yAxisID: 'y-axis-2' }];
		vm.options = {
			scales: {
				yAxes: [
					{
						id: 'y-axis-1',
						type: 'linear',
						display: true,
						position: 'left'
					}
				]
			}
		};
		
		
		function prepareHighCharts(data) {
			vm.chartConfig.xAxis.categories = data.labels;
			vm.chartSeries = [];
			for(var i=0;i<data.series.length;i++){
				var serie = {};
				serie.name = "Sefer Saati:"+data.series[i];
				serie.data = data.datas[i];
				vm.chartSeries.push(serie);
			}
			
		}
		
		
		vm.chartSeries = [
//			{ 
//			"name": "Some data", 
//			"data": [1, 2, 4, 7, 3], 
//			 id: 's1' 
//			 },
		];

		vm.chartConfig = {

			chart: {
				height: 500,
				width: 1100,
				type: 'line'
			},
			plotOptions: {
				series: {
					stacking: ''
				}
			},
			series: vm.chartSeries,
			title: {
				text: 'Yolcu Sayisi Raporu'
			},
			yAxis: {
				title: {
					text: "Yolcu Sayısı"
				}
			},
			xAxis: {
				title: {
					text: "Duraklar"
				},
				
			},
		}

	}
})();
