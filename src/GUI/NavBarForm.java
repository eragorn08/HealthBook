package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NavBarForm extends JFrame implements ActionListener {
    public NavBarForm() {
        super("Health Book");

        setNavPanel();

        setVisible(true);
        setSize(1280, 720);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
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
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton){
            setVisible(false);
            AddForm addForm = new AddForm();
        }
    }

    public JPanel NavPanel;
    public JButton addButton,searchButton;
}
