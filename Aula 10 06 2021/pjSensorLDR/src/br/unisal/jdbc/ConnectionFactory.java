package br.unisal.jdbc;
/**
 * Projeto de Gerência
 * Disciplina: 21845- SISTEMAS INFORMAÇÃO GERÊNCIA TELECOMUNICAÇÕES
 * ConnectionFactory - Fábrica de Conexões com o Banco
 * @autor Paulo C. Barreto / Luiz R. Barreto
 * @date 26/05/2012
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	public static Connection getConnection() throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://localhost/pjGerencia","root","admin");
		} catch (ClassNotFoundException e) {
			throw new SQLException(e.getMessage());
		}
	}
}