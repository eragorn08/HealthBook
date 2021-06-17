package GUI;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import javax.swing.JFrame;

public class AddForm extends JPanel{
    public AddForm(){
        setLayout(null);
        addFormTitle();
        addForm();
    }
    public void addFormTitle(){
        setBackground(new Color(0x212C58));
        AddPatientTitle = new JLabel("Add Patient");
        AddPatientTitle.setFont(new Font("Helvetica", Font.PLAIN, 40));
        AddPatientTitle.setForeground(Color.white);
        AddPatientTitle.setBounds(22, 19, 275, 55);
        add(AddPatientTitle);
    }

    public void addForm(){
        Border border = new LineBorder(Color.WHITE,1,false);
        AddFormPanel = new JPanel();
        AddFormPanel.setBorder(border);
        AddFormPanel.setBackground(new Color(0x2e3861));
        AddFormPanel.setBounds(0,75,976,545);


        //Create a text field



        add(AddFormPanel);
    }


    private JLabel AddPatientTitle;
    private JPanel AddFormPanel;
    private JTextField NameField;
}

