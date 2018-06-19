(function () {
    angular.module('app')
        .service('DialogBuilder', DialogBuilder);

    function DialogBuilder() {
        return {
            confirm: swal.mixin({
                type: 'question',
                showCancelButton: true,
                confirmButtonText: 'Sim',
                cancelButtonText: 'Não',
                confirmButtonClass: 'btn btn-success btn-lg mx-2',
                cancelButtonClass: 'btn btn-danger btn-lg mx-2',
                buttonsStyling: false
            }),
            message: swal.mixin({
                position: 'center',
                type: 'success',
                showConfirmButton: false,
                timer: 1500
            })
        }
    }
})();