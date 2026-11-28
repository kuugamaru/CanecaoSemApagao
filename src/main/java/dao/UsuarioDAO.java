package dao;

import database.ConexaoBanco;
import models.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

    // CREATE
    public int cadastrar(Usuario usuario) throws SQLException {
        String sql = "INSERT INTO usuarios (nome, email) VALUES (?, ?)";

        try (Connection connection = ConexaoBanco.getConexao();
                PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, usuario.getNome());
            statement.setString(2, usuario.getEmail());
            statement.executeUpdate();

            try (Statement idStatement = connection.createStatement();
                    ResultSet resultSet = idStatement.executeQuery("SELECT last_insert_rowid()")) {
                if (resultSet.next()) {
                    return resultSet.getInt(1);
                }
                throw new SQLException("O SQLite não retornou o ID do usuário cadastrado.");
            }
        }
    }

    // READ - listar todos
    public List<Usuario> consultar() throws SQLException {
        String sql = "SELECT id, nome, email FROM usuarios ORDER BY id";
        List<Usuario> usuarios = new ArrayList<>();

        try (Connection connection = ConexaoBanco.getConexao();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                usuarios.add(new Usuario(
                        resultSet.getInt("id"),
                        resultSet.getString("nome"),
                        resultSet.getString("email")));
            }
        }
        return usuarios;
    }

    // READ - buscar por ID
    public Usuario consultarPorId(int id) throws SQLException {
        String sql = "SELECT id, nome, email FROM usuarios WHERE id = ?";

        try (Connection connection = ConexaoBanco.getConexao();
                PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return new Usuario(
                            resultSet.getInt("id"),
                            resultSet.getString("nome"),
                            resultSet.getString("email"));
                }
            }
        }
        return null;
    }

    // UPDATE
    public boolean atualizar(Usuario usuario) throws SQLException {
        String sql = "UPDATE usuarios SET nome = ?, email = ? WHERE id = ?";

        try (Connection connection = ConexaoBanco.getConexao();
                PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, usuario.getNome());
            statement.setString(2, usuario.getEmail());
            statement.setInt(3, usuario.getId());
            return statement.executeUpdate() == 1;
        }
    }

    // DELETE
    public boolean remover(int id) throws SQLException {
        String sql = "DELETE FROM usuarios WHERE id = ?";

        try (Connection connection = ConexaoBanco.getConexao();
                PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            return statement.executeUpdate() == 1;
        }
    }
}