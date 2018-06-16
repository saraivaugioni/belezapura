(function () {
    'use strict'

    angular.module('app')
        .controller('AtendimentoFormController', AtendimentoFormController);

    AtendimentoFormController.$inject = [
        'AtendimentoService',
        '$state',
        '$stateParams',
        'DialogBuilder',
        'ClienteService',
        'ProdutoService'
    ];

    function AtendimentoFormController(AtendimentoService, $state, $stateParams, DialogBuilder, ClienteService, ProdutoService) {

        var vm = this;
        vm.registro = {
            data: new Date(),
            valorTotal: 0,
            itens: []
        };
        vm.error = {};
        vm.titulo = 'Novo Atendimento';

        vm.clientes = [];
        vm.produtos = [];

        vm.salvar = salvar;

        vm.itemOriginal = null;
        vm.registroItem = {};

        vm.excluirItem = excluirItem;
        vm.editarItem = editarItem;
        vm.salvarItem = salvarItem;
        vm.novoItem = novoItem;

        ClienteService.findAllOver()
            .then(function (data) {
                vm.clientes = data;
            });

        ProdutoService.findAllOver()
            .then(function (data) {
                vm.produtos = data;
            });

        if ($stateParams.id) {
            AtendimentoService.findById($stateParams.id)
                .then(function (data) {
                    vm.registro = data;
                    vm.registro.itens = vm.registro.itens || [];
                    vm.titulo = 'Editando Atendimento';
                });
        }

        function salvar() {
            if (!vm.registro.id) {
                AtendimentoService.insert(vm.registro)
                    .then(function (dado) {
                        DialogBuilder.message('Registro incluído com sucesso!');
                        $state.go('atendimentosList');
                    })
                    .catch(function (error) {
                        vm.error = error.data;
                    });
            } else {
                AtendimentoService.update(vm.registro)
                    .then(function (dado) {
                        DialogBuilder.message('Registro alterado com sucesso!');
                        $state.go('atendimentosList');
                    })
                    .catch(function (error) {
                        vm.error = error.data;
                    });
            }
        }

        function novoItem() {
            vm.itemOriginal = null;
            vm.registroItem = {};
        }

        function editarItem(selecionado) {
            vm.itemOriginal = selecionado;
            angular.copy(selecionado, vm.registroItem);
        }

        function salvarItem() {
            // calcula o total do item
            vm.registroItem.valorTotal = vm.registroItem.quantidade * vm.registroItem.valorUnitario;

            var index = vm.registro.itens.indexOf(vm.itemOriginal);
            if (index != -1) {
                vm.registro.itens[index] = vm.registroItem;
            } else {
                vm.registro.itens.push(vm.registroItem);
            }
            vm.itemOriginal = null;
            vm.registroItem = {};

            // calcula o total do atendimento
            vm.registro.valorTotal = 0;
            vm.registro.itens.forEach(function (item) {
                vm.registro.valorTotal += item.valorTotal;
            });
        }

        function excluirItem(selecionado) {
            var index = vm.registro.itens.indexOf(selecionado);
            vm.registro.itens.splice(index, 1);

            // calcula o total do atendimento
            vm.registro.valorTotal = 0;
            vm.registro.itens.forEach(function (item) {
                vm.registro.valorTotal += item.valorTotal;
            });
        }

    }
})();