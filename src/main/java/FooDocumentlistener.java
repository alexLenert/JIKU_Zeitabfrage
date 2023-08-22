import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class FooDocumentlistener implements DocumentListener {

    String text;

    public FooDocumentlistener(String text) {
        this.text = text;
    }

    @Override
    public void insertUpdate(DocumentEvent e) {

    }

    @Override
    public void removeUpdate(DocumentEvent e) {

    }

    @Override
    public void changedUpdate(DocumentEvent e) {

    }
}
