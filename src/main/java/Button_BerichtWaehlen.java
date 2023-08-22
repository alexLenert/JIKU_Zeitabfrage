import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Statement;

public class Button_BerichtWaehlen implements ActionListener {


    GUI_BerichtErstellen list4;

   public Button_BerichtWaehlen( GUI_BerichtErstellen list4) {

       this.list4 = list4;
    }




    @Override
    public void actionPerformed(ActionEvent e) {

        Button_EndzeitEintragen.berichtListe.setVisible(true);


        System.out.println(Button_EndzeitEintragen.berichtListe.getSelectedValuesList());






//        System.out.println("Pressed");
//        System.out.println("Das ist der Index: " + berichtListe.getSelectedIndex());
//        JScrollPane scrollPane = new JScrollPane();
//        scrollPane.setViewportView(berichtListe);
//        berichtListe.setLayoutOrientation(JList.VERTICAL);
//        list4.cp.add(scrollPane);
//        berichtListe.setVisible(true);
//
//
//        list4.cp.add(berichtListe);
//        berichtListe.setModel(listenModell);
//        berichtListe.setVisibleRowCount(15);
//        berichtListe.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
//
//
//        try {
//            MySQLConnection.create();
//            Statement stmt1 = MySQLConnection.con.createStatement();
//            ResultSet rs;
//
//            String query5 = "SELECT beginn FROM zeiten WHERE  id_schueler = " + list4.userID.getText();
//            rs = stmt1.executeQuery(query5);
//
//            while (rs.next()) {
//                listenEintrag = rs.getString("beginn");
//
//                for (int index = 0;index < rs.getRow(); index++) {
//                    listenModell.addElement(String.valueOf(listenEintrag));
//                }
//                System.out.println(listenModell);
//
//                System.out.println("Listeneintrag: " + listenEintrag);
//
//                System.out.println("Listenmodell: " + listenModell);
//
//
//                berichtListe.setVisible(true);
//                System.out.println("Das ist der Index nach dem Befüllen: " + berichtListe.getSelectedValuesList());
//
//                int index = berichtListe.getSelectedIndex();
//
//            }
//
//        } catch (Exception ex) {
//            ex.printStackTrace();
//
//        }




    }




}
