void main() {
  // Variável que armazena números inteiros
  int idade = 33;
  print("Idade: $idade");
 
  // Variável que armazena números decimais
  double raio = 10.25;
  print("Raio: $raio");
  
  // Variável que armazena caracteres e textos
  String nome = "Kleber";
  print("Ola $nome, seja bem vindo!");
  
  // Variável que armazena verdadeiro ou false
  bool ligado = true;
  print("Ligado: $ligado");
  
  // Variável que guarda uma lista genérica
  List numerosGenericos = [10, "Kleber", true, 20];
  print(numerosGenericos);
  
  // Variável que guarda uma lista de números inteiros
  List<int> numerosInteiros = [10, 20, 30, 40];
  print(numerosInteiros);
  
  // Variável que guarda um dicionário com chave e valor em formato texto
  Map<String, String> nome_sobrenome = {"Kleber": "Andrade", "Claudia": "Trevisan"};
  
  // Variável sem tipo definido, seu tipo é igual ao tipo do primeiro valor que recebe
  var sobrenome = nome_sobrenome[nome];
  print("O sobrenome do $nome é $sobrenome");
  
  // Constantes (valores imutáveis)
  const double pi = 3.1416;
  print("O valor de PI é $pi");
  
  // Variável dinâmica (neste momento é do tipo inteiro pois recebeu o valor 10)
  dynamic x = 10;
  print(x);
  
  // O tipo da variável pode ser alterada em tempo de execução (agora é um texto)
  x = "Curso";
  print(x);
}