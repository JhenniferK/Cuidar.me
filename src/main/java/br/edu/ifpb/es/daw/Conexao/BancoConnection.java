package br.edu.ifpb.es.daw.Conexao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BancoConnection {
    public static void main(String[] args) {
        String jdbcURL = "jdbc:postgresql://ep-cold-dawn-ae36zcax-pooler.c-2.us-east-2.aws.neon.tech/neondb";
        String username = "neondb_owner";
        String password = "npg_4TWMvPsme1iY";

        String sql= "{call registrar_log(?)}";

        try (Connection conn = DriverManager.getConnection(jdbcURL, username, password); CallableStatement statement = conn.prepareCall(sql)) {
            System.out.println("Conexão estabelecida com sucesso!");
            String mensagemDeLog = "Aplicação Java iniciada com sucesso";
            statement.setString(1, mensagemDeLog);

            statement.execute();

            System.out.println("Função PL/pgSQL 'registrar_log' executada com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao conectar: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
