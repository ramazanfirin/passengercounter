(function() {
    'use strict';

    angular
        .module('passengercounter2App')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
        $stateProvider
        .state('raw-table', {
            parent: 'entity',
            url: '/raw-table?page&sort&search',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'passengercounter2App.rawTable.home.title'
            },
            views: {
                'content@': {
                    templateUrl: 'app/entities/raw-table/raw-tables.html',
                    controller: 'RawTableController',
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
                    $translatePartialLoader.addPart('rawTable');
                    $translatePartialLoader.addPart('global');
                    return $translate.refresh();
                }]
            }
        })
        .state('raw-table-detail', {
            parent: 'raw-table',
            url: '/raw-table/{id}',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'passengercounter2App.rawTable.detail.title'
            },
            views: {
                'content@': {
                    templateUrl: 'app/entities/raw-table/raw-table-detail.html',
                    controller: 'RawTableDetailController',
                    controllerAs: 'vm'
                }
            },
            resolve: {
                translatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate, $translatePartialLoader) {
                    $translatePartialLoader.addPart('rawTable');
                    return $translate.refresh();
                }],
                entity: ['$stateParams', 'RawTable', function($stateParams, RawTable) {
                    return RawTable.get({id : $stateParams.id}).$promise;
                }],
                previousState: ["$state", function ($state) {
                    var currentStateData = {
                        name: $state.current.name || 'raw-table',
                        params: $state.params,
                        url: $state.href($state.current.name, $state.params)
                    };
                    return currentStateData;
                }]
            }
        })
        .state('raw-table-detail.edit', {
            parent: 'raw-table-detail',
            url: '/detail/edit',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/raw-table/raw-table-dialog.html',
                    controller: 'RawTableDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: ['RawTable', function(RawTable) {
                            return RawTable.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('^', {}, { reload: false });
                }, function() {
                    $state.go('^');
                });
            }]
        })
        .state('raw-table.new', {
            parent: 'raw-table',
            url: '/new',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/raw-table/raw-table-dialog.html',
                    controller: 'RawTableDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: function () {
                            return {
                                deviceIdOriginal: null,
                                upPeople1: null,
                                downPeople1: null,
                                upPeople2: null,
                                downPeople2: null,
                                upPeople3: null,
                                downPeople3: null,
                                upPeople4: null,
                                downPeople4: null,
                                curPeople: null,
                                incrPeople: null,
                                lat: null,
                                lng: null,
                                insertDate: null,
                                processed: null,
                                isSuccess: null,
                                errorMessage: null,
                                id: null
                            };
                        }
                    }
                }).result.then(function() {
                    $state.go('raw-table', null, { reload: 'raw-table' });
                }, function() {
                    $state.go('raw-table');
                });
            }]
        })
        .state('raw-table.edit', {
            parent: 'raw-table',
            url: '/{id}/edit',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/raw-table/raw-table-dialog.html',
                    controller: 'RawTableDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: ['RawTable', function(RawTable) {
                            return RawTable.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('raw-table', null, { reload: 'raw-table' });
                }, function() {
                    $state.go('^');
                });
            }]
        })
        .state('raw-table.delete', {
            parent: 'raw-table',
            url: '/{id}/delete',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/raw-table/raw-table-delete-dialog.html',
                    controller: 'RawTableDeleteController',
                    controllerAs: 'vm',
                    size: 'md',
                    resolve: {
                        entity: ['RawTable', function(RawTable) {
                            return RawTable.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('raw-table', null, { reload: 'raw-table' });
                }, function() {
                    $state.go('^');
                });
            }]
        });
    }

})();
