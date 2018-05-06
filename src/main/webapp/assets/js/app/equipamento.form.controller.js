(function () {
  'use strict'

  angular.module('app')
    .controller('EquipamentoFormController', EquipamentoFormController);

  EquipamentoFormController.$inject = ['EquipamentoService'];

  function EquipamentoFormController(EquipamentoService) {
    var vm = this;

    vm.registro = {}
    vm.salvar = salvar;

    function salvar() {
      EquipamentoService.insert(vm.registro)
        .then(function (dado) {
          alert('Equipamento ' + dado.descricao + ' inserido com sucesso!!!');
          vm.registro = {};
        });
    }
  }
})();