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
            'analyze': { method: 'GET', isArray:false, url: 'api/bus-density-histories/analyze'},
            'findByRouteAndScheduledTime': { method: 'POST', isArray:true, url: 'api/bus-density-histories/findByRouteAndScheduledTime'},
            'findDailyChartData': { method: 'POST', isArray:true, url: 'api/bus-density-histories/findDailyChartData'},
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
