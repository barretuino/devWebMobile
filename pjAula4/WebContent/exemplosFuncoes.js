var contaCliques = 0;
function bemVindo(){
	alert("Seja Bem Vindo a nossa aula. Clicou " + contaCliques++);
}

function imprimir(texto){
	alert("Este foi o texto " + texto);
	//....;
	//....;
}

function parImpar(valor){
	if(valor%2 == 0){
		return "Par";
	}else{
		return "Impar";
	}
}

//Exemplo de Ternário ?
//<avaliação> ? True : False
function otimizada(valor){
	return valor%2 == 0 ? "Par" : "Impar";
}

var valor = 17;
console.log('O valor é ' + valor + ' ele é ' + otimizada(valor));

//Similar a grande maioria das linguagens
//Estrutura de Repetição Simples
/*for(var i=0; i<=10; i++){
	imprimir(i);
}*/



while(valor > 10){
	console.log("Maior que 10 " + new Date());
	valor--;
}