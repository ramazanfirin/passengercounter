'use strict';

describe('Controller Tests', function() {

    describe('BusDensityHistory Management Detail Controller', function() {
        var $scope, $rootScope;
        var MockEntity, MockPreviousState, MockBusDensityHistory, MockScheduledVoyage, MockBus, MockStation, MockRoute, MockRawTable;
        var createController;

        beforeEach(inject(function($injector) {
            $rootScope = $injector.get('$rootScope');
            $scope = $rootScope.$new();
            MockEntity = jasmine.createSpy('MockEntity');
            MockPreviousState = jasmine.createSpy('MockPreviousState');
            MockBusDensityHistory = jasmine.createSpy('MockBusDensityHistory');
            MockScheduledVoyage = jasmine.createSpy('MockScheduledVoyage');
            MockBus = jasmine.createSpy('MockBus');
            MockStation = jasmine.createSpy('MockStation');
            MockRoute = jasmine.createSpy('MockRoute');
            MockRawTable = jasmine.createSpy('MockRawTable');
            

            var locals = {
                '$scope': $scope,
                '$rootScope': $rootScope,
                'entity': MockEntity,
                'previousState': MockPreviousState,
                'BusDensityHistory': MockBusDensityHistory,
                'ScheduledVoyage': MockScheduledVoyage,
                'Bus': MockBus,
                'Station': MockStation,
                'Route': MockRoute,
                'RawTable': MockRawTable
            };
            createController = function() {
                $injector.get('$controller')("BusDensityHistoryDetailController", locals);
            };
        }));


        describe('Root Scope Listening', function() {
            it('Unregisters root scope listener upon scope destruction', function() {
                var eventType = 'passengercounter2App:busDensityHistoryUpdate';

                createController();
                expect($rootScope.$$listenerCount[eventType]).toEqual(1);

                $scope.$destroy();
                expect($rootScope.$$listenerCount[eventType]).toBeUndefined();
            });
        });
    });

});
