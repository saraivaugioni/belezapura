(function () {
  'use strict'

  angular.module('app')
    .factory('EquipamentoService', EquipamentoService);

  EquipamentoService.$inject = ['$http'];

  function EquipamentoService($http) {

    function findAll(filtro, page) {
      return $http.get('/api/equipamentos?page=' + page.number
        + '&size=' + page.size + '&filterField=descricao&filterValue=' + filtro)
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
      return $http.get('/api/equipamentos/' + id)
        .then(function (response) {
          var formatDataAquisicao = response.data.dataAquisicao;
          response.data.dataAquisicao = formatDataAquisicao.substring(8, 10) + formatDataAquisicao.substring(5, 7) + formatDataAquisicao.substring(0, 4);
          return response.data;
        });
    }

    function insert(registro) {
      return $http.post('/api/equipamentos', registro)
        .then(function (response) {
          return response.data;
        });
    }

    function update(registro) {
      return $http.put('/api/equipamentos/' + registro.id, registro)
        .then(function (response) {
          return response.data;
        });
    }

    function remove(id) {
      return $http.delete('/api/equipamentos/' + id)
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