package GUI;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Calendar;

//import javax.swing.JFrame;

public class AddForm extends JPanel implements ActionListener {

    public AddForm(){
        setLayout(null);
        addFormTitle();
        addForm();
    }
    public void addFormTitle(){
        setBackground(new Color(0x212C58));
        JLabel addPatientTitle = new JLabel("Add Patient");
        addPatientTitle.setFont(new Font("Helvetica", Font.PLAIN, 40));
        addPatientTitle.setForeground(Color.white);
        addPatientTitle.setBounds(22, 19, 275, 55);
        add(addPatientTitle);
    }

    public void addForm(){

        String[] bloodTypes = {"--", "A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-"};
       //Border border = new LineBorder(new Color(0x374169),1,false);
        JPanel addFormPanel = new JPanel();
        addFormPanel.setLayout(null);
        //addFormPanel.setBorder(border);
        addFormPanel.setBackground(new Color(0x212C58));
        addFormPanel.setBounds(0,75,994,579);

        //JScrollPane scroll = new JScrollPane(addFormPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        //Create a form
        JLabel slashLabel1 = new JLabel("/");
        slashLabel1.setFont(new Font("Helvetica", Font.PLAIN, 20));
        slashLabel1.setHorizontalTextPosition(JLabel.CENTER);
        slashLabel1.setForeground(Color.white);
        JLabel slashLabel0 = new JLabel("/");
        slashLabel0.setFont(new Font("Helvetica", Font.PLAIN, 20));
        slashLabel0.setForeground(Color.white);
        slashLabel0.setHorizontalTextPosition(JLabel.CENTER);
        JLabel slashLabel2 = new JLabel("/");
        slashLabel2.setFont(new Font("Helvetica", Font.PLAIN, 20));
        slashLabel2.setForeground(Color.white);
        slashLabel2.setHorizontalTextPosition(JLabel.CENTER);

        //NAME FORM
        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setFont(new Font("Helvetica", Font.PLAIN, 20));
        nameLabel.setForeground(Color.white);
        nameLabel.setBounds(25,22, 74,25);
        addFormPanel.add(nameLabel);

        JLabel surnameLabel = new JLabel("Surname");
        surnameLabel.setFont(new Font("Helvetica", Font.PLAIN, 20));
        surnameLabel.setForeground(Color.white);
        surnameLabel.setBounds(183,57, 107,25);
        addFormPanel.add(surnameLabel);

        JLabel firstLabel = new JLabel("Given Name");
        firstLabel.setFont(new Font("Helvetica", Font.PLAIN, 20));
        firstLabel.setForeground(Color.WHITE);
        firstLabel.setBounds(390,57, 142,25);
        addFormPanel.add(firstLabel);

        JLabel middleLabel = new JLabel("Middle Name");
        middleLabel.setFont(new Font("Helvetica", Font.PLAIN, 20));
        middleLabel.setForeground(Color.WHITE);
        middleLabel.setBounds(613,57, 150,25);
        addFormPanel.add(middleLabel);

        surnameField = new JTextField();
        surnameField.setBounds(136, 22, 200, 28);
        surnameField.setBorder(BorderFactory.createEmptyBorder());
        surnameField.setFont(new Font("Helvetica", Font.PLAIN, 20));
        surnameField.setHorizontalAlignment(JTextField.CENTER);
        addFormPanel.add(surnameField);

        firstnameField = new JTextField();
        firstnameField.setBounds(368, 22, 200, 28);
        firstnameField.setBorder(BorderFactory.createEmptyBorder());
        firstnameField.setFont(new Font("Helvetica", Font.PLAIN, 20));
        firstnameField.setHorizontalAlignment(JTextField.CENTER);
        addFormPanel.add(firstnameField);

        middlenameField = new JTextField();
        middlenameField.setBounds(593, 22, 200, 28);
        middlenameField.setBorder(BorderFactory.createEmptyBorder());
        middlenameField.setFont(new Font("Helvetica", Font.PLAIN, 20));
        middlenameField.setHorizontalAlignment(JTextField.CENTER);
        addFormPanel.add(middlenameField);


        //SEX FORM
        JLabel sexLabel = new JLabel("Sex:");
        sexLabel.setFont(new Font("Helvetica", Font.PLAIN, 20));
        sexLabel.setForeground(Color.WHITE);
        sexLabel.setBounds(25,92, 52,25);
        addFormPanel.add(sexLabel);

        JLabel maleLabel = new JLabel("Male");
        maleLabel.setFont(new Font("Helvetica", Font.PLAIN, 20));
        maleLabel.setForeground(Color.WHITE);
        maleLabel.setBounds(176,92, 57,25);
        addFormPanel.add(maleLabel);

        JLabel femaleLabel = new JLabel("Female");
        femaleLabel.setFont(new Font("Helvetica", Font.PLAIN, 20));
        femaleLabel.setForeground(Color.WHITE);
        femaleLabel.setBounds(321,92, 85,25);
        addFormPanel.add(femaleLabel);

        maleRadioButton = new JRadioButton();
        maleRadioButton.setBounds(143,92,25,25);
        maleRadioButton.setBackground(new Color(0x212C58));
        addFormPanel.add(maleRadioButton);

        femaleRadioButton = new JRadioButton();
        femaleRadioButton.setBounds(290,92,25,25);
        femaleRadioButton.setBackground(new Color(0x212C58));
        addFormPanel.add(femaleRadioButton);

        //RADIO BUTTON GROUP
        ButtonGroup Gender = new ButtonGroup();
        Gender.add(maleRadioButton);
        Gender.add(femaleRadioButton);

        //ADDRESS FORM
        JLabel addressLabel = new JLabel("Address:");
        addressLabel.setFont(new Font("Helvetica", Font.PLAIN, 20));
        addressLabel.setForeground(Color.WHITE);
        addressLabel.setBounds(25,135, 100,25);
        addFormPanel.add(addressLabel);

        addressField = new JTextArea();
        addressField.setEditable(true);
        JScrollPane AddressScroll = new JScrollPane(addressField);
        addressField.setFont(new Font("Helvetica", Font.PLAIN, 20));
        addressField.setBounds(136,135, 772,59);
        addFormPanel.add(addressField);


        //AGE FORM
        JLabel ageLabel = new JLabel("Age:");
        ageLabel.setFont(new Font("Helvetica", Font.PLAIN, 20));
        ageLabel.setForeground(Color.WHITE);
        ageLabel.setBounds(25,213, 59,25);
        addFormPanel.add(ageLabel);

        ageField = new JTextField();
        ageField.setBounds(136, 213, 100, 28);
        ageField.setBorder(BorderFactory.createEmptyBorder());
        ageField.setFont(new Font("Helvetica", Font.PLAIN, 20));
        ageField.setHorizontalAlignment(JTextField.CENTER);
        ageField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent ke) {
                ageField.setEditable(ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9'
                        || ke.getKeyChar() == KeyEvent.VK_BACK_SPACE);
            }
        });
        addFormPanel.add(ageField);


        //BIRTHDAY FORM
        JLabel birthLabel = new JLabel("Date of Birth:");
        birthLabel.setFont(new Font("Helvetica", Font.PLAIN, 20));
        birthLabel.setForeground(Color.WHITE);
        birthLabel.setBounds(349,215, 151,25);
        addFormPanel.add(birthLabel);

        JLabel mmLabel = new JLabel("MM");
        mmLabel.setFont(new Font("Helvetica", Font.PLAIN, 20));
        mmLabel.setForeground(Color.WHITE);
        mmLabel.setBounds(550,244, 88,25);
        addFormPanel.add(mmLabel);

        JLabel ddLabel = new JLabel("DD");
        ddLabel.setFont(new Font("Helvetica", Font.PLAIN, 20));
        ddLabel.setForeground(Color.WHITE);
        ddLabel.setBounds(690,244, 88,25);
        addFormPanel.add(ddLabel);

        JLabel yyLabel = new JLabel("YYYY");
        yyLabel.setFont(new Font("Helvetica", Font.PLAIN, 20));
        yyLabel.setForeground(Color.WHITE);
        yyLabel.setBounds(814,244, 88,25);
        addFormPanel.add(yyLabel);

        slashLabel0.setBounds(640, 215, 13, 20);
        addFormPanel.add(slashLabel0);
        slashLabel1.setBounds(779, 215, 13, 20);
        addFormPanel.add(slashLabel1);


        monthField = new JTextField();
        monthField.setBounds(513, 215, 120, 28);
        monthField.setBorder(BorderFactory.createEmptyBorder());
        monthField.setFont(new Font("Helvetica", Font.PLAIN, 20));
        monthField.setHorizontalAlignment(JTextField.CENTER);
        monthField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent ke) {
                String value = monthField.getText();
                int l = value.length();
                if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9'
                        || ke.getKeyChar() == KeyEvent.VK_BACK_SPACE){
                    if (l != 2)
                        monthField.setEditable(true);
                    else
                        monthField.setEditable(ke.getKeyChar() == KeyEvent.VK_BACK_SPACE);
                }
                else {
                    monthField.setEditable(false);
                }
            }

        });

        addFormPanel.add(monthField);

        dayField = new JTextField();
        dayField.setBounds(652, 215, 120, 28);
        dayField.setBorder(BorderFactory.createEmptyBorder());
        dayField.setFont(new Font("Helvetica", Font.PLAIN, 20));
        dayField.setHorizontalAlignment(JTextField.CENTER);
        dayField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent ke) {
                String value = dayField.getText();
                int l = value.length();
                if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9'
                        || ke.getKeyChar() == KeyEvent.VK_BACK_SPACE){
                    if (l != 2)
                        dayField.setEditable(true);
                    else
                        dayField.setEditable(ke.getKeyChar() == KeyEvent.VK_BACK_SPACE);
                }
                else {
                    dayField.setEditable(false);
                }
            }
        });
        addFormPanel.add(dayField);

        yearField = new JTextField();
        yearField.setBounds(791, 215, 120, 28);
        yearField.setBorder(BorderFactory.createEmptyBorder());
        yearField.setFont(new Font("Helvetica", Font.PLAIN, 20));
        yearField.setHorizontalAlignment(JTextField.CENTER);
        yearField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent ke) {
                String value = yearField.getText();
                int l = value.length();
                if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9'
                        || ke.getKeyChar() == KeyEvent.VK_BACK_SPACE){
                    if (l != 4)
                        yearField.setEditable(true);
                    else
                        yearField.setEditable(ke.getKeyChar() == KeyEvent.VK_BACK_SPACE);
                }
                else {
                    yearField.setEditable(false);
                }
            }
        });
        addFormPanel.add(yearField);


        //WEIGHT AND HEIGHT LABEL
        JLabel weightLabel = new JLabel("Weight:");
        weightLabel.setFont(new Font("Helvetica", Font.PLAIN, 20));
        weightLabel.setForeground(Color.WHITE);
        weightLabel.setBounds(25,281, 88,25);
        addFormPanel.add(weightLabel);

        JLabel heightLabel = new JLabel("Height:");
        heightLabel.setFont(new Font("Helvetica", Font.PLAIN, 20));
        heightLabel.setForeground(Color.WHITE);
        heightLabel.setBounds(348,281, 85,25);
        addFormPanel.add(heightLabel);

        JLabel kgLabel = new JLabel("kg");
        kgLabel.setFont(new Font("Helvetica", Font.PLAIN, 20));
        kgLabel.setForeground(Color.WHITE);
        kgLabel.setBounds(258,281, 30,25);
        addFormPanel.add(kgLabel);

        JLabel cmLabel = new JLabel("cm");
        cmLabel.setFont(new Font("Helvetica", Font.PLAIN, 20));
        cmLabel.setForeground(Color.WHITE);
        cmLabel.setBounds(628,281, 48,25);
        addFormPanel.add(cmLabel);

        weightField = new JTextField();
        weightField.setBounds(136, 281, 100, 28);
        weightField.setBorder(BorderFactory.createEmptyBorder());
        weightField.setFont(new Font("Helvetica", Font.PLAIN, 20));
        weightField.setHorizontalAlignment(JTextField.CENTER);
        weightField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent ke) {
                weightField.setEditable(ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9'
                        || ke.getKeyChar() == KeyEvent.VK_BACK_SPACE || ke.getKeyChar() == '.');
            }
        });
        addFormPanel.add(weightField);

        heightField = new JTextField();
        heightField.setBounds(513, 280, 100, 28);
        heightField.setBorder(BorderFactory.createEmptyBorder());
        heightField.setFont(new Font("Helvetica", Font.PLAIN, 20));
        heightField.setHorizontalAlignment(JTextField.CENTER);
        heightField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent ke) {
                heightField.setEditable(ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9'
                        || ke.getKeyChar() == KeyEvent.VK_BACK_SPACE || ke.getKeyChar() == '.');
            }
        });
        addFormPanel.add(heightField);


        //BLOOD FORM
        JLabel bloodtypeLabel = new JLabel("<html>Blood<br>Type:</html>");
        bloodtypeLabel.setFont(new Font("Helvetica", Font.PLAIN, 20));
        bloodtypeLabel.setForeground(Color.WHITE);
        bloodtypeLabel.setBounds(25,329, 69,62);
        addFormPanel.add(bloodtypeLabel);

        JLabel bloodpressureLabel = new JLabel("<html>Blood<br>Pressure:</html>");
        bloodpressureLabel.setFont(new Font("Helvetica", Font.PLAIN, 20));
        bloodpressureLabel.setForeground(Color.WHITE);
        bloodpressureLabel.setBounds(348,337, 109,62);
        addFormPanel.add(bloodpressureLabel);

        slashLabel2.setBounds(620, 349, 14, 20);
        addFormPanel.add(slashLabel2);

        bloodtypeField = new JComboBox<>(bloodTypes);
        bloodtypeField.setBounds(136,349,100,28);
        bloodtypeField.setFont(new Font("Helvetica", Font.PLAIN, 20));
        addFormPanel.add(bloodtypeField);

        bloodPressureField1 = new JTextField();
        bloodPressureField1.setBounds(513,349,100,28);
        bloodPressureField1.setFont(new Font("Helvetica", Font.PLAIN, 20));
        bloodPressureField1.setHorizontalAlignment(JTextField.CENTER);
        bloodPressureField1.setBorder(BorderFactory.createEmptyBorder());
        bloodPressureField1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent ke) {
                bloodPressureField1.setEditable(ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9'
                        || ke.getKeyChar() == KeyEvent.VK_BACK_SPACE);
            }
        });
        addFormPanel.add(bloodPressureField1);

        bloodPressureField2 = new JTextField();
        bloodPressureField2.setBounds(647,349,100,28);
        bloodPressureField2.setFont(new Font("Helvetica", Font.PLAIN, 20));
        bloodPressureField2.setHorizontalAlignment(JTextField.CENTER);
        bloodPressureField2.setBorder(BorderFactory.createEmptyBorder());
        bloodPressureField2.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent ke) {
                bloodPressureField2.setEditable(ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9'
                        || ke.getKeyChar() == KeyEvent.VK_BACK_SPACE);
            }
        });
        addFormPanel.add(bloodPressureField2);


        //BODY TEMPERATURE
        JLabel bodyTempLabel = new JLabel("<html>Body<br>Temp:</html>");
        bodyTempLabel.setFont(new Font("Helvetica", Font.PLAIN, 20));
        bodyTempLabel.setForeground(Color.WHITE);
        bodyTempLabel.setBounds(22,398, 109,58);
        addFormPanel.add(bodyTempLabel);

        bodyTempField = new JTextField();
        bodyTempField.setBounds(136,417,100,28);
        bodyTempField.setFont(new Font("Helvetica", Font.PLAIN, 20));
        bodyTempField.setHorizontalAlignment(JTextField.CENTER);
        bodyTempField.setBorder(BorderFactory.createEmptyBorder());
        bodyTempField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent ke) {
                bodyTempField.setEditable(ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9'
                        || ke.getKeyChar() == KeyEvent.VK_BACK_SPACE || ke.getKeyChar() == '.');
            }
        });
        addFormPanel.add(bodyTempField);

        JLabel celsiusLabel = new JLabel("°C");
        celsiusLabel.setFont(new Font("Helvetica", Font.PLAIN, 20));
        celsiusLabel.setForeground(Color.WHITE);
        celsiusLabel.setBounds(251,423, 30,25);
        addFormPanel.add(celsiusLabel);


        //LEVEL OF PAIN
        JLabel levelofpainLabel = new JLabel("<html>Level of<br>Pain:</html>");
        levelofpainLabel.setFont(new Font("Helvetica", Font.PLAIN, 20));
        levelofpainLabel.setForeground(Color.WHITE);
        levelofpainLabel.setBounds(22,463, 109,58);
        addFormPanel.add(levelofpainLabel);

        levelofpainField = new JTextField();
        levelofpainField.setBounds(136,478,100,28);
        levelofpainField.setFont(new Font("Helvetica", Font.PLAIN, 20));
        levelofpainField.setHorizontalAlignment(JTextField.CENTER);
        levelofpainField.setBorder(BorderFactory.createEmptyBorder());
        levelofpainField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent ke) {
                levelofpainField.setEditable(ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9'
                        || ke.getKeyChar() == KeyEvent.VK_BACK_SPACE);
            }
        });
        addFormPanel.add(levelofpainField);



        confirm = new JButton(new ImageIcon("confirm_logo.png"));
        confirm.setFocusPainted(false);
        confirm.setBorder(BorderFactory.createEmptyBorder());
        confirm.setContentAreaFilled(false);
        confirm.setBounds(768,521,161,41);
        confirm.addActionListener(this);
        addFormPanel.add(confirm);


        add(addFormPanel);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == confirm) {
            InputPatient();
            JOptionPane.showMessageDialog(null, "Patient Information has Been Added!");
            clearinput();
        }
    }

    public void InputPatient(){
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        //Input Variables
        String surname = surnameField.getText();
        String firstname = firstnameField.getText();
        String middlename = middlenameField.getText();
        String age = ageField.getText();
        String month = monthField.getText();
        String day = dayField.getText();
        String year = yearField.getText();
        String weight = weightField.getText();
        String height = heightField.getText();
        String bloodpressure = bloodPressureField1.getText() + '/' + bloodPressureField2.getText();
        String bodyTemp = bodyTempField.getText();
        String painlevel = levelofpainField.getText();

        if(maleRadioButton.isSelected()){
            gender = "Male";
        }
        if(femaleRadioButton.isSelected()){
            gender = "Female";
        }
        String bloodtype = (String) bloodtypeField.getSelectedItem();
        String address = addressField.getText();

        //Input Database
        String  insertFields = "INSERT INTO patientinfo(surname,givenname,middlename,gender,address,age,month," +
                "day,year,weight,height,bloodtype,bloodpressure,bodytemp,levelofpain) VALUES ('";
        String insertValue = surname + "','" + firstname + "','" + middlename + "','" + gender + "','" + address + "','" +
                age + "','" + month + "','" + day + "','" + year + "','" + weight + "','" + height + "','" + bloodtype + "','" +
                bloodpressure + "','" + bodyTemp + "','" + painlevel + "')";
        String insertPatient = insertFields + insertValue;

        try{
            Statement statement = connectDB.createStatement();
            statement.executeUpdate(insertPatient);
        }
        catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }
    public void clearinput(){
        surnameField.setText("");
        firstnameField.setText("");
        middlenameField.setText("");
        ageField.setText("");
        monthField.setText("");
        dayField.setText("");
        yearField.setText("");
        weightField.setText("");
        heightField.setText("");
        bloodPressureField1.setText("");
        bloodPressureField2.setText("");
        bodyTempField.setText("");
        levelofpainField.setText("");
        addressField.setText("");
        bloodtypeField.setSelectedIndex(0);
    }
    private JTextField surnameField,firstnameField,middlenameField,ageField,monthField,dayField,yearField,
            weightField,heightField,bloodPressureField1,bloodPressureField2,bodyTempField,levelofpainField;
    private JComboBox<String> bloodtypeField;
    private JRadioButton maleRadioButton,femaleRadioButton;
    private JTextArea addressField;
    private JButton confirm;
    private String gender;
}

