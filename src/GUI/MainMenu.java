package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JFrame implements ActionListener{

    public MainMenu() {

        super("Health Book");



        setVisible(true);
        setSize(1280, 720);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //setLocationRelativeTo(null);
        setLayout(null);

        //NavBarForm navbar = new NavBarForm();

        //navbar.addButton.addActionListener(this);
        //navbar.searchButton.addActionListener(this);
        Header header = new Header();
        setResizable(false);
        //add(navbar.Spacer);
        //add(navbar.NavPanel);
        setNavPanel();
        add(header.head);
        setDisplayPanel();
    }

    public void setNavPanel(){
        NavPanel = new JPanel();
        Spacer = new JPanel();
        Spacer.setBackground(new Color(0x212C58));
        //NavPanel.setLayout(null);
        NavPanel.setBackground(new Color(0x283469));

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

        Spacer.setBounds(0, 60, 286, 24);
        Spacer.setVisible(true);
        NavPanel.setBounds(0, 84, 286, 720);
        NavPanel.setVisible(true);
        add(NavPanel);
    }


    public void setDisplayPanel(){
        DisplayPanel = new JPanel();
        //DisplayPanel.setLayout(null);
        DisplayPanel.setBackground(new Color(0x212C58));

        DisplayPanel.add(greetingL = new JLabel("Welcome back, Good Afternoon!"));
        DisplayPanel.add(summaryL = new JLabel("Summary of Records"));
        greetingL.setFont(new Font("Sans Serif", Font.PLAIN, 21));
        summaryL.setFont(new Font("Sans Serif", Font.PLAIN, 18));

        greetingL.setBounds(180, 10, 1100, 50);
        summaryL.setBounds(310, 120, 200, 50);

        DisplayPanel.setBounds(286, 60, 1100, 720);
        DisplayPanel.setVisible(true);
        add(DisplayPanel);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton){
            remove(DisplayPanel);
            System.out.println("Hello");
            AddForm addPage = new AddForm();
            //add(addPage.AddPanel);

        }
    }
    public JPanel DisplayPanel, NavPanel, Spacer;
    public JLabel greetingL, summaryL;
    public JButton addButton, searchButton;

}
