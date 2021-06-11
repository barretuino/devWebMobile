import gnu.io.SerialPortEvent;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class frmRele extends JFrame implements ActionListener{
	private ComunicacaoSerial com;
	private JButton btRele1, btRele2, btRele3, btRele4;
	private boolean controle[];
	
	public frmRele(){
		super("Controle da Shield de Relés");
		setSize(700,100);
		setLayout(new FlowLayout());
		
		com = new ComunicacaoSerial();
		com.initialize();
		controle = new boolean[4];
		
		btRele1 = new JButton("Relé 1");
		btRele1.addActionListener(this);
		btRele2 = new JButton("Relé 2");
		btRele2.addActionListener(this);
		btRele3 = new JButton("Relé 3");
		btRele3.addActionListener(this);
		btRele4 = new JButton("Relé 4");
		btRele4.addActionListener(this);
		
		add(btRele1);
		add(btRele2);
		add(btRele3);
		add(btRele4);
		setVisible(true);	
	}
	
	public void actionPerformed(ActionEvent evento) {
		if (evento.getSource() == btRele1){
			if (!controle[0]){
				System.out.println("Ligado Relé 1");		
				btRele1.setForeground(new Color(255, 0, 0));
				com.setRele(11);
				controle[0]= true;
			}else{
				System.out.println("Desligado Relé 1");
				btRele1.setForeground(new Color(0, 0, 0));
				com.setRele(10);
				controle[0]= false;
			}
		}
		if (evento.getSource() == btRele2){
			if (!controle[1]){
				System.out.println("Ligado Relé 2");	
				btRele2.setForeground(new Color(255, 0, 0));
				com.setRele(21);
				controle[1]= true;
			}else{
				System.out.println("Desligado Relé 2");
				btRele2.setForeground(new Color(0, 0, 0));
				com.setRele(20);
				controle[1]= false;
			}
		}
		if (evento.getSource() == btRele3){
			if (!controle[2]){
				System.out.println("Ligado Relé 3");	
				btRele3.setForeground(new Color(255, 0, 0));
				com.setRele(31);
				controle[2]= true;
			}else{
				System.out.println("Desligado Relé 3");
				btRele3.setForeground(new Color(0, 0, 0));
				com.setRele(30);
				controle[2]= false;
			}
		}
		if (evento.getSource() == btRele4){
			if (!controle[3]){
				System.out.println("Ligado Relé 4");	
				btRele4.setForeground(new Color(255, 0, 0));
				com.setRele(41);
				controle[3]= true;
			}else{
				System.out.println("Desligado Relé 4");
				btRele4.setForeground(new Color(0, 0, 0));
				com.setRele(40);
				controle[3]= false;
			}
		}
	}
	public static void main(String args[]){
		frmRele frm = new frmRele();
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}