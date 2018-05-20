(function () {
  'use strict'

  angular.module('app')
    .controller('ProtocoloListController', ProtocoloListController);

  ProtocoloListController.$inject = ['ProtocoloService', 'DialogBuilder'];

  function ProtocoloListController(ProtocoloService, DialogBuilder) {

    var vm = this;
    vm.data = {};
    vm.filtro = '';

    vm.atualizar = load;

    vm.resetFiltro = function () {
      vm.filtro = '';
      load();
    }

    function load() {
      ProtocoloService.findAll(vm.filtro)
        .then(function (dados) {
          vm.data = dados
        });
    }

    vm.excluir = function (item) {
      DialogBuilder.confirm('Tem certeza que deseja remover o registro?')
        .then(function (result) {
          if (result.value) {
            ProtocoloService.remove(item.id)
              .then(function () {
                load();
                DialogBuilder.message('Registro excluído com sucesso!');
              });
          } else {
            DialogBuilder.message({
              title: 'Exclusão cancelada pelo usuário!',
              type: 'error'
            });
          }
        });
    };
    load();
  }

})();