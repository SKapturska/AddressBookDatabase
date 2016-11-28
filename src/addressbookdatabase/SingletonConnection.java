package addressbookdatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SingletonConnection {
    
    private static SingletonConnection instance = null;
    String URL = "jdbc:mysql://127.0.0.1/addressbook?user=root&password=haslo";
    Connection conn;
    Statement st;
    
    private SingletonConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(URL);
            st = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        
    }
    public static SingletonConnection getInstance(){
        if(instance == null){
            instance = new SingletonConnection();
        }
        return instance;
    }
    
    void addToDatabase(){
        Scanner sc = new Scanner(System.in);
        int id;
        String lastName;
        String firstName;
        String city;
        int phoneNumber;
        
        System.out.print("Podaj id ");
        id = sc.nextInt();
        sc.nextLine();
        
        System.out.print("Podaj nazwisko ");
        lastName = sc.nextLine();

        System.out.print("Podaj imie ");
        firstName = sc.nextLine();

        System.out.print("Podaj Miasto ");
        city = sc.nextLine();

        System.out.print("Podaj numer telefonu ");
        phoneNumber = sc.nextInt();
        System.out.println();
        
        try {
            st.executeUpdate("INSERT INTO `addressbook`.`person` (`id`, `nazwisko`, `imie`, `miasto`, `nr_tel`) VALUES ("+ id +", '"+ lastName +"', '"+ firstName +"', '"+ city +"', '"+ phoneNumber +"')");
            System.out.print("Dodano człowieka do bazy danych");
        } catch (SQLException e) {
            e.printStackTrace();
        }
           
    }
    
    ResultSet readFromDatabase(){
        try {
            ResultSet rs = st.executeQuery("Select * from person");
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}