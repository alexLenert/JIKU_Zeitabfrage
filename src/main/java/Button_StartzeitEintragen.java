import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Statement;

public class Button_StartzeitEintragen implements ActionListener {

    JTextField startZeitInput;
    GUI_BerichtErstellen list2;
    static String zeitID;

    public Button_StartzeitEintragen(JTextField startZeitInput, GUI_BerichtErstellen list2) {
        this.startZeitInput = startZeitInput;
        this.list2 = list2;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Pressed");
        System.out.println("direkt NACH PRESSED "+ startZeitInput.getText());
        list2.eintragenZeit.setVisible(false);
        list2.startZeitInput.setVisible(false);
        list2.eintragenBericht.setVisible(true);
        list2.berichtInput.setVisible(true);
        list2.anmeldenOhneRegistrieren.setVisible(false);

        try {
            MySQLConnection.create();
            Statement stmt = MySQLConnection.con.createStatement();
            String query2 = "INSERT INTO zeiten (beginn, id_schueler) VALUES ( '" + startZeitInput.getText() + "', (SELECT id_schueler FROM schueler WHERE id_schueler = '" + list2.userID.getText() + "'))";
            stmt.executeUpdate(query2);
            MySQLConnection.close();

            //-------------------------------------------------------------

            MySQLConnection.create();
            Statement stmt1 = MySQLConnection.con.createStatement();
            ResultSet rs;
            //System.out.println(startZeitInput.getText());
            //System.out.println(list2.userID.getText());
            // beginn = '" + startZeitInput.getText() + "' AND
            String query5 = "SELECT MAX(id) as id FROM zeiten WHERE  id_schueler = " + list2.userID.getText();
            rs = stmt1.executeQuery(query5);
            while (rs.next()) {

                zeitID = rs.getString("id");
                System.out.println("Test 3: " + zeitID);
            }

            MySQLConnection.close();
            //-----------------------------------------------------------


        } catch (Exception ex) {
            ex.printStackTrace();

        }

        System.out.println(list2.userID.getText());

//        try {
//            MySQLConnection.create();
//            Statement stmt = MySQLConnection.con.createStatement();
//            ResultSet rs;
//            String query5 = "SELECT id FROM zeiten WHERE beginn = '" + startZeitInput.getText() + "' AND id_schueler = '" + list2.userID.getText() + "'";
//            rs = stmt.executeQuery(query5);
//            while (rs.next()) {
//
//                zeitID = rs.getString("id");
//                System.out.println("Test 3: " + zeitID);
//            }
//
//            MySQLConnection.close();
//
//        } catch (Exception ex) {
//            ex.printStackTrace();
//
//        }
        System.out.println("ID zeiten: " + zeitID);
    }

}
