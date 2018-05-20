(function () {
  'use strict'

  angular.module('app')
    .controller('PacoteFormController', PacoteFormController);

  PacoteFormController.$inject = ['PacoteService', 'DialogBuilder'];

  function PacoteFormController(PacoteService, DialogBuilder) {
    var vm = this;

    vm.registro = {}
    vm.salvar = salvar;

    function salvar() {
      PacoteService.insert(vm.registro)
        .then(function (dado) {
          DialogBuilder.message('Pacote ' + dado.descricao + ' inserido com sucesso!!!');
          vm.registro = {};
        });
    }
  }

})();