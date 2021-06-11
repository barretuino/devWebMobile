int val;

void setup()
{
  Serial.begin(9600);
  pinMode(2, OUTPUT);     
  pinMode(3, OUTPUT);
  pinMode(4, OUTPUT);  
  pinMode(5, OUTPUT);     
  pinMode(6, OUTPUT);
  pinMode(7, OUTPUT);    
  pinMode(8, OUTPUT);
  pinMode(9, OUTPUT);  
  pinMode(13, OUTPUT);  
}

void loop()
{
  if (Serial.available()) {
    val = Serial.read();
    //Relé 1
    if (val == 11) {
      digitalWrite(2, HIGH);      
    } 
    if (val == 10) {
      digitalWrite(2, LOW);
    }
    //Relé 2
    if (val == 21) {
      digitalWrite(3, HIGH);
    } 
    if (val == 20) {
      digitalWrite(3, LOW);
    }
    //Relé 3
    if (val == 31) {
      digitalWrite(4, HIGH);
    } 
    if (val == 30) {
      digitalWrite(4, LOW);
    }
    //Relé 4
    if (val == 41) {
      digitalWrite(5, HIGH);
    } 
    if (val == 40) {
      digitalWrite(5, LOW);
    }
    //Relé 5
    if (val == 51) {
      digitalWrite(6, HIGH);
    } 
    if (val == 50) {
      digitalWrite(6, LOW);
    }
    //Relé 6
    if (val == 61) {
      digitalWrite(7, HIGH);
    } 
    if (val == 60) {
      digitalWrite(7, LOW);
    }
    //Relé 7
    if (val == 71) {
      digitalWrite(8, HIGH);
    } 
    if (val == 70) {
      digitalWrite(8, LOW);
    }
    //Relé 8
    if (val == 81) {
      digitalWrite(9, HIGH);
    } 
    if (val == 80) {
      digitalWrite(9, LOW);
    }
  }else{
    Serial.print(val);
  }
}
