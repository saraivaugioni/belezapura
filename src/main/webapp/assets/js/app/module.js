(function () {
    angular.module('app', ['ui.router']);

    angular.module('app').config(AppConfig);

    AppConfig.$inject = ['$stateProvider'];

    function AppConfig($stateProvider) {

        $stateProvider
            .state({
                name: 'Clientes',
                url: '/clientes',
                templateUrl: '/view/clientes/list.html',
                controller: 'ClienteListController',
                controllerAs: 'vm'
            })
            .state({
                name: 'Novo Cliente',
                url: '/clientes/novo',
                templateUrl: '/view/clientes/form.html',
                controller: 'ClienteFormController',
                controllerAs: 'vm'
            })
    }
})();