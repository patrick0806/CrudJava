package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

import model.Cliente;

public class ClienteDAO {
	public Connection obterConexao() throws SQLException{		 
		  //criando a conexao atraves do Drive do MySQL
		  String driveMySQL = "jdbc:mysql://127.0.0.1:3306/db_cadastro"; 
		  String usuario= "root";
		  String senha = "";
		  Connection conexao = DriverManager.getConnection
				  (driveMySQL, usuario, senha); 
		  return conexao;
	}
	
	public void desconecta(Connection conexao) throws SQLException{		
		if(conexao !=null){
			conexao.close();
		}
	}
	
	public boolean InsereBanco(Cliente cliente) throws SQLException{
		String comandoSQL="insert into clientes(id,nome,dat_nascimento,cpf,rg,endereco,numero,bairro,cidade,estado,cep) values(?,?,?,?,?,?,?,?,?,?,?)";
		Connection conexao = obterConexao();
		
		conexao.setAutoCommit(false);
		int resultado=0;
		try {
			java.sql.PreparedStatement comandoJava= conexao.prepareStatement(comandoSQL);
			comandoJava.setInt(1,cliente.getId());
			comandoJava.setString(2,cliente.getNome());
			comandoJava.setDate(3,cliente.getDatNascimento());
			comandoJava.setString(4,cliente.getCpf());
			comandoJava.setString(5, cliente.getRg());
			comandoJava.setString(6,cliente.getEndereco());
			comandoJava.setString(7, cliente.getNumero());
			comandoJava.setString(8,cliente.getBairro());
			comandoJava.setString(9, cliente.getCidade());
			comandoJava.setString(10, cliente.getEstado());
			comandoJava.setString(11,cliente.getCep());
			resultado = comandoJava.executeUpdate();
			
		}catch(Exception e){
			conexao.rollback();//caso alguma persistencia
			// da transação não ocorra
			//deve desfazer as partes que
			//ocorreram para manter a consistencia do BD
			throw e;
		}
		 desconecta(conexao);
		    
		 if(resultado !=0){
			    return true;
		   }
		   return false;
	}
}
