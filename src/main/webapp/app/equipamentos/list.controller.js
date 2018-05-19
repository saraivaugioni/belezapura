(function () {
  'use strict'

  angular.module('app')
    .controller('EquipamentoListController', EquipamentoListController);

  EquipamentoListController.$inject = ['EquipamentoService'];

  function EquipamentoListController(EquipamentoService) {

    var vm = this;
    vm.registros = [];
    vm.remove = remove;

    function load() {
      EquipamentoService.findAll()
        .then(function (dados) {
          vm.registros = dados;
        });
    }

    function remove(id) {
      if (confirm('Deseja realmente excluir o equipamento?')) {
        EquipamentoService.remove(id)
          .then(function () {
            alert('equipamento excluído com sucesso!!!');
            load();
          });
      }
    }
    load();
  }
})();