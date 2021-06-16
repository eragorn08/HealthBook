package GUI;

import javax.swing.*;
import java.awt.*;

public class SearchForm {
    public SearchForm(){
        searchform();
    }
    public void searchform(){
        SearchPanel = new JPanel();
        //DisplayPanel.setLayout(null);
        SearchPanel.setBackground(new Color(0x1FFFFF));

        SearchPanel.add(greetingL = new JLabel("Welcome back, Good Afternoon!"));
        SearchPanel.add(summaryL = new JLabel("Summary of Records"));
        greetingL.setFont(new Font("Sans Serif", Font.PLAIN, 21));
        summaryL.setFont(new Font("Sans Serif", Font.PLAIN, 18));

        greetingL.setBounds(180, 10, 1100, 50);
        summaryL.setBounds(310, 120, 200, 50);

        //AddPanel.setBounds(286, 60, 1100, 720);
        //AddPanel.setVisible(true);
        //add(AddPanel);
    }
    public JPanel SearchPanel;
    public JLabel greetingL, summaryL;
}
