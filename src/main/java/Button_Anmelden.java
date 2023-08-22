import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;

public class Button_Anmelden implements ActionListener {

    JTextField nameInput;
    JTextField passwortInput;

    GUI_BerichtErstellen list1;
    static String id_schueler;
    String klasse;




    public Button_Anmelden(JTextField nameInput, JTextField passwortInput, GUI_BerichtErstellen list1) {
        this.nameInput = nameInput;
        this.passwortInput = passwortInput;
        this.list1 = list1;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        LocalDateTime date = LocalDateTime.now();
        System.out.println("Pressed");
        System.out.println(nameInput.getText());
        System.out.println(passwortInput.getText());
        list1.name.setVisible(false);
        list1.passwort.setVisible(false);
        list1.user.setVisible(true);
        list1.userKlasse.setVisible(true);
        list1.nameInput.setVisible(false);
        list1.passwortInput.setVisible(false);
        list1.anmelden.setVisible(false);
        list1.user.setVisible(true);
        list1.startZeitInput.setVisible(true);
        list1.startZeitInput.setText(String.valueOf(date));
        list1.eintragenZeit.setVisible(true);
        list1.anmeldenOhneRegistrieren.setVisible(false);




        try {
            MySQLConnection.create();
            Statement stmt = MySQLConnection.con.createStatement();
            ResultSet rs;
            String query = "SELECT id_schueler FROM schueler WHERE namen = '" + nameInput.getText() + "' AND passwort = '" + HashCodeErstellen.hashBerechnen(passwortInput.getText()) + "'";
            rs = stmt.executeQuery(query);
            while (rs.next()) {

                id_schueler = rs.getString("id_schueler" );
                System.out.println("Test 1: " + id_schueler);

            }

            String query1 = "SELECT klasse FROM schueler WHERE namen = '" + nameInput.getText() + "' AND passwort = '" + HashCodeErstellen.hashBerechnen(passwortInput.getText()) + "'";
            rs = stmt.executeQuery(query1);
            while (rs.next()) {

                klasse = rs.getString("klasse" );
                System.out.println("Test 1: " + klasse);

            }



            MySQLConnection.close();

        } catch (Exception ex) {
            ex.printStackTrace();


        }
        if(id_schueler == null){
            System.out.println("Sie sind nicht registriert !");
            list1.nichtRegistriert.setText("Sie sind nicht registriert !");
            list1.nichtRegistriert.setVisible(true);
            list1.neuRegistrieren.setVisible(true);
            list1.neuRegistrieren.setVisible(true);
            list1.startZeitInput.setVisible(false);
            list1.eintragenZeit.setVisible(false);

        }else{
            list1.user.setText(nameInput.getText());
            list1.userKlasse.setText(klasse);
            list1.userID.setText(id_schueler);

        }
        System.out.println("Test 2 " + id_schueler);
        list1.nameInput.setText("");
        list1.passwortInput.setText("");


    }


}
