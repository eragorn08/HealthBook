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

public class MainMenu extends JFrame{

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
            String path = System.getProperty("user.dir");

            BufferedImage logo_icon = ImageIO.read(new File(String.format("%s\\src\\GUI\\images\\logo_icon.png",path)));
            BufferedImage logo_text = ImageIO.read(new File(String.format("%s\\src\\GUI\\images\\logo_name.png",path)));
            BufferedImage power_button = ImageIO.read(new File(String.format("%s\\src\\GUI\\images\\power_button.png",path)));
            BufferedImage logout = ImageIO.read(new File(String.format("%s\\src\\GUI\\images\\log_out.png",path)));

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
        AddForm add_menu = new AddForm();
        HomePage home = new HomePage();
        SearchForm search = new SearchForm();
        tabbedPane.add("Home",home.DisplayPanel);
        tabbedPane.add("add",add_menu.AddPanel);
        tabbedPane.add("search",search.SearchPanel);
        tabbedPane.setBounds(286,60,1100,660);
        add(tabbedPane);
    }

    public JButton addButton, searchButton;
    public JTabbedPane tabbedPane = new JTabbedPane();

}
