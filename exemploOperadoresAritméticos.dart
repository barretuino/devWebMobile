/**
 * Exemplo de Operadores Aritméticos em Dart
 * Prof. Ms. Paulo Barreto
 * Data 22/04/2021
 */
void main() {
  
  double valorA = 10, valorB = 3.99999;
  
  print("ValorA $valorA ValorB $valorB");
  
  double resultado = valorA / valorB;
  print("Resultado $resultado");
  
  String texto = valorA.toString() + " Texto";
  print("Concatenação $texto");
  
  int valorC = valorB.round();
  print("Arredondamento $valorC");
}
