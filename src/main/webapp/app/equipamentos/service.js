(function () {
  'use strict'

  angular.module('app')
    .factory('EquipamentoService', EquipamentoService);

  EquipamentoService.$inject = ['$http'];

  function EquipamentoService($http) {

    function findAll() {
      return $http.get('/api/equipamentos')
        .then(function (response) {
          return response.data;
        });
    }

    function insert(registro) {
      return $http.post('/api/equipamentos', registro)
        .then(function (response) {
          return response.data;
        });
    }

    function remove(id) {
      return $http.delete('/api/equipamentos/' + id);
    }

    return {
      findAll: findAll,
      insert: insert,
      remove: remove
    };
  }
})();