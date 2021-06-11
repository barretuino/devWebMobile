//Declaração de variavel
int val;

//Função parametrização
void setup()
{
  Serial.begin(9600);
  pinMode(2, OUTPUT);  //Definição do pino de entrada / saída   
  pinMode(3, OUTPUT);
  pinMode(4, OUTPUT);  
  pinMode(5, OUTPUT);  
  menu(); //Função especifica (personalizada)
}

void loop()
{
  if (Serial.available()) { //Avalia ação da serial
    val = (int)Serial.read(); //Leitura da porta serial
    //Relé 1
    if (val == 49) { //Digitou 1?
      digitalWrite(2, HIGH);      
    } 
    if (val == 50) {  //Digitou 2?
      digitalWrite(2, LOW);
    }
    //Relé 2
    if (val == 51) { //Digitou 3?
      digitalWrite(3, HIGH);
    } 
    if (val == 52) { //Digitou 4?
      digitalWrite(3, LOW);
    }
    //Relé 3
    if (val == 53) { //Digitou 5?
      digitalWrite(4, HIGH);
    } 
    if (val == 54) { //Digitou 6?
      digitalWrite(4, LOW);
    }
    //Relé 4
    if (val == 55) { //Digitou 7?
      digitalWrite(5, HIGH);
    } 
    if (val == 56) { //Digitou 8?
      digitalWrite(5, LOW);
    }
  }else{ //Será executado quando não houver mudanças na serial
    delay(1000);
  }
}

//Função personalizada
void menu(){
    Serial.println("************************");
    Serial.println("** 1 - Liga Rele 1    **");
    Serial.println("** 2 - Desliga Rele 1 **");
    Serial.println("** 3 - Liga Rele 2    **");
    Serial.println("** 4 - Desliga Rele 2 **");
    Serial.println("** 5 - Liga Rele 3    **");
    Serial.println("** 6 - Desliga Rele 3 **");
    Serial.println("** 7 - Liga Rele 4    **");
    Serial.println("** 8 - Desliga Rele 4 **");
    Serial.println("************************");
}
