package GUI;



import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;



public class ADMINMENU extends JFrame implements ActionListener{

    public int posX = 0;
    public int posY = 0;



    public ADMINMENU() {
        super("HealthBook");

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
        Head.setLayout(new GridLayout(1,5));
        Head.setVisible(true);

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

        Head.add(icon);
        Head.add(text);
        Head.add(power);
        Head.add(log_out);
        add(Head);
    }
/*
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
        //addButton.setBorder(BorderFactory.createEmptyBorder(0, 21, 0, 0));
        searchButton.setBorder(BorderFactory.createEmptyBorder(0, 29, 0, 0));

        //addButton.setText("Add Patient");
        //.setIconTextGap(15);
        //.setHorizontalAlignment(SwingConstants.LEFT);

        searchButton.setText("Search Patient");
        searchButton.setIconTextGap(23);
        searchButton.setHorizontalAlignment(SwingConstants.LEFT);

        //addButton.addActionListener(this);
        searchButton.addActionListener(this);
        homeButton.addActionListener(this);

        homeButton.setBackground(new Color(0x525c86));
        homeButton.setForeground(Color.WHITE);
        homeButton.setFont(new Font("Helvetica",Font.PLAIN,20));

        homeButton.setFocusPainted(false);
        //addButton.setContentAreaFilled(false);
//.setForeground(Color.white);
        //addButton.setFont(new Font("Helvetica",Font.PLAIN,20));

        // addButton.setFocusPainted(false);
        searchButton.setContentAreaFilled(false);
        searchButton.setForeground(Color.white);
        searchButton.setFont(new Font("Helvetica",Font.PLAIN,20));

        searchButton.setFocusPainted(false);

        homeButton.setBounds(0,0, 286,56);
        //addButton.setBounds(0, 57, 286, 56);
        searchButton.setBounds(0, 57, 286, 56);

        Spacer.setBounds(0, 65, 286, 24);
        Spacer.setVisible(true);
        NavPanel.setBounds(0, 84, 286, 636);
        NavPanel.setVisible(true);
        add(Spacer);
        add(NavPanel);
    }

*/
    public void setDisplayPanel(){
        cardPanel.setLayout(cl);
        cardPanel.add("Home",new HomePageADMIN());
        cardPanel.add("add",new AddForm());
        cardPanel.add("search",new SearchForm());
        cardPanel.setBounds(0,65,1280,655);
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


    private final CardLayout cl = new CardLayout();
    public JButton addButton, searchButton, homeButton, log_out, power;
    private final JPanel cardPanel = new JPanel();
    //public JFrame frame;
}
