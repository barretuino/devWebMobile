package br.unisal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.unisal.modelagem.Cliente;

/**
 * Classe de Acesso ao Banco de Dados
 * CRUD - Create, Read, Update e Delete
 * @author Paulo Barreto
 * @data 09/05/2024
 */
public class ClienteDao {
	//1º Passo - Estabelecer uma Conexão
	private Connection connection;
	public ClienteDao() throws SQLException{
		connection = ConnectionFactory.getConnection();
	}
	
	//2º Passo - Ação de Inserção de Dados
	public void adicionar(Cliente cliente) throws SQLException{
		//Instrução de Inserção (Comando SQL)
		PreparedStatement stmt = this.connection.prepareStatement(
		   "insert into clientes (cpf, nome, endRua, endNum, "
		   + "endBairro, endCidade, "
			+ "endUF, endComplemento, sexo) "
			+ "values (?, ?, ?, ?, ?, ?, ?, ?, ?)");
		try {
			stmt.setDouble(1, cliente.getCpf());
			stmt.setString(2, cliente.getNome());
			stmt.setString(3, cliente.getEndRua());
			stmt.setInt(4, cliente.getEndNum());
			stmt.setString(5, cliente.getEndBairro());
			stmt.setString(6, cliente.getEndCidade());
			stmt.setString(7, cliente.getEndUF());
			stmt.setString(8, cliente.getEndComplemento());
			stmt.setString(9, cliente.getSexo());
			
			//Execução no Banco
			stmt.execute();
			System.out.println("Cliente Inserido com Sucesso!");
		}catch(SQLException e) {
			System.out.println("Falha ao inserir " + e);
		}finally {
			stmt.close();
		}
	}
	
	//3º Passo - Ação de Seleção de Dados
	public Cliente selecionar(double cpf) throws SQLException {
		//cria o objeto
        Cliente clienteRet = new Cliente();
        // prepared statement para inser��o
		PreparedStatement stmt = 
				this.connection.prepareStatement(
						"SELECT * FROM `clientes` "
						+ "where `cpf` = ?");
		try {
			// seta os valores			
			stmt.setDouble(1, cpf);		
			// executa stmt (Query)			
	        ResultSet rs = stmt.executeQuery();		
            while (rs.next()) {                
                // seta os valores dos campos do objeto
                clienteRet.setCpf(rs.getDouble(1));
                clienteRet.setNome(rs.getString(2));
                clienteRet.setEndRua(rs.getString(3));
                clienteRet.setEndNum(rs.getInt(4));
                clienteRet.setEndBairro(rs.getString(5));
                clienteRet.setEndCidade(rs.getString(6));
                clienteRet.setEndUF(rs.getString(7));
                clienteRet.setSexo(rs.getString(8));
                clienteRet.setEndComplemento(rs.getString(9));                
            }

        } catch (SQLException ex) {
            System.out.println("Erro ao consultar " + ex);
            ex.printStackTrace();
        } finally {
			stmt.close();
			System.out.println("Pesquisa realizada.");
        }
        return clienteRet;  
	}
	//4º Passo - Ação de Atualização de Dados
	public void atualizar(Cliente cliente) throws SQLException {
		// prepared statement para inserção
		PreparedStatement stmt = 
				this.connection.prepareStatement(
						"UPDATE clientes SET " +
				"nome = '" + cliente.getNome() + "', " +
				"endRua = '" + cliente.getEndRua()+ "', " +
				"endNum = " + cliente.getEndNum() + ", " +
				"endBairro = '" + cliente.getEndBairro() + "', " +
				"endCidade = '" + cliente.getEndCidade() + "', " +
				"endUF = '" + cliente.getEndUF() + "', " +
				"endComplemento = '" + cliente.getEndComplemento() + "', " +
				"sexo = '" + cliente.getSexo() + "'" + 
				" WHERE cpf = " + cliente.getCpf());
        try {            
			
			System.out.println(stmt.toString());
			
			// executa stmt (Query)			
	        stmt.executeUpdate();
	        System.out.println("Alterado Cliente: " + cliente.getCpf());	        
        } catch (SQLException ex) {
            System.out.println("Erro ao atualizar cliente " + ex);
            ex.printStackTrace();
        } finally {
			stmt.close();			
        }        
    }
	
	//5º Passo - Ação de Remoção de Dados
	public void excluir(double cpf) throws SQLException {
		//prepared statement para inser��o
		PreparedStatement stmt = this.connection.prepareStatement(
				"DELETE FROM `clientes` where `cpf` = ?");
		
		try{
			// seta os valores
			stmt.setDouble(1,cpf);		
			// executa stmt (Query)
			stmt.execute();
		} catch (SQLException ex) {
			System.out.println("Erro ao excluir " + ex);
			ex.printStackTrace();
		} finally {
			stmt.close();
			System.out.println("Excluido: " + cpf);
		}	
	}
}
