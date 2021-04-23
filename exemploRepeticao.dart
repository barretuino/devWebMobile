/**
 * Exemplo de Fluxo de Controle em Dart
 * Prof. Ms. Paulo Barreto
 * Data 22/04/2021
 */
void main() {
  //Repetição Simples
  for(int i=0; i<10; i++){
    print(i);
  }
  
  //Repetição Condicional
  int contador = 10;
  while(contador > 0){
    print(contador--);
  }
  
  do{
    print(contador++);
  }while(contador < 10);
}
