package br.com.apiclientes.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;

import br.com.apiclientes.entities.Cliente;
import br.com.apiclientes.factories.ConnectionFactory;

public class ClienteRepository {

	public void create(Cliente cliente) throws Exception {

		Connection connection = ConnectionFactory.getConnection();

		PreparedStatement statement = connection
				.prepareStatement("insert into cliente(nome, email, cpf) values(?, ?, ?)");
		statement.setString(1, cliente.getNome());
		statement.setString(2, cliente.getEmail());
		statement.setString(3, cliente.getCpf());
		statement.execute();

		connection.close();
	}

	public void update(Cliente cliente) throws Exception {

		Connection connection = ConnectionFactory.getConnection();

		PreparedStatement statement = connection
				.prepareStatement("update cliente set nome=?, email=?, cpf=?, where idcliente=?");
		statement.setString(1, cliente.getNome());
		statement.setString(2, cliente.getEmail());
		statement.setString(3, cliente.getCpf());
		statement.setInt(4, cliente.getIdCliente());
		statement.execute();

		connection.close();
	}

	public void delete(Cliente cliente) throws Exception {

		Connection connection = ConnectionFactory.getConnection();

		PreparedStatement statement = connection.prepareStatement("delete from cliente where idcliente=?");
		statement.setInt(1, cliente.getIdCliente());
		statement.execute();

		connection.close();
	}

	public List<Cliente> findAll() throws Exception {

		Connection connection = ConnectionFactory.getConnection();

		PreparedStatement statement = connection.prepareStatement("select * from cliente");
		ResultSet resultSet = statement.executeQuery();

		List<Cliente> lista = new ArrayList<Cliente>();

		while (resultSet.next()) {

			Cliente cliente = new Cliente();

			cliente.setIdCliente(resultSet.getInt("idcliente"));
			cliente.setNome(resultSet.getString("nome"));
			cliente.setCpf(resultSet.getString("cpf"));
			cliente.setEmail(resultSet.getString("email"));

			lista.add(cliente);
		}

		connection.close();
		return lista;
	}

	public Cliente findById(Integer idCliente) throws Exception {

		Connection connection = ConnectionFactory.getConnection();

		PreparedStatement statement = connection.prepareStatement("select * from cliente where idcliente=?");
		statement.setInt(1, idCliente);
		ResultSet resultSet = statement.executeQuery();

		Cliente cliente = null;

		if (resultSet.next()) {

			cliente = new Cliente();

			cliente.setIdCliente(resultSet.getInt("idcliente"));
			cliente.setNome(resultSet.getString("nome"));
			cliente.setCpf(resultSet.getString("cpf"));
			cliente.setEmail(resultSet.getString("email"));
		}

		connection.close();
		return cliente;

	}
}
