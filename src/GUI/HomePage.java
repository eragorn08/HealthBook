package GUI;

import javax.swing.*;
import java.awt.*;

public class HomePage extends JPanel{
    public HomePage(){
        setLayout(null);
        home();
    }

    public void home(){
        setBackground(new Color(0x212C58));
        add(greetingL = new JLabel("Welcome to HealthBook, Nurse!"));
        add(summaryL = new JLabel("Summary of Records"));
        greetingL.setFont(new Font("Helvetica", Font.PLAIN, 40));
        greetingL.setForeground(Color.white);
        summaryL.setFont(new Font("Sans Serif", Font.PLAIN, 30));
        summaryL.setForeground(Color.white);

        greetingL.setBounds(17, 20, 894, 68);
        summaryL.setBounds(347, 136, 286, 32);
        //DisplayPanel.setVisible(true);
    }
    public JLabel greetingL, summaryL;
}
