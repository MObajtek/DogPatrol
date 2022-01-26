package okna;

import logistyka.Walker;
import logistyka.Owner;
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
    public void startup(ArrayList<Review> reviews_,JComboBox<Review> reviews){
        for (Review r:reviews_) {
            reviews.addItem(r);
        }

    }
    public ProfileGUI(Walker w)  {
        walker = w;
        setContentPane(panelMain);
        nameField.setText(w.getWalkerDescription().getName());
        ageField.setText(String.valueOf(w.getWalkerDescription().getAge()));
        addressTextField.setText(w.getWalkerDescription().getHomeRegion().getCurrentAddress().toString());
        bioTextArea.setText(w.getWalkerDescription().getBio());
        startup(w.getReviewsOfWalker(),reviewsComboBox);

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
            nameField.setText(owner.getOwnerDescription().getName());
            ageField.setText(String.valueOf(o.getOwnerDescription().getAge()));
            addressTextField.setText(o.getOwnerDescription().getHomeRegion().getCurrentAddress().toString());
            bioTextArea.setText(o.getOwnerDescription().getBio());
            startup(o.getReviewsOfOwner(),reviewsComboBox);

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
