package GUI;



import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;


public class MainMenu extends JFrame implements ActionListener{

    public int posX = 0;
    public int posY = 0;



    public MainMenu()  {
        super("HealthBook");
        setNavPanel();
        setDisplayPanel();
        setHeader();
        setSize(1280, 720);
        setLayout(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true);
        setVisible(true);
    }



    public void setHeader() {
        Border noborder = BorderFactory.createEmptyBorder();
        JLabel icon, text;
        JPanel Head = new JPanel();
        Head.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent ev) {
                posX = ev.getX();
                posY = ev.getY();
            }
        });
        Head.addMouseMotionListener(new MouseAdapter() {

            @Override
            public void mouseDragged(MouseEvent evt) {
                setLocation(evt.getXOnScreen()-posX,evt.getYOnScreen()-posY);
            }
        });
        Head.setBackground(new Color(0x283469));
        Head.setBounds(0, 0, 1280, 65);
        Head.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();


        Head.setVisible(true);
        Head.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));

        icon = new JLabel(new ImageIcon("logo_icon.png"));
        text = new JLabel(new ImageIcon("logo_name.png"));
        power = new JButton(new ImageIcon("power_button.png"));
        log_out = new JButton(new ImageIcon("log_out.png"));

        power.setContentAreaFilled(false);
        power.setFocusPainted(false);
        power.setBorder(noborder);

        log_out.setContentAreaFilled(false);
        log_out.setFocusPainted(false);
        log_out.setBorder(noborder);

        power.addActionListener(this);
        log_out.addActionListener(this);


        c.fill = GridBagConstraints.BOTH;
        c.weightx = 0.0;
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(0, 15, 0, 0);
        Head.add(icon,c);
        c.insets = new Insets(0, 11, 0, 0);
        c.gridx = 1;
        c.gridy = 0;
        Head.add(text,c);
        JLabel Empty = new JLabel("WAAAAAAAH");
        Empty.setFont(new Font("Helvetica", Font.PLAIN, 20));
        Empty.setForeground(new Color(0x283469));
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1.0;
        c.insets = new Insets(20, 33, 2, 0);
        c.gridx = 2;
        c.gridy = 0;
        Head.add(Empty, c);
        c.weightx = 0.0;
        c.insets = new Insets(0, 0, 0, 0);
        c.gridx = 3;
        c.gridy = 0;
        Head.add(power,c);
        c.insets = new Insets(0, 16, 0, 30);
        c.gridx = 4;
        c.gridy = 0;
        Head.add(log_out,c);
        add(Head);
    }

    public void setNavPanel (){
        var NavPanel = new JPanel(new BorderLayout());
        var Spacer = new JPanel();
        Spacer.setBackground(new Color(0x212C58));
        NavPanel.setLayout(null);
        NavPanel.setBackground(new Color(0x283469));
        NavPanel.add(homeButton = new JButton(new ImageIcon("home.png")));
        NavPanel.add(addButton = new JButton(new ImageIcon("add.png")));
        NavPanel.add(searchButton = new JButton(new ImageIcon("search.png")));

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

        homeButton.setBackground(new Color(0x525c86));
        homeButton.setForeground(Color.WHITE);
        homeButton.setFont(new Font("Helvetica",Font.PLAIN,20));

        homeButton.setFocusPainted(false);
        addButton.setContentAreaFilled(false);
        addButton.setForeground(Color.white);
        addButton.setFont(new Font("Helvetica",Font.PLAIN,20));

        addButton.setFocusPainted(false);
        searchButton.setContentAreaFilled(false);
        searchButton.setForeground(Color.white);
        searchButton.setFont(new Font("Helvetica",Font.PLAIN,20));

        searchButton.setFocusPainted(false);

        homeButton.setBounds(0,0, 286,56);
        addButton.setBounds(0, 57, 286, 56);
        searchButton.setBounds(0, 114, 286, 56);

        Spacer.setBounds(0, 65, 286, 24);
        Spacer.setVisible(true);
        NavPanel.setBounds(0, 84, 286, 636);
        NavPanel.setVisible(true);
        add(Spacer);
        add(NavPanel);
    }


    public void setDisplayPanel(){
        cardPanel.setLayout(cl);
        cardPanel.add("Home",new HomePage());
        cardPanel.add("add",new AddForm());
        cardPanel.add("search", new SearchForm());
        cardPanel.setBounds(286,65,994,655);
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

        if(e.getSource() == searchButton) {
            searchButton.setContentAreaFilled(true);
            searchButton.setBackground(new Color(0x525c86));
            cl.show(cardPanel, "search");
            homeButton.setBackground(null);
            addButton.setBackground(null);
        }

        if(e.getSource() == log_out) {
            dispose();
            new LoginForm();
        }

        if(e.getSource() == power){
            dispose();
        }
    }


    public final CardLayout cl = new CardLayout();
    public JButton addButton, searchButton, homeButton, log_out, power;
    public final JPanel cardPanel = new JPanel();
    //public JFrame frame;
}
