(function() {
    'use strict';

    angular
        .module('passengercounter2App')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
        $stateProvider
        .state('device', {
            parent: 'entity',
            url: '/device',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'passengercounter2App.device.home.title'
            },
            views: {
                'content@': {
                    templateUrl: 'app/entities/device/devices.html',
                    controller: 'DeviceController',
                    controllerAs: 'vm'
                }
            },
            resolve: {
                translatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate, $translatePartialLoader) {
                    $translatePartialLoader.addPart('device');
                    $translatePartialLoader.addPart('global');
                    return $translate.refresh();
                }]
            }
        })
        .state('device-detail', {
            parent: 'device',
            url: '/device/{id}',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'passengercounter2App.device.detail.title'
            },
            views: {
                'content@': {
                    templateUrl: 'app/entities/device/device-detail.html',
                    controller: 'DeviceDetailController',
                    controllerAs: 'vm'
                }
            },
            resolve: {
                translatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate, $translatePartialLoader) {
                    $translatePartialLoader.addPart('device');
                    return $translate.refresh();
                }],
                entity: ['$stateParams', 'Device', function($stateParams, Device) {
                    return Device.get({id : $stateParams.id}).$promise;
                }],
                previousState: ["$state", function ($state) {
                    var currentStateData = {
                        name: $state.current.name || 'device',
                        params: $state.params,
                        url: $state.href($state.current.name, $state.params)
                    };
                    return currentStateData;
                }]
            }
        })
        .state('device-detail.edit', {
            parent: 'device-detail',
            url: '/detail/edit',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/device/device-dialog.html',
                    controller: 'DeviceDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: ['Device', function(Device) {
                            return Device.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('^', {}, { reload: false });
                }, function() {
                    $state.go('^');
                });
            }]
        })
        .state('device.new', {
            parent: 'device',
            url: '/new',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/device/device-dialog.html',
                    controller: 'DeviceDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: function () {
                            return {
                                deviceId: null,
                                id: null
                            };
                        }
                    }
                }).result.then(function() {
                    $state.go('device', null, { reload: 'device' });
                }, function() {
                    $state.go('device');
                });
            }]
        })
        .state('device.edit', {
            parent: 'device',
            url: '/{id}/edit',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/device/device-dialog.html',
                    controller: 'DeviceDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: ['Device', function(Device) {
                            return Device.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('device', null, { reload: 'device' });
                }, function() {
                    $state.go('^');
                });
            }]
        })
        .state('device.delete', {
            parent: 'device',
            url: '/{id}/delete',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/device/device-delete-dialog.html',
                    controller: 'DeviceDeleteController',
                    controllerAs: 'vm',
                    size: 'md',
                    resolve: {
                        entity: ['Device', function(Device) {
                            return Device.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('device', null, { reload: 'device' });
                }, function() {
                    $state.go('^');
                });
            }]
        });
    }

})();
