/**
   Manipulando portas Digitais - Arduino Web
   Prof. Ms. Paulo Barreto
   Aula: 04/10/2014
   Exemplo de semafóro com leds coloridos
**/
#include <SPI.h>
#include <Ethernet.h>
boolean incoming = 0;

int led1 = 0; //armazena o estado do led 0 - low e 1 - high
int led2 = 0; //armazena o estado do led 0 - low e 1 - high
int led3 = 0; //armazena o estado do led 0 - low e 1 - high

#define pin_rly1 2 //Representa a porta digital 2
#define pin_rly2 3 //Representa a porta digital 3
#define pin_rly3 4 //Representa a porta digital 4

byte mac[] = { 0x90, 0xA2, 0xDA, 0x00, 0x9B, 0x36 }; //Mac Adress - Enderço Físico
byte ip[] = { 192, 168, 2, 99 }; //IP da Shield na Rede
byte gateway[] = { 192, 168, 2, 1 }; //IP do Roteador que prôve o acesso
byte subnet[] = { 255, 255, 255, 0 }; //Máscara de SubNet
EthernetServer server(80); //Porta no Servidor

void setup()
{
  Ethernet.begin(mac, ip);
  server.begin();
  Serial.begin(9600);
  pinMode(pin_rly1, OUTPUT);
  digitalWrite(pin_rly1, LOW);
  pinMode(pin_rly2, OUTPUT);
  digitalWrite(pin_rly2, LOW);
  pinMode(pin_rly3, OUTPUT);
  digitalWrite(pin_rly3, LOW);  
}

void loop()
{
  //Instanciando um objeto EthernetClient
  EthernetClient client = server.available();
  if (client)
  {
    //Uma solicitação http termina com uma linha em branco
    boolean currentLineIsBlank = true;
    String str;
    while (client.connected())
    {
      if (client.available())
      {
        char c = client.read();
        str.concat(c);

        if(str.endsWith("/1on")) led1 =1;
        else if(str.endsWith("/1off")) led1 =0;

        if(str.endsWith("/2on")) led2 =1;
        else if(str.endsWith("/2off")) led2 =0;

        if(str.endsWith("/3on")) led3 =1;
        else if(str.endsWith("/3off")) led3 =0;

        if (c == '\n' && currentLineIsBlank)
        {
          client.println("HTTP/1.1 200 OK");
          client.println("Content-Type: text/html"); //inicializa o arquivo html
          //client.println("Refresh: 1"); // refresh a pagina a cada 1 seg
          client.println();
          client.println("<H1><center>Arduino Web - Curso de Extens&atildeo</H1></center><br/>");
          //<H1> Tamanho da letra
          //<center> Centraliza o texto que estiver na sequência
          //<br> Quebra de linha
          client.println("<hr width=50%>"); // Traço centralizado na pagina
          client.println();
          client.println("<UL>"); // iniciar lista não numerada
          if(led1 == 1)
          {
            client.print("<br><LI><font color=’blue’ size=’5′><a href=http://192.168.2.99/1off/><font color=red><i>Desligar Saida 1</i></center></a>");
            //<LI> Item não numerado
            //<a href=endereço pagina/>texto a ser apresentado</a> link para outra pagina
            digitalWrite(pin_rly1, HIGH);
          }
          else if (led1 ==0)
          {
            client.println("<br><LI><font color=’blue’ size=’5′><a href=http://192.168.2.99/1on/>LIGAR SAIDA 1</a>");
            digitalWrite(pin_rly1, LOW);
          }
          if(led2 == 1)
          {
            client.println("<br><LI><font color=’blue’ size=’5′><a href=http://192.168.2.99/2off/><font color=red><font color=red><i>Desligar Saida 2</i></font></font></a>");
            digitalWrite(pin_rly2, HIGH);
          }
          else if (led2 ==0)
          {
            client.println("<br><LI><font color=’blue’ size=’5′><a href=http://192.168.2.99/2on/>LIGAR SAIDA 2</a>");
            digitalWrite(pin_rly2, LOW);
          }
          if(led3 == 1)
          {
            client.println("<br><LI><font color=’blue’ size=’5′><a href=http://192.168.2.99/3off/><font color=red><i>Desligar Saida 3</i></font></a>");
            digitalWrite(pin_rly3, HIGH);
          }
          else if (led3 ==0)
          {
            client.println("<br><LI><font color=’blue’ size=’5′><a href=http://192.168.2.99/3on/>LIGAR SAIDA 3</a>");
            digitalWrite(pin_rly3, LOW);
          }          
          client.println("</UL>");

          break;
        }
        if (c == '\n')
        {
          currentLineIsBlank = true;
        }
        else if (c != '\r')
        {
          currentLineIsBlank = false;
        }
      }
    }
    // Dar tempo ao navegador para receber os dados
    delay(1000);
    //Fechar a conexão
    client.stop();
  }
}
