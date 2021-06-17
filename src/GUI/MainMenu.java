package GUI;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.Insets;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MainMenu extends JFrame implements ActionListener{

    public MainMenu() {

        super("Health Book");

        getImage(); //scans all image files

        setVisible(true);
        setSize(1280, 720);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        setResizable(false);
        setNavPanel();
        setDisplayPanel();
        setHeader();
    }

    public void getImage(){
        try{
            String path = System.getProperty("user.dir");
            logo_icon = ImageIO.read(new File(String.format("%s\\src\\GUI\\images\\logo_icon.png",path)));
            logo_text = ImageIO.read(new File(String.format("%s\\src\\GUI\\images\\logo_name.png",path)));
            power_button = ImageIO.read(new File(String.format("%s\\src\\GUI\\images\\power_button.png",path)));
            logout = ImageIO.read(new File(String.format("%s\\src\\GUI\\images\\log_out.png",path)));
            home_button = ImageIO.read(new File(String.format("%s\\src\\GUI\\images\\home.png",path)));
            add_button = ImageIO.read(new File(String.format("%s\\src\\GUI\\images\\add.png",path)));
            search_button = ImageIO.read(new File(String.format("%s\\src\\GUI\\images\\search.png",path)));
        }catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    public void setHeader(){
        JLabel icon, text, power, log_out;


        JPanel Head = new JPanel();
        Head.setBackground(new Color(0x283469));
        Head.setBounds(0,0,1280,60);
        Head.setLayout(null);
        Head.setVisible(true);

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
    add(Head);
    }

    public void setNavPanel (){
        var NavPanel = new JPanel(new BorderLayout());
        var Spacer = new JPanel();
        Spacer.setBackground(new Color(0x212C58));
        NavPanel.setLayout(null);
        NavPanel.setBackground(new Color(0x283469));
        homeButton = new JButton(new ImageIcon(home_button));
        NavPanel.add(homeButton = new JButton(new ImageIcon(home_button)));
        NavPanel.add(addButton = new JButton(new ImageIcon(add_button)));
        NavPanel.add(searchButton = new JButton(new ImageIcon(search_button)));

        homeButton.setText("Home");
        homeButton.setIconTextGap(25);
        homeButton.setHorizontalAlignment(SwingConstants.LEFT);

        homeButton.setBorder(BorderFactory.createEmptyBorder(0, 31, 0, 0));
        addButton.setBorder(BorderFactory.createEmptyBorder(0, 21, 0, 0));
        searchButton.setBorder(BorderFactory.createEmptyBorder(0, 29, 0, 0));

        addButton.setText("Add Patient");
        addButton.setIconTextGap(15);
        addButton.setHorizontalAlignment(SwingConstants.LEFT);

        searchButton.setText("Search Patient");
        searchButton.setIconTextGap(23);
        searchButton.setHorizontalAlignment(SwingConstants.LEFT);



        addButton.addActionListener(this);
        searchButton.addActionListener(this);
        homeButton.addActionListener(this);

        //Border emptyBorder = BorderFactory.createEmptyBorder();
        homeButton.setBackground(new Color(0x525c86));
        homeButton.setForeground(Color.WHITE);
        homeButton.setFont(new Font("Helvetica",Font.PLAIN,20));
        //homeButton.setBorder(emptyBorder);
        homeButton.setFocusPainted(false);
        addButton.setContentAreaFilled(false);
        addButton.setForeground(Color.white);
        addButton.setFont(new Font("Helvetica",Font.PLAIN,20));
        //addButton.setBorder(emptyBorder);
        addButton.setFocusPainted(false);
        searchButton.setContentAreaFilled(false);
        searchButton.setForeground(Color.white);
        searchButton.setFont(new Font("Helvetica",Font.PLAIN,20));
       // searchButton.setBorder(emptyBorder);
        searchButton.setFocusPainted(false);

        homeButton.setBounds(0,0, 286,56);
        addButton.setBounds(0, 57, 286, 56);
        searchButton.setBounds(0, 114, 286, 56);


        Spacer.setBounds(0, 60, 286, 24);
        Spacer.setVisible(true);
        NavPanel.setBounds(0, 84, 286, 720);
        NavPanel.setVisible(true);
        add(Spacer);
        add(NavPanel);
    }


    public void setDisplayPanel(){

        SearchForm search = new SearchForm();
        cardPanel.setLayout(cl);
        cardPanel.add("Home",new HomePage());
        cardPanel.add("add",new AddForm());
        cardPanel.add("search",search.SearchPanel);
        cardPanel.setBounds(286,60,1100,660);
        cl.show(cardPanel,"Home");
        add(cardPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == homeButton){
            homeButton.setContentAreaFilled(true);
            homeButton.setBackground(new Color(0x525c86));
            cl.show(cardPanel, "Home");

            addButton.setContentAreaFilled(false);
            searchButton.setContentAreaFilled(false);
        }

        if(e.getSource() == addButton){
            addButton.setContentAreaFilled(true);
            addButton.setBackground(new Color(0x525c86));
            cl.show(cardPanel, "add");
            homeButton.setContentAreaFilled(false);

            searchButton.setContentAreaFilled(false);
        }

        if(e.getSource() == searchButton){
            searchButton.setContentAreaFilled(true);
            searchButton.setBackground(new Color(0x525c86));
            cl.show(cardPanel, "search");
            homeButton.setBackground(null);
            addButton.setBackground(null);

        }
    }


    private CardLayout cl = new CardLayout();
    private JButton addButton, searchButton, homeButton;
    private JPanel cardPanel = new JPanel();
    private BufferedImage home_button, logo_icon, logo_text, power_button, logout, add_button, search_button;


}
