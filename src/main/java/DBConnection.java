import java.sql.*;
import java.util.Properties;

public class DBConnection {

    static Connection con = null;



    static void getConnection() {
        try {

            String url = " http://localhost/phpmyadmin/index.php?route=/database/structure&db=zeiterfassung_jiku   " ;//"jdbc:mysql://localhost:3306/zeiterfassung_jiku";
            Properties info = new Properties();
            info.put("user", "root");
            info.put("password", "");

            con = DriverManager.getConnection(url, info);

            if (con != null) {
                System.out.println("Verbindungsaufbau erfolgreich!");
            }


        } catch (SQLException ex) {
            System.out.println("Verbindungsfehler");
            ex.printStackTrace();
        }
    }

//    public void create() {
//        try {
//            String url = "jdbc:mysql://localhost:3306/zeiterfassung_jiku";
//            Connection conn = DriverManager.getConnection(url, "root", "");
//            Statement st = conn.createStatement();
//
//
//            conn.close();
//        } catch (Exception e) {
//            System.err.println("Got an exception! ");
//            System.err.println(e.getMessage());
//        }
//    }

}