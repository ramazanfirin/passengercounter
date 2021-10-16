'use strict';

describe('Controller Tests', function() {

    describe('ScheduledVoyage Management Detail Controller', function() {
        var $scope, $rootScope;
        var MockEntity, MockPreviousState, MockScheduledVoyage, MockRoute, MockBus;
        var createController;

        beforeEach(inject(function($injector) {
            $rootScope = $injector.get('$rootScope');
            $scope = $rootScope.$new();
            MockEntity = jasmine.createSpy('MockEntity');
            MockPreviousState = jasmine.createSpy('MockPreviousState');
            MockScheduledVoyage = jasmine.createSpy('MockScheduledVoyage');
            MockRoute = jasmine.createSpy('MockRoute');
            MockBus = jasmine.createSpy('MockBus');
            

            var locals = {
                '$scope': $scope,
                '$rootScope': $rootScope,
                'entity': MockEntity,
                'previousState': MockPreviousState,
                'ScheduledVoyage': MockScheduledVoyage,
                'Route': MockRoute,
                'Bus': MockBus
            };
            createController = function() {
                $injector.get('$controller')("ScheduledVoyageDetailController", locals);
            };
        }));


        describe('Root Scope Listening', function() {
            it('Unregisters root scope listener upon scope destruction', function() {
                var eventType = 'passengercounter2App:scheduledVoyageUpdate';

                createController();
                expect($rootScope.$$listenerCount[eventType]).toEqual(1);

                $scope.$destroy();
                expect($rootScope.$$listenerCount[eventType]).toBeUndefined();
            });
        });
    });

});
