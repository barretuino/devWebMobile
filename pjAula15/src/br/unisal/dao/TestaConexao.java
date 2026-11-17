package br.unisal.dao;

import java.sql.Connection;
import java.sql.SQLException;

import br.unisal.modelagem.Cliente;

public class TestaConexao {
	public static void main(String[] args) {
		try {
			Connection con = ConnectionFactory.getConnection();
			if(con != null) {
				System.out.println("Conexão Realizada");
				
				/*Cliente cliente = new Cliente();
				cliente.setCpf(123456789);
				cliente.setNome("Paulo C. Barreto");
				cliente.setEndRua("Av. Brasil");
				cliente.setEndNum(1000);
				cliente.setEndBairro("Jardim Glória");
				cliente.setEndCidade("Americana");
				cliente.setEndUF("SP");
				cliente.setSexo("M");
				
				ClienteDao dao = new ClienteDao();
				dao.adicionar(cliente);*/
				ClienteDao dao = new ClienteDao();
				Cliente clienteNovo = dao.selecionar(123456789);
				System.out.println(clienteNovo.getNome());
				
				Cliente cliente = new Cliente();
				cliente.setCpf(123456789);
				cliente.setNome("Giulia Fuentes");
				cliente.setEndRua("Rua Angelina Sartori");
				cliente.setEndNum(623);
				cliente.setEndBairro("Centro");
				cliente.setEndCidade("Americana");
				cliente.setEndUF("SP");
				cliente.setSexo("F");
				
				dao.adicionar(cliente);
				System.out.println(cliente.getNome());
				
				/*dao.excluir(123456789);
				clienteNovo = dao.selecionar(123456789);
				System.out.println(clienteNovo.getNome());*/
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}