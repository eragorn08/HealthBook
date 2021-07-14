package GUI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.Period;

public class PatientInformation extends JFrame implements ActionListener {
    private String[] level = {"--","1","2","3","4","5","6","7","8","9","10",};
    public JPanel panel = new JPanel();
    public JScrollPane scrollPane = new JScrollPane(panel);
    public RoundedPanel body_panel, vitalsigns, addOldPatient, adminAuthentication;
    public String lastname,firstname,midname,gend,addrress,ag,month,day,year,weigh,heigh,bt,bloodpressure,btp,
            lop, department,pulse,obp,obt,opr,olop,ohei,owei,ebp,doctor;
    private final String[] empty = {"","Name"};
    public JButton back_button, addrecord,editPatient,confirm_add_old, confirm_edit, cancel_edit;
    private JComboBox<String> painEntry;
    public JTextField surnameField, givennameField, middlenameFIeld, genderField, monthField,
            dayField, yearField, btypeField, ageField, heightField ,weightField,
            blpField0, tempeField,pulField,plevelField,bpEntry0,bpEntry1,tempEntry,pulseEntry,
            heightEntry,weightEntry;
    private JPasswordField adminPass;
    public JTextArea addressField;

    public int X = 0;
    public int Y = 0;

    public void setEditable(){
        surnameField.setEditable(true);
        givennameField.setEditable(true);
        middlenameFIeld.setEditable(true);
        genderField.setEditable(true);
        addressField.setEditable(true);
        monthField.setEditable(true);
        dayField.setEditable(true);
        yearField.setEditable(true);
        btypeField.setEditable(true);
        ageField.setEditable(true);
        heightField.setEditable(true);
        weightField.setEditable(true);
        blpField0.setEditable(true);
        tempeField.setEditable(true);
        pulField.setEditable(true);
        plevelField.setEditable(true);
        editPatient.setVisible(false);

        panel.add(Box.createRigidArea((new Dimension(5,20))));

        panel.add(adminAuthentication = new RoundedPanel(50,new Color(0x212C58)));
        adminAuthentication.setOpaque(false);
        adminAuthentication.setBorder(new LineBorder(new Color(0x212C58), 1));
        adminAuthentication.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        c.weightx = 0;
        c.weighty = 0;
        adminAuthentication.setVisible(true);

        JLabel basicDetails = new JLabel("<html><div style= 'text-align:center;'>" +
                "To make changes, type the Admin Employee ID to<br>allow this, and then " +
                "click Confirm<div></html>");
        basicDetails.setFont(new Font("Helvetica", Font.BOLD, 25));
        basicDetails.setForeground(Color.white);
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(0, 0, 30, 0);
        c.gridwidth = 2;
        c.gridx = 0;
        c.gridy = 0;
        adminAuthentication.add(basicDetails, c);

        JLabel AdminLabel = new JLabel("Administrator");
        AdminLabel.setFont(new Font("Helvetica", Font.BOLD, 25));
        AdminLabel.setForeground(Color.white);
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(0, 0, 0, 0);
        c.gridwidth = 1;
        c.gridx = 0;
        c.gridy = 1;
        adminAuthentication.add(AdminLabel, c);

        adminPass = new JPasswordField(10);
        adminPass.setEchoChar('•');
        adminPass.setFont(new Font("Helvetica", Font.PLAIN, 20));
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridwidth = 2;
        c.gridx = 0;
        c.gridy = 2;
        c.insets = new Insets(0, 0, 20, 0);
        adminAuthentication.add(adminPass, c);

        confirm_edit = new JButton(new ImageIcon("confirmedit.png"));
        confirm_edit.setContentAreaFilled(false);
        confirm_edit.setVisible(true);
        confirm_edit.setFocusPainted(false);
        confirm_edit.setBorder(BorderFactory.createEmptyBorder());
        confirm_edit.addActionListener(this);
        confirm_edit.setAlignmentX(Component.CENTER_ALIGNMENT);
        c.fill = GridBagConstraints.BOTH;
        c.gridwidth =1;
        c.gridx = 0;
        c.gridy = 3;
        adminAuthentication.add(confirm_edit, c);

        cancel_edit = new JButton(new ImageIcon("close.png"));
        cancel_edit.setContentAreaFilled(false);
        cancel_edit.setVisible(true);
        cancel_edit.setFocusPainted(false);
        cancel_edit.setBorder(BorderFactory.createEmptyBorder());
        cancel_edit.addActionListener(this);
        confirm_edit.setAlignmentX(Component.CENTER_ALIGNMENT);
        c.fill = GridBagConstraints.BOTH;
        c.gridwidth = 1;
        c.gridx = 1;
        c.gridy = 3;
        adminAuthentication.add(cancel_edit, c);
    }
    public void setNotEditable(){
        surnameField.setEditable(false);
        givennameField.setEditable(false);
        middlenameFIeld.setEditable(false);
        genderField.setEditable(false);
        addressField.setEditable(false);
        monthField.setEditable(false);
        dayField.setEditable(false);
        yearField.setEditable(false);
        btypeField.setEditable(false);
        ageField.setEditable(false);
        heightField.setEditable(false);
        weightField.setEditable(false);
        blpField0.setEditable(false);
        tempeField.setEditable(false);
        pulField.setEditable(false);
        plevelField.setEditable(false);
        editPatient.setVisible(true);

    }

    public void GetData() {
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connect = connectNow.getConnection();

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
                pulse = rs.getString("pulserate");
                department = rs.getString("department");
                doctor = rs.getString("doctor");
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

        editPatient = new JButton(new ImageIcon("edit.png"));
        editPatient.setContentAreaFilled(false);
        editPatient.setVisible(true);
        editPatient.setFocusPainted(false);
        editPatient.setBorder(BorderFactory.createEmptyBorder());
        editPatient.setAlignmentX(Component.CENTER_ALIGNMENT);
        editPatient.addActionListener(this);
        panel.add(editPatient);

        scrollPane = new JScrollPane(panel, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        scrollPane.setLayout(new ScrollPaneLayout());
        scrollPane.setBounds(0, 100, 1280, 620);

        add(scrollPane);

        setNotEditable();

        //Transfer Data
        surnameField.setText(lastname);
        givennameField.setText(firstname);
        middlenameFIeld.setText(midname);
        genderField.setText(gend);
        addressField.setText(addrress);
        monthField.setText(month);
        dayField.setText(day);
        yearField.setText(year);
        btypeField.setText(bt);
        ageField.setText(ag);
        heightField.setText(heigh);
        weightField.setText(weigh);
        blpField0.setText(bloodpressure);
        tempeField.setText(btp);
        pulField.setText(pulse);
        plevelField.setText(lop);
    }

    public void vitalSigns(){

        panel.add(vitalsigns = new RoundedPanel(50,new Color(0x4d5579)));
        vitalsigns.setOpaque(false);
        vitalsigns.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        c.weightx = 0;
        c.weighty = 0;

        vitalsigns.setVisible(true);

        //Vital Signs Title
        JLabel vitalSignsLabel = new JLabel("Vital Signs");
        vitalSignsLabel.setFont(new Font("Helvetica", Font.BOLD, 25));
        vitalSignsLabel.setForeground(Color.white);
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(40, 41, 2, 0);
        vitalsigns.add(vitalSignsLabel, c);
        c.weightx = 0;

        //Blood Pressure
        JLabel bpLabel = new JLabel("Blood Pressure:");
        bpLabel.setFont(new Font("Helvetica", Font.PLAIN, 20));
        bpLabel.setForeground(Color.white);
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(15, 41, 2, 0);
        c.gridx = 0;
        c.gridy = 1;
        vitalsigns.add(bpLabel, c);

        blpField0 =  new JTextField(10);
        blpField0.setFont(new Font("Helvetica", Font.PLAIN, 20));
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 1;
        vitalsigns.add(blpField0, c);

        //Body Temperature
        JLabel tempLabel = new JLabel("Body Temperature:");
        tempLabel.setFont(new Font("Helvetica", Font.PLAIN, 20));
        tempLabel.setForeground(Color.white);
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(15, 41, 2, 0);
        c.gridx = 0;
        c.gridy = 2;
        vitalsigns.add(tempLabel, c);

        tempeField =  new JTextField(10);
        tempeField.setFont(new Font("Helvetica", Font.PLAIN, 20));
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 2;
        vitalsigns.add(tempeField, c);

        JLabel degreeLabel = new JLabel("°C");
        degreeLabel.setFont(new Font("Helvetica", Font.PLAIN, 20));
        degreeLabel.setForeground(Color.white);
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(15, 41, 2, 0);
        c.gridx = 2;
        c.gridy = 2;
        vitalsigns.add(degreeLabel, c);

        //Pulse Rate
        JLabel pulseLabel = new JLabel("Pulse Rate:");
        pulseLabel.setFont(new Font("Helvetica", Font.PLAIN, 20));
        pulseLabel.setForeground(Color.white);
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(15, 41, 2, 0);
        c.gridx = 0;
        c.gridy = 3;
        vitalsigns.add(pulseLabel, c);

        pulField =  new JTextField(10);
        pulField.setFont(new Font("Helvetica", Font.PLAIN, 20));
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 3;
        vitalsigns.add(pulField, c);

        JLabel bpmLabel = new JLabel("bpm");
        bpmLabel.setFont(new Font("Helvetica", Font.PLAIN, 20));
        bpmLabel.setForeground(Color.white);
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(15, 41, 2, 0);
        c.gridx = 2;
        c.gridy = 3;
        vitalsigns.add(bpmLabel, c);

        //Level of Pain:
        JLabel painLabel = new JLabel("Level of Pain:");
        painLabel.setFont(new Font("Helvetica", Font.PLAIN, 20));
        painLabel.setForeground(Color.white);
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(15, 41, 14, 0);
        c.gridx = 0;
        c.gridy = 4;
        vitalsigns.add(painLabel, c);

        plevelField =  new JTextField(10);
        plevelField.setFont(new Font("Helvetica", Font.PLAIN, 20));
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 4;
        vitalsigns.add(plevelField, c);


        JLabel uwuut = new JLabel("asddsfdsfsdfhjjhhhasdfas");
        uwuut.setFont(new Font("Helvetica", Font.PLAIN, 20));
        uwuut.setForeground(new Color(0x4d5579));
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(0, 0, 0, 40);
        c.gridx = 3;
        c.gridy = 4;
        vitalsigns.add(uwuut, c);


        JLabel uwu = new JLabel("sdfasdfasdfasdf");
        uwu.setFont(new Font("Helvetica", Font.PLAIN, 20));
        uwu.setForeground(new Color(0x4d5579));
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(15, 0, 14, 0);
        c.gridx = 4;
        c.gridy = 4;
        vitalsigns.add(uwu, c);

        JLabel uwuu = new JLabel("asddsfdsfsdf");
        uwuu.setFont(new Font("Helvetica", Font.PLAIN, 20));
        uwuu.setForeground(new Color(0x4d5579));
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(0, 0, 0, 40);
        c.gridx = 5;
        c.gridy = 4;
        vitalsigns.add(uwuu, c);


        JLabel uwuutt = new JLabel("asddsfdsfsdf");
        uwuutt.setForeground(new Color(0x4d5579));
        uwuutt.setFont(new Font("Helvetica", Font.PLAIN, 20));
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridwidth = 2;
        c.gridx = 1;
        c.gridy = 5;
        vitalsigns.add(uwuutt, c);
        c.gridwidth = 1;



    }

    public void info() {
        //Basic Info Variables
        String no = SearchForm.value;
        String date = SearchForm.date;

        panel.add(body_panel = new RoundedPanel(50,new Color(0x4d5579)));
        body_panel.setOpaque(false);
        body_panel.setBorder(BorderFactory.createEmptyBorder());
        body_panel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        c.weightx = 0;
        c.weighty = 0;
        body_panel.setVisible(true);

        //Basic Details Title
        JLabel basicDetails = new JLabel("Basic Details");
        basicDetails.setFont(new Font("Helvetica", Font.BOLD, 25));
        basicDetails.setForeground(Color.white);
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(20, 33, 2, 0);
        c.gridx = 0;
        c.gridy = 0;
        body_panel.add(basicDetails, c);

        //Name
        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setFont(new Font("Helvetica", Font.PLAIN, 20));
        nameLabel.setForeground(Color.white);
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(15, 33, 2, 0);
        c.gridx = 0;
        c.gridy = 1;
        body_panel.add(nameLabel, c);

        surnameField = new JTextField(10);
        surnameField.setFont(new Font("Helvetica", Font.PLAIN, 20));
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 1;
        body_panel.add(surnameField, c);

        middlenameFIeld = new JTextField(10);
        middlenameFIeld.setFont(new Font("Helvetica", Font.PLAIN, 20));
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 3;
        c.gridy = 1;
        body_panel.add(middlenameFIeld, c);

        givennameField = new JTextField(10);
        givennameField.setFont(new Font("Helvetica", Font.PLAIN, 20));
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 2;
        c.gridy = 1;
        body_panel.add(givennameField, c);

        JLabel surnameLabel = new JLabel("Surname");
        surnameLabel.setFont(new Font("Helvetica", Font.PLAIN, 20));
        surnameLabel.setForeground(Color.white);
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(15, 33, 2, 0);
        c.gridx = 1;
        c.gridy = 2;
        body_panel.add(surnameLabel, c);

        JLabel givennameLabel = new JLabel("Given Name");
        givennameLabel.setFont(new Font("Helvetica", Font.PLAIN, 20));
        givennameLabel.setForeground(Color.white);
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(15, 33, 2, 0);
        c.gridx = 2;
        c.gridy = 2;
        body_panel.add(givennameLabel, c);

        JLabel middlenameLabel = new JLabel("Middle Name");
        middlenameLabel.setFont(new Font("Helvetica", Font.PLAIN, 20));
        middlenameLabel.setForeground(Color.white);
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(15, 33, 2, 0);
        c.gridx = 3;
        c.gridy = 2;
        body_panel.add(middlenameLabel, c);

        //Sex
        JLabel sexLabel = new JLabel("Sex:");
        sexLabel.setFont(new Font("Helvetica", Font.PLAIN, 20));
        sexLabel.setForeground(Color.white);
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(15, 33, 2, 0);
        c.gridx = 0;
        c.gridy = 3;
        body_panel.add(sexLabel, c);

        genderField = new JTextField(10);
        genderField.setFont(new Font("Helvetica", Font.PLAIN, 20));
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 3;
        body_panel.add(genderField, c);

        //Address
        JLabel addressLabel = new JLabel("Address:");
        addressLabel.setFont(new Font("Helvetica", Font.PLAIN, 20));
        addressLabel.setForeground(Color.white);
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(15, 33, 2, 0);
        c.gridx = 0;
        c.gridy = 4;
        body_panel.add(addressLabel, c);

        addressField = new JTextArea();
        addressField.setColumns(20);
        addressField.setRows(2);
        addressField.setLineWrap(true);
        addressField.setWrapStyleWord(true);
        addressField.setEditable(true);
        addressField.setFont(new Font("Helvetica", Font.PLAIN, 20));
        c.fill = GridBagConstraints.BOTH;
        c.gridwidth = 2;
        c.gridx = 1;
        c.gridy = 4;
        body_panel.add(addressField, c);
        c.gridwidth = 1;

        //Date of Birth:
        JLabel birthLabel = new JLabel("Date of Birth:");
        birthLabel.setFont(new Font("Helvetica", Font.PLAIN, 20));
        birthLabel.setForeground(Color.white);
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(15, 33, 2, 0);
        c.gridx = 0;
        c.gridy = 5;
        body_panel.add(birthLabel, c);

        yearField = new JTextField(4);
        yearField.setFont(new Font("Helvetica", Font.PLAIN, 20));
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 5;
        body_panel.add(yearField, c);

        JLabel yyyyLabel = new JLabel("YYYY");
        yyyyLabel.setFont(new Font("Helvetica", Font.PLAIN, 20));
        yyyyLabel.setForeground(Color.white);
        yyyyLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(15, 33, 2, 0);
        c.gridx = 1;
        c.gridy = 6;
        body_panel.add(yyyyLabel, c);

        monthField = new JTextField(2);
        monthField.setFont(new Font("Helvetica", Font.PLAIN, 20));
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 2;
        c.gridy = 5;
        body_panel.add(monthField, c);

        JLabel mmLabel = new JLabel("MM");
        mmLabel.setFont(new Font("Helvetica", Font.PLAIN, 20));
        mmLabel.setForeground(Color.white);
        mmLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(15, 33, 2, 0);
        c.gridx = 2;
        c.gridy = 6;
        body_panel.add(mmLabel, c);

        dayField = new JTextField(2);
        dayField.setFont(new Font("Helvetica", Font.PLAIN, 20));
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 3;
        c.gridy = 5;
        body_panel.add(dayField, c);

        JLabel ddLabel = new JLabel("DD");
        ddLabel.setFont(new Font("Helvetica", Font.PLAIN, 20));
        ddLabel.setForeground(Color.white);
        ddLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(15, 33, 2, 0);
        c.gridx = 3;
        c.gridy = 6;
        body_panel.add(ddLabel, c);

        //Blood Type:
        JLabel bloodTypeLabel = new JLabel("Blood Type:");
        bloodTypeLabel.setFont(new Font("Helvetica", Font.PLAIN, 20));
        bloodTypeLabel.setForeground(Color.white);
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(15, 33, 2, 0);
        c.gridx = 0;
        c.gridy = 7;
        body_panel.add(bloodTypeLabel, c);

        btypeField = new JTextField(10);
        btypeField.setFont(new Font("Helvetica", Font.PLAIN, 20));
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 7;
        body_panel.add(btypeField, c);

        //Age:
        JLabel ageLabel = new JLabel("Age:");
        ageLabel.setFont(new Font("Helvetica", Font.PLAIN, 20));
        ageLabel.setForeground(Color.white);
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(15, 33, 2, 0);
        c.gridx = 0;
        c.gridy = 8;
        body_panel.add(ageLabel, c);

        ageField = new JTextField(10);
        ageField.setFont(new Font("Helvetica", Font.PLAIN, 20));
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 8;
        body_panel.add(ageField, c);

        //Height
        JLabel heightLabel = new JLabel("Height:");
        heightLabel.setFont(new Font("Helvetica", Font.PLAIN, 20));
        heightLabel.setForeground(Color.white);
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(15, 33, 2, 0);
        c.gridx = 0;
        c.gridy = 9;
        body_panel.add(heightLabel, c);

        heightField = new JTextField(10);
        heightField.setFont(new Font("Helvetica", Font.PLAIN, 20));
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 9;
        body_panel.add(heightField, c);

        JLabel cmLabel = new JLabel("cm");
        cmLabel.setFont(new Font("Helvetica", Font.PLAIN, 20));
        cmLabel.setForeground(Color.white);
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(15, 33, 2, 0);
        c.gridx = 2;
        c.gridy = 9;
        body_panel.add(cmLabel, c);

        //Weight
        JLabel weightLabel = new JLabel("Weight:");
        weightLabel.setFont(new Font("Helvetica", Font.PLAIN, 20));
        weightLabel.setForeground(Color.white);
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(15, 33, 14, 0);
        c.gridx = 0;
        c.gridy = 10;
        body_panel.add(weightLabel, c);

        weightField = new JTextField(10);
        weightField.setFont(new Font("Helvetica", Font.PLAIN, 20));
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 10;
        body_panel.add(weightField, c);

        JLabel kgLabel = new JLabel("kg");
        kgLabel.setFont(new Font("Helvetica", Font.PLAIN, 20));
        kgLabel.setForeground(Color.white);
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(15, 33, 2, 0);
        c.gridx = 2;
        c.gridy = 10;
        body_panel.add(kgLabel, c);

        //Patient No.:
        JLabel patientNoLabel = new JLabel("Patient No.: " + no);
        patientNoLabel.setFont(new Font("Helvetica", Font.PLAIN, 20));
        patientNoLabel.setForeground(Color.white);
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(15, 33, 5, 0);
        c.gridx = 5;
        c.gridy = 1;
        body_panel.add(patientNoLabel, c);

        //Date:
        JLabel DateLabel = new JLabel("Date: " + date);
        DateLabel.setFont(new Font("Helvetica", Font.PLAIN, 20));
        DateLabel.setForeground(Color.white);
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(15, 33, 5, 40);
        c.gridx = 5;
        c.gridy = 2;
        body_panel.add(DateLabel, c);

        //Date:
        JLabel DeptLabel = new JLabel("Dept: " + department);
        DeptLabel.setFont(new Font("Helvetica", Font.PLAIN, 20));
        DeptLabel.setForeground(Color.white);
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(15, 33, 5, 0);
        c.gridx = 5;
        c.gridy = 3;
        body_panel.add(DeptLabel, c);

        //Date:
        JLabel docLabel = new JLabel("Doctor ID: " + doctor);
        docLabel.setFont(new Font("Helvetica", Font.PLAIN, 20));
        docLabel.setForeground(Color.white);
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(15, 33, 5, 0);
        c.gridx = 5;
        c.gridy = 4;
        body_panel.add(docLabel, c);

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

        bpEntry0 = new JTextField(3);
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

        bpEntry1 = new JTextField(3);
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

        tempEntry = new JTextField(5);
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

        pulseEntry = new JTextField(5);
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

        painEntry = new JComboBox<>(level);
        painEntry.setFont(new Font("Helvetica", Font.PLAIN, 20));
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 4;
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

        heightEntry = new JTextField(5);
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

        weightEntry = new JTextField(5);
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

        confirm_add_old = new JButton(new ImageIcon("confirm_logo.png"));
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
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        obp = bpEntry0.getText() + "/" + bpEntry1.getText();
        obt = tempEntry.getText();
        opr = pulseEntry.getText();
        olop = (String) painEntry.getSelectedItem();
        ohei = heightEntry.getText();
        owei = weightEntry.getText();

        //Date Parsing
        LocalDate selectedDate = LocalDate.of(Integer.parseInt(year),Integer.parseInt(month),Integer.parseInt(day));
        LocalDate currentDate = LocalDate.now();
        int result = Period.between(selectedDate,currentDate).getYears();
        String age = Integer.toString(result);

        String insertFields = "INSERT INTO patientinfo(surname,givenname,middlename,gender,address,age,month," +
                "day,year,weight,height,bloodtype,bloodpressure,bodytemp,levelofpain,pulserate,department) VALUES ('";
        String insertValue = lastname + "','" + firstname + "','" + midname + "','" + gend + "','" + addrress + "','" +
                age + "','" + month + "','" + day + "','" + year + "','" + owei + "','" + ohei + "','" + btp + "','" +
                obp + "','" + obt + "','" + olop + "','" + opr + "','"+LoginForm.dept+"')";
        String insertPatient = insertFields + insertValue;

        try{
            Statement statement = connectDB.createStatement();
            statement.executeUpdate(insertPatient);
            JOptionPane.showMessageDialog(null, "Patient Record Added!");
            SearchForm.gettableData(empty);
        }
        catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }

    public void editinsert(){
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        lastname = surnameField.getText();
        firstname = givennameField.getText();
        midname = middlenameFIeld.getText();
        gend = genderField.getText();
        addrress = addressField.getText();
        ag = ageField.getText();
        month = monthField.getText();
        day = dayField.getText();
        year = yearField.getText();
        weigh = weightField.getText();
        heigh = heightField.getText();
        bt = btypeField.getText();
        ebp = blpField0.getText();
        bt = tempeField.getText();
        lop = plevelField.getText();
        pulse = pulField.getText();

        String insertFields = "UPDATE patientinfo SET surname = '"+lastname+"',givenname = '"+firstname+"',middlename = " +
                "'"+midname+"',gender = '"+gend+"',address='"+addrress+"',age='"+ag+"',month='"+month+"',day='"+day+"'," +
                "year='"+year+"',weight='"+weigh+"',height='"+heigh+"',bloodtype='"+bt+"',bloodpressure='"+ebp+"',bodytemp='"+bt+"'" +
                ",levelofpain='"+lop+"',pulserate='"+pulse+"' WHERE patientID = '"+SearchForm.value+"'";

        try{
            Statement statement = connectDB.createStatement();
            statement.executeUpdate(insertFields);
        }
        catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }

    }

    //admin authentication
    public void autheticate(){
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        String verifyLogin = "SELECT count(1) FROM accounts WHERE Username = '" +adminPass.getText()+ "' AND Position = 'Admin'";

        try {
            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(verifyLogin);
            while(queryResult.next()){
                if (queryResult.getInt(1) == 1) {
                    editinsert();
                    JOptionPane.showMessageDialog(null, "Account has Been Edited");
                    SearchForm.gettableData(empty);
                }else{
                    JOptionPane.showMessageDialog(null, "Wrong Username for Admin.");
                }
            }

        }catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back_button) {
            SearchForm.gettableData(empty);
            setVisible(false);
        }

        if (e.getSource() == addrecord) {
            editPatient.setVisible(false);
            addrecord.setVisible(false);
            OldPatient();
        }

        if (e.getSource() == editPatient){
            addrecord.setVisible(false);
            setEditable();
        }

        if (e.getSource() == confirm_add_old){
            editPatient.setVisible(true);
            InsertOldPatient();
            dispose();
        }
        if (e.getSource() == confirm_edit){
            addrecord.setVisible(true);
            adminAuthentication.setVisible(false);
            autheticate();
            setNotEditable();
        }

        if (e.getSource() == cancel_edit){
            addrecord.setVisible(true);
            editPatient.setVisible(true);
            adminAuthentication.setVisible(false);
            setNotEditable();
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