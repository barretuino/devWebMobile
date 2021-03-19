/**
    Uso de forEach
    Autor: Paulo Barreto
    Data: 18/03/2021
**/
var Pessoa = /** @class */ (function () {
    function Pessoa(nome) {
        this.nome = nome;
    }
    Pessoa.prototype.bemVindo = function () {
        return "Olá Boa Noite, " + this.nome;
    };
    return Pessoa;
}());

var gustavo = new Pessoa("Gustavo");
var cristiano = new Pessoa("Cristiano");
var joao = new Pessoa("João Guilherme");

var pessoas = new Array();
pessoas.push(gustavo);
pessoas.push(cristiano);
pessoas.push(joao);

//Função de Looping
pessoas.forEach(function (p) {
    return console.log(p.bemVindo());
});
