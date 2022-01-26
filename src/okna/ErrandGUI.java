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

    public ErrandGUI(Address a, Owner o){
        setContentPane(panelMain);
        ownerNameField.setText(o.getDescription().getName());
        addressField.setText(a.toString());
        ownerSeeProfileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new ProfileGUI(o);
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
                //trzeba opakować try catchem jakby ktoś nie wybrał zwierza
                Errand errand = new Errand(a,pay,time,true,((Pet)petComboBox.getSelectedItem()).getDescription().getName());
                o.getListOfErrands().add(errand);
                dispose();
            }
        });
        discardErrandButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {{
                    dispose();
            }
        }
        });

}
    }
