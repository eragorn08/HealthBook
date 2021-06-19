package GUI;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

//import javax.swing.JFrame;

public class AddForm extends JPanel{
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
        Border border = new LineBorder(new Color(0x374169),1,false);
        JPanel addFormPanel = new JPanel();
        addFormPanel.setLayout(null);
        addFormPanel.setBorder(border);
        addFormPanel.setBackground(new Color(0x212C58));
        addFormPanel.setBounds(0,75,976,545);


        //Create a form
        JLabel slashLabel1 = new JLabel("/");
        slashLabel1.setFont(new Font("Helvetica", Font.PLAIN, 25));
        slashLabel1.setHorizontalTextPosition(JLabel.CENTER);
        slashLabel1.setForeground(Color.white);
        JLabel slashLabel0 = new JLabel("/");
        slashLabel0.setFont(new Font("Helvetica", Font.PLAIN, 25));
        slashLabel0.setForeground(Color.white);
        slashLabel0.setHorizontalTextPosition(JLabel.CENTER);
        JLabel slashLabel2 = new JLabel("/");
        slashLabel2.setFont(new Font("Helvetica", Font.PLAIN, 25));
        slashLabel2.setForeground(Color.white);
        slashLabel2.setHorizontalTextPosition(JLabel.CENTER);



        //NAME FORM
        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setFont(new Font("Helvetica", Font.PLAIN, 24));
        nameLabel.setForeground(Color.white);
        nameLabel.setBounds(32,26, 74,25);
        addFormPanel.add(nameLabel);

        JLabel surnameLabel = new JLabel("Surname");
        surnameLabel.setFont(new Font("Helvetica", Font.PLAIN, 25));
        surnameLabel.setForeground(Color.white);
        surnameLabel.setBounds(189,69, 107,25);
        addFormPanel.add(surnameLabel);

        JLabel firstLabel = new JLabel("Given Name");
        firstLabel.setFont(new Font("Helvetica", Font.PLAIN, 25));
        firstLabel.setForeground(Color.WHITE);
        firstLabel.setBounds(397,69, 142,25);
        addFormPanel.add(firstLabel);

        JLabel middleLabel = new JLabel("Middle Name");
        middleLabel.setFont(new Font("Helvetica", Font.PLAIN, 25));
        middleLabel.setForeground(Color.WHITE);
        middleLabel.setBounds(619,69, 150,25);
        addFormPanel.add(middleLabel);

        JTextField surnameField = new JTextField();
        surnameField.setBounds(143, 26, 200, 34);
        surnameField.setBorder(BorderFactory.createEmptyBorder());
        surnameField.setFont(new Font("Helvetica", Font.PLAIN, 25));
        surnameField.setHorizontalAlignment(JTextField.CENTER);
        addFormPanel.add(surnameField);

        JTextField firstnameField = new JTextField();
        firstnameField.setBounds(368, 26, 200, 34);
        firstnameField.setBorder(BorderFactory.createEmptyBorder());
        firstnameField.setFont(new Font("Helvetica", Font.PLAIN, 25));
        firstnameField.setHorizontalAlignment(JTextField.CENTER);
        addFormPanel.add(firstnameField);

        JTextField middlenameField = new JTextField();
        middlenameField.setBounds(593, 26, 200, 34);
        middlenameField.setBorder(BorderFactory.createEmptyBorder());
        middlenameField.setFont(new Font("Helvetica", Font.PLAIN, 25));
        middlenameField.setHorizontalAlignment(JTextField.CENTER);
        addFormPanel.add(middlenameField);


        //SEX FORM
        JLabel sexLabel = new JLabel("Sex:");
        sexLabel.setFont(new Font("Helvetica", Font.PLAIN, 25));
        sexLabel.setForeground(Color.WHITE);
        sexLabel.setBounds(32,114, 52,25);
        addFormPanel.add(sexLabel);

        JLabel maleLabel = new JLabel("Male");
        maleLabel.setFont(new Font("Helvetica", Font.PLAIN, 25));
        maleLabel.setForeground(Color.WHITE);
        maleLabel.setBounds(176,114, 57,25);
        addFormPanel.add(maleLabel);

        JLabel femaleLabel = new JLabel("Female");
        femaleLabel.setFont(new Font("Helvetica", Font.PLAIN, 25));
        femaleLabel.setForeground(Color.WHITE);
        femaleLabel.setBounds(321,114, 85,25);
        addFormPanel.add(femaleLabel);

        JRadioButton maleRadioButton = new JRadioButton();
        maleRadioButton.setBounds(143,111,25,25);
        maleRadioButton.setBackground(new Color(0x212C58));
        addFormPanel.add(maleRadioButton);

        JRadioButton femaleRadioButton = new JRadioButton();
        femaleRadioButton.setBounds(290,111,25,25);
        femaleRadioButton.setBackground(new Color(0x212C58));
        addFormPanel.add(femaleRadioButton);

        //RADIO BUTTON GROUP
        ButtonGroup Gender = new ButtonGroup();
        Gender.add(maleRadioButton);
        Gender.add(femaleRadioButton);

        //ADDRESS FORM
        JLabel addressLabel = new JLabel("Address:");
        addressLabel.setFont(new Font("Helvetica", Font.PLAIN, 25));
        addressLabel.setForeground(Color.WHITE);
        addressLabel.setBounds(32,164, 100,25);
        addFormPanel.add(addressLabel);

        JTextArea addressField = new JTextArea();
        addressField.setEditable(true);
        JScrollPane AddressScroll = new JScrollPane(addressField);
        addressField.setFont(new Font("Helvetica", Font.PLAIN, 25));
        addressField.setBounds(143,163, 772,85);
        addFormPanel.add(addressField);


        //AGE FORM
        JLabel ageLabel = new JLabel("Age:");
        ageLabel.setFont(new Font("Helvetica", Font.PLAIN, 25));
        ageLabel.setForeground(Color.WHITE);
        ageLabel.setBounds(32,285, 59,25);
        addFormPanel.add(ageLabel);

        JTextField ageField = new JTextField();
        ageField.setBounds(143, 278, 100, 34);
        ageField.setBorder(BorderFactory.createEmptyBorder());
        ageField.setFont(new Font("Helvetica", Font.PLAIN, 25));
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
        birthLabel.setFont(new Font("Helvetica", Font.PLAIN, 25));
        birthLabel.setForeground(Color.WHITE);
        birthLabel.setBounds(349,285, 151,25);
        addFormPanel.add(birthLabel);

        JLabel mmLabel = new JLabel("MM");
        mmLabel.setFont(new Font("Helvetica", Font.PLAIN, 25));
        mmLabel.setForeground(Color.WHITE);
        mmLabel.setBounds(550,318, 88,25);
        addFormPanel.add(mmLabel);

        JLabel ddLabel = new JLabel("DD");
        ddLabel.setFont(new Font("Helvetica", Font.PLAIN, 25));
        ddLabel.setForeground(Color.WHITE);
        ddLabel.setBounds(690,318, 88,25);
        addFormPanel.add(ddLabel);

        JLabel yyLabel = new JLabel("YYYY");
        yyLabel.setFont(new Font("Helvetica", Font.PLAIN, 25));
        yyLabel.setForeground(Color.WHITE);
        yyLabel.setBounds(814,318, 88,25);
        addFormPanel.add(yyLabel);

        slashLabel0.setBounds(640, 286, 13, 20);
        addFormPanel.add(slashLabel0);
        slashLabel1.setBounds(779, 286, 13, 20);
        addFormPanel.add(slashLabel1);


        JTextField monthField = new JTextField();
        monthField.setBounds(513, 278, 120, 34);
        monthField.setBorder(BorderFactory.createEmptyBorder());
        monthField.setFont(new Font("Helvetica", Font.PLAIN, 25));
        monthField.setHorizontalAlignment(JTextField.CENTER);
        monthField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent ke) {
                String value = monthField.getText();
                int l = value.length();
                if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9'
                        || ke.getKeyChar() == KeyEvent.VK_BACK_SPACE){
                    monthField.setEditable(l != 2);
                }
                else {
                    monthField.setEditable(false);
                }
            }

        });

        addFormPanel.add(monthField);

        JTextField dayField = new JTextField();
        dayField.setBounds(652, 278, 120, 34);
        dayField.setBorder(BorderFactory.createEmptyBorder());
        dayField.setFont(new Font("Helvetica", Font.PLAIN, 25));
        dayField.setHorizontalAlignment(JTextField.CENTER);
        dayField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent ke) {
                String value = dayField.getText();
                int l = value.length();
                if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9'
                        || ke.getKeyChar() == KeyEvent.VK_BACK_SPACE){
                    dayField.setEditable(l != 2);
                }
                else {
                    dayField.setEditable(false);
                }
            }
        });
        addFormPanel.add(dayField);

        JTextField yearField = new JTextField();
        yearField.setBounds(791, 278, 120, 34);
        yearField.setBorder(BorderFactory.createEmptyBorder());
        yearField.setFont(new Font("Helvetica", Font.PLAIN, 25));
        yearField.setHorizontalAlignment(JTextField.CENTER);
        yearField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent ke) {
                String value = yearField.getText();
                int l = value.length();
                if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9'
                        || ke.getKeyChar() == KeyEvent.VK_BACK_SPACE){
                    yearField.setEditable(l != 4);
                }
                else {
                    yearField.setEditable(false);
                }
            }
        });
        addFormPanel.add(yearField);


        //WEIGHT AND HEIGHT LABEL
        JLabel weightLabel = new JLabel("Weight:");
        weightLabel.setFont(new Font("Helvetica", Font.PLAIN, 25));
        weightLabel.setForeground(Color.WHITE);
        weightLabel.setBounds(32,376, 88,25);
        addFormPanel.add(weightLabel);

        JLabel heightLabel = new JLabel("Height:");
        heightLabel.setFont(new Font("Helvetica", Font.PLAIN, 25));
        heightLabel.setForeground(Color.WHITE);
        heightLabel.setBounds(348,376, 85,25);
        addFormPanel.add(heightLabel);

        JLabel kgLabel = new JLabel("kg");
        kgLabel.setFont(new Font("Helvetica", Font.PLAIN, 25));
        kgLabel.setForeground(Color.WHITE);
        kgLabel.setBounds(258,376, 30,25);
        addFormPanel.add(kgLabel);

        JLabel cmLabel = new JLabel("cm");
        cmLabel.setFont(new Font("Helvetica", Font.PLAIN, 25));
        cmLabel.setForeground(Color.WHITE);
        cmLabel.setBounds(628,376, 48,25);
        addFormPanel.add(cmLabel);

        JTextField weightField = new JTextField();
        weightField.setBounds(143, 367, 100, 34);
        weightField.setBorder(BorderFactory.createEmptyBorder());
        weightField.setFont(new Font("Helvetica", Font.PLAIN, 25));
        weightField.setHorizontalAlignment(JTextField.CENTER);
        weightField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent ke) {
                weightField.setEditable(ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9'
                        || ke.getKeyChar() == KeyEvent.VK_BACK_SPACE);
            }
        });
        addFormPanel.add(weightField);

        JTextField heightField = new JTextField();
        heightField.setBounds(513, 367, 100, 34);
        heightField.setBorder(BorderFactory.createEmptyBorder());
        heightField.setFont(new Font("Helvetica", Font.PLAIN, 25));
        heightField.setHorizontalAlignment(JTextField.CENTER);
        heightField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent ke) {
                heightField.setEditable(ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9'
                        || ke.getKeyChar() == KeyEvent.VK_BACK_SPACE);
            }
        });
        addFormPanel.add(heightField);


        //BLOOD FORM
        JLabel bloodtypeLabel = new JLabel("<html>Blood<br>Type:</html>");
        bloodtypeLabel.setFont(new Font("Helvetica", Font.PLAIN, 25));
        bloodtypeLabel.setForeground(Color.WHITE);
        bloodtypeLabel.setBounds(32,431, 69,62);
        addFormPanel.add(bloodtypeLabel);

        JLabel bloodpressureLabel = new JLabel("<html>Blood<br>Pressure:</html>");
        bloodpressureLabel.setFont(new Font("Helvetica", Font.PLAIN, 25));
        bloodpressureLabel.setForeground(Color.WHITE);
        bloodpressureLabel.setBounds(349,433, 109,62);
        addFormPanel.add(bloodpressureLabel);

        slashLabel2.setBounds(620, 451, 14, 20);
        addFormPanel.add(slashLabel2);

        JComboBox<String> bloodtypeField = new JComboBox<>(bloodTypes);
        bloodtypeField.setBounds(143,442,100,38);
        bloodtypeField.setFont(new Font("Helvetica", Font.PLAIN, 25));
        addFormPanel.add(bloodtypeField);

        JTextField bloodPressureField1 = new JTextField();
        bloodPressureField1.setBounds(632,444,100,34);
        bloodPressureField1.setFont(new Font("Helvetica", Font.PLAIN, 25));
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

        JTextField bloodPressureField2 = new JTextField();
        bloodPressureField2.setBounds(513,444,100,34);
        bloodPressureField2.setFont(new Font("Helvetica", Font.PLAIN, 25));
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

        add(addFormPanel);
    }

}

