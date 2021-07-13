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
        add(greetingL = new JLabel("Welcome to HealthBook, Nurse " + LoginForm.nurse+"!"));
        add(summaryL = new JLabel("Summary of Records"));
        add(buttonLabel = new JLabel("View Records by Department"));
        greetingL.setFont(new Font("Helvetica", Font.PLAIN, 40));
        greetingL.setForeground(Color.white);
        buttonLabel.setFont(new Font("Helvetica", Font.PLAIN, 25));
        buttonLabel.setForeground(Color.white);
        summaryL.setFont(new Font("Sans Serif", Font.PLAIN, 30));
        summaryL.setForeground(Color.white);

        add(pieButton = new JButton(new ImageIcon("piegraph.png")));
        pieButton.setBounds(275,231,430,242);
        pieButton.setFocusPainted(false);
        pieButton.addActionListener(e -> new PieChartForm());

        greetingL.setBounds(17, 20, 894, 68);
        summaryL.setBounds(347, 136, 286, 32);
        buttonLabel.setBounds(327, 508, 330, 27);

    }

    public JLabel greetingL, summaryL,buttonLabel;
    public JButton pieButton;
}
