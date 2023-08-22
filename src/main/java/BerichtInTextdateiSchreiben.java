import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Collection;

public class BerichtInTextdateiSchreiben {

    Button_BerichtDrucken list10;
    String filename;
    static String beginn;
    static String ende;

    public BerichtInTextdateiSchreiben(Button_BerichtDrucken list10){
        this.list10=list10;
    }


    public BerichtInTextdateiSchreiben(String filename) {
        this.filename = filename;

    }


        public void schreiben (String filename) {


            try {
                MySQLConnection.create();
                Statement stmt = MySQLConnection.con.createStatement();
                ResultSet rs;
                String query = "SELECT beginn, ende FROM schueler s RIGHT JOIN zeiten z ON s.id_schueler=z.id_schueler WHERE s.namen = 'Alex'";
                rs = stmt.executeQuery(query);
                while (rs.next()) {

                    beginn = rs.getString("beginn");
                    System.out.println("Test 1: " + beginn);
                    ende = rs.getString("ende");
                    System.out.println("Test 2 :" + ende);

                }
                MySQLConnection.close();

            } catch (Exception er) {
                er.printStackTrace();


            try {
// File writer object Creation
                FileWriter fileWriter = new FileWriter(filename);
// FileWriter object Creation.
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
//Add String in lines of file
                bufferedWriter.write(String.valueOf(Button_EndzeitEintragen.berichtListe.getSelectedValuesList()));
               // bufferedWriter.write(" It so easy ");
                // Versuch die Zeiten zu den Berichten hinzuzufügen
             //   bufferedWriter.write(String.valueOf(Button_EndzeitEintragen.berichtListe.getSelectedValuesList()));
//user this function if you need to leave a line
                bufferedWriter.newLine();


               // bufferedWriter.write("Neue Zeile");
               // bufferedWriter.write(" Appended Text in seond Line ");
// Always close files.
                bufferedWriter.close();
            } catch (IOException ex) {
                System.out.println(
                        "Ich kann keine Datei erstellen "
                                + filename + "'");
// Or we could just do this:
// ex.printStackTrace();
            }


        }


    }
}

