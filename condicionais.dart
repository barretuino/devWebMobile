void main(){ 
  double media = 4.9;

  // IF (condiçao verdadeira) / ELSE 
  if (media < 6.0){
    print("Reprovado!");
  } else {
    print("Aprovado!");
  }

  /* Podemos também utiliar IF TERNÁRIO
  * CONDIÇÃO ? RETORNO VERDADEIRO : RETORNO FALSO
  */
  print(media < 6.0 ? "Reprovado!" : "Aprovado"); 
  
  /* Toda variável declarada e que não recebe valor, automáticamente é nula
   * VARIAVEL ?? RETORNO CASO SEJA NULO
   */
  String linguagem;
  print(linguagem ?? "Não Informado");
  
  linguagem = "Dart";
  print(linguagem ?? "Não Informado");

  /* SWITCH / CASE / DEFAULT 
   * Utilizado geralmente quando temos constantes
   * Cada cláusula de case não vazio termina com uma instrução break, como regra.
   */
  switch(linguagem){
    case "Dart":
      print("É Dart!");
      break;
    case "Java":
      print("É Java!");
      break;
    case "C#":
      print("É C#!");
      break;
    default:
      print("Não sabe no que programa");
  }
}