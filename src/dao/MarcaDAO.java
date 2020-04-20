package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Marca;

public class MarcaDAO {
	
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
	
	public boolean InsereBanco(Marca marca)throws SQLException {
		String comandoSQL="insert into marca (id,marca) values (?,?)";
		Connection conexao = obterConexao();
		
		conexao.setAutoCommit(false);//passa o controle das
									//transações para o programador
		int resultado=0;
		try {
			PreparedStatement comandoJava= conexao.prepareStatement(comandoSQL);
			comandoJava.setInt(1, marca.getId());
			comandoJava.setString(2, marca.getNome());
			
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
	};
	
public ArrayList<Marca> consultaMarcas() throws SQLException{
		
		/**
		obter a  conexão, conultar e preencher um ArrayList de marcas 
		*/
		ArrayList<Marca> marcas = new ArrayList<Marca>();
		//criar o comando de consulta no banco
				String comandoSQL="select id,marca from marca";
				
				//criar conexão
				Connection conexao=obterConexao();
				
				//criar o objeto jdbc que é capaz de executar a consulta
				PreparedStatement comandoJava=conexao.prepareStatement(comandoSQL);
				
				
				//executar o comando de consulta em banco e obter o conjunto resultante
				ResultSet registros=comandoJava.executeQuery();
				
				Marca marca=null;
				//avaliar se há elementos na coleção
				while(registros.next())
				{
					marca=new Marca();
					marca.setId(registros.getInt(1));
					marca.setNome(registros.getString(2));
					marcas.add(marca);
				}
				comandoJava.close();
				desconecta(conexao);
				return marcas;
	}
}
