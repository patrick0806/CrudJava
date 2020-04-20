package control;

import java.sql.Connection;
import java.sql.SQLException;

import dao.FornecedorDAO;
import model.Fornecedor;

public class FornecedorControl {
private FornecedorDAO dao = new FornecedorDAO();
	
	public boolean persist(int id, String razao, String fantasia, String cpf_cnpj, String rg, int telefone) throws SQLException {
		Fornecedor fornecedor=new Fornecedor(id,razao,fantasia,cpf_cnpj,rg,telefone);
		return dao.InsereBanco(fornecedor);
	}
	
	public Connection obterConexao() throws SQLException{
        return dao.obterConexao();
	}

	public void desconecta(Connection conexao) throws SQLException{
		  dao.desconecta(conexao);
	}
}
