package okna;

import logistyka.Description;
import logistyka.Owner;
import logistyka.Walker;
import logistyka.region_address.Address;
import logistyka.region_address.Region;
import logistyka.save_load.Save;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class AddWalker extends JFrame {
    private JTextField userName;
    private JTextField userBio;
    private JButton addButton;
    private JButton cancelButton;
    private JTextField userAge;
    private JPanel panelMain;
    private JTextField userAddressX;
    private JTextField userAddressY;

    public AddWalker(JComboBox walkerList) {
        setContentPane(panelMain);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Walker walker = new Walker(new Description(
                            userName.getText(),
                            Integer.parseInt(userAge.getText()),
                            new Region(new Address(Double.parseDouble(userAddressX.getText()),Double.parseDouble(userAddressY.getText()))),
                            userBio.getText()));
                    Save.saveWalker(walker);
                    walkerList.addItem(walker);

                } catch (IOException ex) {
                    ex.printStackTrace();
                } finally {
                    dispose();
                }
            }
        });
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
}
