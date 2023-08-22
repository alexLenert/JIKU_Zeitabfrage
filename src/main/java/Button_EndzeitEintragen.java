import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Button_EndzeitEintragen implements ActionListener {
    //Test Liste nach hierher umziehen
    static JList<String> berichtListe = new JList<String>();
    static String listenEintrag;
    DefaultListModel<String> listenModell = new DefaultListModel<>();
    //Ende Deklaration Liste

    JTextField endZeitInput;
    GUI_BerichtErstellen list5;


    public Button_EndzeitEintragen(JList<String> berichtListe, JTextField endZeitInput, GUI_BerichtErstellen list5) {
        this.berichtListe = berichtListe;
        this.endZeitInput = endZeitInput;
        this.list5 = list5;


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Pressed");
        System.out.println(endZeitInput.getText());
        list5.endZeitInput.setVisible(false);
        list5.eintragenEndzeit.setVisible(false);
        list5.berichtWaehlen.setVisible(true);
        list5.berichtListe.setVisible(true);
        list5.berichteDrucken.setVisible(true);
        list5.ausloggen.setVisible(true);


        try {
            MySQLConnection.create();
            Statement stmt = MySQLConnection.con.createStatement();
            String query4 = "UPDATE zeiten SET ende = '" + endZeitInput.getText() + "' WHERE id = " + list5.zeitenID.getText();
            System.out.println("ZeitenID für ZeitEnde" + list5.zeitenID.getText());
            stmt.executeUpdate(query4);
            MySQLConnection.close();


            MySQLConnection.create();
            Statement stmt1 = MySQLConnection.con.createStatement();
            String query5 = "UPDATE zeiten SET zwischenstand = (SELECT TIMEDIFF('" + endZeitInput.getText() + "', beginn)) WHERE id = " + list5.zeitenID.getText();
            System.out.println("ZeitenID für Zwischenstand" + list5.zeitenID.getText());
            stmt1.executeUpdate(query5);
            MySQLConnection.close();


        } catch (Exception ex) {
            ex.printStackTrace();

        }


        //Test Liste Datenbankzugriff


        System.out.println("Pressed");
        System.out.println("Das ist der Index: " + berichtListe.getSelectedIndex());
        JScrollPane scrollPane = new JScrollPane(berichtListe);
        scrollPane.setBounds(290,50,150,300);

        berichtListe.setLayoutOrientation(JList.VERTICAL);

        list5.cp.add(scrollPane);
        scrollPane.setVisible(true);


        berichtListe.setModel(listenModell);
        berichtListe.setVisibleRowCount(15);
        berichtListe.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        berichtListe.setVisible(true);
        list5.wochenBericht.setVisible(true);





        try {
            MySQLConnection.create();
            Statement stmt1 = MySQLConnection.con.createStatement();
            ResultSet rs;

            String query5 = "SELECT bericht FROM zeiten WHERE  id_schueler = " + list5.userID.getText();
            rs = stmt1.executeQuery(query5);

            while (rs.next()) {
                listenEintrag = rs.getString("bericht");


                listenModell.addElement(String.valueOf(listenEintrag));



                System.out.println("Listeneintrag: " + listenEintrag);

                System.out.println("Listenmodell: " + listenModell);


                berichtListe.setVisible(true);
                System.out.println("Das ist der Index nach dem Befüllen: " + berichtListe.getSelectedValuesList());

                int index = berichtListe.getSelectedIndex();

            }

        } catch (Exception ex) {
            ex.printStackTrace();

        }

        System.out.println("Das ist die berichtListe: " + berichtListe);


        //Ende Datenbankzugriff


    }

}
