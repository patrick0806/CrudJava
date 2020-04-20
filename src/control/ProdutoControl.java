package control;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.ProdutoDAO;
import model.Marca;
import model.Produto;

public class ProdutoControl {
	private ProdutoDAO dao = new ProdutoDAO();
	public boolean persist(int id, String nome, int estoque, double precoVenda, double precoCusto, Date dataCompra, Date dataVenda, Marca marca) throws SQLException {
		Produto produto=new Produto(id, nome, estoque, precoVenda, precoCusto, dataCompra, dataVenda, marca);
		return dao.InsereBanco(produto);
	}
	
	public Connection obterConexao() throws SQLException{
        return dao.obterConexao();
	}

	public void desconecta(Connection conexao) throws SQLException{
		  dao.desconecta(conexao);
	}
	
}
