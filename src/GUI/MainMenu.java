package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import GUI.AddForm.*;

public class MainMenu extends JFrame{

    public MainMenu() {

        super("Health Book");

        NavBarForm navbar = new NavBarForm();
        setDisplayPanel();

        setVisible(true);
        setSize(640, 480);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
//        setLayout(null);
        setResizable(false);
    }

    public void setDisplayPanel(){
        DisplayPanel = new JPanel();
        DisplayPanel.setLayout(null);
        DisplayPanel.setBackground(Color.cyan);

        DisplayPanel.add(greetingL = new JLabel("Welcome back, Good Afternoon!"));
        DisplayPanel.add(summaryL = new JLabel("Summary of Records"));
        greetingL.setFont(new Font("Sans Serif", Font.PLAIN, 21));
        summaryL.setFont(new Font("Sans Serif", Font.PLAIN, 18));

        greetingL.setBounds(180, 10, 480, 50);
        summaryL.setBounds(310, 120, 200, 50);

        DisplayPanel.setBounds(0, 0, 480, 480);
        DisplayPanel.setVisible(true);
        getContentPane().add(DisplayPanel);
    }

    public JPanel DisplayPanel;
    public JLabel greetingL, summaryL;

}
