import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Statement;

public class Button_Registrieren implements ActionListener {

    JTextField nameInput;
    JTextField passwortInput;
    JTextField klasseInput;
    GUI_BerichtErstellen list;

    public Button_Registrieren(JTextField nameInput, JTextField passwortInput, JTextField klasseInput, GUI_BerichtErstellen list) {
        this.nameInput = nameInput;
        this.passwortInput = passwortInput;
        this.klasseInput = klasseInput;
        this.list = list;

    }

//    String hashBerechnen(String passwort){
//
//        String x;
//
//        x = passwort + "einsZweiDreiGeheim";
//
//        String hashWert = String.valueOf(x.hashCode());
//
//        return  hashWert;
//    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //FooDocumentlistener test = new FooDocumentlistener(nameInput.getText());

        if(nameInput.getText().length() < 1){
            System.out.println("Bitte Namen eingeben");
            list.user1.setVisible(true);
            list.anmeldenOhneRegistrieren.setVisible(false);
        }else if(passwortInput.getText().length()<8){
            System.out.println("Das Passwort muss mind. 8 Zeichen haben");
            list.passwort1.setVisible(true);
        }else{



            System.out.println("Pressed");
            System.out.println(nameInput.getText());
            System.out.println(passwortInput.getText());
            System.out.println(klasseInput.getText());
            list.user1.setVisible(false);
            list.passwort1.setVisible(false);
            list.anmeldenOhneRegistrieren.setVisible(false);
            list.anmelden.setVisible(true);
            list.eintragen.setVisible(false);
            list.klasse.setVisible(false);
            list.klasseInput.setVisible(false);









            // 1. Ramen für SQL-Kommunikation einrichten -> try-catch-block
            // 2. in den try-Block mit create öffnen und mit close schließen
            // 3. Um die Kommunikation durchführen zu können, muss zuerst ein Statement mit con erstellt werden
            // 4. einen String mit Bezeichner erstellen und darin den MySQL-Befehl schreiben
            // 5. das Statement mit execute(bezeichner) ausführen
            try{
                MySQLConnection.create();
                Statement stmt = MySQLConnection.con.createStatement(); //Greift direkt über die Klasse MySQLConnection mit dem Objekt "con" auf die Methode "createStatement" zu
                String query = "INSERT INTO schueler (namen, passwort, klasse) VALUES ('" + nameInput.getText() + "', '" + HashCodeErstellen.hashBerechnen(passwortInput.getText()) + "', '" + klasseInput.getText() + "')" ;
                stmt.executeUpdate(query);
                MySQLConnection.close();

            }catch(Exception ex ){
                ex.printStackTrace();
            }


        }

        list.nameInput.setText("");
        list.passwortInput.setText("");
    }






}
