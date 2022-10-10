(function() {
    'use strict';

    angular
        .module('passengercounter2App')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
        $stateProvider
        .state('bus-charts', {
            parent: 'entity',
            url: '/bus-charts?page&sort&search',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'passengercounter2App.bus.home.title'
            },
            views: {
                'content@': {
                    templateUrl: 'app/entities/bus-charts/buses-charts.html',
                    controller: 'BusChartsController',
                    controllerAs: 'vm'
                }
            },
            params: {
                page: {
                    value: '1',
                    squash: true
                },
                sort: {
                    value: 'id,asc',
                    squash: true
                },
                search: null
            },
            resolve: {
                pagingParams: ['$stateParams', 'PaginationUtil', function ($stateParams, PaginationUtil) {
                    return {
                        page: PaginationUtil.parsePage($stateParams.page),
                        sort: $stateParams.sort,
                        predicate: PaginationUtil.parsePredicate($stateParams.sort),
                        ascending: PaginationUtil.parseAscending($stateParams.sort),
                        search: $stateParams.search
                    };
                }],
                translatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate, $translatePartialLoader) {
					$translatePartialLoader.addPart('busDensityHistory');
                    $translatePartialLoader.addPart('global');
                    $translatePartialLoader.addPart('route');
                    $translatePartialLoader.addPart('scheduledVoyage');
                     $translatePartialLoader.addPart('stationRouteConnection');	
                    return $translate.refresh();
                }]
            }
        })
    }

})();
