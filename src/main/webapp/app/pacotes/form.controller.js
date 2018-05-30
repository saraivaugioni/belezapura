(function () {
  'use strict'

  angular.module('app')
    .controller('PacoteFormController', PacoteFormController);

  PacoteFormController.$inject = ['PacoteService', '$state', '$stateParams', 'DialogBuilder'];

  function PacoteFormController(PacoteService, $state, $stateParams, DialogBuilder) {
    var vm = this;

    vm.registro = {}
    vm.error = {};
    vm.salvar = salvar;

    if ($stateParams.id) {
      PacoteService.findById($stateParams.id)
        .then(function (data) {
          vm.registro = data;
        });
    }

    function salvar() {
      if (!vm.registro.id) {
        PacoteService.insert(vm.registro)
          .then(function (dado) {
            DialogBuilder.message('Registro inserido com sucesso!');
            $state.go("^");
          })
          .catch(function (error) {
            vm.error = error.data;
          });
      } else {
        PacoteService.update(vm.registro)
          .then(function (dado) {
            DialogBuilder.message('Registro alterado com sucesso!');
            $state.go("^");
          })
          .catch(function (error) {
            vm.error = error.data;
          });
      }
    }
  }

})();