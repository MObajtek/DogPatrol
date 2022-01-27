package okna;

import logistyka.Owner;
import logistyka.Pet;
import logistyka.errand.Errand;
import logistyka.region_address.Address;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ErrandGUI extends JFrame{
    private JTextField ownerNameField;
    private JButton ownerSeeProfileButton;
    private JButton petSeeProfileButton;
    private JTextField paymentField;
    private JTextField timeField;
    private JButton discardErrandButton;
    private JButton acceptErrandButton;
    private JPanel panelMain;
    private JTextField addressField;
    private JComboBox petComboBox;

    public ErrandGUI(Address address, Owner owner){
        setContentPane(panelMain);
        ownerNameField.setText(owner.getDescription().getName());
        addressField.setText(address.toString());
        if (owner.getListOfPets().isEmpty()){
            System.out.println("Nie istnieje zwierzę, dla którego można stworzyć zlecenie");
            dispose();
        }
        for (Pet pet: owner.getListOfPets()) {
            petComboBox.addItem(pet);
        }
        ownerSeeProfileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new ProfileGUI(owner);
                frame.pack();
                frame.setVisible(true);
            }
        });

        acceptErrandButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int pay = 50;
                int time = 60;
                try{
                pay = Integer.valueOf(paymentField.getText());}
                catch(Exception e1){
                    System.out.println("Brak wpisanej wartości lub ma zły format, wybrano domyślne 50");
                }
                try{
                    time = Integer.valueOf(timeField.getText());}
                catch(Exception e1){
                    System.out.println("Brak wpisanej wartości lub ma zły format, wybrano domyślne 60");
                }
                try{
                Errand errand = new Errand(address,pay,time,true,((Pet)petComboBox.getSelectedItem()).getDescription().getName());
                owner.getListOfErrands().add(errand);
                dispose();}catch(Exception e1) { System.out.println("Nie wybrano zwierzaka, hmmm?");}           }
        });
        discardErrandButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {{
                    dispose();
            }
        }
        });

        petSeeProfileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Pet pet = (Pet)(petComboBox.getSelectedItem());
                JFrame frame = new ProfileGUI(pet);
                frame.pack();
                frame.setVisible(true);

            }
        });
    }
    }
