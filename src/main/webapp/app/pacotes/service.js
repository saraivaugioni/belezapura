(function () {
  'use strict'

  angular.module('app')
    .factory('PacoteService', PacoteService);

  PacoteService.$inject = ['$http'];

  function PacoteService($http) {

    function findAll(filtro, page) {
      return $http.get('/api/pacotes?filterField=descricao&filterValue=' + filtro)
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
      return $http.get('/api/pacotes/' + id)
        .then(function (response) {
          return response.data;
        });
    }

    function insert(registro) {
      return $http.post('/api/pacotes', registro)
        .then(function (response) {
          return response.data;
        });
    }

    function update(registro) {
      return $http.put('/api/pacotes/' + registro.id, registro)
        .then(function (response) {
          return response.data;
        });
    }

    function remove(id) {
      return $http.delete('/api/pacotes/' + id)
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