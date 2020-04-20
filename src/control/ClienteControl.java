package control;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;

import dao.ClienteDAO;
import model.Cliente;

public class ClienteControl {
	private ClienteDAO dao = new ClienteDAO();
	
	public boolean persist(int id, String nome, Date datNascimento, String cpf, String rg, String endereco,
			String numero, String bairro, String cidade, String estado, String cep) throws SQLException {
		Cliente cliente = new Cliente(id,nome,datNascimento,cpf,rg,endereco,numero,bairro,cidade,estado,cep);
		return dao.InsereBanco(cliente);
	}
	
	public Connection obterConexao() throws SQLException{
        return dao.obterConexao();
	}

	public void desconecta(Connection conexao) throws SQLException{
		  dao.desconecta(conexao);
	}
}
