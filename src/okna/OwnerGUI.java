package okna;
import logistyka.Owner;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OwnerGUI extends JFrame {
    private JPanel mainPanel;
    private JTextField ownerAddressField;
    private JTextField ownerNameField;
    private JLabel ownerName;
    private JLabel ownerAddress;
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
    private JButton seeProfileButton;
    private JComboBox comboBox1;

    public OwnerGUI(Owner o){
        setContentPane(mainPanel);
        ownerNameField.setText(o.getOwnerDescription().getName());
        ownerAddressField.setText(o.getOwnerDescription().getHomeRegion().getCurrentAddress().toString());
        seeProfileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new ProfileGUI(o);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }

}
