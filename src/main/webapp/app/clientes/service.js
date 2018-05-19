(function(){
  'use strict'

  angular.module('app')
    .factory('ClienteService', ClienteService);

  ClienteService.$inject = ['$http'];

  function ClienteService($http) {
    
    function findAll() {
      return $http.get('/api/clientes')
        .then(function (response) {
          return response.data;
        });
    }

    function insert(registro) {
      return $http.post('/api/clientes', registro)
        .then(function(response) {
          return response.data;
        });
    }

    function remove(id) {
      return $http.delete('/api/clientes/' + id);
    }

    return {
      findAll: findAll,
      insert: insert,
      remove: remove
    };
  }



})();