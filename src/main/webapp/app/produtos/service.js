(function () {
  'use strict'

  angular.module('app')
    .factory('ProdutoService', ProdutoService);

  ProdutoService.$inject = ['$http'];

  function ProdutoService($http) {

    function findAll() {
      return $http.get('/api/produtos')
        .then(function (response) {
          return response.data;
        });
    }

    function insert(registro) {
      return $http.post('/api/produtos', registro)
        .then(function (response) {
          return response.data;
        });
    }

    function remove(id) {
      return $http.delete('/api/produtos/' + id);
    }

    return {
      findAll: findAll,
      insert: insert,
      remove: remove
    };
  }
})();