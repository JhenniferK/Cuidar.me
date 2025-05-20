package br.edu.ifpb.es.bd.dao;

import java.sql.Connection;
import java.sql.SQLException;

public class TestConnection {
    public static void main(String[] args){
        try {
            Connection connection = DataBaseConnection.getConnection();
            System.out.println("Conexão com o Banco de Dados bem sucedida!");
        } catch (SQLException e){
            System.out.println("Erro na conexão com o Banco de Dados: " + e.getMessage());
        }
    }
}
