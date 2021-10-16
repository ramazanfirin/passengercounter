'use strict';

describe('Controller Tests', function() {

    describe('StationRouteConnection Management Detail Controller', function() {
        var $scope, $rootScope;
        var MockEntity, MockPreviousState, MockStationRouteConnection, MockStation, MockRoute;
        var createController;

        beforeEach(inject(function($injector) {
            $rootScope = $injector.get('$rootScope');
            $scope = $rootScope.$new();
            MockEntity = jasmine.createSpy('MockEntity');
            MockPreviousState = jasmine.createSpy('MockPreviousState');
            MockStationRouteConnection = jasmine.createSpy('MockStationRouteConnection');
            MockStation = jasmine.createSpy('MockStation');
            MockRoute = jasmine.createSpy('MockRoute');
            

            var locals = {
                '$scope': $scope,
                '$rootScope': $rootScope,
                'entity': MockEntity,
                'previousState': MockPreviousState,
                'StationRouteConnection': MockStationRouteConnection,
                'Station': MockStation,
                'Route': MockRoute
            };
            createController = function() {
                $injector.get('$controller')("StationRouteConnectionDetailController", locals);
            };
        }));


        describe('Root Scope Listening', function() {
            it('Unregisters root scope listener upon scope destruction', function() {
                var eventType = 'passengercounter2App:stationRouteConnectionUpdate';

                createController();
                expect($rootScope.$$listenerCount[eventType]).toEqual(1);

                $scope.$destroy();
                expect($rootScope.$$listenerCount[eventType]).toBeUndefined();
            });
        });
    });

});
