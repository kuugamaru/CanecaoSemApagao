import java.sql.Connection;
import java.sql.SQLException;

import database.ConexaoBanco;

public class main {
    public static void main(String[] args) throws SQLException {
        try (Connection connection = ConexaoBanco.getConexao()) {
            System.out.println("Conexão com o banco SQLite estabelecida.");
        }
    }
}