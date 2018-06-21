(function () {
  'use strict'

  angular.module('app')
    .controller('EquipamentoFormController', EquipamentoFormController);

  EquipamentoFormController.$inject = ['EquipamentoService', '$state', '$stateParams', 'DialogBuilder'];

  function EquipamentoFormController(EquipamentoService, $state, $stateParams, DialogBuilder) {
    var vm = this;

    vm.registro = {}
    vm.error = {};
    vm.titulo = 'Novo Equipamento';
    vm.salvar = salvar;

    if ($stateParams.id) {
      EquipamentoService.findById($stateParams.id)
        .then(function (data) {
          vm.registro = data;
          vm.titulo = 'Editando Equipamento';
        });
    }

    function salvar() {
      if (!vm.registro.id) {
        EquipamentoService.insert(vm.registro)
          .then(function (dado) {
            DialogBuilder.message('Registro inserido com sucesso!');
            $state.go("Equipamentos");
          })
          .catch(function (error) {
            vm.error = error.data;
          });
      } else {
        EquipamentoService.update(vm.registro)
          .then(function (dado) {
            DialogBuilder.message('Registro alterado com sucesso!');
            $state.go("Equipamentos");
          })
          .catch(function (error) {
            vm.error = error.data;
          });
      }
    }
  }
})();