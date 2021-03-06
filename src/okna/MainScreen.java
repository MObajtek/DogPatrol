package okna;

import future.Photo;
import logistyka.*;
import logistyka.errand.Errand;
import logistyka.region_address.Address;
import logistyka.region_address.Region;
import logistyka.Walker;
import logistyka.Owner;
import logistyka.save_load.Load;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

public class MainScreen extends Thread {
    private JPanel mainPanel;
    private JButton addWalkerButton;
    private JButton addOwnerButton;
    private JComboBox walkerList;
    private JComboBox ownerList;
    private JPanel walkerPanel;
    private JPanel ownerPanel;
    private ArrayList<Errand> masterErrandList = new ArrayList<>();

    public MainScreen(ArrayList<Owner> owners, ArrayList<Walker> walkers) {
        this.startup(owners,walkers);
        walkerList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new WalkerGUI((Walker)walkerList.getSelectedItem(), masterErrandList);
                frame.pack();
                frame.setVisible(true);
            }
        });
        addWalkerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new AddWalker(walkerList);
                frame.pack();
                frame.setVisible(true);
            }
        });
        addOwnerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new AddOwner(ownerList);
                frame.pack();
                frame.setVisible(true);
            }
        });
        ownerList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new OwnerGUI((Owner)ownerList.getSelectedItem(),masterErrandList);
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
        File ownerDir = new File ("src\\res\\owners\\");
        ownerDir.mkdirs();
        File walkerDir = new File ("src\\res\\walkers\\");
        walkerDir.mkdirs();
        Owner owner;
        Walker walker;


        if (ownerDir.list().length > 0) {
            for (final File fileEntry : ownerDir.listFiles()) {
                owner = Load.loadOwner(fileEntry.getName());
                for (Errand errand:owner.getListOfErrands()) {
                    if (errand.isActive())
                        masterErrandList.add(errand);
                }
                ownerList.addItem(owner);
            }
        }
        if (walkerDir.list().length > 0) {
            for (final File fileEntry : walkerDir.listFiles()) {
                walkerList.addItem(Load.loadWalker(fileEntry.getName()));
            }
        }
    }




    public static void main(String[] args){
        Photo photo = new Photo();
        Region ownerRegion = new Region(new Address(0,0),60);
        Region walkerRegion = new Region(new Address(10,0),40);
        Pet pet = new Pet(new Description("Buba",1,ownerRegion,"Super zwierz 10/10"),"heterodontozaur",4);
        Owner owner = new Owner(new Description("Ma??go??ka m??wi?? mi",20,ownerRegion,"Warta jednej ??zy"),100);
        Walker walker = new Walker(new Description("Chcia??em mie?? tatua??e", 21,walkerRegion,"Chcia??em mie?? pe??ne sale"),0);
        ArrayList<Owner> owners = new ArrayList<>();
        owners.add(owner);
        ArrayList<Walker> walkers = new ArrayList<>();
        walkers.add(walker);


        JFrame frame = new JFrame("MainScreen");
        frame.setContentPane(new MainScreen(owners,walkers).mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
