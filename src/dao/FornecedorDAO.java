package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

import model.Fornecedor;

public class FornecedorDAO {
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
	
	public boolean InsereBanco(Fornecedor fornecedor) throws SQLException {
		String comandoSQL="insert into fornecedor(id,razao,fantasia,cpf_cnpj,rg_inscr,telefone) values(?,?,?,?,?,?)";
		Connection conexao = obterConexao();
		conexao.setAutoCommit(false);//passa o controle das
		//transações para o programador
		int resultado=0;
		try {
			java.sql.PreparedStatement comandoJava= conexao.prepareStatement(comandoSQL);
			comandoJava.setInt(1,fornecedor.getId());
			comandoJava.setString(2,fornecedor.getRazao());
			comandoJava.setString(3,fornecedor.getFantasia());
			comandoJava.setString(4,fornecedor.getCpf_cnpj());
			comandoJava.setString(5,fornecedor.getRg());
			comandoJava.setInt(6,fornecedor.getTelefone());
			
			resultado = comandoJava.executeUpdate();
			
			conexao.commit();//faz com que a transação seja concluido
		} catch (Exception e) {
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
