(function() {
    'use strict';

    angular
        .module('passengercounter2App')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
        $stateProvider
        .state('scheduled-voyage', {
            parent: 'entity',
            url: '/scheduled-voyage',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'passengercounter2App.scheduledVoyage.home.title'
            },
            views: {
                'content@': {
                    templateUrl: 'app/entities/scheduled-voyage/scheduled-voyages.html',
                    controller: 'ScheduledVoyageController',
                    controllerAs: 'vm'
                }
            },
            resolve: {
                translatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate, $translatePartialLoader) {
                    $translatePartialLoader.addPart('scheduledVoyage');
                    $translatePartialLoader.addPart('global');
                    return $translate.refresh();
                }]
            }
        })
        .state('scheduled-voyage-detail', {
            parent: 'scheduled-voyage',
            url: '/scheduled-voyage/{id}',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'passengercounter2App.scheduledVoyage.detail.title'
            },
            views: {
                'content@': {
                    templateUrl: 'app/entities/scheduled-voyage/scheduled-voyage-detail.html',
                    controller: 'ScheduledVoyageDetailController',
                    controllerAs: 'vm'
                }
            },
            resolve: {
                translatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate, $translatePartialLoader) {
                    $translatePartialLoader.addPart('scheduledVoyage');
                    return $translate.refresh();
                }],
                entity: ['$stateParams', 'ScheduledVoyage', function($stateParams, ScheduledVoyage) {
                    return ScheduledVoyage.get({id : $stateParams.id}).$promise;
                }],
                previousState: ["$state", function ($state) {
                    var currentStateData = {
                        name: $state.current.name || 'scheduled-voyage',
                        params: $state.params,
                        url: $state.href($state.current.name, $state.params)
                    };
                    return currentStateData;
                }]
            }
        })
        .state('scheduled-voyage-detail.edit', {
            parent: 'scheduled-voyage-detail',
            url: '/detail/edit',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/scheduled-voyage/scheduled-voyage-dialog.html',
                    controller: 'ScheduledVoyageDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: ['ScheduledVoyage', function(ScheduledVoyage) {
                            return ScheduledVoyage.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('^', {}, { reload: false });
                }, function() {
                    $state.go('^');
                });
            }]
        })
        .state('scheduled-voyage.new', {
            parent: 'scheduled-voyage',
            url: '/new',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/scheduled-voyage/scheduled-voyage-dialog.html',
                    controller: 'ScheduledVoyageDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: function () {
                            return {
                                name: null,
                                scheduledTime: null,
                                id: null
                            };
                        }
                    }
                }).result.then(function() {
                    $state.go('scheduled-voyage', null, { reload: 'scheduled-voyage' });
                }, function() {
                    $state.go('scheduled-voyage');
                });
            }]
        })
        .state('scheduled-voyage.edit', {
            parent: 'scheduled-voyage',
            url: '/{id}/edit',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/scheduled-voyage/scheduled-voyage-dialog.html',
                    controller: 'ScheduledVoyageDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: ['ScheduledVoyage', function(ScheduledVoyage) {
                            return ScheduledVoyage.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('scheduled-voyage', null, { reload: 'scheduled-voyage' });
                }, function() {
                    $state.go('^');
                });
            }]
        })
        .state('scheduled-voyage.delete', {
            parent: 'scheduled-voyage',
            url: '/{id}/delete',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/scheduled-voyage/scheduled-voyage-delete-dialog.html',
                    controller: 'ScheduledVoyageDeleteController',
                    controllerAs: 'vm',
                    size: 'md',
                    resolve: {
                        entity: ['ScheduledVoyage', function(ScheduledVoyage) {
                            return ScheduledVoyage.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('scheduled-voyage', null, { reload: 'scheduled-voyage' });
                }, function() {
                    $state.go('^');
                });
            }]
        });
    }

})();
