(function() {
    'use strict';
    angular
        .module('passengercounter2App')
        .factory('BusDensityHistory', BusDensityHistory);

    BusDensityHistory.$inject = ['$resource', 'DateUtils'];

    function BusDensityHistory ($resource, DateUtils) {
        var resourceUrl =  'api/bus-density-histories/:id';

        return $resource(resourceUrl, {}, {
            'query': { method: 'GET', isArray: true},
            'get': {
                method: 'GET',
                transformResponse: function (data) {
                    if (data) {
                        data = angular.fromJson(data);
                        data.recordDate = DateUtils.convertDateTimeFromServer(data.recordDate);
                    }
                    return data;
                }
            },
            'update': { method:'PUT' }
        });
    }
})();
