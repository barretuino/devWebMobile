package br.unisal.gui;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.unisal.dao.ClienteDao;
import br.unisal.modelagem.Cliente;

public class frmCliente extends JFrame implements ActionListener{
	//Passo 1 - Declaração do Objetos
	private JLabel lbCpf, lbNome, lbEnd, lbEndRua, lbEndNum, lbEndBairro, 
				   lbEndCidade, lbEndUF, lbEndComplemento, lbSexo;
	private JTextField txtCpf, txtNome, txtEndRua, txtEndNum, txtEndBairro, 
	   				   txtEndCidade, txtEndComplemento;
	private JComboBox cbxSexo;
	private JComboBox cbxEstado;
	private String sexo[] = {"Masculino","Feminino"};
	private String estado[] = {"AC"	,"AL", "AP", "AM","BA","CE", 
								"DF", "ES", "GO", "MA",
								"MT", "MS" , "MG", "PB", 
								"PR", "PA","PE","PI","RJ", 
								"RN", "RS","RO",
								"RR","SP", "SC", "SE","TO" };
	
	private JButton btCadastrar, btExcluir, btPesquisar, btAlterar, btSair, btLimpar;	
	private ClienteDao dao; //Invoco DAO
	private Cliente cliente; //Instancio um objeto do tipo Cliente
	
	public frmCliente(){
		setTitle("Controle de Clientes - Cadastro de Clientes");
		
		//Tamanho do Frame
		int comprimento = 650;
		int largura = 265;
		setSize(comprimento,largura);		
		
		//Disposição Inicial e Final
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((d.width - comprimento)/2,(d.height - largura)/2);
		
		//Instanciando objeto de Cliente
		try{
			dao = new ClienteDao();	
		} catch(Exception ex){
			JOptionPane.showMessageDialog(null, "Erro ao construir ClienteDAO.\nErro --> " + ex, 
										 "Atenção - Erro Grave", JOptionPane.ERROR_MESSAGE);
		}		
		cliente = new Cliente();
		
		setLayout(null);
		
		//SetBounds (Coluna Inicial, Linha Inicial, Comprimento, Largura)
		
		lbCpf = new JLabel("CPF:");
		lbCpf.setBounds(5,16, 50, 10);//seta a posição
		txtCpf = new JTextField(11);
		txtCpf.setBounds(35,11, 85, 22);
		
		lbNome = new JLabel("Nome:");
		lbNome.setBounds(145,16, 50, 10);
		txtNome = new JTextField(25);
		txtNome.setBounds(185,11, 230, 22);
		       
        lbEnd = new JLabel("Endereco:");
        lbEnd.setBounds(5,38, 70, 22);
        
        lbEndRua = new JLabel("Rua:");
        lbEndRua.setBounds(15,61, 70, 22);
        txtEndRua = new JTextField(25);
        txtEndRua.setBounds(45,61, 270, 22);
        
        lbEndNum = new JLabel("Num:");
        lbEndNum.setBounds(330,61, 70, 22);
        txtEndNum = new JTextField(4);
        txtEndNum.setBounds(366,61, 50, 22);
        
        lbEndBairro = new JLabel("Bairro:");
        lbEndBairro.setBounds(440,61, 70, 22);
        txtEndBairro = new JTextField(35);
        txtEndBairro.setBounds(486,61, 100, 22);
        
        
        lbEndCidade = new JLabel("Cidade:");
        lbEndCidade.setBounds(15,91, 70, 22);
        txtEndCidade = new JTextField(35);
        txtEndCidade.setBounds(80,91, 235, 22);
        
        lbEndUF = new JLabel("UF:");  
        lbEndUF.setBounds(330, 91, 70, 22);
        cbxEstado = new JComboBox(estado);
        cbxEstado.setBounds(366,91, 50, 22);
        
        lbEndComplemento = new JLabel("Complemento:");
        lbEndComplemento.setBounds(15, 121, 100, 22);
        txtEndComplemento = new JTextField(30);
        txtEndComplemento.setBounds(120, 121, 470, 22);

        lbSexo = new JLabel("Sexo:");
        lbSexo.setBounds(440, 16, 70, 10);
        cbxSexo = new JComboBox(sexo);
        cbxSexo.setBounds(490, 11, 100, 22);
               
        add(lbCpf);
        add(txtCpf);
        add(lbNome);
        add(txtNome);
        add(lbEnd);
        add(lbEndRua);
        add(txtEndRua);
        add(lbEndNum);
        add(txtEndNum);
        add(lbEndBairro);
        add(txtEndBairro);
        add(lbEndCidade);
        add(txtEndCidade);
        add(lbEndUF);
        add(cbxEstado);
        add(lbEndComplemento);
        add(txtEndComplemento);
        add(lbSexo);
        add(cbxSexo);
               
		btCadastrar = new JButton("Cadastrar");
		btCadastrar.addActionListener(this);			
		btCadastrar.setMnemonic(btCadastrar.getText().charAt(0));
		btCadastrar.setToolTipText("Cadastar Cliente <<Cliente.DAO-->adicionar()>>");
		btCadastrar.setBounds(5,200, 100, 22);
		add(btCadastrar);
		
		btAlterar = new JButton("Alterar");
		btAlterar.addActionListener(this);			
		btAlterar.setMnemonic(btAlterar.getText().charAt(0));
		btAlterar.setToolTipText("Alterar Cliente <<Cliente.DAO-->alterar()>>");		
		btAlterar.setEnabled(false);
		btAlterar.setBounds(115,200, 100, 22);
		add(btAlterar);
		
		btExcluir = new JButton("Excluir");
		btExcluir.addActionListener(this);			
		btExcluir.setMnemonic(btExcluir.getText().charAt(0));
		btExcluir.setToolTipText("Excluir Cliente <<Cliente.DAO-->excluir()>>");	
		btExcluir.setEnabled(false);
		btExcluir.setBounds(225,200, 100, 22);
		add(btExcluir);
		
		btPesquisar = new JButton("Pesquisar");
		btPesquisar.addActionListener(this);			
		btPesquisar.setMnemonic(btPesquisar.getText().charAt(0));
		btPesquisar.setToolTipText("Pesquisar Cliente <<Cliente.DAO-->pesquisar()>>");	
		btPesquisar.setBounds(335,200, 100, 22);
		add(btPesquisar);
		
		btLimpar = new JButton("Limpar");
		btLimpar.addActionListener(this);			
		btLimpar.setMnemonic(btLimpar.getText().charAt(0));
		btLimpar.setToolTipText("Limpar Frame");
		btLimpar.setBounds(445,200, 100, 22);
		add(btLimpar);		
		
		btSair = new JButton("Sair");		
		btSair.addActionListener(this);			
		btSair.setMnemonic(btSair.getText().charAt(0));
		btSair.setToolTipText("Sair do Frame");		
		btSair.setBounds(565,200, 60, 22);
		add(btSair);
        
        setVisible (true);
	}

	//Método implementa o método abstrato actionPerformed que trata as ações dos objetos
	public void actionPerformed(ActionEvent evento){
		if(evento.getSource() == btCadastrar){
			cadastrar();
		}
		if(evento.getSource() == btAlterar){
			alterar();
		}
		if(evento.getSource() == btExcluir){
			excluir();
		}
		if(evento.getSource() == btPesquisar){
			pesquisar();
		}
		if(evento.getSource() == btLimpar){
			limpar();
		}
		if(evento.getSource() == btSair){
			dispose();
		}
	}
	
	private void instanciaCliente(){		
		cliente.setCpf(Double.parseDouble(txtCpf.getText())); 
		cliente.setNome(txtNome.getText());
		cliente.setEndRua(txtEndRua.getText());
		cliente.setEndNum(Integer.parseInt(txtEndNum.getText()));
		cliente.setEndBairro(txtEndBairro.getText());
		cliente.setEndCidade(txtEndCidade.getText());
		cliente.setEndUF(estado[cbxEstado.getSelectedIndex()]);
		cliente.setEndComplemento(txtEndComplemento.getText());
		cliente.setSexo((cbxSexo.getSelectedIndex()==0 ? "M" : "F"));		
	}
	
	private void cadastrar() {		
		instanciaCliente();		
		try{			
			dao.adicionar(cliente);	
			JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso.\nCliente--> " + String.format("%.0f", cliente.getCpf()), 
 					"Alteração", JOptionPane.INFORMATION_MESSAGE);
			limpar();
		} catch(SQLException ex){
			JOptionPane.showMessageDialog(null, "Erro ao incluir cliente.\nErro --> " + ex, 
										 "Atenção - Erro Grave", JOptionPane.ERROR_MESSAGE);
		}		
	}

	private void alterar() {
		instanciaCliente();		
		try {
			dao.atualizar(cliente);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		JOptionPane.showMessageDialog(null, "Cliente alterado com sucesso.\nCliente--> " + String.format("%.0f", cliente.getCpf()), 
				 					"Alteração", JOptionPane.INFORMATION_MESSAGE);
		limpar();		
	}

	private void excluir() {
		instanciaCliente();		
		try {
			dao.excluir(Double.parseDouble(txtCpf.getText()));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		JOptionPane.showMessageDialog(null, "Cliente excluído com sucesso.\nCliente--> " + String.format("%.0f", cliente.getCpf()), 
				"Alteração", JOptionPane.INFORMATION_MESSAGE);
		limpar();			
	}
	
	private void pesquisar() {			
		try {
			cliente = dao.selecionar(Double.parseDouble(txtCpf.getText()));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(String.format("%.0f", cliente.getCpf()));
		if (cliente.getCpf()>0){			
			//atualizar campos do Frame
			txtNome.setText(cliente.getNome());
			txtEndRua.setText(cliente.getEndRua());
			txtEndNum.setText("" + cliente.getEndNum());
			txtEndBairro.setText(cliente.getEndBairro());
			txtEndCidade.setText(cliente.getEndCidade());
			for (int i=0; i < estado.length; i++){
				if (estado[i].equals(cliente.getEndUF())){
					cbxEstado.setSelectedIndex(i);					
				}			
			}
			txtEndComplemento.setText(cliente.getEndComplemento());
			cbxSexo.setSelectedIndex(cliente.getSexo().equals("M") ? 0 : 1);
			
			txtCpf.requestFocus();
			
			btExcluir.setEnabled(true);
			btAlterar.setEnabled(true);
			btCadastrar.setEnabled(false);
			
		}else{
			limpar();
			JOptionPane.showMessageDialog(null, "Não há cliente com o CPF informado.", 
					 					"Resultado da Pesquisa", JOptionPane.ERROR_MESSAGE);
			txtCpf.requestFocus();
		}				
	}
	
	private void limpar() {
		//atualizar campos do Frame
		txtCpf.setText("");
		txtNome.setText("");
		txtEndRua.setText("");
		txtEndNum.setText("");
		txtEndBairro.setText("");
		txtEndCidade.setText("");
		cbxEstado.setSelectedIndex(0);					
		txtEndComplemento.setText("");
		cbxSexo.setSelectedIndex(0);
		
		btCadastrar.setEnabled(true);
		btExcluir.setEnabled(false);
		btAlterar.setEnabled(false);
		
		txtCpf.requestFocus();		
	}
	
	public static void main(String args[]){
		frmCliente f = new frmCliente();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
