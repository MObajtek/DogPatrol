package okna;

import logistyka.Owner;
import logistyka.Pet;
import logistyka.errand.Errand;
import logistyka.region_address.Address;
import logistyka.save_load.Load;
import logistyka.save_load.Save;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class OwnerGUI extends JFrame{
    private JPanel mainPanel;
    private JLabel ownerAddressField;
    private JLabel ownerNameField;
    private JLabel ownerName;
    private JLabel ownerAddress;
    private JTextField walletValue;
    private JPanel mapa;
    private JButton transferMoneyButton;
    private JButton seeProfileButton;
    private JComboBox petList;
    private JComboBox currentErrandsComboBox;
    private JComboBox archivalErrandsComboBox;
    private JLabel errandIcon;
    private JButton addPetButton;
    private JLabel Wallet;
    private JLabel errandsList;
    private JButton refreshButton;
    ArrayList<Errand> masterErrandList = new ArrayList<>();

    public OwnerGUI(Owner owner, ArrayList<Errand> masterErrandList){
        setContentPane(mainPanel);
        errandIcon.setVisible(false);
        this.masterErrandList = masterErrandList;
        sortErrands();

        ownerNameField.setText(owner.getDescription().getName());
        ownerAddressField.setText(owner.getDescription().getHomeRegion().getCurrentAddress().toString());
        refresh(owner);
        seeProfileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new ProfileGUI(owner);
                frame.pack();
                frame.setVisible(true);
                refresh(owner);
            }
        });
        mapa.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent event) {
                super.mouseClicked(event);
                errandIcon.setLocation(event.getX(), event.getY());
                Address address = new Address(event.getX(),event.getY());
                JFrame frame = new OwnerErrandGUI(address,owner,currentErrandsComboBox, masterErrandList);
                errandIcon.setLocation(event.getX(), event.getY());
                errandIcon.setVisible(true);
                refresh(owner);
                errandIcon.setLocation(event.getX(), event.getY());
                frame.pack();
                frame.setVisible(true);
                refresh(owner);
            }

        });
        transferMoneyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                owner.setWalletStatus(owner.getWalletStatus()+10);
                refresh(owner);
            }
        });
        addPetButton.addActionListener(e -> {
            JFrame frame = new AddPet(owner, petList);
            frame.pack();
            frame.setVisible(true);
            refresh(owner);
//            frame.addWindowListener(new WindowAdapter() {
//                @Override
//                public void windowClosed(WindowEvent e) {
//                    refresh(owner);
//                }
//            });

        });
        this.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                Save.saveOwnerErrands(owner);
                Save.saveOwnerPets(owner);
            }
        });

        refreshButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                refresh(owner);
            }
        });
    }
    public void refresh(Owner o){
        walletValue.setText(String.valueOf(o.getWalletStatus()));
        Load.loadOwner(o.getDescription().getName());

        for (Pet pet: o.getListOfPets()) {
            if (((DefaultComboBoxModel)petList.getModel()).getIndexOf(pet) == -1)
                petList.addItem(pet);

        }
        for (Errand ownerErrand: o.getListOfErrands()) {
            if (((DefaultComboBoxModel)currentErrandsComboBox.getModel()).getIndexOf(ownerErrand) != -1 ||
                    ((DefaultComboBoxModel)archivalErrandsComboBox.getModel()).getIndexOf(ownerErrand) != -1){
                ;
            }
            else if(ownerErrand.isActive()){
                currentErrandsComboBox.addItem(ownerErrand);
            }
            else {
                archivalErrandsComboBox.addItem(ownerErrand);
            }

            if (!ownerErrand.isActive() && masterErrandList.contains(ownerErrand)){
                archivalErrandsComboBox.addItem(ownerErrand);
                currentErrandsComboBox.removeItem(ownerErrand);
            }

        }

    };

    public void sortErrands(){
        for (Errand errand: masterErrandList) {
            if (errand.isActive())
                currentErrandsComboBox.addItem(errand);
            else
                archivalErrandsComboBox.addItem(errand);
        }
    }



}
