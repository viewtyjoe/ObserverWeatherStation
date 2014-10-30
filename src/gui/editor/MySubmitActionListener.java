package gui.editor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author jlombardo
 */
public class MySubmitActionListener implements ActionListener {
    private final MyCustomWindow window;
    
    public MySubmitActionListener(MyCustomWindow window) {
        this.window = window;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JLabel label = window.getLblMessage();
        label.setText(label.getText() + window.getWindowTitle());
    }
    
}
