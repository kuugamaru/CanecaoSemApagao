package database;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexaoBanco {

    private static final String DATABASE_PATH_PROPERTY = "ocorrencias.db.path";
    private static final String DEFAULT_DATABASE_PATH = "database/ocorrencias.db";

    public static Connection getConexao() throws SQLException {
        Path databasePath = Path.of(
                System.getProperty(DATABASE_PATH_PROPERTY, DEFAULT_DATABASE_PATH))
                .toAbsolutePath();
        try {
            Files.createDirectories(databasePath.getParent());
        } catch (IOException e) {
            throw new SQLException("Não foi possível criar a pasta do banco de dados.", e);
        }

        Connection connection = DriverManager.getConnection("jdbc:sqlite:" + databasePath);
        try {
            try (Statement statement = connection.createStatement()) {
                statement.execute("PRAGMA foreign_keys = ON");
            }
            inicializarSchema(connection);
            return connection;
        } catch (SQLException e) {
            try {
                connection.close();
            } catch (SQLException closeException) {
                e.addSuppressed(closeException);
            }
            throw e;
        }
    }

    private static void inicializarSchema(Connection connection) throws SQLException {
        try (InputStream schemaStream = ConexaoBanco.class.getResourceAsStream("/database/schema.sql")) {
            if (schemaStream == null) {
                throw new SQLException("Arquivo database/schema.sql não encontrado no classpath.");
            }

            String schema = new String(schemaStream.readAllBytes(), StandardCharsets.UTF_8);
            try (Statement statement = connection.createStatement()) {
                for (String command : schema.split(";")) {
                    if (!command.isBlank()) {
                        statement.execute(command);
                    }
                }
            }
        } catch (IOException e) {
            throw new SQLException("Não foi possível ler database/schema.sql.", e);
        }
    }
}