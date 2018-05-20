(function () {
  'use strict'

  angular.module('app')
    .factory('ProtocoloService', ProtocoloService);

  ProtocoloService.$inject = ['$http'];

  function ProtocoloService($http) {

    function findAll(filtro, page) {
      return $http.get('/api/protocolos?filterField=nome&filterValue=' + filtro)
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
      return $http.get('/api/protocolos/' + id)
        .then(function (response) {
          return response.data;
        });
    }

    function insert(registro) {
      return $http.post('/api/protocolos', registro)
        .then(function (response) {
          return response.data;
        });
    }

    function update(registro) {
      return $http.put('/api/protocolos/' + registro.id, registro)
        .then(function (response) {
          return response.data;
        });
    }

    function remove(id) {
      return $http.delete('/api/protocolos/' + id)
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