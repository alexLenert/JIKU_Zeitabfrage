import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Button_ZeigeBerichte implements ActionListener {

    JTextField berichtWählen;



    public Button_ZeigeBerichte(JTextField berichtWählen) {
        this.berichtWählen = berichtWählen;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Pressed");
        System.out.println(berichtWählen.getText());


    }
}
