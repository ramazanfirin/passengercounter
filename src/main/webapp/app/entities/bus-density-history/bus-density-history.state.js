(function() {
    'use strict';

    angular
        .module('passengercounter2App')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
        $stateProvider
        .state('bus-density-history', {
            parent: 'entity',
            url: '/bus-density-history?page&sort&search',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'passengercounter2App.busDensityHistory.home.title'
            },
            views: {
                'content@': {
                    templateUrl: 'app/entities/bus-density-history/bus-density-histories.html',
                    controller: 'BusDensityHistoryController',
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
        .state('bus-density-history-detail', {
            parent: 'bus-density-history',
            url: '/bus-density-history/{id}',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'passengercounter2App.busDensityHistory.detail.title'
            },
            views: {
                'content@': {
                    templateUrl: 'app/entities/bus-density-history/bus-density-history-detail.html',
                    controller: 'BusDensityHistoryDetailController',
                    controllerAs: 'vm'
                }
            },
            resolve: {
                translatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate, $translatePartialLoader) {
                    $translatePartialLoader.addPart('busDensityHistory');
                    return $translate.refresh();
                }],
                entity: ['$stateParams', 'BusDensityHistory', function($stateParams, BusDensityHistory) {
                    return BusDensityHistory.get({id : $stateParams.id}).$promise;
                }],
                previousState: ["$state", function ($state) {
                    var currentStateData = {
                        name: $state.current.name || 'bus-density-history',
                        params: $state.params,
                        url: $state.href($state.current.name, $state.params)
                    };
                    return currentStateData;
                }]
            }
        })
        .state('bus-density-history-detail.edit', {
            parent: 'bus-density-history-detail',
            url: '/detail/edit',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/bus-density-history/bus-density-history-dialog.html',
                    controller: 'BusDensityHistoryDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    //resolve: {
                        //entity: ['BusDensityHistory', function(BusDensityHistory) {
                         //   return BusDensityHistory.get({id : $stateParams.id}).$promise;
                    //    }]
                    //}
                }).result.then(function() {
                    $state.go('^', {}, { reload: false });
                }, function() {
                    $state.go('^');
                });
            }]
        })
        .state('bus-density-history.new', {
            parent: 'bus-density-history',
            url: '/new',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/bus-density-history/bus-density-history-dialog.html',
                    controller: 'BusDensityHistoryDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: function () {
                            return {
                                recordDate: null,
                                totalPassengerCount: null,
                                getInPassengerCount: null,
                                getOutPassengerCount: null,
                                density: null,
                                id: null
                            };
                        }
                    }
                }).result.then(function() {
                    $state.go('bus-density-history', null, { reload: 'bus-density-history' });
                }, function() {
                    $state.go('bus-density-history');
                });
            }]
        })
        .state('bus-density-history.edit', {
            parent: 'bus-density-history',
            url: '/{id}/edit',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/bus-density-history/bus-density-history-dialog.html',
                    controller: 'BusDensityHistoryDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: ['BusDensityHistory', function(BusDensityHistory) {
                            return BusDensityHistory.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('bus-density-history', null, { reload: 'bus-density-history' });
                }, function() {
                    $state.go('^');
                });
            }]
        })
        .state('bus-density-history.delete', {
            parent: 'bus-density-history',
            url: '/{id}/delete',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/bus-density-history/bus-density-history-delete-dialog.html',
                    controller: 'BusDensityHistoryDeleteController',
                    controllerAs: 'vm',
                    size: 'md',
                    resolve: {
                        entity: ['BusDensityHistory', function(BusDensityHistory) {
                            return BusDensityHistory.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('bus-density-history', null, { reload: 'bus-density-history' });
                }, function() {
                    $state.go('^');
                });
            }]
        });
    }

})();
