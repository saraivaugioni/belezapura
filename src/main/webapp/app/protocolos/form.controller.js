(function () {
  'use strict'

  angular.module('app')
    .controller('ProtocoloFormController', ProtocoloFormController);

  ProtocoloFormController.$inject = ['ProtocoloService', 'DialogBuilder'];

  function ProtocoloFormController(ProtocoloService, DialogBuilder) {
    var vm = this;

    vm.registro = {}
    vm.salvar = salvar;

    function salvar() {
      ProtocoloService.insert(vm.registro)
        .then(function (dado) {
          DialogBuilder.message('Protocolo ' + dado.descricao + ' inserido com sucesso!!!');
          vm.registro = {};
        });
    }
  }

})();