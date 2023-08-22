import java.sql.*;
import java.util.Properties;

public class JDBC_INSERT_INTO {

        public static Connection con = null;
        public static Statement sqlStatement = null;
        public static String dbHost = "localhost";
        public static String dbPort = "3306";
        public static String dbName = "Kalender";
        public static String dbUser = "root";
        public static String dbPass = "";

        public static void create() {

            try {

                String url = "jdbc:mysql://localhost:3306/zeiterfassung_jiku";
                Properties info = new Properties();
                info.put("user", "root");
                info.put("password", "");

                con = DriverManager.getConnection(url, info);

                if(con != null) {
                    System.out.println("Verbindungsaufbau erfolgreich!");
                }


            } catch(SQLException ex) {
                System.out.println("Verbindungsfehler");
                ex.printStackTrace();
            }


        }

        public void close() {
            try {
                if (sqlStatement != null) {
                    sqlStatement.close();
                }
                if (con != null) {
                    con.close();
                    System.out.println(" Datenverbindung beendet. ");
                }
            } catch (SQLException e) {
                System.out.println(" SQLException: " + e.getMessage());
                System.out.println(" SQLState: " + e.getSQLState());
                System.out.println(" VendorError:  " + e.getErrorCode());
            }
        }



    }







