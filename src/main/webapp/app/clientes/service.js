(function () {
  'use strict'

  angular.module('app')
    .factory('ClienteService', ClienteService);

  ClienteService.$inject = ['$http'];

  function ClienteService($http) {

    function findAll(filtro, page) {
      return $http.get('/api/clientes?filterField=nome&filterValue=' + filtro)
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
      return $http.get('/api/clientes/' + id)
        .then(function (response) {
          return response.data;
        });
    }

    function insert(registro) {
      return $http.post('/api/clientes', registro)
        .then(function (response) {
          return response.data;
        });
    }

    function update(registro) {
      return $http.put('/api/clientes/' + registro.id, registro)
        .then(function (response) {
          return response.data;
        });
    }

    function remove(id) {
      return $http.delete('/api/clientes/' + id)
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