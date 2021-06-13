package GUI;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.ImagingOpException;
import java.io.File;
import java.io.IOException;

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
        setResizable(false);
        setNavPanel();
        setDisplayPanel();
        setHeader();
    }

    public void setHeader(){
        JLabel icon, text, power, log_out;


        //ImageIcon logo_icon = new ImageIcon("logo_icon.png");

        JPanel Head = new JPanel();
        Head.setBackground(new Color(0x283469));
        Head.setBounds(0,0,1280,60);
        Head.setLayout(null);
        Head.setVisible(true);


        //icon.setIcon(logo_icon);
        //icon.setText("Bro, do you even code?");
        try {
            BufferedImage logo_icon = ImageIO.read(new File("C:\\Users\\Macapuno\\Desktop\\JAVA PROJECT\\HealthBook\\src\\GUI\\images\\logo_icon.png"));
            BufferedImage logo_text = ImageIO.read(new File("C:\\Users\\Macapuno\\Desktop\\JAVA PROJECT\\HealthBook\\src\\GUI\\images\\logo_name.png"));
            BufferedImage power_button = ImageIO.read(new File("C:\\Users\\Macapuno\\Desktop\\JAVA PROJECT\\HealthBook\\src\\GUI\\images\\power_button.png"));
            BufferedImage logout = ImageIO.read(new File("C:\\Users\\Macapuno\\Desktop\\JAVA PROJECT\\HealthBook\\src\\GUI\\images\\log_out.png"));

            icon = new JLabel(new ImageIcon(logo_icon));
            icon.setBounds(16,13,61,39);
            text = new JLabel(new ImageIcon(logo_text));
            text.setBounds(87,23,175,20);
            power = new JLabel(new ImageIcon(power_button));
            power.setBounds(1087,19,25,27);
            log_out = new JLabel(new ImageIcon(logout));
            log_out.setBounds(1127,12,123,41);


            Head.add(icon);
            Head.add(text);
            Head.add(power);
            Head.add(log_out);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        add(Head);
    }

    public void setNavPanel(){
        var NavPanel = new JPanel();
        var Spacer = new JPanel();
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
        add(Spacer);
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
    public JPanel DisplayPanel;
    public JLabel greetingL, summaryL;
    public JButton addButton, searchButton;

}
