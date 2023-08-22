import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Button_ZurueckZumRegistrieren implements ActionListener {


    JTextField nameInput;
    JTextField passwortInput;
    JTextField klasseInput;
    GUI_BerichtErstellen list;


    public Button_ZurueckZumRegistrieren(JTextField nameInput, JTextField passwortInput, JTextField klasseInput, GUI_BerichtErstellen list) {
        this.nameInput = nameInput;
        this.passwortInput = passwortInput;
        this.klasseInput = klasseInput;
        this.list = list;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Pressed");
        System.out.println(nameInput.getText());
        System.out.println(passwortInput.getText());
        System.out.println(klasseInput.getText());
        list.eintragen.setVisible(true);
        list.klasse.setVisible(true);
        list.klasseInput.setVisible(true);
        list.nameInput.setVisible(true);
        list.name.setVisible(true);
        list.passwort.setVisible(true);
        list.passwortInput.setVisible(true);
        list.eintragenZeit.setVisible(false);
        list.startZeitInput.setVisible(false);
        list.user.setVisible(false);
        list.userKlasse.setVisible(false);
        list.neuRegistrieren.setVisible(false);
        list.nichtRegistriert.setVisible(false);



    }


}
