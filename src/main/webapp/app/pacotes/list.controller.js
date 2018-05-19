(function () {
  'use strict'

  angular.module('app')
    .controller('PacoteListController', PacoteListController);

    PacoteListController.$inject = ['PacoteService'];

  function PacoteListController(PacoteService) {

    var vm = this;
    vm.registros = [];
    vm.remove = remove;

    function load() {
      PacoteService.findAll()
        .then(function (dados) {
          vm.registros = dados;
        });
    }

    function remove(id) {
      if (confirm('Deseja realmente excluir o pacote?')) {
        PacoteService.remove(id)
          .then(function () {
            alert('pacote excluído com sucesso!!!');
            load();
          });
      }
    }
    load();
  }
})();