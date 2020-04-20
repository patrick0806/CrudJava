package control;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.MarcaDAO;
import model.Marca;

public class MarcaControl {
	private MarcaDAO dao = new MarcaDAO();
	
	public boolean persist(int id,String nome) throws SQLException {
		Marca marca=new Marca(id,nome);
		return dao.InsereBanco(marca);
	}
	
	public Connection obterConexao() throws SQLException{
        return dao.obterConexao();
	}

	public void desconecta(Connection conexao) throws SQLException{
		  dao.desconecta(conexao);
	}
	
	public ArrayList<Marca> obtemMarcas() throws SQLException{
		return dao.consultaMarcas();
	}
}
