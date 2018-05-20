(function () {
  'use strict'

  angular.module('app')
    .controller('EquipamentoFormController', EquipamentoFormController);

  EquipamentoFormController.$inject = ['EquipamentoService', 'DialogBuilder'];

  function EquipamentoFormController(EquipamentoService, DialogBuilder) {
    var vm = this;

    vm.registro = {}
    vm.salvar = salvar;

    function salvar() {
      EquipamentoService.insert(vm.registro)
        .then(function (dado) {
          DialogBuilder.message('Equipamento ' + dado.descricao + ' inserido com sucesso!!!');
          vm.registro = {};
        });
    }
  }
})();