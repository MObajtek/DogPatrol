package okna;

import logistyka.Owner;
import logistyka.Pet;
import logistyka.Walker;
import logistyka.review.Review;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ProfileGUI extends JFrame {
    Walker walker;
    Owner owner;
    private JComboBox reviewsComboBox;
    private JTextField nameField;
    private JTextField ageField;
    private JTextField addressTextField;
    private JTextArea bioTextArea;
    private JPanel panelMain;
    private JLabel PHOTO;
    private JPanel photoPanel;

    public void startup(ArrayList<Review> reviews_,JComboBox<Review> reviews){
        for (Review r:reviews_) {
            reviews.addItem(r);
        }

    }
    public ProfileGUI(Walker w)  {
        PHOTO = new JLabel("PHOTO", JLabel.CENTER);
        walker = w;
        setContentPane(panelMain);
        nameField.setText(w.getDescription().getName());
        ageField.setText(String.valueOf(w.getDescription().getAge()));
        addressTextField.setText(w.getDescription().getHomeRegion().getCurrentAddress().toString());
        bioTextArea.setText(w.getDescription().getBio());




        startup(w.getReviews(),reviewsComboBox);

        reviewsComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Review r = (Review) reviewsComboBox.getSelectedItem();
              JFrame frame = new ReviewGUI(r);
                frame.pack();
                frame.setVisible(true);
            }
        });}
        public ProfileGUI(Owner o)  {
             owner = o;
            setContentPane(panelMain);
            nameField.setText(owner.getDescription().getName());
            ageField.setText(String.valueOf(o.getDescription().getAge()));
            addressTextField.setText(o.getDescription().getHomeRegion().getCurrentAddress().toString());
            bioTextArea.setText(o.getDescription().getBio());

            startup(o.getReviews(),reviewsComboBox);

            reviewsComboBox.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Review r = (Review) reviewsComboBox.getSelectedItem();
                    JFrame frame = new ReviewGUI(r);
                    frame.pack();
                    frame.setVisible(true);
                }
            });
    }
    public ProfileGUI(Pet p)  {
        setContentPane(panelMain);
        nameField.setText(p.getDescription().getName());
        ageField.setText(String.valueOf(p.getDescription().getAge()));
        addressTextField.setText(p.getDescription().getHomeRegion().getCurrentAddress().toString());
        bioTextArea.setText(p.getDescription().getBio());
        //startup(p.getReviews(),reviewsComboBox); //TRZEBA DODAC REVIEWS DO ZWIERZA, albo zbudowac nowy profilGUI

        reviewsComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Review r = (Review) reviewsComboBox.getSelectedItem();
                JFrame frame = new ReviewGUI(r);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }

}
