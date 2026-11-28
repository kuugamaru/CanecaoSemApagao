package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import database.ConexaoBanco;
import models.Ocorrencia;

public class OcorrenciaDAO {

    // CREATE
    public int cadastrar(Ocorrencia ocorrencia) throws SQLException {
        String sql = "INSERT INTO ocorrencias (descricao, categoria, endereco, status) VALUES (?, ?, ?, ?)";

        try (Connection connection = ConexaoBanco.getConexao();
                PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, ocorrencia.getDescricao());
            statement.setString(2, ocorrencia.getCategoria());
            statement.setString(3, ocorrencia.getEndereco());
            statement.setString(4, ocorrencia.getStatus());
            statement.executeUpdate();

            try (Statement idStatement = connection.createStatement();
                    ResultSet resultSet = idStatement.executeQuery("SELECT last_insert_rowid()")) {
                if (resultSet.next()) {
                    return resultSet.getInt(1);
                }
                throw new SQLException("O SQLite não retornou o ID da ocorrência cadastrada.");
            }
        }
    }

    // READ - listar todos
    public List<Ocorrencia> consultar() throws SQLException {
        String sql = "SELECT id, descricao, categoria, endereco, status FROM ocorrencias ORDER BY id";
        List<Ocorrencia> ocorrencias = new ArrayList<>();

        try (Connection connection = ConexaoBanco.getConexao();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                ocorrencias.add(new Ocorrencia(
                        resultSet.getInt("id"),
                        resultSet.getString("descricao"),
                        resultSet.getString("categoria"),
                        resultSet.getString("endereco"),
                        resultSet.getString("status")));
            }
        }
        return ocorrencias;
    }

    // READ - buscar por ID
    public Ocorrencia consultarPorId(int id) throws SQLException {
        String sql = "SELECT id, descricao, categoria, endereco, status FROM ocorrencias WHERE id = ?";

        try (Connection connection = ConexaoBanco.getConexao();
                PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return new Ocorrencia(
                            resultSet.getInt("id"),
                            resultSet.getString("descricao"),
                            resultSet.getString("categoria"),
                            resultSet.getString("endereco"),
                            resultSet.getString("status"));
                }
            }
        }
        return null;
    }

    // UPDATE
    public boolean atualizar(Ocorrencia ocorrencia) throws SQLException {
        String sql = "UPDATE ocorrencias SET descricao = ?, categoria = ?, endereco = ?, status = ? WHERE id = ?";

        try (Connection connection = ConexaoBanco.getConexao();
                PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, ocorrencia.getDescricao());
            statement.setString(2, ocorrencia.getCategoria());
            statement.setString(3, ocorrencia.getEndereco());
            statement.setString(4, ocorrencia.getStatus());
            statement.setInt(5, ocorrencia.getId());
            return statement.executeUpdate() == 1;
        }
    }

    // DELETE
    public boolean remover(int id) throws SQLException {
        String sql = "DELETE FROM ocorrencias WHERE id = ?";

        try (Connection connection = ConexaoBanco.getConexao();
                PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            return statement.executeUpdate() == 1;
        }
    }
}