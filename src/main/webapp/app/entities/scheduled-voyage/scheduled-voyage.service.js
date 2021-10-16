(function() {
    'use strict';
    angular
        .module('passengercounter2App')
        .factory('ScheduledVoyage', ScheduledVoyage);

    ScheduledVoyage.$inject = ['$resource', 'DateUtils'];

    function ScheduledVoyage ($resource, DateUtils) {
        var resourceUrl =  'api/scheduled-voyages/:id';

        return $resource(resourceUrl, {}, {
            'query': { method: 'GET', isArray: true},
            'get': {
                method: 'GET',
                transformResponse: function (data) {
                    if (data) {
                        data = angular.fromJson(data);
                        data.scheduledTime = DateUtils.convertDateTimeFromServer(data.scheduledTime);
                    }
                    return data;
                }
            },
            'update': { method:'PUT' }
        });
    }
})();
