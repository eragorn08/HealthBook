package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import javax.swing.JFrame;

public class AddForm{
    public void addForm(){
        AddPanel = new JPanel();
        //DisplayPanel.setLayout(null);
        AddPanel.setBackground(new Color(0x214E58));

        AddPanel.add(greetingL = new JLabel("Welcome back, Good Afternoon!"));
        AddPanel.add(summaryL = new JLabel("Summary of Records"));
        greetingL.setFont(new Font("Sans Serif", Font.PLAIN, 21));
        summaryL.setFont(new Font("Sans Serif", Font.PLAIN, 18));

        greetingL.setBounds(180, 10, 1100, 50);
        summaryL.setBounds(310, 120, 200, 50);

        AddPanel.setBounds(286, 60, 1100, 720);
        AddPanel.setVisible(true);
        //add(AddPanel);
    }
    public JPanel AddPanel;
    public JLabel greetingL, summaryL;
}
