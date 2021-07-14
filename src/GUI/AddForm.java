package GUI;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.Period;

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
        String[] level = {"--","1","2","3","4","5","6","7","8","9","10",};
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

        JLabel surnameLabel = new JLabel("  Surname");
        surnameLabel.setFont(new Font("Helvetica", Font.PLAIN, 20));
        surnameLabel.setForeground(Color.white);
        surnameLabel.setBounds(186,57, 107,25);
        addFormPanel.add(surnameLabel);

        JLabel firstLabel = new JLabel("  Given Name");
        firstLabel.setFont(new Font("Helvetica", Font.PLAIN, 20));
        firstLabel.setForeground(Color.WHITE);
        firstLabel.setBounds(395,57, 142,25);
        addFormPanel.add(firstLabel);

        JLabel middleLabel = new JLabel("  Middle Name");
        middleLabel.setFont(new Font("Helvetica", Font.PLAIN, 20));
        middleLabel.setForeground(Color.WHITE);
        middleLabel.setBounds(617,57, 150,25);
        addFormPanel.add(middleLabel);

        surnameField = new JTextField();
        surnameField.setBounds(136, 22, 200, 28);
        surnameField.setBorder(BorderFactory.createEmptyBorder());
        surnameField.setFont(new Font("Helvetica", Font.PLAIN, 20));
        surnameField.setHorizontalAlignment(JTextField.CENTER);
        surnameField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent ke) {
                surnameField.setEditable(!(ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9'));
            }
        });
        addFormPanel.add(surnameField);

        firstnameField = new JTextField();
        firstnameField.setBounds(368, 22, 200, 28);
        firstnameField.setBorder(BorderFactory.createEmptyBorder());
        firstnameField.setFont(new Font("Helvetica", Font.PLAIN, 20));
        firstnameField.setHorizontalAlignment(JTextField.CENTER);
        firstnameField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent ke) {
                firstnameField.setEditable(!(ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9'));
            }
        });
        addFormPanel.add(firstnameField);

        middlenameField = new JTextField();
        middlenameField.setBounds(593, 22, 200, 28);
        middlenameField.setBorder(BorderFactory.createEmptyBorder());
        middlenameField.setFont(new Font("Helvetica", Font.PLAIN, 20));
        middlenameField.setHorizontalAlignment(JTextField.CENTER);
        middlenameField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent ke) {
                middlenameField.setEditable(!(ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9'));
            }
        });
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
        Gender = new ButtonGroup();
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


        //BIRTHDAY FORM
        JLabel birthLabel = new JLabel("<html>Date of<br>Birth:</html>");
        birthLabel.setFont(new Font("Helvetica", Font.PLAIN, 20));
        birthLabel.setForeground(Color.WHITE);
        birthLabel.setBounds(25,213, 151,62);
        addFormPanel.add(birthLabel);

        birthField = new JDateChooser();
        birthField.setBounds(136, 213, 200, 28);
        birthField.setBorder(BorderFactory.createEmptyBorder());
        birthField.setFont(new Font("Helvetica", Font.PLAIN, 20));
        birthField.setDateFormatString("dd/MM/yyyy");
        addFormPanel.add(birthField);

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

        //PULSE RATE
        pulseField = new JTextField();
        pulseField.setBounds(513, 417, 100, 28);
        pulseField.setBorder(BorderFactory.createEmptyBorder());
        pulseField.setFont(new Font("Helvetica", Font.PLAIN, 20));
        pulseField.setHorizontalAlignment(JTextField.CENTER);
        pulseField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent ke) {
                pulseField.setEditable(ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9'
                        || ke.getKeyChar() == KeyEvent.VK_BACK_SPACE || ke.getKeyChar() == '.');
            }
        });
        addFormPanel.add(pulseField);

        JLabel pulseLabel = new JLabel("<html>Pulse<br>Rate:</html>");
        pulseLabel.setFont(new Font("Helvetica", Font.PLAIN, 20));
        pulseLabel.setForeground(Color.WHITE);
        pulseLabel.setBounds(348,402, 109,48);
        addFormPanel.add(pulseLabel);

        JLabel bpmLabel = new JLabel("bpm");
        bpmLabel.setFont(new Font("Helvetica", Font.PLAIN, 20));
        bpmLabel.setForeground(Color.WHITE);
        bpmLabel.setBounds(628,423, 48,25);
        addFormPanel.add(bpmLabel);


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





        levelofpainField = new JComboBox<>(level);
        levelofpainField.setBounds(136,478,100,28);
        levelofpainField.setFont(new Font("Helvetica", Font.PLAIN, 20));
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

    //Patient Input Action
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == confirm) {
            if(surnameField.getText().equals("")||
                firstnameField.getText().equals("")||
                middlenameField.getText().equals("")||
                weightField.getText().equals("")||
                heightField.getText().equals("")||
                bloodPressureField1.getText().equals("")||
                bloodPressureField2.getText().equals("")||
                bodyTempField.getText().equals("")||
                levelofpainField.getSelectedIndex() ==0||
                addressField.getText().equals("")||
                pulseField.getText().equals("")||
                bloodtypeField.getSelectedIndex() == 0 ||
                Gender.getSelection()==null ||
                birthField.getDate()==null){
                JOptionPane.showMessageDialog(null, "Please complete all required fields!");
            }else{
                InputPatient();
                JOptionPane.showMessageDialog(null, "Patient Information has Been Added!");
                clearinput();
                SearchForm.gettableData(empty);
            }
        }
    }

    public void InputPatient(){
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        //Input Variables
        String surname = surnameField.getText();
        String firstname = firstnameField.getText();
        String middlename = middlenameField.getText();
        //String age = ageField.getText();

        //getting the age from dateChooser
        String dateofBirth = ((JTextField)birthField.getDateEditor().getUiComponent()).getText();

        String[] dob = dateofBirth.split("/");
        int day = Integer.parseInt(dob[0]);
        int month = Integer.parseInt(dob[1]);
        int year = Integer.parseInt(dob[2]);


        LocalDate selectedDate = LocalDate.of(year,month,day);
        LocalDate currentDate = LocalDate.now();

        int result = Period.between(selectedDate,currentDate).getYears();
        String age = Integer.toString(result);

        String weight = weightField.getText();
        String height = heightField.getText();
        String bloodpressure = bloodPressureField1.getText() + '/' + bloodPressureField2.getText();
        String bodyTemp = bodyTempField.getText();
        String painlevel = (String)levelofpainField.getSelectedItem();
        String pulse = pulseField.getText();

        if(maleRadioButton.isSelected()){
            gender = "Male";
        }
        if(femaleRadioButton.isSelected()){
            gender = "Female";
        }
        String bloodtype = (String) bloodtypeField.getSelectedItem();
        String address = addressField.getText();

        //Input Database
        String insertFields = "INSERT INTO patientinfo(surname,givenname,middlename,gender,address,age,month," +
                "day,year,weight,height,bloodtype,bloodpressure,bodytemp,levelofpain,pulserate,department) VALUES ('";
        String insertValue = surname + "','" + firstname + "','" + middlename + "','" + gender + "','" + address + "','" +
                age + "','" + month + "','" + day + "','" + year + "','" + weight + "','" + height + "','" + bloodtype + "','" +
                bloodpressure + "','" + bodyTemp + "','" + painlevel + "','" + pulse + "','"+LoginForm.dept+"')";
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
        birthField.setDate(null);
        Gender.clearSelection();
        surnameField.setText("");
        firstnameField.setText("");
        middlenameField.setText("");
        weightField.setText("");
        heightField.setText("");
        bloodPressureField1.setText("");
        bloodPressureField2.setText("");
        bodyTempField.setText("");
        levelofpainField.setSelectedIndex(0);
        addressField.setText("");
        pulseField.setText("");
        bloodtypeField.setSelectedIndex(0);
    }

    private JTextField surnameField,firstnameField,middlenameField,
            weightField,heightField,bloodPressureField1,bloodPressureField2,bodyTempField,
            pulseField;
    private ButtonGroup Gender;
    public JDateChooser birthField;
    private JComboBox<String> bloodtypeField, levelofpainField;
    private JRadioButton maleRadioButton,femaleRadioButton;
    private JTextArea addressField;
    private JButton confirm;
    private String gender;
    private final String[] empty = {"","Name"};
}

