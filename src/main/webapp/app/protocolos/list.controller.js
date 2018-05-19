(function () {
  'use strict'

  angular.module('app')
    .controller('ProtocoloListController', ProtocoloListController);

  ProtocoloListController.$inject = ['ProtocoloService'];

  function ProtocoloListController(ProtocoloService) {

    var vm = this;
    vm.registros = [];
    vm.remove = remove;

    function load() {
      ProtocoloService.findAll()
        .then(function (dados) {
          vm.registros = dados;
        });
    }

    function remove(id) {
      if (confirm('Deseja realmente excluir o protocolo?')) {
        ProtocoloService.remove(id)
          .then(function () {
            alert('protocolo excluído com sucesso!!!');
            load();
          });
      }
    }
    load();
  }
})();