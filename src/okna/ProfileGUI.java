package okna;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProfileGUI extends JFrame {
    private JComboBox reviewsComboBox;
    private JTextField nameField;
    private JTextField textField1;
    private JTextField textField2;
    private JTextArea bioTextArea;
    private JPanel panelMain;
    public ProfileGUI()  {
        setContentPane(panelMain);

        reviewsComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              JFrame frame = new ReviewGUI();
                frame.pack();
                frame.setVisible(true);
            }
        });
    }

}
