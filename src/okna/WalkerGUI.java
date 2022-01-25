package okna;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WalkerGUI extends JFrame{
    private JPanel mainPanel;
    private JLabel walkerName;
    private  JTextField walkerNameField;
    private JLabel walkerAddress;
    private  JTextField walkerAddressField;
    private JButton searchErrandsButton;
    private JComboBox errandsComboBox;
    private JLabel errandsList;
    private JTextField walletValue;
    private JLabel Wallet;
    private JPanel mapa;
    private JLabel Map;
    private JRadioButton archivalErrandsRadioButton;
    private JRadioButton currentErrandsRadioButton;
    private JButton payOutButton;
    private JButton seeProfileButton;

    public WalkerGUI()  {
        setContentPane(mainPanel);
        seeProfileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new ProfileGUI();
                frame.pack();
                frame.setVisible(true);
            }
        });
    }



}
