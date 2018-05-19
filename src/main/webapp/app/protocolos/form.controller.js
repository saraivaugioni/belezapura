(function () {
  'use strict'

  angular.module('app')
    .controller('ProtocoloFormController', ProtocoloFormController);

  ProtocoloFormController.$inject = ['ProtocoloService'];

  function ProtocoloFormController(ProtocoloService) {
    var vm = this;

    vm.registro = {}
    vm.salvar = salvar;

    function salvar() {
      ProtocoloService.insert(vm.registro)
        .then(function (dado) {
          alert('Protocolo ' + dado.descricao + ' inserido com sucesso!!!');
          vm.registro = {};
        });
    }
  }
})();