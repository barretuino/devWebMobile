/**
   Monitoramento de Luminosidade - Arduino Web
   Prof. Ms. Paulo Barreto
   Aula: 04/10/2014
   Exemplo com leitura de sensor LDR (Atualização de Leitura)
**/
#include <SPI.h>
#include <Ethernet.h>

// Endereço MAC e endereço IP para o controlador
byte mac[] = {0xDE, 0xAD, 0xBE, 0xEF, 0xFE, 0xED };
IPAddress ip(192,168,2,100);

//Instanciando um objeto Ethernet
EthernetServer server(80);

void setup() {
 // Abrindo a porta de comunicação e estabelecendo a taxa de transmissão.
  Serial.begin(9600);
   while (!Serial) {
    ; //Esperar por porta serial para conectar.
  }


  //Inicia a conexão Ethernet
  Ethernet.begin(mac, ip);
  server.begin();
  Serial.print("Servidor conectado em ");
  Serial.println(Ethernet.localIP());
}


void loop() {
  // Inicia o processo de entrada
  EthernetClient client = server.available();
  if (client) {
    Serial.println("Novo cliente conectado");
    //Uma solicitação http termina com uma linha em branco
    boolean currentLineIsBlank = true;
    while (client.connected()) {
      if (client.available()) {
        char c = client.read();
        Serial.write(c);
         // Se você chegou ao fim da linha ( recebeu uma nova linha
        // com caractere) e a linha está em branco, o pedido http terminou,
        // Para que você possa enviar uma resposta
        if (c == '\n' && currentLineIsBlank) {
          // Enviar um cabeçalho de resposta HTTP padrão
          client.println("HTTP/1.1 200 OK");
          client.println("Content-Type: text/html");
          client.println("Connection: close");  // A conexão será fechada após a conclusão da resposta
          client.println("Refresh: 5"); // Atualizar a página automaticamente a cada 5 segundos
          client.println();
          client.println("<!DOCTYPE HTML>");
          client.println("<html>");
          client.println("<title>Exemplo de Automa&ccedil;&atilde;o Arduino com HTML</title>");
          client.println("<meta http-equiv='Content-Type' content='text/html; charset=ISO-8859-1'>");
          client.println("</head>");
          client.println("<body>");
          client.println("<center><h1>Supervis&oacute;rio de Luminosidade<h1></center>");

          int valorSensor = analogRead(0);
          client.print("Leitura da Analogic ");
          client.print(0);
          client.print("<br>Luminosidade &eacute ");
          client.print(valorSensor);          
          if (valorSensor < 550)
              client.println(" - <font color=red>Escuro, cuidado</font>");                    
          if (valorSensor >= 550 && valorSensor <=600)
              client.println(" - <font color=blue>Agrad&aacute;vel</font>");          
          if (valorSensor >= 601)
              client.println(" - <font color=black>Muito Claro</font>");         
          
          client.println("<br/>");       
          client.println("</html>");
          break;
        }
        if (c == '\n') {
          // Você está começando uma nova linha
          currentLineIsBlank = true;
        } 
        else if (c != '\r') {
          // Que você tenha obtido um caracter na linha atual
          currentLineIsBlank = false;
        }
      }
    }
    // Dar tempo ao navegador para receber os dados
    delay(1);
    // encerrar conexão
    client.stop();
    Serial.println("Cliente desconectado");
  }
}
