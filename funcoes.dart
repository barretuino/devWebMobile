// Função sem parâmetros
void escreverBemVindo(){
  print("Seja bem-vindo!");
}

// Quando a função só tem um comando interno, você pode usar desta forma
void escreverDesculpas() => print("Desculpa, encontramos um erro.");

// Função com passagem de parâmetros (podem ter quantos parâmetros quiser)
void calcularSoma(double a, double b){ 
  double resultado = a + b;
  print(resultado);
}

// Função que retorna uma variável do tipo double
double calcularSubtracao(double a, double b){
  double resultado = a - b;
  return resultado; 
}

// Exemplo reduzido de uma função que retorna valor
double calcularAreaCirculo(double raio) => 3.14 * raio * raio;

// Função com parâmetros opcionais (utiliza-se os parâmetros dentro de chaves {})
void exibirNomeCursoIdade(String nome, {int idade, String curso}) {
  if(idade != null && curso != null) {
    print("$nome tem $idade anos e faz o curso de $curso.");  
  } else if(idade == null && curso != null) {
    print("$nome faz o curso de $curso.");
  } else if(idade != null && curso == null) {
    print("$nome tem $idade anos."); 
  } else {
    print("Ola $nome");
  }
}

// Passar funções como parâmetros
void calcular(double a, double b, Function funcao){
  funcao(a, b);
}

// Função principal
void main() {
  // Executando a função escreverBemVindo()
  escreverBemVindo();
  
  // Executando a função escreverDesculpas()
  escreverDesculpas();
  
  // Executando a função calcularSoma(a, b)
  calcularSoma(10, 20);
  
  // Executando a função calcularSubtracao(a, b)
  print(calcularSubtracao(10, 20));
  
  // Executando a função calcularAreaCirculo(raio)
  print(calcularAreaCirculo(10));
  
  // Execuntado a função exibirNomeCursoIdade(nome)
  exibirNomeCursoIdade("Kleber");
  
  // Execuntado a função exibirNomeCursoIdade(nome, idade)
  exibirNomeCursoIdade("Kleber", idade: 33);
  
  // Execuntado a função exibirNomeCursoIdade(nome, curso)
  exibirNomeCursoIdade("Kleber", curso: "Ciência da Computação");
  
  // Execuntado a função exibirNomeCursoIdade(nome, idade, curso)
  exibirNomeCursoIdade("Kleber", idade: 33, curso: "Ciência da Computação");
  
  // Executando a função calcular(a, b, função), como função foi passada a calcularSoma(a,b)
  calcular(30, 20, calcularSoma);
  
  // Executando a função calcular(a, b, função), como função foi criado uma função anônima(a,b)
  calcular(30, 20, (a, b){
    var resultado = a * b;
    print(resultado);
  });
}