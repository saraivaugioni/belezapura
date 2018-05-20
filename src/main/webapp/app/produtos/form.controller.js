(function () {
  'use strict'

  angular.module('app')
    .controller('ProdutoFormController', ProdutoFormController);

  ProdutoFormController.$inject = ['ProdutoService', 'DialogBuilder'];

  function ProdutoFormController(ProdutoService, DialogBuilder) {
    var vm = this;

    vm.registro = {}
    vm.salvar = salvar;

    function salvar() {
      ProdutoService.insert(vm.registro)
        .then(function (dado) {
          DialogBuilder.message('Produto ' + dado.descricao + ' inserido com sucesso!!!');
          vm.registro = {};
        });
    }
  }

})();