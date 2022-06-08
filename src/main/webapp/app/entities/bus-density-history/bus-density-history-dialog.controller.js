(function() {
    'use strict';

    angular
        .module('passengercounter2App')
        .controller('BusDensityHistoryDialogController', BusDensityHistoryDialogController);

    BusDensityHistoryDialogController.$inject = ['$timeout', '$scope', '$stateParams', '$uibModalInstance', 'entity', 'BusDensityHistory', 'ScheduledVoyage', 'Bus', 'Station', 'Route', 'RawTable','AlertService'];

    function BusDensityHistoryDialogController ($timeout, $scope, $stateParams, $uibModalInstance, entity, BusDensityHistory, ScheduledVoyage, Bus, Station, Route, RawTable,AlertService) {
        var vm = this;

        vm.busDensityHistory = entity;
        vm.clear = clear;
        vm.datePickerOpenStatus = {};
        vm.openCalendar = openCalendar;
        vm.save = save;
        vm.scheduledvoyages = ScheduledVoyage.query();
        vm.buses = Bus.query();
        vm.stations = Station.query();
        vm.routes = Route.query();
        vm.rawtables = RawTable.query();


        loadAll();

        function loadAll () {
            BusDensityHistory.query({
                page: 0,
                size: 10000,
                sort: sort()
            }, onSuccess, onError);
            function sort() {
                var result = ['id','desc'];
               
                return result;
            }
            function onSuccess(data, headers) {
                //vm.links = ParseLinks.parse(headers('link'));
                vm.totalItems = headers('X-Total-Count');
                vm.queryCount = vm.totalItems;
                vm.busDensityHistories = data;
                //vm.page = pagingParams.page;
                prepareMap();
            }
            function onError(error) {
                AlertService.error(error.data.message);
            }
        }


        $timeout(function (){
            angular.element('.form-group:eq(1)>input').focus();
           
        });
        
		function prepareMap() {

			console.log(vm.busDensityHistories[0].station.lat);
			console.log(vm.busDensityHistories[0].station.lng);

			$scope.MapOptions = {
				center: { lat: Number(vm.busDensityHistories[0].station.lat), lng: Number(vm.busDensityHistories[0].station.lng) },
				zoom: 14,
				mapTypeId: google.maps.MapTypeId.satellite
			};

			$scope.Map = new google.maps.Map(document.getElementById("dvMap"), $scope.MapOptions);

			let routeCoordinates = [

			];

			for (let i = 0; i < vm.busDensityHistories.length; i++) {
				let busDensity = vm.busDensityHistories[i];


				var myLatlng = new google.maps.LatLng(busDensity.station.lat, busDensity.station.lng);
				routeCoordinates.push(myLatlng);
				var marker = new google.maps.Marker({
					position: myLatlng,
					map: $scope.Map,
					title: busDensity.station.name,
					label: {
						text: busDensity.station.name,
						color: 'yellow',
					},
					customInfo: busDensity.density
				});


				let infoWindow = new google.maps.InfoWindow();
				infoWindow.setContent("Y. Sayisi:" + busDensity.totalPassengerCount + "<br>Yoğunluk:%" + busDensity.density);
				infoWindow.open({
					anchor: marker,
					map: $scope.Map,
					shouldFocus: false,
				});

			}

			const lineSymbol = {
				path: google.maps.SymbolPath.FORWARD_CLOSED_ARROW,
			};

			const flightPath = new google.maps.Polyline({
				path: routeCoordinates,
				icons: [
					{
						icon: lineSymbol,
						offset: "100%",
					},
				],
				geodesic: true,
				strokeColor: "#FF0000",
				strokeOpacity: 1.0,
				strokeWeight: 2,

			});

			flightPath.setMap($scope.Map);

		}
	


        function clear () {
            $uibModalInstance.dismiss('cancel');
        }

        function save () {
            vm.isSaving = true;
            if (vm.busDensityHistory.id !== null) {
                BusDensityHistory.update(vm.busDensityHistory, onSaveSuccess, onSaveError);
            } else {
                BusDensityHistory.save(vm.busDensityHistory, onSaveSuccess, onSaveError);
            }
        }

        function onSaveSuccess (result) {
            $scope.$emit('passengercounter2App:busDensityHistoryUpdate', result);
            $uibModalInstance.close(result);
            vm.isSaving = false;
        }

        function onSaveError () {
            vm.isSaving = false;
        }

        vm.datePickerOpenStatus.recordDate = false;

        function openCalendar (date) {
            vm.datePickerOpenStatus[date] = true;
        }
    }
})();
