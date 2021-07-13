package GUI;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class HomePageDoctor extends JPanel{
    public HomePageDoctor(){
        setLayout(null);
        home();
    }
    public void GetName(){
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connect = connectNow.getConnection();

        String Identify = "SELECT LastName FROM accounts WHERE username = '" +LoginForm.emid+ "'";
        try{
            Statement st = connect.createStatement();
            ResultSet rs = st.executeQuery(Identify);
            if(rs.next()) {
                LastName = rs.getString("LastName");
             }}
        catch(Exception e){
            e.getCause();
            e.printStackTrace();
        }
    }

    public void home(){
        GetName();
        setBackground(new Color(0x212C58));
        add(greetingL = new JLabel("Welcome to HealthBook, Doctor " + LastName));
        add(summaryL = new JLabel("Summary of Records"));
        add(buttonLabel = new JLabel("View Records by Department"));
        buttonLabel.setFont(new Font("Helvetica", Font.PLAIN, 25));
        buttonLabel.setForeground(Color.white);
        greetingL.setFont(new Font("Helvetica", Font.PLAIN, 40));
        greetingL.setForeground(Color.white);
        summaryL.setFont(new Font("Sans Serif", Font.PLAIN, 30));
        summaryL.setForeground(Color.white);
        add(pieButton = new JButton(new ImageIcon("piegraph.png")));
        pieButton.setBounds(275,231,430,242);
        pieButton.setFocusPainted(false);
        pieButton.addActionListener(e -> new PieChartForm());

        greetingL.setBounds(17, 20, 894, 68);
        summaryL.setBounds(347, 136, 286, 32);
        buttonLabel.setBounds(327, 508, 330, 27);
        //DisplayPanel.setVisible(true);
    }
    public JLabel greetingL, summaryL, buttonLabel;
    public JButton pieButton;
    public String LastName;
}
