/**
 * Created by Basis Tecnologia on 25/04/2017.
 */
(function(){
    'use strict';
    angular.module('gestaoRiscosApp').factory('ValidacaoService', ['$http', '$q', service]);

    function service($http, $q){
        var baseUrl = '/gestaoriscos/api/processos';

        var getDecisoes = function(){
            return $http.get(baseUrl + "/decisoes");
        };

        var findBy = function(registroId){
            return $http.get(baseUrl + "/" + registroId);
        };

        var update = function(registro){
            return $http.put(baseUrl + "/validar-processo", registro);
        };

        var getUsuarioLogado = function(){
            return $http.get("gestaoriscos/api/usuarios/usuario-logado");

            // var data = {};
            // data.data = {cpf: "61914509153"};
            // var deferred = $q.defer();
            // deferred.resolve(data);
            // return deferred.promise;
        };

        var getPermissao = function(cpf){
            return $http.get(baseUrl + "/permissao?cpf=" + cpf);
        };

        return {
            getDecisoes: getDecisoes,
            findBy: findBy,
            update: update,
            getUsuarioLogado: getUsuarioLogado,
            getPermissao: getPermissao

        };
    }
})();
