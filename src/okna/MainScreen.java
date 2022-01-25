package okna;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainScreen extends Thread {
    private JPanel mainPanel;
    private JButton addWalkerButton;
    private JButton addOwnerButton;
    private JComboBox walkerList;
    private JComboBox ownerList;
    private JPanel walkerPanel;
    private JPanel ownerPanel;

    public MainScreen() {
        walkerList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new WalkerGUI();
                frame.pack();
                frame.setVisible(true);
            }
        });
        addWalkerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new WalkerGUI();
                frame.pack();
                frame.setVisible(true);
            }
        });
        addOwnerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new OwnerGUI();
                frame.pack();
                frame.setVisible(true);
            }
        });
        ownerList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new OwnerGUI();
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
    public static void main(String[] args){
        JFrame frame = new JFrame("MainScreen");
        frame.setContentPane(new MainScreen().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
