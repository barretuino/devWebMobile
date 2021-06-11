package br.unisal.gui;


/**
 * Projeto de Gerência
 * Classe que modela configuração
 * @autor Prof. Paulo C. Barreto
 * @date 30/11/2013
 */

/**
 * Pilar de Gerência de Configuração
 */
import gnu.io.CommPortIdentifier;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Enumeration;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import br.unisal.modelagem.Medicao;

public class frmConfiguracao extends JFrame implements ActionListener{
	//Atributos
	private JLabel lbPortaCOM, lbTimeOut, lbDataRate;
	private JComboBox cbxPortaCOM;
	private JTextField txtTimeOut, txtDataRate;
	private JButton btMedicao, btSair;
	private String vPortCom[] = new String[99];
	
	public frmConfiguracao(){
		super("Projeto de Gerência iBarreto - Controle de Demanda Energética");
		setSize(600,600);
		setLayout(null);
		
	    lbPortaCOM = new JLabel("Porta de Comunicação");
	    lbTimeOut = new JLabel("TIME_OUT");
	    lbDataRate = new JLabel("DATE_RATE");
	    
	    //Indentificando as portas de comunicação disponíveis
	    CommPortIdentifier portId;  
	    Enumeration portList = CommPortIdentifier.getPortIdentifiers(); 
	    int i = 0;
	    while (portList.hasMoreElements()) {  
	        portId = (CommPortIdentifier) portList.nextElement();  
	        vPortCom[i++] = portId.getName();
	        //System.out.println(portId.getPortType() + ", " + portId.getName());  
	    }   
	    String tempPort[] = vPortCom;
	    i = 0;
	    while(vPortCom[i] != null){
	    	i++;
	    }
	    if (i == 0){
	    	vPortCom = new String[1];
	    	lbPortaCOM.setForeground(Color.red);
	    	vPortCom[0] = "<Não Encontrada>";
	    }else{
	    	vPortCom = new String[i];
	    	for(int cont = 0; cont < i; cont++){
	    		vPortCom[cont] = tempPort[i-1];
	    	}
	    }
	    	    
	    cbxPortaCOM = new JComboBox(vPortCom);	     

	    txtTimeOut = new JTextField("2000");
	    txtDataRate = new JTextField("9600");
	    
	    btMedicao = new JButton("Coletar Dados");
	    btSair = new JButton("Sair");
	    
	    lbPortaCOM.setBounds(10, 10, 150, 20);
	    cbxPortaCOM.setBounds(10, 35, 150, 20);
	    
	    lbTimeOut.setBounds(10, 60, 150, 20);
	    txtTimeOut.setBounds(10, 85, 150, 20);
	    
	    lbDataRate.setBounds(10, 110, 150, 20);
	    txtDataRate.setBounds(10, 135, 150, 20);
	    
	    btMedicao.setBounds(30, 250, 150, 35);
	    btSair.setBounds(190, 250, 150, 35);
	    
	    btMedicao.addActionListener(this);
	    btSair.addActionListener(this);
	    
	    add(lbPortaCOM);
	    add(cbxPortaCOM);
	    add(lbTimeOut);
	    add(txtTimeOut);
	    add(lbDataRate);
	    add(txtDataRate);
	    add(btMedicao);
	    add(btSair);
	    
	    setVisible(true);
	}

	//Método Tratador de Eventos do GUI
	public void actionPerformed(ActionEvent ev) {
		if(ev.getSource()==btMedicao){
			Medicao main;
			String portaCOM = vPortCom[cbxPortaCOM.getSelectedIndex()];
			int timeOut = Integer.parseInt(txtTimeOut.getText());
			int dataRate = Integer.parseInt(txtDataRate.getText());
			try {
				main = new Medicao(portaCOM, timeOut, dataRate);
				main.initialize();
				System.out.println("Inicializada Leitura");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(ev.getSource()==btSair){
			System.exit(0);
		}
		
	}
	public static void main(String args[]){
		frmConfiguracao frm = new frmConfiguracao();
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
