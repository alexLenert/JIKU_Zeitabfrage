import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Button_WochenberichtErstellen implements ActionListener {

    GUI_BerichtErstellen list11;
    String start;
    String bericht;
    String stop;
    String berichtMitZeiten;
    String space = " ";

    public Button_WochenberichtErstellen(GUI_BerichtErstellen list11) {
        this.list11 = list11;

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        try {
            MySQLConnection.create();
            Statement stmt = MySQLConnection.con.createStatement();
            ResultSet rs;
            String query = "SELECT beginn FROM zeiten LEFT JOIN schueler ON zeiten.id_schueler = schueler.id_schueler WHERE schueler.namen = '" + list11.user.getText() +
                    "' AND schueler.klasse  = '" + list11.userKlasse.getText() + "'";
            rs = stmt.executeQuery(query);
            while (rs.next()) {

                start = rs.getString("beginn");

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

            try {
                MySQLConnection.create();
                Statement stmt1 = MySQLConnection.con.createStatement();
                ResultSet rs1;
                String query1 = "SELECT  bericht FROM zeiten LEFT JOIN schueler ON zeiten.id_schueler = schueler.id_schueler WHERE schueler.namen = '" + list11.user.getText() +
                        "' AND schueler.klasse  = '" + list11.userKlasse.getText() + "'";
                rs1 = stmt1.executeQuery(query1);
                while (rs1.next()) {

                    bericht = rs1.getString("bericht");

                }

            } catch (Exception ex) {
                ex.printStackTrace();

            }

                try {
                    MySQLConnection.create();
                    Statement stmt2 = MySQLConnection.con.createStatement();
                    ResultSet rs2;
                    String query2 = "SELECT ende FROM zeiten LEFT JOIN schueler ON zeiten.id_schueler = schueler.id_schueler WHERE schueler.namen = '" + list11.user.getText() +
                            "' AND schueler.klasse  = '" + list11.userKlasse.getText() + "'";
                    rs2 = stmt2.executeQuery(query2);
                    while (rs2.next()) {

                        stop = rs2.getString("ende");

                    }


                berichtMitZeiten = start.concat(space).concat(bericht).concat(space).concat(stop);

                System.out.println("Test 1: " + berichtMitZeiten);


            MySQLConnection.close();

        } catch (Exception ex) {
            ex.printStackTrace();


        }


    }
}