package dao;

import database.ConexaoBanco;
import models.Gestor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GestorDAO {

    // CREATE
    public int cadastrar(Gestor gestor) throws SQLException {
        String sql = "INSERT INTO gestores (nome, setorResponsavel) VALUES (?, ?)";

        try (Connection connection = ConexaoBanco.getConexao();
                PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, gestor.getNome());
            statement.setString(2, gestor.getSetorResponsavel());
            statement.executeUpdate();

            try (Statement idStatement = connection.createStatement();
                    ResultSet resultSet = idStatement.executeQuery("SELECT last_insert_rowid()")) {
                if (resultSet.next()) {
                    return resultSet.getInt(1);
                }
                throw new SQLException("O SQLite não retornou o ID do gestor cadastrado.");
            }
        }
    }

    // READ - listar todos
    public List<Gestor> consultar() throws SQLException {
        String sql = "SELECT id, nome, setorResponsavel FROM gestores ORDER BY id";
        List<Gestor> gestores = new ArrayList<>();

        try (Connection connection = ConexaoBanco.getConexao();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                gestores.add(new Gestor(
                        resultSet.getInt("id"),
                        resultSet.getString("nome"),
                        resultSet.getString("setorResponsavel")));
            }
        }
        return gestores;
    }

    // READ - buscar por ID
    public Gestor consultarPorId(int id) throws SQLException {
        String sql = "SELECT id, nome, setorResponsavel FROM gestores WHERE id = ?";

        try (Connection connection = ConexaoBanco.getConexao();
                PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return new Gestor(
                            resultSet.getInt("id"),
                            resultSet.getString("nome"),
                            resultSet.getString("setorResponsavel"));
                }
            }
        }
        return null;
    }

    // UPDATE
    public boolean atualizar(Gestor gestor) throws SQLException {
        String sql = "UPDATE gestores SET nome = ?, setorResponsavel = ? WHERE id = ?";

        try (Connection connection = ConexaoBanco.getConexao();
                PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, gestor.getNome());
            statement.setString(2, gestor.getSetorResponsavel());
            statement.setInt(3, gestor.getId());
            return statement.executeUpdate() == 1;
        }
    }

    // DELETE
    public boolean remover(int id) throws SQLException {
        String sql = "DELETE FROM gestores WHERE id = ?";

        try (Connection connection = ConexaoBanco.getConexao();
                PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            return statement.executeUpdate() == 1;
        }
    }
}