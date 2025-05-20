package br.edu.ifpb.es.bd.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseConnection {
    private static final String URL = "jdbc:postgresql://ep-odd-hill-a4h6nwmr-pooler.us-east-1.aws.neon.tech/bd2?user=bd2_owner";
    private static final String USER = "bd2_owner";
    private static final String PASSWORD = "npg_SB5mHk2sqPdO";
    private static final String DRIVER = "org.postgresql.Driver";
    public static void main(String[] args){

        Connection connection = null;
        Statement statement = null;

        try {
            Class.forName(DRIVER);

            connection = DriverManager.getConnection(URL,USER, PASSWORD);
            System.out.println("Conexão estabelecida com sucesso!");

            statement = connection.createStatement();

            String createEnderecoTable = "CREATE TABLE IF NOT EXISTS endereco (" +
                    "id SERIAL PRIMARY KEY, " +
                    "logradouro VARCHAR(255) NOT NULL, " +
                    "numero INTEGER NOT NULL, " +
                    "cidade VARCHAR(100) NOT NULL, " +
                    "estado VARCHAR(100) NOT NULL)";

            String createContatoEmergenciaTable = "CREATE TABLE contato_emergencia (" +
                    "id SERIAL PRIMARY KEY, " +
                    "nome VARCHAR(255) NOT NULL, " +
                    "telefone INTEGER NOT NULL)";

            String createPsicologoTable = "CREATE TABLE IF NOT EXISTS psicologo (" +
                    "crp SERIAL PRIMARY KEY, " +
                    "nome VARCHAR(255), " +
                    "email VARCHAR(255), " +
                    "senha VARCHAR(255))";

            String createPacienteTable = "CREATE TABLE IF NOT EXISTS paciente (" +
                    "id SERIAL PRIMARY KEY, " +
                    "cpf BIGINT NOT NULL UNIQUE, " +
                    "rg BIGINT NOT NULL UNIQUE, " +
                    "info_adicionais VARCHAR(400), " +
                    "endereco_pessoal_id BIGINT, " +
                    "endereco_trabalho_id BIGINT, " +
                    "contato_emergencia_id BIGINT, " +
                    "FOREIGN KEY (endereco_pessoal_id) REFERENCES endereco(id), " +
                    "FOREIGN KEY (endereco_trabalho_id) REFERENCES endereco(id), " +
                    "FOREIGN KEY (contato_emergencia_id) REFERENCES contato_emergencia(id))";

            String createPagamentoTable = "CREATE TABLE IF NOT EXISTS pagamento (" +
                    "id SERIAL PRIMARY KEY, " +
                    "valor DECIMAL(10, 2) NOT NULL, " +
                    "metodo VARCHAR(255), " +
                    "status BOOLEAN NOT NULL, " +
                    "data TIMESTAMP NOT NULL)";

            String createAtendimentoTable = "CREATE TABLE IF NOT EXISTS atendimento (" +
                    "id SERIAL PRIMARY KEY, " +
                    "data TIMESTAMP NOT NULL, " +
                    "localidade VARCHAR(255) NOT NULL, " +
                    "agendado BOOLEAN NOT NULL)";

            String createProntuarioTable = "CREATE TABLE IF NOT EXISTS prontuario (" +
                    "id SERIAL PRIMARY KEY, " +
                    "descricao TEXT NOT NULL, " +
                    "data_registro TIMESTAMP NOT NULL)";

            statement.executeUpdate(createEnderecoTable);
            statement.executeUpdate(createContatoEmergenciaTable);
            statement.executeUpdate(createPsicologoTable);
            statement.executeUpdate(createPacienteTable);
            statement.executeUpdate(createPagamentoTable);
            statement.executeUpdate(createAtendimentoTable);
            statement.executeUpdate(createProntuarioTable);


            System.out.println("Tabelas criadas com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println();
        } catch (ClassNotFoundException e){
            System.err.println("Driver não encontrado" + e.getMessage());
        } finally {
            try {
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static Connection getConnection() throws SQLException {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e){
            throw new SQLException("Driver JDBC não encontrado: " + e.getMessage(), e);
        }
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}