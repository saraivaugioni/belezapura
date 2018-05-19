(function () {
  'use strict'

  angular.module('app')
    .factory('ProtocoloService', ProtocoloService);

  ProtocoloService.$inject = ['$http'];

  function ProtocoloService($http) {

    function findAll() {
      return $http.get('/api/protocolos')
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

    function remove(id) {
      return $http.delete('/api/protocolos/' + id);
    }

    return {
      findAll: findAll,
      insert: insert,
      remove: remove
    };
  }
})();