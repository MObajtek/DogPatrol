package okna;

import logistyka.Walker;
import logistyka.errand.Errand;
import logistyka.errand.WalkersErrand;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

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
    private JButton payOutButton;
    private JButton seeProfileButton;
    private JPanel mapa;
    private JLabel walkerLocation = new JLabel();

    public WalkerGUI(Walker walker, ArrayList<Errand> masterErrandList)  {
        setContentPane(mainPanel);
        walkerLocation.setLocation((int)walker.getDescription().getHomeRegion().getCurrentAddress().getX(),(int)walker.getDescription().getHomeRegion().getCurrentAddress().getY());
        walkerLocation.setVisible(false);
        walkerNameField.setText(walker.getDescription().getName());
        walkerAddressField.setText(walker.getDescription().getHomeRegion().getCurrentAddress().toString());
        walletValue.setText(String.valueOf(walker.getWalletStatus()));

        seeProfileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new ProfileGUI(walker);
                frame.pack();
                frame.setVisible(true);
            }
        });
        payOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                walker.setWalletStatus(0);
                walletValue.setText(String.valueOf(walker.getWalletStatus()));
            }
        });
        searchErrandsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Errand errand:masterErrandList) {
                    errandsComboBox.addItem(new WalkersErrand(errand,walker));
                }
                walkerLocation.setVisible(true);
            }
        });

        errandsComboBox.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                JFrame frame = new WalkerErrandGUI((Errand) errandsComboBox.getSelectedItem(),errandsComboBox,masterErrandList);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }



}
