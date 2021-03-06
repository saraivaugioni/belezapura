(function () {
  'use strict'

  angular.module('app')
    .controller('ProtocoloFormController', ProtocoloFormController);

  ProtocoloFormController.$inject = ['ProtocoloService', '$state', '$stateParams', 'DialogBuilder'];

  function ProtocoloFormController(ProtocoloService, $state, $stateParams, DialogBuilder) {
    var vm = this;

    vm.registro = {}
    vm.error = {};
    vm.titulo = 'Novo Protocolo';
    vm.salvar = salvar;

    if ($stateParams.id) {
      ProtocoloService.findById($stateParams.id)
        .then(function (data) {
          vm.registro = data;
          vm.titulo = 'Editando Protocolo';
        });
    }

    function salvar() {
      if (!vm.registro.id) {
        ProtocoloService.insert(vm.registro)
          .then(function (dado) {
            DialogBuilder.message('Registro inserido com sucesso!');
            $state.go("Protocolos");
          })
          .catch(function (error) {
            vm.error = error.data;
          });
      } else {
        ProtocoloService.update(vm.registro)
          .then(function (dado) {
            DialogBuilder.message('Registro alterado com sucesso!');
            $state.go("Protocolos");
          })
          .catch(function (error) {
            vm.error = error.data;
          });
      }
    }
  }

})();