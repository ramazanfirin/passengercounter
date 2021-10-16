(function() {
    'use strict';
    angular
        .module('passengercounter2App')
        .factory('StationRouteConnection', StationRouteConnection);

    StationRouteConnection.$inject = ['$resource'];

    function StationRouteConnection ($resource) {
        var resourceUrl =  'api/station-route-connections/:id';

        return $resource(resourceUrl, {}, {
            'query': { method: 'GET', isArray: true},
            'get': {
                method: 'GET',
                transformResponse: function (data) {
                    if (data) {
                        data = angular.fromJson(data);
                    }
                    return data;
                }
            },
            'update': { method:'PUT' }
        });
    }
})();
