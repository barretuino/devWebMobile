/**
 * Exemplo de Declaração de Variáveis em Dart
 * Prof. Ms. Paulo Barreto
 * Data 22/04/2021
 */
void main() {
  // Variável que armazena números inteiros
  int idade = 33;
  String nome = "Paulo";
  bool status = true;
  //Técnica do ternário '?'
  String estado = (status ? "Ativo" : "Inativo");

  // Listas são coleções
  // Variável que guarda uma lista genérica
  List numerosGenericos = [10, "Kleber", true, 20, 20.5];
  print(numerosGenericos);

  // Variável que guarda uma lista de números inteiros
  List<int> numerosInteiros = [10, 20, 30, 40];
  print(numerosInteiros);

  // Variável que guarda um dicionário com chave e valor em formato texto. Map<KEY, VALUE>
  Map<String, String> nome_sobrenome = {
    "Kleber": "Andrade",
    "Claudia": "Trevisan",
    "Paulo": "Barreto"
  };
  print(nome_sobrenome);
  // Variável sem tipo definido, seu tipo é igual ao tipo do primeiro valor que recebe
  var sobrenome = nome_sobrenome[nome];
  print("O sobrenome do $nome é $sobrenome");

  //Comando de Saída, em que invocamos o conteúdo da variável
  print("Idade: $idade Nome: $nome");
  print("Status: $estado");

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
