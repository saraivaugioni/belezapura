(function () {
  'use strict'

  angular.module('app')
    .controller('ProdutoFormController', ProdutoFormController);

  ProdutoFormController.$inject = ['ProdutoService', '$state', '$stateParams', 'DialogBuilder'];

  function ProdutoFormController(ProdutoService, $state, $stateParams, DialogBuilder) {
    var vm = this;

    vm.registro = {}
    vm.error = {};
    vm.salvar = salvar;

    if ($stateParams.id) {
      ProdutoService.findById($stateParams.id)
        .then(function (data) {
          vm.registro = data;
        });
    }

    function salvar() {
      if (!vm.registro.id) {
        ProdutoService.insert(vm.registro)
          .then(function (dado) {
            DialogBuilder.message('Registro inserido com sucesso!');
            $state.go("Produtos");
          })
          .catch(function (error) {
            vm.error = error.data;
          });
      } else {
        ProdutoService.update(vm.registro)
          .then(function (dado) {
            DialogBuilder.message('Registro alterado com sucesso!');
            $state.go("Produtos");
          })
          .catch(function (error) {
            vm.error = error.data;
          });
      }
    }
  }

})();