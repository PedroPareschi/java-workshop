package br.com.pedropareschi;

import java.awt.event.ContainerAdapter;
import java.sql.*;

public class Main {
    public static final String DB_NAME = "testjava.db";
    public static final String CONNECTION_STRING = "jdbc:sqlite:C:\\Users\\Pedro\\IdeaProjects\\TestDB\\" + DB_NAME;
    public static final String TABLE_CONTACTS = "contacts";

    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_PHONE = "phone";
    public static final String COLUMN_EMAIL = "email";

    public static void main(String[] args) {

        try{
            Connection conn = DriverManager.getConnection(CONNECTION_STRING);

            Statement statement = conn.createStatement();
            statement.execute("drop table if exists " + TABLE_CONTACTS);
            statement.execute("create table if not exists " + TABLE_CONTACTS +
                    " (" + COLUMN_NAME + " text, " +
                    COLUMN_PHONE + " Integer, " +
                    COLUMN_EMAIL + " text" +
                    ")");
            insertContact(statement,"Tim", 654567813, "tim@gmail.com");
            insertContact(statement,"Joe", 45632543, "joe@gmail.com");
            insertContact(statement,"Jane", 4864515, "jane@gmail.com");
            insertContact(statement,"Fido", 5683354, "dog@gmail.com");

            ResultSet results = statement.executeQuery("select * from " +TABLE_CONTACTS);
            while(results.next()){
                System.out.println(results.getString(COLUMN_NAME) + " "
                + results.getInt(COLUMN_PHONE) + " "
                + results.getString(COLUMN_EMAIL));
            }
            statement.close();
            conn.close();

        }catch (SQLException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    private static void insertContact(Statement statement, String name, int phone, String email) throws SQLException {
        statement.execute("INSERT INTO " + TABLE_CONTACTS +
                " (" + COLUMN_NAME + ", " +
                COLUMN_PHONE + ", " +
                COLUMN_EMAIL +
                " ) " +
                "VALUES('" + name + "', " + phone + ", '" + email + "')");
    }
}
