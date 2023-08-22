import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GUI_BerichtErstellen extends JFrame implements ActionListener {


    JFrame registrieren = new JFrame();
    JPanel cp = new JPanel(null);



    JButton eintragen = new JButton("Registrieren");
    JButton anmelden = new JButton("Anmelden");
    JButton eintragenZeit = new JButton("Zeit starten");
    JButton eintragenBericht = new JButton("Bericht eintragen");
    JButton eintragenEndzeit = new JButton("Endzeit eintragen");
    JButton berichtWaehlen = new JButton("Berichte auswählen");
    JButton berichteDrucken = new JButton("Berichte drucken");
    JButton wochenBericht = new JButton("Zum Wochenbericht erstellen ");
    JButton ausloggen = new JButton("ausloggen");
    JButton neuRegistrieren = new JButton("Zurück zum Registrieren!");
    JButton anmeldenOhneRegistrieren = new JButton("Anmelden wenn schon registriert");

    JButton datenbank = new JButton("Zeige größe der Datenbank");


    JLabel name = new JLabel("Name");
    JLabel passwort = new JLabel("passwort");
    JLabel klasse = new JLabel("Klasse");
    JLabel user = new JLabel("Unbekannt");
    JLabel user1 = new JLabel("Bitte Daten eingeben");
    JLabel passwort1 = new JLabel("Das Passwort muss mind. 8 Zeichen haben");
    JLabel userKlasse = new JLabel("Unbekannt");
    JList<String> berichtListe = new JList<String>();
    JLabel nichtRegistriert = new JLabel("Name");
    JLabel userID = new JLabel("ID");
    JLabel zeitenID = new JLabel("zeitID");


    JTextField nameInput = new JTextField(20);
    JPasswordField passwortInput = new JPasswordField(20);
    JTextField klasseInput = new JTextField(20);
    TextArea berichtInput = new TextArea("Bericht eintragen", 10,20,1);

    String pattern = "EEEE dd MMMM YYYY   HH : mm : ss";
    DateTimeFormatter fmt = DateTimeFormatter.ofPattern(pattern);

//    static LocalDateTime date = LocalDateTime.now();
//    static LocalDateTime dateStop = LocalDateTime.now();


    JFormattedTextField startZeitInput = new JFormattedTextField();//date.format(fmt)
    JFormattedTextField endZeitInput = new JFormattedTextField();//dateStop.format(fmt)







    public static void main(String[] args) {

        GUI_BerichtErstellen user3 = new GUI_BerichtErstellen();
        user3.guiAnzeigen();

    }

    public void guiAnzeigen() {

        registrieren.setTitle("Jiku Zeiterfassung Registrierung");
        registrieren.setContentPane(cp);
        registrieren.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        registrieren.setResizable(true);
        registrieren.setSize(600, 600);
        registrieren.setVisible(true);



//----------------Labels-------------------------------

        //JLabel name = new JLabel("Name");
        cp.add(name);
        name.setBounds(100, 20, 70, 25);
        name.setVisible(true);

        //JLabel passwort = new JLabel("passwort");
        cp.add(passwort);
        passwort.setBounds(100, 45, 70, 25);
        passwort.setVisible(true);

        //JLabel klasse = new JLabel("Klasse");
        cp.add(klasse);
        klasse.setBounds(100, 70, 70, 25);
        klasse.setVisible(true);

        //JLabel user = new JLabel("Hier sollte der angemeldete Nutzer stehen");
        cp.add(user);
        user.setBounds(100, 20, 250, 25);
        user.setVisible(false);

        //JLabel user1 = new JLabel("Bitte Daten eingeben");
        cp.add(user1);
        user1.setBounds(350, 20, 250, 25);
        user1.setVisible(false);


        //JLabel passwort1 = new JLabel("Bitte Daten eingeben");
        cp.add(passwort1);
        passwort1.setBounds(350, 45, 250, 25);
        passwort1.setVisible(false);


        //JLabel userKlasse = new JLabel("Hier sollte die Klasse des Nutzers stehen");
        cp.add(userKlasse);
        userKlasse.setBounds(100, 45, 250, 25);
        userKlasse.setVisible(false);


        //JLabel nichtRegistriert = new JLabel("Name");
        cp.add(nichtRegistriert);
        nichtRegistriert.setBounds(100, 150, 200, 25);
        nichtRegistriert.setVisible(false);

        //JLabel userID = new JLabel("ID");
        cp.add(userID);
        userID.setBounds(50, 250, 25, 25);
        userID.setVisible(false);

        //JLabel zeitenID = new JLabel("zeitID");
        cp.add(zeitenID);
        zeitenID.setBounds(50, 275, 25, 25);
        zeitenID.setVisible(false);

//------------------------JList---------------------

        //JList<LocalDateTime> berichtListe = new JList<>();
        cp.add(berichtListe);
        berichtListe.setBounds(290,50,150,300);
        berichtListe.setVisible(false);





        //--------------------------JTextfields


        //JTextField nameInput = new JTextField(20);
        cp.add(nameInput);
        nameInput.setBounds(200, 20, 100, 25);
        nameInput.setVisible(true);

        //JTextField passwortInput = new JTextField(20);
        cp.add(passwortInput);
        passwortInput.setBounds(200, 45, 100, 25);
        passwortInput.setVisible(true);

        //JTextField klasseInput = new JTextField(20);
        cp.add(klasseInput);
        klasseInput.setBounds(200, 70, 60, 25);
        klasseInput.setVisible(true);

        //JFormattedTextField startZeitInput = new JFormattedTextField(date.format(fmt));
        cp.add(startZeitInput);
        startZeitInput.setBounds(150, 100, 250, 25);
        startZeitInput.setVisible(false);

        //TextArea berichtInput = new TextArea("Bericht eintragen", 10,20,1);
        cp.add(berichtInput);
        berichtInput.setBounds(200, 95, 300, 200);
        berichtInput.setVisible(false);

        //JFormattedTextField endZeitInput = new JFormattedTextField(date.format(fmt));
        cp.add(endZeitInput);
        endZeitInput.setBounds(150, 295, 250, 25);
        endZeitInput.setVisible(false);


//---------------------------------JButtons

       // JButton eintragen = new JButton("Registrieren");

        cp.add(eintragen);
        eintragen.addActionListener(new Button_Registrieren(nameInput, passwortInput, klasseInput, this));
        eintragen.setBounds(170, 100, 130, 20);
        eintragen.setVisible(true);



        //JButton anmelden = new JButton("Anmelden");
        cp.add(anmelden);
        anmelden.addActionListener(new Button_Anmelden(nameInput, passwortInput, this));
        anmelden.setBounds(300, 100, 130, 20);
        anmelden.setVisible(false);


        //JButton eintragen = new JButton("Zeit starten");
        cp.add(eintragenZeit);
        eintragenZeit.addActionListener(new Button_StartzeitEintragen(startZeitInput, this));
        eintragenZeit.setBounds(430, 100, 130, 20);
        eintragenZeit.setVisible(false);


        //JButton eintragenBericht = new JButton("Bericht eintragen");
        cp.add(eintragenBericht);
        eintragenBericht.addActionListener(new Button_BerichtEintragen(berichtInput, this));
        eintragenBericht.setBounds(170, 320, 130, 20);
        eintragenBericht.setVisible(false);

        //JButton eintragenEndzeit = new JButton("Endzeit eintragen");
        cp.add(eintragenEndzeit);
        eintragenEndzeit.addActionListener(new Button_EndzeitEintragen(berichtListe,endZeitInput, this));
        eintragenEndzeit.setBounds(150, 320, 130, 20);
        eintragenEndzeit.setVisible(false);

        //JButton berichteWählen = new JButton("Berichte auswählen");
        cp.add(berichtWaehlen);
        berichtWaehlen.addActionListener(new Button_BerichtWaehlen( this));
        berichtWaehlen.setBounds(100,150,150,25);
        berichtWaehlen.setVisible(false);

        //JButton berichteDrucken = new JButton("Berichte drucken");
        cp.add(berichteDrucken);
        berichteDrucken.addActionListener(new Button_BerichtDrucken( this));
        berichteDrucken.setBounds(100, 175, 150, 25);
        berichteDrucken.setVisible(false);

        //JButton wochenBericht = new JButton("Berichte drucken");
        cp.add(wochenBericht);
        wochenBericht.addActionListener(new Button_WochenberichtErstellen(this));
        wochenBericht.setBounds(100, 200, 150, 25);
        wochenBericht.setVisible(false);




        //JButton ausloggen = new JButton("ausloggen");
        cp.add(ausloggen);
        ausloggen.addActionListener(new Button_Ausloggen(nameInput, passwortInput, this));
        ausloggen.setBounds(290, 20, 150, 25);
        ausloggen.setVisible(false);

        //JButton neuRegistrieren = new JButton("Zurück zum Registrieren!");
        cp.add(neuRegistrieren);
        neuRegistrieren.addActionListener(new Button_ZurueckZumRegistrieren(nameInput, passwortInput, klasseInput, this));
        neuRegistrieren.setBounds(170, 200, 200, 20);
        neuRegistrieren.setVisible(false);

        //JButton anmeldenOhneRegistrieren = new JButton("Anmelden wenn schon registriert");
        cp.add(anmeldenOhneRegistrieren);
        anmeldenOhneRegistrieren.addActionListener(new ForkActionListener(nameInput,passwortInput,this));
        anmeldenOhneRegistrieren.setBounds(300, 100, 200, 20);
        anmeldenOhneRegistrieren.setVisible(true);



        //------------------------Button Datenbankgröße auslesen-----------------------------------------

        //JButton datenbank = new JButton("Zeige größe der Datenbank");
        cp.add(datenbank);
        datenbank.addActionListener(new AktuelleSpeichergrößeDatenbank(AktuelleSpeichergrößeDatenbank.daten,this));
        datenbank.setBounds(300, 400, 130, 20);
        datenbank.setVisible(true);




    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

