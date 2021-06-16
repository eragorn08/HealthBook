package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class NavBarForm implements ActionListener {
    NavBarForm(){
        setNavPanel();
    }

    public void setNavPanel(){
        NavPanel = new JPanel();
        Spacer = new JPanel();
        Spacer.setBackground(new Color(0x212C58));
        //NavPanel.setLayout(null);
        NavPanel.setBackground(new Color(0x283469));

        NavPanel.add(addButton = new JButton("Add"));
        NavPanel.add(searchButton = new JButton("Search"));


        addButton.addActionListener(this);
        searchButton.addActionListener(this);


        addButton.setContentAreaFilled(false);
        addButton.setForeground(Color.white);
        searchButton.setContentAreaFilled(false);
        searchButton.setForeground(Color.white);



        addButton.setBounds(19, 56, 114, 44);
        searchButton.setBounds(19, 120, 114, 44);

        Spacer.setBounds(0, 60, 286, 24);
        Spacer.setVisible(true);
        NavPanel.setBounds(0, 84, 286, 720);
        NavPanel.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        System.out.println("Pressed");
        MainMenu main = new MainMenu();
        if(e.getSource() == addButton)
            main.tabbedPane.setSelectedIndex(1);

        if(e.getSource() == searchButton)
            main.tabbedPane.setSelectedIndex(2);
    }
    public JButton addButton,searchButton;
    public JPanel NavPanel, Spacer;
}
