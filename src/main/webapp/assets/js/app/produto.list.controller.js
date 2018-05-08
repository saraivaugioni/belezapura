(function () {
  'use strict'

  angular.module('app')
    .controller('ProdutoListController', ProdutoListController);

  ProdutoListController.$inject = ['ProdutoService'];

  function ProdutoListController(ProdutoService) {

    var vm = this;
    vm.registros = [];
    vm.remove = remove;

    function load() {
      ProdutoService.findAll()
        .then(function (dados) {
          vm.registros = dados;
        });
    }

    function remove(id) {
      if (confirm('Deseja realmente excluir o produto?')) {
        ProdutoService.remove(id)
          .then(function () {
            alert('produto excluído com sucesso!!!');
            load();
          });
      }
    }
    load();
  }
})();