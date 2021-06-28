package GUI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class SearchForm extends JPanel {
    public SearchForm(){
        setLayout(null);
        setBackground(new Color(0x212C58));
        searchform();
        searchformtitle();
    }
    public void searchformtitle(){



        JLabel searchPatientTitle = new JLabel("Search Patient");
        searchPatientTitle.setFont(new Font("Helvetica", Font.PLAIN, 40));
        searchPatientTitle.setForeground(Color.white);
        searchPatientTitle.setBounds(22, 19, 275, 55);
        add(searchPatientTitle);
    }

    public void searchform(){
        JPanel searchFormPanel = new JPanel();
        searchFormPanel.setLayout(new FlowLayout( FlowLayout.LEFT));
        searchFormPanel.setBackground(new Color(0x212C58));
        searchFormPanel.setBorder(new EmptyBorder(8,22,0,22));
        //searchFormPanel.setSize(994,579);
        searchFormPanel.setBounds(0,75,994,579);


        //search label
        JLabel search_label = new JLabel("Search:");
        search_label.setFont(new Font("Helvetica", Font.PLAIN, 20));
        search_label.setForeground(Color.WHITE);
        searchFormPanel.add(search_label);

        //search field
        JTextField search_field = new JTextField(50);
        search_field.setSize(561,40);
        search_field.setBackground(new Color(0x4b5576));
        searchFormPanel.add(search_field);

        add(searchFormPanel);
    }

}
