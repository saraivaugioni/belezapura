(function () {
  'use strict'

  angular.module('app')
    .controller('ClienteFormController', ClienteFormController);

  ClienteFormController.$inject = ['ClienteService', 'DialogBuilder'];

  function ClienteFormController(ClienteService, DialogBuilder) {
    var vm = this;
    vm.registro = {}
    vm.salvar = salvar;

    function salvar() {
      ClienteService.insert(vm.registro)
        .then(function (dado) {
          DialogBuilder.message('Cliente ' + dado.nome + ' inserido com sucesso!!!');
          vm.registro = {};
        });
    }
  }

})();