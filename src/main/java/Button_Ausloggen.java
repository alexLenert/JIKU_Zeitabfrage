import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Button_Ausloggen implements ActionListener {

    JTextField nameInput;
    JTextField passwortInput;
    GUI_BerichtErstellen list6;



    public Button_Ausloggen(JTextField nameInput, JTextField passwortInput, GUI_BerichtErstellen list6) {
        this.nameInput = nameInput;
        this.passwortInput = passwortInput;
        this.list6 = list6;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Pressed");
        list6.ausloggen.setVisible(false);
        list6.name.setVisible(true);
        list6.passwort.setVisible(true);
        list6.nameInput.setVisible(true);
        list6.passwortInput.setVisible(true);
        list6.anmelden.setVisible(true);
        list6.berichteDrucken.setVisible(false);
        list6.berichtWaehlen.setVisible(false);
        list6.berichtListe.setVisible(false);
        list6.user.setVisible(false);
        list6.userKlasse.setVisible(false);
        list6.berichtInput.setText("");
        list6.endZeitInput.setText("");
        list6.berichtListe.setVisible(false);


    }


}
