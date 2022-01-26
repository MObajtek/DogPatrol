package okna;

import logistyka.Owner;
import logistyka.region_address.Address;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class OwnerGUI extends JFrame {
    private JPanel mainPanel;
    private JTextField ownerAddressField;
    private JTextField ownerNameField;
    private JLabel ownerName;
    private JLabel ownerAddress;
    private JComboBox currentErrandsComboBox;
    private JLabel errandsList;
    private JLabel Wallet;
    private JTextField walletValue;
    private JPanel mapa;
    private JLabel Map;
    private JButton transferMoneyButton;
    private JRadioButton archivalErrandsRadioButton;
    private JRadioButton currentErrandsRadioButton;
    private JButton seeProfileButton;
    private JComboBox comboBox1;
    public OwnerGUI(Owner o){
        setContentPane(mainPanel);
        refresh(o);

        seeProfileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new ProfileGUI(o);
                frame.pack();
                frame.setVisible(true);
            }
        });


        mapa.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                Address a = new Address(e.getX(),e.getY());
                mapa = new JPanel(); //na internetach tak mieli, nie pomogło
                mapa.setLayout(null);
                JLabel newErrand = new JLabel("XXXXXXXXXX"); //nie wiadomo czemu się nie pojawia
                newErrand.setLocation(e.getX(), e.getY());
                mapa.add(newErrand);
                JFrame frame = new ErrandGUI(a,o);
                frame.pack();
                frame.setVisible(true);
                refresh(o);
            }

        });


        transferMoneyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                o.setWalletStatus(o.getWalletStatus()+10);
                refresh(o);
            }
        });

    }
    public void refresh(Owner o){
        ownerNameField.setText(o.getDescription().getName());
        ownerAddressField.setText(o.getDescription().getHomeRegion().getCurrentAddress().toString());
        walletValue.setText(String.valueOf(o.getWalletStatus()));
    };

}
