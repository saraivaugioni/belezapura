(function () {
  'use strict'

  angular.module('app')
    .controller('PacoteFormController', PacoteFormController);

    PacoteFormController.$inject = ['PacoteService'];

  function PacoteFormController(PacoteService) {
    var vm = this;

    vm.registro = {}
    vm.salvar = salvar;

    function salvar() {
      PacoteService.insert(vm.registro)
        .then(function (dado) {
          alert('Pacote ' + dado.descricao + ' inserido com sucesso!!!');
          vm.registro = {};
        });
    }
  }
})();