'use strict';

describe('Controller Tests', function() {

    describe('RawTable Management Detail Controller', function() {
        var $scope, $rootScope;
        var MockEntity, MockPreviousState, MockRawTable, MockDevice, MockScheduledVoyage, MockStation;
        var createController;

        beforeEach(inject(function($injector) {
            $rootScope = $injector.get('$rootScope');
            $scope = $rootScope.$new();
            MockEntity = jasmine.createSpy('MockEntity');
            MockPreviousState = jasmine.createSpy('MockPreviousState');
            MockRawTable = jasmine.createSpy('MockRawTable');
            MockDevice = jasmine.createSpy('MockDevice');
            MockScheduledVoyage = jasmine.createSpy('MockScheduledVoyage');
            MockStation = jasmine.createSpy('MockStation');
            

            var locals = {
                '$scope': $scope,
                '$rootScope': $rootScope,
                'entity': MockEntity,
                'previousState': MockPreviousState,
                'RawTable': MockRawTable,
                'Device': MockDevice,
                'ScheduledVoyage': MockScheduledVoyage,
                'Station': MockStation
            };
            createController = function() {
                $injector.get('$controller')("RawTableDetailController", locals);
            };
        }));


        describe('Root Scope Listening', function() {
            it('Unregisters root scope listener upon scope destruction', function() {
                var eventType = 'passengercounter2App:rawTableUpdate';

                createController();
                expect($rootScope.$$listenerCount[eventType]).toEqual(1);

                $scope.$destroy();
                expect($rootScope.$$listenerCount[eventType]).toBeUndefined();
            });
        });
    });

});
