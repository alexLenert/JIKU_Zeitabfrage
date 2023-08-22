import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Statement;
import java.time.LocalDateTime;

public class Button_BerichtEintragen implements ActionListener {

    TextArea berichtInput;
    GUI_BerichtErstellen list3;




    public Button_BerichtEintragen(TextArea berichtInput, GUI_BerichtErstellen list3) {
        this.berichtInput = berichtInput;
        this.list3 = list3;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        LocalDateTime dateStop = LocalDateTime.now();
        System.out.println("Pressed");
        System.out.println(berichtInput.getText());
        list3.eintragenBericht.setVisible(false);
        list3.berichtInput.setVisible(false);
        list3.eintragenEndzeit.setVisible(true);
        list3.endZeitInput.setVisible(true);
        list3.endZeitInput.setText(String.valueOf(dateStop));
        list3.zeitenID.setText(Button_StartzeitEintragen.zeitID);
        list3.startZeitInput.setText("");

        System.out.println("FOP: " + Button_StartzeitEintragen.zeitID);
        try{
            MySQLConnection.create();
            Statement stmt = MySQLConnection.con.createStatement();
            System.out.println("Bericht: " + berichtInput.getText());

            System.out.println("ZID:" + list3.zeitenID.getText());
            String query3 = "UPDATE zeiten SET bericht = '" + berichtInput.getText() + "' WHERE id = " + list3.zeitenID.getText();
            stmt.executeUpdate(query3);
            MySQLConnection.close();


        }catch(Exception ex ){
            ex.printStackTrace();

        }

    }



}
