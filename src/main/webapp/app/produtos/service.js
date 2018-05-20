(function () {
  'use strict'

  angular.module('app')
    .factory('ProdutoService', ProdutoService);

  ProdutoService.$inject = ['$http'];

  function ProdutoService($http) {

    function findAll(filtro, page) {
      return $http.get('/api/produtos?filterField=descricao&filterValue=' + filtro)
        .then(function (response) {
          return {
            registros: response.data,
            total: response.headers['X-Total-Lenght'],
            pages: ['1', '2'],
            currentPage: '1'
          }
        });
    }

    function findById(id) {
      return $http.get('/api/produtos/' + id)
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

    function update(registro) {
      return $http.put('/api/produtos/' + registro.id, registro)
        .then(function (response) {
          return response.data;
        });
    }

    function remove(id) {
      return $http.delete('/api/produtos/' + id)
        .then(function (response) {
          return response.data;
        });
    }

    return {
      findAll: findAll,
      findById: findById,
      insert: insert,
      update: update,
      remove: remove
    }
  }

})();