void main(){ 
  // Repetição de 0 a 5 (conhecemos o número inicial e final)
  // FOR (INICIO; CONDIÇÃO; INCREMENTO)
  for(int i = 0; i < 5; i++){
    print(i);
  }
  
  // Repetição de 0 a 5
  // INICIO; WHILE (CONDICAO){ INCREMENTO; }
  // Teste condicional no início
  int j = 0;      // Início
  while(j < 5){   // Condição
    print(j); 
    j++;          // Incremento
  }
  
  // Repetição de 0 a 5
  // INICIO; DO { INCREMENTO; } WHILE(CONDICAO);
  // Teste condicional no final
  int k = 0;      // Início
  do {   
    print(k); 
    k++;          // Incremento
  } while(k < 5); // Condição
  
  
  // Conjunto de números (Lista)
  List numeros = [0, 1, 2, 3, 4];
  
  // FOREACH
  // FOR (VARIAVEL DENTRO DO CONJUNTO)
  for (int numero in numeros){
    print(numero);
  }
}