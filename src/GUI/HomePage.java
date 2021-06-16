package GUI;

import javax.swing.*;
import java.awt.*;


public class HomePage {
    public HomePage(){
        home();
    }

    public void home(){
        DisplayPanel = new JPanel();
        DisplayPanel.setBackground(new Color(0x212C58));
        DisplayPanel.add(greetingL = new JLabel("Welcome back, Good Afternoon!"));
        DisplayPanel.add(summaryL = new JLabel("Summary of Records"));
        greetingL.setFont(new Font("Sans Serif", Font.PLAIN, 21));
        summaryL.setFont(new Font("Sans Serif", Font.PLAIN, 18));

        greetingL.setBounds(180, 10, 1100, 50);
        summaryL.setBounds(310, 120, 200, 50);
        //DisplayPanel.setVisible(true);
    }
    public JPanel DisplayPanel;
    public JLabel greetingL, summaryL;
}
