package okna;

import logistyka.Description;
import logistyka.Owner;
import logistyka.Pet;
import logistyka.region_address.Address;
import logistyka.region_address.Region;
import logistyka.save_load.Save;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddPet extends JFrame {
    private JPanel panelMain;
    private JButton cancelButton;
    private JButton addPetButton;
    private JSlider petActivity;
    private JTextField petBreed;
    private JTextField petBio;
    private JTextField petAddressY;
    private JTextField petAddressX;
    private JTextField petAge;
    private JTextField petName;

    public AddPet(Owner owner, JComboBox petList) {
        setContentPane(panelMain);
        addPetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Pet pet = new Pet(new Description(
                        petName.getText(),
                        Integer.parseInt(petAge.getText()),
                        new Region(new Address(Double.parseDouble(petAddressX.getText()),Double.parseDouble(petAddressY.getText()))),
                        petBio.getText()),
                        petBreed.getText(),
                        petActivity.getValue());
                Save.savePetInfo(pet, owner.getDescription().getName());
                petList.addItem(pet);
                dispose();

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
