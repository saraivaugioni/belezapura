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
            .state({
                name: 'Equipamentos',
                url: '/equipamentos',
                templateUrl: '/view/equipamentos/list.html',
                controller: 'EquipamentoListController',
                controllerAs: 'vm'
            })
            .state({
                name: 'Novo Equipamento',
                url: '/equipamentos/novo',
                templateUrl: '/view/equipamentos/form.html',
                controller: 'EquipamentoFormController',
                controllerAs: 'vm'
            })
            .state({
                name: 'Pacotes',
                url: '/pacotes',
                templateUrl: '/view/pacotes/list.html',
                controller: 'PacoteListController',
                controllerAs: 'vm'
            })
            .state({
                name: 'Novo Pacote',
                url: '/pacotes/novo',
                templateUrl: '/view/pacotes/form.html',
                controller: 'PacoteFormController',
                controllerAs: 'vm'
            })
            .state({
                name: 'Produtos',
                url: '/produtos',
                templateUrl: '/view/produtos/list.html',
                controller: 'ProdutoListController',
                controllerAs: 'vm'
            })
            .state({
                name: 'Novo Produto',
                url: '/produtos/novo',
                templateUrl: '/view/produtos/form.html',
                controller: 'ProdutoFormController',
                controllerAs: 'vm'
            })
            .state({
                name: 'Protocolos',
                url: '/protocolos',
                templateUrl: '/view/protocolos/list.html',
                controller: 'ProtocoloListController',
                controllerAs: 'vm'
            })
            .state({
                name: 'Novo Protocolo',
                url: '/protocolos/novo',
                templateUrl: '/view/protocolos/form.html',
                controller: 'ProtocoloFormController',
                controllerAs: 'vm'
            })
    }
})();