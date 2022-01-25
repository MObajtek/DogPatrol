package okna;

import javax.swing.*;

public class OwnerGUI extends JFrame {
    private JPanel mainPanel;
    private JTextField walkerAddressField;
    private JTextField walkerNameField;
    private JLabel walkerName;
    private JLabel walkerAddress;
    private JButton placeErrandButton;
    private JComboBox currentErrandsComboBox;
    private JLabel errandsList;
    private JLabel Wallet;
    private JTextField walletValue;
    private JPanel mapa;
    private JLabel Map;
    private JButton transferMoneyButton;
    private JRadioButton archivalErrandsRadioButton;
    private JRadioButton currentErrandsRadioButton;

    public OwnerGUI(){
        setContentPane(mainPanel);
    }
    private JButton seeProfileButton;
}
