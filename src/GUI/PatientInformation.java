package GUI;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.awt.font.FontRenderContext;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class PatientInformation extends JFrame implements ActionListener {
    public JPanel panel = new JPanel();
    public JScrollPane scrollPane = new JScrollPane(panel);
    public RoundedPanel body_panel, vitalsigns, addOldPatient;
    public String lastname,firstname,midname,gend,addrress,ag,month,day,year,weigh,heigh,bt,bloodpressure,btp,
            lop;
    public JButton back_button, addrecord;
    public int X = 0;
    public int Y = 0;

    public void GetData() {
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connect = connectNow.getConnection();

        System.out.println(SearchForm.value);

        String Identify = "SELECT * FROM patientinfo WHERE patientID = '" +SearchForm.value+ "'";
        try{
            Statement st = connect.createStatement();
            ResultSet rs = st.executeQuery(Identify);
            if(rs.next()) {
                lastname = rs.getString("surname");
                firstname = rs.getString("givenname");
                midname = rs.getString("middlename");
                gend = rs.getString("gender");
                ag = rs.getString("age");
                addrress = rs.getString("address");
                day = rs.getString("day");
                month = rs.getString("month");
                year = rs.getString("year");
                weigh = rs.getString("weight");
                heigh = rs.getString("height");
                bt = rs.getString("bloodtype");
                bloodpressure = rs.getString("bloodpressure");
                btp = rs.getString("bodytemp");
                lop = rs.getString("levelofpain");
            }}
        catch(Exception e){
            e.getCause();
            e.printStackTrace();
        }
    }

    public PatientInformation() {
        super("Patient Information");
        setSize(1280, 720);

        setUndecorated(true);
        setResizable(false);
        setVisible(true);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        setLayout(null);
        //setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));

        JPanel title_panel = new JPanel();
        title_panel.setLayout(null);
        title_panel.setBackground(new Color(0x212C58));
        title_panel.setBounds(0, 0, 1280, 100);
        add(title_panel);
        title_panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent ev) {
                X = ev.getX();
                Y = ev.getY();
            }
        });
        title_panel.addMouseMotionListener(new MouseAdapter() {

            @Override
            public void mouseDragged(MouseEvent evt) {
                setLocation(evt.getXOnScreen() - X, evt.getYOnScreen() - Y);
            }
        });

        GetData();

        back_button = new JButton(new ImageIcon("back.png"));
        back_button.setContentAreaFilled(false);
        back_button.setVisible(true);
        back_button.setFocusPainted(false);
        back_button.setBorder(BorderFactory.createEmptyBorder());
        back_button.setBounds(19, 20, 86, 63);
        back_button.addActionListener(this);
        title_panel.add(back_button);

        addrecord = new JButton(new ImageIcon("addnewrecord.png"));
        addrecord.setContentAreaFilled(false);
        addrecord.setVisible(true);
        addrecord.setFocusPainted(false);
        addrecord.setBorder(BorderFactory.createEmptyBorder());
        addrecord.setBounds(1007, 34, 221, 41);
        addrecord.addActionListener(this);
        title_panel.add(addrecord);

        JLabel patient_details = new JLabel("Patient Details");
        patient_details.setForeground(Color.white);
        patient_details.setFont(new Font("Helvetica", Font.PLAIN, 40));
        patient_details.setVisible(true);
        patient_details.setBounds(510, 30, 260, 54);
        title_panel.add(patient_details);


        //add(panel);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(new EmptyBorder(new Insets(23, 40, 100, 40)));
        panel.setBackground(new Color(0x212C58));
        panel.setVisible(true);
        panel.setBounds(0, 100, 1280, 620);


        scrollPane.setVisible(true);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setPreferredSize(new Dimension(1280,643));

        info();
        panel.add(Box.createRigidArea((new Dimension(5,15))));
        vitalSigns();
        panel.add(Box.createRigidArea((new Dimension(5,20))));


        scrollPane = new JScrollPane(panel, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        scrollPane.setLayout(new ScrollPaneLayout());
        scrollPane.setBounds(0, 100, 1280, 620);

        add(scrollPane);


    }
    public void vitalSigns(){
        // pwede mo ito i edit para may varibles na sila
        // ako na lang mag concatinate
        // VARIABLES FOR VITAL SIGNS//
        String bp = bloodpressure;
        String temp = bt;
        String pulse = "110/80" + " " + "bpm";
        String pain = lop;
        //////////////////////////////
        panel.add(vitalsigns = new RoundedPanel(50,new Color(0x4d5579)));
        vitalsigns.setOpaque(false);
        vitalsigns.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        c.weightx = 1.0;
        c.weighty = 1.0;

        vitalsigns.setVisible(true);

        //Vital Signs Title
        JLabel vitalSignsLabel = new JLabel("Vital Signs");
        vitalSignsLabel.setFont(new Font("Helvetica", Font.BOLD, 25));
        vitalSignsLabel.setForeground(Color.white);
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 0.5;
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(13, 33, 2, 0);
        vitalsigns.add(vitalSignsLabel, c);
        c.weightx = 1.0;

        //Blood Pressure
        JLabel bpLabel = new JLabel("Blood Pressure: " + bp);
        bpLabel.setFont(new Font("Helvetica", Font.PLAIN, 20));
        bpLabel.setForeground(Color.white);
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(15, 33, 2, 0);
        c.gridx = 0;
        c.gridy = 1;
        vitalsigns.add(bpLabel, c);



        //Body Temperature
        JLabel tempLabel = new JLabel("Body Temperature: " + temp);
        tempLabel.setFont(new Font("Helvetica", Font.PLAIN, 20));
        tempLabel.setForeground(Color.white);
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(15, 33, 2, 0);
        c.gridx = 0;
        c.gridy = 2;
        vitalsigns.add(tempLabel, c);



        //Pulse Rate
        JLabel pulseLabel = new JLabel("Pulse Rate: " + pulse);
        pulseLabel.setFont(new Font("Helvetica", Font.PLAIN, 20));
        pulseLabel.setForeground(Color.white);
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(15, 33, 2, 0);
        c.gridx = 0;
        c.gridy = 3;
        vitalsigns.add(pulseLabel, c);



        //Level of Pain:
        JLabel painLabel = new JLabel("Level of Pain: " + pain);
        painLabel.setFont(new Font("Helvetica", Font.PLAIN, 20));
        painLabel.setForeground(Color.white);
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(15, 33, 14, 0);
        c.gridx = 0;
        c.gridy = 4;
        vitalsigns.add(painLabel, c);


    }

    public void info() {
        // pwede mo ito i edit para may varibles na sila
        // ako na lang mag concatinate
        // VARIABLES FOR BASIC DETAILS//
        String name = lastname +", " + firstname + " " + midname;
        String sex = gend;
        String address = addrress;
        String birth = month + "/" + day + "/" + year;
        String bloodtype = bt;
        String age = ag;
        String height = heigh;
        String weight = weigh;
        String no = SearchForm.value;
        String date = SearchForm.date;
        //////////////////////////////
        panel.add(body_panel = new RoundedPanel(50,new Color(0x4d5579)));
        body_panel.setOpaque(false);
        body_panel.setBorder(BorderFactory.createEmptyBorder());
        body_panel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        c.weightx = 1.0;
        c.weighty = 1.0;
        body_panel.setVisible(true);

        //Basic Details Title
        JLabel basicDetails = new JLabel("Basic Details");
        basicDetails.setFont(new Font("Helvetica", Font.BOLD, 25));
        basicDetails.setForeground(Color.white);
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 0.5;
        c.insets = new Insets(20, 33, 2, 0);
        c.gridx = 0;
        c.gridy = 0;
        body_panel.add(basicDetails, c);
        c.weightx = 1.0;


        //Name
        JLabel nameLabel = new JLabel("Name: " + name);
        nameLabel.setFont(new Font("Helvetica", Font.PLAIN, 20));
        nameLabel.setForeground(Color.white);
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(15, 33, 2, 0);
        c.gridx = 0;
        c.gridy = 1;
        body_panel.add(nameLabel, c);



        //Sex
        JLabel sexLabel = new JLabel("Sex: " + sex);
        sexLabel.setFont(new Font("Helvetica", Font.PLAIN, 20));
        sexLabel.setForeground(Color.white);
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(15, 33, 2, 0);
        c.gridx = 0;
        c.gridy = 2;
        body_panel.add(sexLabel, c);



        //Address
        JLabel addressLabel = new JLabel("Address: " + address);
        addressLabel.setFont(new Font("Helvetica", Font.PLAIN, 20));
        addressLabel.setForeground(Color.white);
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(15, 33, 2, 0);
        c.gridx = 0;
        c.gridy = 3;
        body_panel.add(addressLabel, c);


        //Date of Birth:
        JLabel birthLabel = new JLabel("Date of Birth: " + birth);
        birthLabel.setFont(new Font("Helvetica", Font.PLAIN, 20));
        birthLabel.setForeground(Color.white);
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(15, 33, 2, 0);
        c.gridx = 0;
        c.gridy = 4;
        body_panel.add(birthLabel, c);


        //Blood Type:
        JLabel bloodTypeLabel = new JLabel("Blood Type: " + bloodtype);
        bloodTypeLabel.setFont(new Font("Helvetica", Font.PLAIN, 20));
        bloodTypeLabel.setForeground(Color.white);
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(15, 33, 2, 0);
        c.gridx = 0;
        c.gridy = 5;
        body_panel.add(bloodTypeLabel, c);


        //Age:
        JLabel ageLabel = new JLabel("Age: " + age);
        ageLabel.setFont(new Font("Helvetica", Font.PLAIN, 20));
        ageLabel.setForeground(Color.white);
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(15, 33, 2, 0);
        c.gridx = 0;
        c.gridy = 6;
        body_panel.add(ageLabel, c);


        //Height
        JLabel heightLabel = new JLabel("Height: " + height);
        heightLabel.setFont(new Font("Helvetica", Font.PLAIN, 20));
        heightLabel.setForeground(Color.white);
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(15, 33, 2, 0);
        c.gridx = 0;
        c.gridy = 7;
        body_panel.add(heightLabel, c);


        //Weight
        JLabel weightLabel = new JLabel("Weight: " + weight);
        weightLabel.setFont(new Font("Helvetica", Font.PLAIN, 20));
        weightLabel.setForeground(Color.white);
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(15, 33, 14, 0);
        c.gridx = 0;
        c.gridy = 8;
        body_panel.add(weightLabel, c);



        //Patient No.:
        JLabel patientNoLabel = new JLabel("Patient No.: " + no);
        patientNoLabel.setFont(new Font("Helvetica", Font.PLAIN, 20));
        patientNoLabel.setForeground(Color.white);
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(15, 33, 5, 0);
        c.gridx = 2;
        c.gridy = 1;
        body_panel.add(patientNoLabel, c);


        //Date:
        JLabel DateLabel = new JLabel("Date: " + date);
        DateLabel.setFont(new Font("Helvetica", Font.PLAIN, 20));
        DateLabel.setForeground(Color.white);
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(15, 33, 5, 0);
        c.gridx = 2;
        c.gridy = 2;
        body_panel.add(DateLabel, c);


    }


    public void OldPatient(){
        scrollPane.getVerticalScrollBar().setValue(scrollPane.getVerticalScrollBar().getMaximum()+ 3);

        JLabel oldpatientLabel = new JLabel("Add Old Patient");
        oldpatientLabel.setForeground(Color.white);
        oldpatientLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        oldpatientLabel.setFont(new Font("Helvetica", Font.PLAIN, 40));
        oldpatientLabel.setVisible(true);
        panel.add(oldpatientLabel);

        panel.add(addOldPatient = new RoundedPanel(50,new Color(0x4d5579)));
        addOldPatient.setOpaque(false);
        addOldPatient.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        c.weightx = 1.0;
        c.weighty = 1.0;

        addOldPatient.setVisible(true);
        panel.add(Box.createRigidArea((new Dimension(5,20))));

        //Vital Signs Title
        JLabel vitalSignsLabel = new JLabel("Vital Signs");
        vitalSignsLabel.setFont(new Font("Helvetica", Font.BOLD, 25));
        vitalSignsLabel.setForeground(Color.white);
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 0.5;
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(13, 33, 2, 0);
        addOldPatient.add(vitalSignsLabel, c);
        c.weightx = 1.0;

        //Blood Pressure
        JLabel bpLabel = new JLabel("Blood Pressure: ");
        bpLabel.setFont(new Font("Helvetica", Font.PLAIN, 20));
        bpLabel.setForeground(Color.white);
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(15, 33, 2, 0);
        c.gridx = 0;
        c.gridy = 1;

        addOldPatient.add(bpLabel, c);

        JTextField bpEntry0 = new JTextField(3);
        bpEntry0.setFont(new Font("Helvetica", Font.PLAIN, 20));
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 1;
        bpEntry0.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent ke) {
                bpEntry0.setEditable(ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9'
                        || ke.getKeyChar() == KeyEvent.VK_BACK_SPACE|| ke.getKeyChar() == '.');
            }
        });
        addOldPatient.add(bpEntry0, c);

        JLabel slash = new JLabel("/");
        slash.setFont(new Font("Helvetica", Font.PLAIN, 20));
        slash.setHorizontalAlignment(JLabel.CENTER);
        slash.setForeground(Color.white);
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(15, 0, 2, 0);
        c.weightx = 0;
        c.gridx = 2;
        c.gridy = 1;
        addOldPatient.add(slash, c);
        c.weightx = 1;

        JTextField bpEntry1 = new JTextField(3);
        bpEntry1.setFont(new Font("Helvetica", Font.PLAIN, 20));
        c.fill = GridBagConstraints.HORIZONTAL;
        bpEntry1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent ke) {
                bpEntry1.setEditable(ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9'
                        || ke.getKeyChar() == KeyEvent.VK_BACK_SPACE|| ke.getKeyChar() == '.');
            }
        });
        c.gridx = 3;
        c.gridy = 1;
        addOldPatient.add(bpEntry1, c);


        JLabel space = new JLabel("DFDSFASDFASDFSDFSDFASDFSDFSDFASDFSDFSDDSFSD");
        space.setFont(new Font("Helvetica", Font.PLAIN, 20));
        space.setForeground(new Color(0x4d5579));
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(15, 33, 2, 0);
        c.gridx = 4;
        c.gridy = 1;
        addOldPatient.add(space, c);



        //Body Temperature
        JLabel tempLabel = new JLabel("Body Temperature:");
        tempLabel.setFont(new Font("Helvetica", Font.PLAIN, 20));
        tempLabel.setForeground(Color.white);
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(15, 33, 2, 0);
        c.gridx = 0;
        c.gridy = 2;
        addOldPatient.add(tempLabel, c);

        JTextField tempEntry = new JTextField(5);
        tempEntry.setFont(new Font("Helvetica", Font.PLAIN, 20));
        c.fill = GridBagConstraints.HORIZONTAL;
        tempEntry.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent ke) {
                tempEntry.setEditable(ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9'
                        || ke.getKeyChar() == KeyEvent.VK_BACK_SPACE|| ke.getKeyChar() == '.');
            }
        });
        c.gridx = 1;
        c.gridy = 2;
        addOldPatient.add(tempEntry, c);

        JLabel celsius = new JLabel("°C");
        celsius.setFont(new Font("Helvetica", Font.PLAIN, 20));
        celsius.setForeground(Color.white);
        celsius.setHorizontalAlignment(JLabel.CENTER);
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(15, 0, 2, 0);
        c.weightx = 0;
        c.gridx = 2;
        c.gridy = 2;
        addOldPatient.add(celsius, c);
        c.weightx = 1;



        //Pulse Rate
        JLabel pulseLabel = new JLabel("Pulse Rate:");
        pulseLabel.setFont(new Font("Helvetica", Font.PLAIN, 20));
        pulseLabel.setForeground(Color.white);
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(15, 33, 2, 0);
        c.gridx = 0;
        c.gridy = 3;
        addOldPatient.add(pulseLabel, c);

        JTextField pulseEntry = new JTextField(5);
        pulseEntry.setFont(new Font("Helvetica", Font.PLAIN, 20));
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 3;
        pulseEntry.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent ke) {
                pulseEntry.setEditable(ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9'
                        || ke.getKeyChar() == KeyEvent.VK_BACK_SPACE|| ke.getKeyChar() == '.');
            }
        });
        addOldPatient.add(pulseEntry, c);


        JLabel bpm = new JLabel("bpm");
        bpm.setFont(new Font("Helvetica", Font.PLAIN, 20));
        bpm.setForeground(Color.white);
        bpm.setHorizontalAlignment(JLabel.CENTER);
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(15, 0, 2, 0);
        c.gridx = 2;
        c.gridy = 3;
        addOldPatient.add(bpm, c);

        //Level of Pain:
        JLabel painLabel = new JLabel("Level of Pain:");
        painLabel.setFont(new Font("Helvetica", Font.PLAIN, 20));
        painLabel.setForeground(Color.white);
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(15, 33, 14, 0);
        c.gridx = 0;
        c.gridy = 4;
        addOldPatient.add(painLabel, c);

        JTextField painEntry = new JTextField(5);
        painEntry.setFont(new Font("Helvetica", Font.PLAIN, 20));
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 4;
        painEntry.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent ke) {
                painEntry.setEditable(ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9'
                        || ke.getKeyChar() == KeyEvent.VK_BACK_SPACE|| ke.getKeyChar() == '.');
            }
        });
        addOldPatient.add(painEntry, c);


        //Height:
        JLabel heightLabel = new JLabel("Height:");
        heightLabel.setFont(new Font("Helvetica", Font.PLAIN, 20));
        heightLabel.setForeground(Color.white);
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(15, 33, 14, 0);
        c.gridx = 0;
        c.gridy = 5;
        addOldPatient.add(heightLabel, c);

        JTextField heightEntry = new JTextField(5);
        heightEntry.setFont(new Font("Helvetica", Font.PLAIN, 20));
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 5;
        heightEntry.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent ke) {
                heightEntry.setEditable(ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9'
                        || ke.getKeyChar() == KeyEvent.VK_BACK_SPACE|| ke.getKeyChar() == '.');
            }
        });
        addOldPatient.add(heightEntry, c);

        JLabel cm = new JLabel("cm");
        cm.setFont(new Font("Helvetica", Font.PLAIN, 20));
        cm.setHorizontalAlignment(JLabel.CENTER);
        cm.setForeground(Color.white);
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(15, 0, 2, 0);
        c.gridx = 2;
        c.gridy = 5;
        addOldPatient.add(cm, c);

        //Weight:
        JLabel weightLabel = new JLabel("Weight:");
        weightLabel.setFont(new Font("Helvetica", Font.PLAIN, 20));
        weightLabel.setForeground(Color.white);
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(15, 33, 14, 0);
        c.gridx = 0;
        c.gridy = 6;
        addOldPatient.add(weightLabel, c);

        JTextField weightEntry = new JTextField(5);
        weightEntry.setFont(new Font("Helvetica", Font.PLAIN, 20));
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 6;
        weightEntry.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent ke) {
                weightEntry.setEditable(ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9'
                        || ke.getKeyChar() == KeyEvent.VK_BACK_SPACE|| ke.getKeyChar() == '.');
            }
        });
        addOldPatient.add(weightEntry, c);

        JLabel kg = new JLabel("kg");
        kg.setFont(new Font("Helvetica", Font.PLAIN, 20));
        kg.setForeground(Color.white);
        kg.setHorizontalAlignment(JLabel.CENTER);
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(15, 0, 2, 0);
        c.gridx = 2;
        c.gridy = 6;
        addOldPatient.add(kg, c);
        panel.add(Box.createRigidArea((new Dimension(5,20))));


        JButton confirm_add_old = new JButton(new ImageIcon("confirm_logo.png"));
        confirm_add_old.setContentAreaFilled(false);
        confirm_add_old.setVisible(true);
        confirm_add_old.setFocusPainted(false);
        confirm_add_old.setBorder(BorderFactory.createEmptyBorder(0,0,20,0));
        confirm_add_old.addActionListener(this);
        confirm_add_old.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(confirm_add_old);
        panel.add(Box.createRigidArea((new Dimension(5,20))));


    }

    public void InsertOldPatient(){


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back_button) {
            setVisible(false);
        }

        if (e.getSource() == addrecord) {
            addrecord.setVisible(false);
            OldPatient();
        }
    }

    static class RoundedPanel extends JPanel {
        private Color backgroundColor;
        private int cornerRadius = 15;

        public RoundedPanel(LayoutManager layout, int radius) {
            super(layout);
            cornerRadius = radius;
        }

        public RoundedPanel(LayoutManager layout, int radius, Color bgColor) {
            super(layout);
            cornerRadius = radius;
            backgroundColor = bgColor;
        }

        public RoundedPanel(int radius) {
            super();
            cornerRadius = radius;
        }

        public RoundedPanel(int radius, Color bgColor) {
            super();
            cornerRadius = radius;
            backgroundColor = bgColor;
        }
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Dimension arcs = new Dimension(cornerRadius, cornerRadius);
            int width = getWidth();
            int height = getHeight();
            Graphics2D graphics = (Graphics2D) g;
            graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            //Draws the rounded panel with borders.
            if (backgroundColor != null) {
                graphics.setColor(backgroundColor);
            } else {
                graphics.setColor(getBackground());
            }
            graphics.fillRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height); //paint background
            graphics.setColor(getForeground());
            graphics.drawRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height); //paint border
        }
    }

}


