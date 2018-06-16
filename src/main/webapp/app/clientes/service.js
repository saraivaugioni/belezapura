(function () {
  'use strict'

  angular.module('app')
    .factory('ClienteService', ClienteService);

  ClienteService.$inject = ['$http'];

  function ClienteService($http) {

    function findAllOver() {
      return $http.get('/api/clientes/all?order=nome')
        .then(function (response) {
          return response.data;
        });
    }

    function findAll(filtro, page) {
      return $http.get('/api/clientes?page=' + page.number
        + '&size=' + page.size + '&filterField=nome&filterValue=' + filtro)
        .then(function (response) {
          return {
            registros: response.data,
            total: response.headers('X-Total-Lenght'),
            pageSize: response.headers('X-Page-Size'),
            pages: _calcPage(response.headers('X-Total-Lenght'), response.headers('X-Page-Size')),
            currentPage: response.headers('X-Current-Page')
          }
        });
    }

    function _calcPage(totalRegistros, tamanhoPagina) {
      var pages = [];
      var num = totalRegistros / tamanhoPagina;
      var actual = 1;

      while (num > 0) {
        pages.push(actual++)
        num -= 1;
      }
      return pages;
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
      findAllOver: findAllOver,
      findById: findById,
      insert: insert,
      update: update,
      remove: remove
    }
  }

})();