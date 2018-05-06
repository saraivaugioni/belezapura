(function () {
  'use strict'

  angular.module('app')
    .factory('PacoteService', PacoteService);

    PacoteService.$inject = ['$http'];

  function PacoteService($http) {

    function findAll() {
      return $http.get('/api/pacotes')
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

    function remove(id) {
      return $http.delete('/api/pacotes/' + id);
    }

    return {
      findAll: findAll,
      insert: insert,
      remove: remove
    };
  }
})();