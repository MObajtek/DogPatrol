package okna;

import logistyka.Owner;
import logistyka.Pet;
import logistyka.errand.Errand;
import logistyka.region_address.Address;
import logistyka.save_load.Load;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Enumeration;

public class OwnerGUI extends JFrame {
    private JPanel mainPanel;
    private JLabel ownerAddressField;
    private JLabel ownerNameField;
    private JLabel ownerName;
    private JLabel ownerAddress;
    private JComboBox errandsComboBox;
    private JTextField walletValue;
    private JPanel mapa;
    private JButton transferMoneyButton;
    private JRadioButton archivalErrandsRadioButton;
    private JRadioButton currentErrandsRadioButton;
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
        this.masterErrandList = masterErrandList;
        sortErrands();

        setContentPane(mainPanel);

        ButtonGroup group = new ButtonGroup();
        group.add(archivalErrandsRadioButton);
        group.add(currentErrandsRadioButton);

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
                Address address = new Address(event.getX(),event.getY());
                errandIcon.setLocation(event.getX(), event.getY());
                JFrame frame = new ErrandGUI(address,owner);
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
        errandsComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Enumeration<AbstractButton> buttons = group.getElements(); buttons.hasMoreElements();) {
                    AbstractButton button = buttons.nextElement();
                    if (button.isSelected() && button.getText().equalsIgnoreCase("Current Errands")) {
                        errandsComboBox = currentErrandsComboBox;
                    }
                    else if (button.isSelected() && button.getText().equalsIgnoreCase("Archival Errands"))
                        errandsComboBox = archivalErrandsComboBox;
                }
            }
        });

        addPetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new AddPet(owner);
                frame.pack();
                frame.setVisible(true);
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

}
