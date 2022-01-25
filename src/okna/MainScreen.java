package okna;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainScreen {
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

            }
        });
    }

    public static void main(String[] args){
        JFrame frame = new JFrame("MainScreen");
        frame.setContentPane(new MainScreen().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
