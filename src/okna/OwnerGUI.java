package okna;

import logistyka.Owner;
import logistyka.Pet;
import logistyka.errand.Errand;
import logistyka.region_address.Address;
import logistyka.save_load.Load;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Enumeration;

public class OwnerGUI extends JFrame {
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
    ArrayList<Errand> masterErrandList = new ArrayList<>();

    public OwnerGUI(Owner owner, ArrayList<Errand> masterErrandList){
        errandIcon.setVisible(false);
        this.masterErrandList = masterErrandList;
        sortErrands();

        setContentPane(mainPanel);


        ownerNameField.setText(owner.getDescription().getName());
        ownerAddressField.setText(owner.getDescription().getHomeRegion().getCurrentAddress().toString());



        refresh(owner);


        seeProfileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new ProfileGUI(owner);
                frame.pack();
                frame.setVisible(true);
            }
        });
        mapa.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent event) {
                super.mouseClicked(event);
                errandIcon.setLocation(event.getX(), event.getY());
                Address address = new Address(event.getX(),event.getY());
                JFrame frame = new ErrandGUI(address,owner,currentErrandsComboBox);
                errandIcon.setVisible(true);
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
//            frame.addWindowListener(new WindowAdapter() {
//                @Override
//                public void windowClosed(WindowEvent e) {
//                    refresh(owner);
//                }
//            });

        });

    }
    public void refresh(Owner o){
        walletValue.setText(String.valueOf(o.getWalletStatus()));
        Load.loadOwner(o.getDescription().getName());
        for (Pet pet: o.getListOfPets()) {
            if (((DefaultComboBoxModel)petList.getModel()).getIndexOf(pet) == -1)
                petList.addItem(pet);

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

    public void startup(){

    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
