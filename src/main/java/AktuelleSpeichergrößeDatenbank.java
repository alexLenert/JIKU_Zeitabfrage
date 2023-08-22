import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Statement;

public class AktuelleSpeichergrößeDatenbank implements ActionListener {

    GUI_BerichtErstellen list8;
    static String groeßeDatenbank;
    static JList<String> daten;
    static DefaultListModel<String> moddell = new DefaultListModel<>();


    public AktuelleSpeichergrößeDatenbank(JList<String> daten,  GUI_BerichtErstellen list8) {
        this.daten = daten;
        this.list8 = list8;
    }

    @Override
    public void actionPerformed(ActionEvent e) {


        System.out.println(" -Pressed- ");
        daten.setModel(moddell);
        daten.setVisibleRowCount(15);

        try {
            MySQLConnection.create();
            Statement stmt = MySQLConnection.con.createStatement();
            ResultSet rs;
            String query = "SELECT CONCAT(sum(ROUND(((DATA_LENGTH + INDEX_LENGTH - DATA_FREE) / 1024 / 1024),2)),\" MB\") AS Größe FROM INFORMATION_SCHEMA.TABLES where TABLE_SCHEMA = 'zeiterfassung_jiku'";
            rs = stmt.executeQuery(query);
            while (rs.next()) {

                groeßeDatenbank = rs.getString("Größe");

                for (int index = 0; index < rs.getRow(); index++) {
                    moddell.addElement(groeßeDatenbank);

                }

                System.out.println("Größe der Datenbank: " + daten);


            }

            MySQLConnection.close();

        } catch (Exception ex) {
            ex.printStackTrace();


        }


    }


}
