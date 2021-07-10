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

    public void setNavPanel (){
        var NavPanel = new JPanel(new BorderLayout());
        var Spacer = new JPanel();
        Spacer.setBackground(new Color(0x212C58));
        NavPanel.setLayout(null);
        NavPanel.setBackground(new Color(0x283469));

        NavPanel.add(usersLabel = new JLabel("USERS"));
        usersLabel.setFont(new Font("Helvetica", Font.PLAIN, 20));
        usersLabel.setForeground(Color.white);
        usersLabel.setBounds(18, 17, 72, 33);

        NavPanel.add(adminLabel = new JLabel("ADMIN"));
        adminLabel.setFont(new Font("Helvetica", Font.PLAIN, 20));
        adminLabel.setForeground(Color.white);
        adminLabel.setBounds(18, 180, 72, 33);


        NavPanel.add(searchUser = new JButton(new ImageIcon("search.png")));
        NavPanel.add(addUser = new JButton(new ImageIcon("adduser.png")));
        NavPanel.add(ChangePass = new JButton(new ImageIcon("padlock.png")));

        searchUser.setText("Search User");
        searchUser.setIconTextGap(25);
        searchUser.setHorizontalAlignment(SwingConstants.LEFT);

        searchUser.setBorder(BorderFactory.createEmptyBorder(0, 31, 0, 0));
        addUser.setBorder(BorderFactory.createEmptyBorder(0, 30, 0, 0));
        ChangePass.setBorder(BorderFactory.createEmptyBorder(0, 29, 0, 0));

        addUser.setText("Add User");
        addUser.setIconTextGap(15);
        addUser.setHorizontalAlignment(SwingConstants.LEFT);

        ChangePass.setText("Change Password");
        ChangePass.setIconTextGap(23);
        ChangePass.setHorizontalAlignment(SwingConstants.LEFT);

        addUser.addActionListener(this);
        ChangePass.addActionListener(this);
        searchUser.addActionListener(this);

        searchUser.setBackground(new Color(0x525c86));
        searchUser.setForeground(Color.WHITE);
        searchUser.setFont(new Font("Helvetica",Font.PLAIN,20));

        searchUser.setFocusPainted(false);
        addUser.setContentAreaFilled(false);
        addUser.setForeground(Color.white);
        addUser.setFont(new Font("Helvetica",Font.PLAIN,20));

        addUser.setFocusPainted(false);
        ChangePass.setContentAreaFilled(false);
        ChangePass.setForeground(Color.white);
        ChangePass.setFont(new Font("Helvetica",Font.PLAIN,20));

        ChangePass.setFocusPainted(false);

        searchUser.setBounds(0,57, 286,56);
        addUser.setBounds(0, 113, 286, 56);
        ChangePass.setBounds(0, 225, 286, 56);

        Spacer.setBounds(0, 65, 286, 24);
        Spacer.setVisible(true);
        NavPanel.setBounds(0, 84, 286, 636);
        NavPanel.setVisible(true);
        add(Spacer);
        add(NavPanel);
    }


    public void setDisplayPanel(){
        cardPanel.setLayout(cl);
        cardPanel.add("Home",new AdminSearch());
        cardPanel.add("add",new AddForm());
        cardPanel.add("search",new SearchForm());
        cardPanel.setBounds(286,65,994,655);
        cl.show(cardPanel,"Home");
        add(cardPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == searchUser){
            searchUser.setContentAreaFilled(true);
            searchUser.setBackground(new Color(0x525c86));
            cl.show(cardPanel, "Home");

            addUser.setContentAreaFilled(false);
            ChangePass.setContentAreaFilled(false);
        }

        if(e.getSource() == addUser){
            addUser.setContentAreaFilled(true);
            addUser.setBackground(new Color(0x525c86));
            cl.show(cardPanel, "add");
            searchUser.setContentAreaFilled(false);
            ChangePass.setContentAreaFilled(false);
        }

        if(e.getSource() == ChangePass) {
            ChangePass.setContentAreaFilled(true);
            ChangePass.setBackground(new Color(0x525c86));
            cl.show(cardPanel, "search");
            searchUser.setBackground(null);
            addUser.setBackground(null);
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
    public JButton addUser, ChangePass, searchUser, log_out, power;
    private final JPanel cardPanel = new JPanel();
    public JLabel usersLabel, adminLabel;
    //public JFrame frame;
}


