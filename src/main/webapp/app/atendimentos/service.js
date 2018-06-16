(function () {
    'use strict'

    angular.module('app')
        .service('AtendimentoService', AtendimentoService);

    AtendimentoService.$inject = ['$http'];

    function AtendimentoService($http) {

        function findAll(filtro, page) {
            return $http.get('/api/atendimentos?page=' + page.number +
                '&size=' + page.size + '&filterField=cliente.nome&filterValue=' + filtro)
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
            return $http.get('/api/atendimentos/' + id)
                .then(function (response) {
                    return response.data;
                });
        }

        function insert(registro) {
            return $http.post('/api/atendimentos', registro)
                .then(function (response) {
                    return response.data;
                });
        }

        function update(registro) {
            return $http.put('/api/atendimentos/' + registro.id, registro)
                .then(function (response) {
                    return response.data;
                });
        }

        function remove(id) {
            return $http.delete('/api/atendimentos/' + id)
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