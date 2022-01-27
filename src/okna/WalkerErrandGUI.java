package okna;

import logistyka.Owner;
import logistyka.Pet;
import logistyka.errand.Errand;
import logistyka.region_address.Address;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class WalkerErrandGUI extends JFrame{
    private JButton acceptErrandButton;
    private JLabel errandAddressText;
    private JLabel errandPaymentText;
    private JLabel errandTimeText;
    private JLabel petNameText;
    private JButton cancelButton;
    private JPanel panelMain;
    private JTextField addressField;
    private JComboBox petComboBox;

    public WalkerErrandGUI(Errand errand, JComboBox currentList, ArrayList<Errand> masterErrandList){
        setContentPane(panelMain);

        errandAddressText.setText(errand.getAddress().toString());
        errandPaymentText.setText(String.valueOf(errand.getPayment()));
        errandTimeText.setText(String.valueOf(errand.getTime()));
        petNameText.setText(errand.getPetName());


        acceptErrandButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentList.removeItem(errand);
                errand.setActive(false);
                masterErrandList.remove(errand);
            }


        });
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {{
                dispose();
            }
            }
        });

    }
}
