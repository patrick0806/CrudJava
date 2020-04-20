package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Marca;
import model.Produto;

public class ProdutoDAO {
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
	
	public boolean InsereBanco(Produto produto)throws SQLException {
		String comandoSQL="insert into produto(nome,estoque,preco_venda,preco_custo,dat_compra,dat_venda,marca_id) values (?,?,?,?,?,?,?)";
		Connection conexao = obterConexao();
		
		conexao.setAutoCommit(false);//passa o controle das
									//transações para o programador
		int resultado=0;
		try {
			PreparedStatement comandoJava= conexao.prepareStatement(comandoSQL);
			comandoJava.setString(1,produto.getNome());
			comandoJava.setInt(2, produto.getEstoque());
			comandoJava.setDouble(3,produto.getPrecoVenda());
			comandoJava.setDouble(4, produto.getPrecoCusto());
			comandoJava.setDate(5,produto.getDataCompra());
			comandoJava.setDate(6,produto.getDataVenda());
			comandoJava.setInt(7, produto.getMarca().getId());
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
