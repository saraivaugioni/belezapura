(function(){
  'use strict'

  angular.module('app')
    .controller('ClienteListController', ClienteListController);
  
  ClienteListController.$inject = ['ClienteService'];
  
  function ClienteListController(ClienteService) {
  
      var vm = this;
      vm.registros = [];
      vm.remove = remove;
  
      function load() {
        ClienteService.findAll()
          .then(function (dados) {
            vm.registros = dados;
          });
      }

      function remove(id) {
        if (confirm('Deseja realmente excluir o cliente?')) {
          ClienteService.remove(id)
          .then(function() {
            alert('Cliente excluído com sucesso!!!');
            load();
          });
        }
      }
      load();
  }

})();