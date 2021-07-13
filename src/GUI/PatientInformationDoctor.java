package GUI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class PatientInformationDoctor extends JFrame implements ActionListener {
    public JPanel spacer;
    public JPanel panel = new JPanel();
    public JScrollPane scrollPane = new JScrollPane(panel);
    public RoundedPanel body_panel, vitalsigns,symptoms_panel, diagnosis_panel, medication_panel;
    public String lastname,firstname,midname,gend,addrress,ag,month,day,year,weigh,heigh,bt,bloodpressure,btp,
            lop, symptoms_info,diagnosis_info,medication_info,pulserate,doctor;
    public JButton back_button, edit, confirm;
    public JTextArea symptoms_content, diagnosis_content, medication_content;

    public int X = 0;
    public int Y = 0;

    public void InputDoc(){
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connect = connectNow.getConnection();

        System.out.println(LoginForm.EmpID);

        String Identify = "UPDATE patientinfo SET symptoms='"+symptoms_content.getText()+"' , " +
                "diagnosis='"+diagnosis_content.getText()+"',medication='"+medication_content.getText()+"'" +
                ",doctor='"+LoginForm.emid+"' WHERE patientID = '"+SearchFormDoctor.value+"'";
        try{
            Statement st = connect.createStatement();
            st.executeUpdate(Identify);
            }
        catch(Exception e){
            e.getCause();
            e.printStackTrace();
        }
    }

    public void GetData() {
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connect = connectNow.getConnection();

        System.out.println(SearchForm.value);

        String Identify = "SELECT * FROM patientinfo WHERE patientID = '" +SearchFormDoctor.value+ "'";
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
                pulserate = rs.getString("pulserate");
                bloodpressure = rs.getString("bloodpressure");
                btp = rs.getString("bodytemp");
                lop = rs.getString("levelofpain");
                symptoms_info = rs.getString("symptoms");
                diagnosis_info = rs.getString("diagnosis");
                medication_info = rs.getString("medication");
                doctor = rs.getString("doctor");
            }}
        catch(Exception e){
            e.getCause();
            e.printStackTrace();
        }
    }

    public PatientInformationDoctor() {
        super("Patient Information");
        setSize(1280, 720);

        setUndecorated(true);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        setResizable(true);
        setVisible(true);
        setLayout(null);

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

        JLabel patient_details = new JLabel("Patient Details");
        patient_details.setForeground(Color.white);
        patient_details.setFont(new Font("Helvetica", Font.PLAIN, 40));
        patient_details.setVisible(true);
        patient_details.setBounds(510, 30, 260, 54);
        title_panel.add(patient_details);

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
        form();
        symptoms();
        panel.add(Box.createRigidArea((new Dimension(5,15))));
        diagnosis();
        panel.add(Box.createRigidArea((new Dimension(5,15))));
        medication();
        panel.add(Box.createRigidArea((new Dimension(5,15))));

        confirm = new JButton(new ImageIcon("confirm_logo.png"));
        confirm.setFocusPainted(false);
        confirm.setBorder(BorderFactory.createEmptyBorder());
        confirm.setAlignmentX(Component.CENTER_ALIGNMENT);
        confirm.setContentAreaFilled(false);
        confirm.addActionListener(this);
        panel.add(confirm);
        setAllUneditable();

        scrollPane = new JScrollPane(panel, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        scrollPane.setLayout(new ScrollPaneLayout());
        scrollPane.setBounds(0, 100, 1280, 620);

        add(scrollPane);
    }
    public void vitalSigns(){
        //Variables for Vital Signs
        String bp = bloodpressure;
        String temp = bt;
        String pulse = pulserate + " " + "bpm";
        String pain = lop;
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
        //Basic Details
        String name = lastname +", " + firstname + " " + midname;
        String sex = gend;
        String address = addrress;
        String birth = month + "/" + day + "/" + year;
        String bloodtype = bt;
        String age = ag;
        String height = heigh;
        String weight = weigh;
        String no = SearchFormDoctor.value;
        String date = SearchFormDoctor.date;

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
        JLabel heightLabel = new JLabel("Height: " + height + " cm");
        heightLabel.setFont(new Font("Helvetica", Font.PLAIN, 20));
        heightLabel.setForeground(Color.white);
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(15, 33, 2, 0);
        c.gridx = 0;
        c.gridy = 7;
        body_panel.add(heightLabel, c);

        //Weight
        JLabel weightLabel = new JLabel("Weight: " + weight + " kg");
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
    public void form() {
        panel.add(spacer = new JPanel());
        spacer.setOpaque(false);
        spacer.setBackground(new Color(0x212C58));
        spacer.setBorder(BorderFactory.createEmptyBorder());
        spacer.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        c.weightx = 1.0;
        c.weighty = 1.0;
        spacer.setVisible(true);

        JLabel patient_form = new JLabel("Patient Form");
        patient_form.setForeground(Color.white);
        patient_form.setFont(new Font("Helvetica", Font.PLAIN, 40));
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 0.5;
        c.insets = new Insets(20, 23, 20, 0);
        c.gridx = 0;
        c.gridy = 0;
        spacer.add(patient_form, c);
        c.weightx = 1.0;

        //Patient No.:
        edit = new JButton(new ImageIcon("edit.png"));
        edit.setContentAreaFilled(false);
        edit.setFocusPainted(false);
        edit.setBorder(BorderFactory.createEmptyBorder());
        edit.addActionListener(this);
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(15, 100, 5, 0);
        c.gridx = 2;
        c.gridy = 0;
        spacer.add(edit, c);
    }

    public void symptoms() {
        panel.add(symptoms_panel = new RoundedPanel(50,new Color(0x4d5579)));
        symptoms_panel.setOpaque(false);
        symptoms_panel.setBorder(BorderFactory.createEmptyBorder());
        symptoms_panel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        c.weightx = 1.0;
        c.weighty = 1.0;
        symptoms_panel.setVisible(true);

        //Basic Details Title
        JLabel symptoms_label = new JLabel("Symptoms");
        symptoms_label.setFont(new Font("Helvetica", Font.BOLD, 25));
        symptoms_label.setForeground(Color.white);
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 0.5;
        c.insets = new Insets(20, 33, 2, 0);
        c.gridx = 0;
        c.gridy = 0;
        symptoms_panel.add(symptoms_label, c);
        c.weightx = 1.0;

        symptoms_content = new JTextArea();
        symptoms_content.setColumns(50);
        symptoms_content.setRows(1);
        symptoms_content.setLineWrap(true);
        symptoms_content.setWrapStyleWord(true);
        symptoms_content.setEditable(true);
        symptoms_content.setBackground(new Color(0x4d5579));
        symptoms_content.setForeground(Color.white);
        symptoms_content.setBorder(new LineBorder(Color.WHITE,2));
        symptoms_content.setFont(new Font("Helvetica", Font.PLAIN, 20));
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(15, 40, 15, 40);
        c.gridx = 0;
        c.gridy = 1;
        symptoms_panel.add(symptoms_content, c);
        symptoms_content.setText(symptoms_info);
    }
    public void diagnosis() {
        panel.add(diagnosis_panel = new RoundedPanel(50,new Color(0x4d5579)));
        diagnosis_panel.setOpaque(false);
        diagnosis_panel.setBorder(BorderFactory.createEmptyBorder());
        diagnosis_panel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        c.weightx = 1.0;
        c.weighty = 1.0;
        diagnosis_panel.setVisible(true);

        //Basic Details Title
        JLabel diagnosis_label = new JLabel("Diagnosis");
        diagnosis_label.setFont(new Font("Helvetica", Font.BOLD, 25));
        diagnosis_label.setForeground(Color.white);
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 0.5;
        c.insets = new Insets(20, 33, 2, 0);
        c.gridx = 0;
        c.gridy = 0;
        diagnosis_panel.add(diagnosis_label, c);
        c.weightx = 1.0;

        diagnosis_content = new JTextArea();
        diagnosis_content.setColumns(50);
        diagnosis_content.setRows(1);
        diagnosis_content.setLineWrap(true);
        diagnosis_content.setWrapStyleWord(true);
        diagnosis_content.setEditable(true);
        diagnosis_content.setBackground(new Color(0x4d5579));
        diagnosis_content.setForeground(Color.white);
        diagnosis_content.setBorder(new LineBorder(Color.WHITE,2));
        diagnosis_content.setFont(new Font("Helvetica", Font.PLAIN, 20));
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(15, 40, 15, 40);
        c.gridx = 0;
        c.gridy = 1;
        diagnosis_panel.add(diagnosis_content, c);
        diagnosis_content.setText(diagnosis_info);
    }
    public void medication(){
        panel.add(medication_panel = new RoundedPanel(50,new Color(0x4d5579)));
        medication_panel.setOpaque(false);
        medication_panel.setBorder(BorderFactory.createEmptyBorder());
        medication_panel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        c.weightx = 1.0;
        c.weighty = 1.0;
        medication_panel.setVisible(true);

        //Basic Details Title
        JLabel medication_label = new JLabel("Medication");
        medication_label.setFont(new Font("Helvetica", Font.BOLD, 25));
        medication_label.setForeground(Color.white);
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 0.5;
        c.insets = new Insets(20, 33, 2, 0);
        c.gridx = 0;
        c.gridy = 0;
        medication_panel.add(medication_label, c);
        c.weightx = 1.0;

        medication_content = new JTextArea();
        medication_content.setColumns(50);
        medication_content.setRows(1);
        medication_content.setLineWrap(true);
        medication_content.setWrapStyleWord(true);
        medication_content.setEditable(true);
        medication_content.setBackground(new Color(0x4d5579));
        medication_content.setForeground(Color.white);
        medication_content.setBorder(new LineBorder(Color.WHITE,2));
        medication_content.setFont(new Font("Helvetica", Font.PLAIN, 20));
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(15, 40, 15, 40);
        c.gridx = 0;
        c.gridy = 1;
        medication_panel.add(medication_content, c);
        medication_content.setText(medication_info);
    }

    public void setAllUneditable(){
        symptoms_content.setEditable(false);
        diagnosis_content.setEditable(false);
        medication_content.setEditable(false);
        confirm.setVisible(false);

    }

    public void setAllEditable(){
        symptoms_content.setEditable(true);
        diagnosis_content.setEditable(true);
        medication_content.setEditable(true);
        confirm.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back_button) {
            setVisible(false);
        }

        if (e.getSource() == edit){
            setAllEditable();
        }

        if (e.getSource() == confirm){
            InputDoc();
            setAllUneditable();
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


