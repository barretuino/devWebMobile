/**
   Monitoramento de Luminosidade - Arduino Web
   Prof. Ms. Paulo Barreto
   Aula: 04/10/2014
   Exemplo de atualização de leitura de sensor LDR
**/
#include <SPI.h>
#include <Ethernet.h>

byte mac[] = { 0x90, 0xA2, 0xDA, 0x00, 0x9B, 0x36 }; //Mac Adress - Endereço Físico
byte ip[] = { 192, 168, 2, 100 }; //IP da Shield na Rede
byte gateway[] = { 192, 168, 2, 1 }; //IP do Roteador que prôve o acesso
byte subnet[] = { 255, 255, 255, 0 }; //Máscara de SubNet
EthernetServer server(80); //Porta no Servidor

int sensor = 0;      //Pino analógico em que o sensor está conectado.
int valorSensor = 0; //variável usada para ler o valor do sensor em tempo real.

void setup(){
  //Instanciando a Ethernet
  Ethernet.begin(mac, ip, gateway, subnet);
  server.begin();
  //Definindo a velocidade de comunicação Serial
  Serial.begin(9600);
  Serial.println("Exemplo de Comunicacao via Ethernet Shield"); 
}

void loop(){
  //Lendo o valor do sensor.
  int valorSensor = analogRead(sensor);
  EthernetClient client = server.available();
  if (client) {
    client.println("HTTP/1.1 200 OK"); //send new page
    client.println("Content-Type: text/html");
    client.println();     
    client.println("<html>");
    client.println("<head>"); 
    client.println("<title>Exemplo de Automa&ccedil;&atilde;o Arduino com HTML</title>");
    client.println("<meta http-equiv='Content-Type' content='text/html; charset=ISO-8859-1'>");
    client.println("</head>");
    client.println("<body>");
    client.println("<center><h1>Supervis&oacute;rio de Luminosidade<h1></center>");
   while (client.connected()) {
      if (client.available()) {
          valorSensor = analogRead(sensor);
          client.println("<br>Luminosidade ");
          client.println(valorSensor); //Saída Ethernet
          Serial.println(valorSensor); //Exibindo o valor do sensor no serial monitor.
          if (valorSensor < 550)
              client.println(" - <font color=red>Escuro, cuidado</font>");                    
          if (valorSensor >= 550 && valorSensor <=600)
              client.println(" - <font color=blue>Agrad&aacute;vel</font>");          
          if (valorSensor >= 601)
              client.println(" - <font color=black>Muito Claro</font>");         
          
          delay(5000);
      }
   }
   client.println("</body>");
   client.println("</head>");    
  }
}
