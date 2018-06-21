(function () {
  'use strict'

  angular.module('app')
    .controller('ServicoFormController', ServicoFormController);

  ServicoFormController.$inject = ['ServicoService', '$state', '$stateParams', 'DialogBuilder'];

  function ServicoFormController(ServicoService, $state, $stateParams, DialogBuilder) {
    var vm = this;

    vm.registro = {}
    vm.error = {};
    vm.titulo = 'Novo Serviço';
    vm.salvar = salvar;

    if ($stateParams.id) {
      ServicoService.findById($stateParams.id)
        .then(function (data) {
          vm.registro = data;
          vm.titulo = 'Editando Serviço';
        });
    }

    function salvar() {
      if (!vm.registro.id) {
        ServicoService.insert(vm.registro)
          .then(function (dado) {
            DialogBuilder.message('Registro inserido com sucesso!');
            $state.go("Servicos");
          })
          .catch(function (error) {
            vm.error = error.data;
          });
      } else {
        ServicoService.update(vm.registro)
          .then(function (dado) {
            DialogBuilder.message('Registro alterado com sucesso!');
            $state.go("Servicos");
          })
          .catch(function (error) {
            vm.error = error.data;
          });
      }
    }
  }

})();