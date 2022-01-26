package okna;

import logistyka.*;
import logistyka.region_address.Address;
import logistyka.region_address.Region;
import logistyka.Walker;
import logistyka.Owner;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MainScreen extends Thread {
    private JPanel mainPanel;
    private JButton addWalkerButton;
    private JButton addOwnerButton;
    private JComboBox walkerList;
    private JComboBox ownerList;
    private JPanel walkerPanel;
    private JPanel ownerPanel;

    public MainScreen(ArrayList<Owner> owners, ArrayList<Walker> walkers) {
        this.startup(owners,walkers);
        walkerList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new WalkerGUI((Walker)walkerList.getSelectedItem());
                frame.pack();
                frame.setVisible(true);
            }
        });
        addWalkerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new AddUser();
                frame.pack();
                frame.setVisible(true);
            }
        });
        addOwnerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new AddUser();
                frame.pack();
                frame.setVisible(true);
            }
        });
        ownerList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new OwnerGUI((Owner)ownerList.getSelectedItem());
                frame.pack();
                frame.setVisible(true);
            }
        });

    }


    public void refresh(){

    }

    @Override
    public void run() {
        while (true){
            refresh();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void startup(ArrayList<Owner> owners, ArrayList<Walker> walkers){
        for (Owner owner:owners) {
            ownerList.addItem(owner);
        }
        for (Walker walker:walkers) {
            walkerList.addItem(walker);
        }

    }


    public static void main(String[] args){
        Photo photo = new Photo();
        Region ownerRegion = new Region(new Address(0,0),60);
        Region walkerRegion = new Region(new Address(10,0),40);
        Pet pet = new Pet("Buba",1,ownerRegion,photo,"Super zwierz 10/10","heterodontozaur",4);
        Owner owner = new Owner(new Description("Małgośka mówią mi",20,ownerRegion,photo,"Warta jednej łzy"),100);
        Walker walker = new Walker(new Description("Chciałem mieć tatuaże", 21,walkerRegion,photo,"Chciałem mieć pełne sale"),0);
        ArrayList<Owner> owners = new ArrayList<>();
        owners.add(owner);
        ArrayList<Walker> walkers = new ArrayList<>();
        walkers.add(walker);
        System.out.println(owner.toHashmap());


        JFrame frame = new JFrame("MainScreen");
        frame.setContentPane(new MainScreen(owners,walkers).mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
