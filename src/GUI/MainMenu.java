package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import GUI.AddForm.*;

public class MainMenu extends JFrame implements ActionListener{

    public MainMenu() {

        super("Health Book");

        setNavPanel();
        setDisplayPanel();

        setVisible(true);
        setSize(640, 480);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
//        setLayout(null);
        setResizable(false);

    }

    public void setNavPanel(){
        NavPanel = new JPanel();
        NavPanel.setLayout(null);
        NavPanel.setBackground(Color.DARK_GRAY);

        NavPanel.add(addButton = new JButton("Add"));
        NavPanel.add(searchButton = new JButton("Search"));

        addButton.setContentAreaFilled(false);
        addButton.setForeground(Color.white);
        searchButton.setContentAreaFilled(false);
        searchButton.setForeground(Color.white);

        addButton.addActionListener(this);
        searchButton.addActionListener(this);

        addButton.setBounds(19, 56, 114, 44);
        searchButton.setBounds(19, 120, 114, 44);

        NavPanel.setBounds(0, 0, 160, 480);
        NavPanel.setVisible(true);
        getContentPane().add(NavPanel);
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

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton){
            setVisible(false);
            AddForm addForm = new AddForm();
        }
    }

    public JPanel NavPanel, DisplayPanel;
    public JButton addButton, searchButton;
    public JLabel greetingL, summaryL;

}
