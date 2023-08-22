import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Button_BerichtDrucken implements ActionListener {

    GUI_BerichtErstellen list9;
    String saveName;

    public Button_BerichtDrucken(GUI_BerichtErstellen list9) {
        this.list9 = list9;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String place = " ";
        String document = ".txt";

        saveName = list9.user.getText().concat(place).concat(list9.userKlasse.getText().concat(document));
        BerichtInTextdateiSchreiben druck = new BerichtInTextdateiSchreiben(saveName);
        System.out.println("Unter diesem Namen wird das Dokument gespeichert: " + saveName);

        druck.schreiben(saveName);
    }


}
