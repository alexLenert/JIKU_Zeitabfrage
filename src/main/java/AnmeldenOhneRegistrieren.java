import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class AnmeldenOhneRegistrieren extends JFrame implements ActionListener {


    JFrame registrieren = new JFrame();
    JPanel cp = new JPanel(null);

    JButton anmeldungOhneRegistrieren = new JButton("Anmelden wenn schon registriert");


    public void methode() {

        registrieren.setTitle("Jiku Zeiterfassung Registrierung");
        registrieren.setContentPane(cp);
        registrieren.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        registrieren.setResizable(true);
        registrieren.setSize(600, 600);
        registrieren.setVisible(true);

//
//        //JButton anmeldenOhneRegistrieren = new JButton("Anmelden wenn schon registriert");
//        cp.add(anmeldungOhneRegistrieren);
//        anmeldungOhneRegistrieren.addActionListener(new ForkActionListener());
//        anmeldungOhneRegistrieren.setBounds(170, 100, 130, 20);
//        anmeldungOhneRegistrieren.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

}
class ForkActionListener implements ActionListener {
    JTextField nameInput;
    JTextField passwortInput;
    GUI_BerichtErstellen list7;

    public ForkActionListener(JTextField nameInput, JTextField passwortInput, GUI_BerichtErstellen list7) {
        this.nameInput = nameInput;
        this.passwortInput = passwortInput;
        this.list7 = list7;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Pressed");
        list7.name.setVisible(true);
        list7.passwort.setVisible(true);
        list7.nameInput.setVisible(true);
        list7.passwortInput.setVisible(true);
        list7.anmelden.setVisible(true);
        list7.eintragen.setVisible(false);
        list7.klasse.setVisible(false);
        list7.klasseInput.setVisible(false);
        list7.anmeldenOhneRegistrieren.setVisible(false);
        System.out.println(nameInput.getText());
        System.out.println(passwortInput.getText());

    }
}


