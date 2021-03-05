package pjAula2;

import java.util.Date;

/**
 * Classe de Modelagem Conceitual para Contato
 * @author Paulo Barreto
 * @date 04/03/2021
 */

public class Contato {
	private String nome;
	private Date dataContato;
	private String email;
	private boolean receberNovidades;
	private String mensagem;
	private String telefone;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getDataContato() {
		return dataContato;
	}
	public void setDataContato(Date dataContato) {
		this.dataContato = dataContato;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isReceberNovidades() {
		return receberNovidades;
	}
	public void setReceberNovidades(boolean receberNovidades) {
		this.receberNovidades = receberNovidades;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	
}
