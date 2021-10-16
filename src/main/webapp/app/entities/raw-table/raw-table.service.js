(function() {
    'use strict';
    angular
        .module('passengercounter2App')
        .factory('RawTable', RawTable);

    RawTable.$inject = ['$resource', 'DateUtils'];

    function RawTable ($resource, DateUtils) {
        var resourceUrl =  'api/raw-tables/:id';

        return $resource(resourceUrl, {}, {
            'query': { method: 'GET', isArray: true},
            'get': {
                method: 'GET',
                transformResponse: function (data) {
                    if (data) {
                        data = angular.fromJson(data);
                        data.insertDate = DateUtils.convertDateTimeFromServer(data.insertDate);
                    }
                    return data;
                }
            },
            'update': { method:'PUT' }
        });
    }
})();
