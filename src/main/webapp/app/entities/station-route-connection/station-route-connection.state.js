(function() {
    'use strict';

    angular
        .module('passengercounter2App')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
        $stateProvider
        .state('station-route-connection', {
            parent: 'entity',
            url: '/station-route-connection',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'passengercounter2App.stationRouteConnection.home.title'
            },
            views: {
                'content@': {
                    templateUrl: 'app/entities/station-route-connection/station-route-connections.html',
                    controller: 'StationRouteConnectionController',
                    controllerAs: 'vm'
                }
            },
            resolve: {
                translatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate, $translatePartialLoader) {
                    $translatePartialLoader.addPart('stationRouteConnection');
                    $translatePartialLoader.addPart('global');
                    return $translate.refresh();
                }]
            }
        })
        .state('station-route-connection-detail', {
            parent: 'station-route-connection',
            url: '/station-route-connection/{id}',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'passengercounter2App.stationRouteConnection.detail.title'
            },
            views: {
                'content@': {
                    templateUrl: 'app/entities/station-route-connection/station-route-connection-detail.html',
                    controller: 'StationRouteConnectionDetailController',
                    controllerAs: 'vm'
                }
            },
            resolve: {
                translatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate, $translatePartialLoader) {
                    $translatePartialLoader.addPart('stationRouteConnection');
                    return $translate.refresh();
                }],
                entity: ['$stateParams', 'StationRouteConnection', function($stateParams, StationRouteConnection) {
                    return StationRouteConnection.get({id : $stateParams.id}).$promise;
                }],
                previousState: ["$state", function ($state) {
                    var currentStateData = {
                        name: $state.current.name || 'station-route-connection',
                        params: $state.params,
                        url: $state.href($state.current.name, $state.params)
                    };
                    return currentStateData;
                }]
            }
        })
        .state('station-route-connection-detail.edit', {
            parent: 'station-route-connection-detail',
            url: '/detail/edit',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/station-route-connection/station-route-connection-dialog.html',
                    controller: 'StationRouteConnectionDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: ['StationRouteConnection', function(StationRouteConnection) {
                            return StationRouteConnection.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('^', {}, { reload: false });
                }, function() {
                    $state.go('^');
                });
            }]
        })
        .state('station-route-connection.new', {
            parent: 'station-route-connection',
            url: '/new',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/station-route-connection/station-route-connection-dialog.html',
                    controller: 'StationRouteConnectionDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: function () {
                            return {
                                name: null,
                                index: null,
                                id: null
                            };
                        }
                    }
                }).result.then(function() {
                    $state.go('station-route-connection', null, { reload: 'station-route-connection' });
                }, function() {
                    $state.go('station-route-connection');
                });
            }]
        })
        .state('station-route-connection.edit', {
            parent: 'station-route-connection',
            url: '/{id}/edit',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/station-route-connection/station-route-connection-dialog.html',
                    controller: 'StationRouteConnectionDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: ['StationRouteConnection', function(StationRouteConnection) {
                            return StationRouteConnection.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('station-route-connection', null, { reload: 'station-route-connection' });
                }, function() {
                    $state.go('^');
                });
            }]
        })
        .state('station-route-connection.delete', {
            parent: 'station-route-connection',
            url: '/{id}/delete',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/station-route-connection/station-route-connection-delete-dialog.html',
                    controller: 'StationRouteConnectionDeleteController',
                    controllerAs: 'vm',
                    size: 'md',
                    resolve: {
                        entity: ['StationRouteConnection', function(StationRouteConnection) {
                            return StationRouteConnection.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('station-route-connection', null, { reload: 'station-route-connection' });
                }, function() {
                    $state.go('^');
                });
            }]
        });
    }

})();
