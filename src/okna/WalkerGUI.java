package okna;

import logistyka.Walker;

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

    public WalkerGUI(Walker w)  {
        setContentPane(mainPanel);
        walkerNameField.setText(w.getDescription().getName());
        walkerAddressField.setText(w.getDescription().getHomeRegion().getCurrentAddress().toString());
        walletValue.setText(String.valueOf(w.getWalletSatus()));
        seeProfileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new ProfileGUI(w);
                frame.pack();
                frame.setVisible(true);
            }
        });
        payOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                w.setWalletSatus(0);
                walletValue.setText(String.valueOf(w.getWalletSatus()));
            }
        });
    }



}
