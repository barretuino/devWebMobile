package br.unisal.modelagem;

import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;

import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.Enumeration;

import br.unisal.gui.frmGraficoReal;
import br.unisal.jdbc.MedicaoDAO;

public class Medicao implements SerialPortEventListener {
	
	/**
	 * Pilar de Ger�ncia de Configura��o
	 */
	String texto = "";
	SerialPort serialPort;
  
	//Configura��o da Porta
	private static final String PORT_NAMES[] = { 
			"/dev/tty.usbserial-A9007UX1", // Mac OS X
			"/dev/ttyUSB0", // Linux
			"COM15", // Windows
			};
	// Buffered de input da pota COM
	private InputStream input;
	// Output stream da porta COM
	private OutputStream output;
	//Milissegundos para bloquear enquanto aguarda abertura da COM
	private int TIME_OUT;
	//Defini��o do n�mero de bits por segundo da porta COM
	private int DATA_RATE;
	//Instacia do DAO
	private MedicaoDAO dao;
	//Instancia do objeto de leitura
	private Medida leitura;	
	//Grafico de Monitoramento
	private frmGraficoReal grafico;
	
	//M�todo Construtor da classe de medi��o
	public Medicao(String portaCOM, int timeOut, int dataRate) throws SQLException{
		dao = new MedicaoDAO();		
		leitura = new Medida();
		TIME_OUT = timeOut;
		DATA_RATE = dataRate;
		grafico = new frmGraficoReal("Medida de Luminosidade");		
		grafico.pack();
		grafico.setVisible(true);
	}	

	public void initialize() {
		CommPortIdentifier portId = null;
		Enumeration portEnum = CommPortIdentifier.getPortIdentifiers();

		//Localizando portas de comunica��o dispon�veis
		while (portEnum.hasMoreElements()) {
			CommPortIdentifier currPortId = (CommPortIdentifier) portEnum.nextElement();
			for (String portName : PORT_NAMES) {
				if (currPortId.getName().equals(portName)) {
					portId = currPortId;
					break;
				}
			}
		}

		if (portId == null) {
			System.out.println("N�o foi poss�vel encontrar a porta COM.");
			return;
		}

		try {
			//Abertura da  porta serial
			serialPort = (SerialPort) portId.open(this.getClass().getName(),
					TIME_OUT);

			//Setando parametros da porta
			serialPort.setSerialPortParams(DATA_RATE,
					SerialPort.DATABITS_8,
					SerialPort.STOPBITS_1,
					SerialPort.PARITY_NONE);

			//Abertura dos streams
			input = serialPort.getInputStream();
			output = serialPort.getOutputStream();

			//Adicionando eventos de monitoramento da porta
			serialPort.addEventListener(this);
			serialPort.notifyOnDataAvailable(true);
		} catch (Exception e) {
			System.err.println(e.toString());
		}
	}
	/**
	 * Fim do Pilar Configura��o
	 */

	/**
	* Isto deve ser chamado quando voc� parar de usar a porta.
	* Isso ir� evitar o bloqueio de porta em plataformas como o Linux.
	**/
	public synchronized void close() {
		if (serialPort != null) {
			serialPort.removeEventListener();
			serialPort.close();
			System.out.println(texto);		
		}
	}

	/**
	 * Lidar com um evento na porta serial. Leitura dos dados, tratamento e persistencia.
	 */
	public synchronized void serialEvent(SerialPortEvent oEvent) {
		if (oEvent.getEventType() == SerialPortEvent.DATA_AVAILABLE) {
			try {
				int available = input.available();
				byte chunk[] = new byte[available];
				input.read(chunk, 0, available);

				//Resultados apresentados s�o a leitura de input
				System.out.print(new String(chunk));

				for(int i=0; i<available; i++){
					if(chunk[i]=='$')
						texto="";
					else
						if(chunk[i]=='#'){
							//Preparando para Persistencia no Banco de Dados	
							float luminosidade = Float.parseFloat(texto);

							//Escrevendo as vari�veis monitoradas
							leitura.setLuminosidade(luminosidade);

							//Realizando Persistencia no Banco de Dados	
							dao.adiciona(leitura);
							System.out.println("Grava��o realizada na MIB: " + leitura.getLuminosidade());
							grafico.setLuminosidade(luminosidade);							
						}else
							texto = texto + new String(chunk).charAt(i);					
				}
			} catch (Exception e) {
				System.err.println(e.toString());
			}
		}
	}
}