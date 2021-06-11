package br.unisal.jdbc;
/**
 * Projeto de Gerência
 * Classe DAO - Data Access Object
 * @autor Prof. Paulo C. Barreto 
 * @date 30/11/2013
 */

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;
import java.util.GregorianCalendar;

import br.unisal.modelagem.Medida;

public class MedicaoDAO {
	//Estabele conexão com o banco de dados
	private Connection connection;
	public MedicaoDAO() throws SQLException {
		this.connection = ConnectionFactory.getConnection();
	}
	public void adiciona(Medida leitura) throws SQLException {
		//Prepara statement para inserção
		PreparedStatement stmt = this.connection.prepareStatement("insert into medidas (data, hora, valor) values (?, ?, ?)");
		
		//Seta os valores dos argumentos da stmt	
		GregorianCalendar atual = new GregorianCalendar();
		Date data = new Date(atual.getTime().getYear(), atual.getTime().getMonth(), atual.getTime().getDate());
		Time hora = new Time(atual.getTime().getHours(), atual.getTime().getMinutes(), atual.getTime().getSeconds());
		
		stmt.setDate(1, data);
		stmt.setTime(2, hora);
		stmt.setFloat(3,(float) leitura.getLuminosidade());
		
		//Executa query
		stmt.execute();
		stmt.close();
	}
}