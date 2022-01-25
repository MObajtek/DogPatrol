package okna;

import javax.swing.*;
import java.awt.*;

public class AddWalker extends JFrame{
    private JTextField walkerName;
    private JTextField walkerAddress;
    private JTextField walkerDescription;
    private JButton addWalkerButton;
    private JButton cancelButton;
    private JPanel mainPanel;

    public AddWalker() {
        setContentPane(mainPanel);
    }
}
