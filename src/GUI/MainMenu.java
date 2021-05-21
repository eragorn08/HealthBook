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

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(640, 480);
        setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);

    }

    public void setNavPanel(){
        NavPanel = new JPanel();
        NavPanel.setLayout(null);

        NavPanel.add(addButton = new JButton("Add"));
        NavPanel.add(searchButton = new JButton("Search"));

        addButton.setContentAreaFilled(false);
        addButton.setForeground(Color.white);
        searchButton.setContentAreaFilled(false);
        searchButton.setForeground(Color.white);

        addButton.addActionListener(this);
        searchButton.addActionListener(this);

        NavPanel.setBounds(0, 0, 160, 480);
        addButton.setBounds(19, 56, 114, 44);
        searchButton.setBounds(19, 120, 114, 44);

        NavPanel.setVisible(true);
        NavPanel.setBackground(Color.DARK_GRAY);
        getContentPane().add(NavPanel);
    }

    public void setDisplayPanel(){
        DisplayPanel = new JPanel();
        DisplayPanel.setLayout(null);

        DisplayPanel.add(greetingL = new JLabel("Welcome back, Good Afternoon!"));
        DisplayPanel.add(summaryL = new JLabel("Summary of Records"));
        greetingL.setFont(new Font("Sans Serif", Font.PLAIN, 21));
        summaryL.setFont(new Font("Sans Serif", Font.PLAIN, 18));

        DisplayPanel.setBounds(160, 0, 480, 480);
        greetingL.setBounds(25, 10, 480, 50);
        summaryL.setBounds(150, 120, 200, 50);

        DisplayPanel.setVisible(true);
        DisplayPanel.setBackground(Color.cyan);
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
