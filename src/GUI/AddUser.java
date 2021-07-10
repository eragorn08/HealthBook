package GUI;

import javax.swing.*;
import java.awt.*;

public class AddUser extends JPanel {
    public AddUser(){
        setLayout(null);
        addUserForm();
        addUserTitle();
    }
    public void addUserTitle(){
        setBackground(new Color(0x212C58));
        JLabel addPatientTitle = new JLabel("Add User");
        addPatientTitle.setFont(new Font("Helvetica", Font.PLAIN, 40));
        addPatientTitle.setForeground(Color.white);
        addPatientTitle.setBounds(22, 19, 275, 55);
        add(addPatientTitle);
    }
    public void addUserForm(){
        //NAME FORM
        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setFont(new Font("Helvetica", Font.PLAIN, 25));
        nameLabel.setForeground(Color.white);
        nameLabel.setBounds(64,133, 151,29);
        add(nameLabel);

        JLabel surnameLabel = new JLabel("Surname");
        surnameLabel.setFont(new Font("Helvetica", Font.PLAIN, 25));
        surnameLabel.setForeground(Color.white);
        surnameLabel.setBounds(276,168, 107,29);
        add(surnameLabel);

        JLabel givennameLabel = new JLabel("Given Name");
        givennameLabel.setFont(new Font("Helvetica", Font.PLAIN, 25));
        givennameLabel.setForeground(Color.white);
        givennameLabel.setBounds(483,168, 143,29);
        add(givennameLabel);

        JLabel middlenameLabel = new JLabel("Middle Name");
        middlenameLabel.setFont(new Font("Helvetica", Font.PLAIN, 25));
        middlenameLabel.setForeground(Color.white);
        middlenameLabel.setBounds(705,168, 153,29);
        add(middlenameLabel);

        JTextField surnameField = new JTextField();
        surnameField.setBounds(229, 132, 200, 28);
        surnameField.setBorder(BorderFactory.createEmptyBorder());
        surnameField.setFont(new Font("Helvetica", Font.PLAIN, 20));
        surnameField.setHorizontalAlignment(JTextField.CENTER);
        add(surnameField);

        JTextField givenField = new JTextField();
        givenField.setBounds(455, 132, 200, 28);
        givenField.setBorder(BorderFactory.createEmptyBorder());
        givenField.setFont(new Font("Helvetica", Font.PLAIN, 20));
        givenField.setHorizontalAlignment(JTextField.CENTER);
        add(givenField);

        JTextField middleField = new JTextField();
        middleField.setBounds(680, 132, 200, 28);
        middleField.setBorder(BorderFactory.createEmptyBorder());
        middleField.setFont(new Font("Helvetica", Font.PLAIN, 20));
        middleField.setHorizontalAlignment(JTextField.CENTER);
        add(middleField);

        //Dept FORM
        JLabel deptLabel = new JLabel("Department:");
        deptLabel.setFont(new Font("Helvetica", Font.PLAIN, 25));
        deptLabel.setForeground(Color.white);
        deptLabel.setBounds(64,200, 138,29);
        add(deptLabel);

        String[] department_list = {
                "--",
                "Cardiology",
                "Gastroentrology",
                "Gynecology",
                "Nephrology",
                "Neurology",
                "Oncology",
                "Opthalmology",
                "Orthopaedics",
                "Otolarngology",
                "Urology"};
        JComboBox<String> dept = new JComboBox<>(department_list);
        dept.setBounds(229,200,229,28);
        dept.setFont(new Font("Helvetica", Font.PLAIN, 20));
        add(dept);


        //ROLE FORM
        JLabel roleLabel = new JLabel("Role:");
        roleLabel.setFont(new Font("Helvetica", Font.PLAIN, 25));
        roleLabel.setForeground(Color.white);
        roleLabel.setBounds(64,244, 138,29);
        add(roleLabel);

        JLabel DocLabel = new JLabel("Doctor");
        DocLabel.setFont(new Font("Helvetica", Font.PLAIN, 25));
        DocLabel.setForeground(Color.white);
        DocLabel.setBounds(262,244, 138,29);
        add(DocLabel);

        JLabel nurseLabel = new JLabel("Nurse");
        nurseLabel.setFont(new Font("Helvetica", Font.PLAIN, 25));
        nurseLabel.setForeground(Color.white);
        nurseLabel.setBounds(407,244, 138,29);
        add(nurseLabel);

        JRadioButton doctorRadio = new JRadioButton();
        doctorRadio.setBounds(229,244,25,25);
        doctorRadio.setForeground(Color.white);
        doctorRadio.setBackground(new Color(0x212C58));
        add(doctorRadio);

        JRadioButton nurseRadio = new JRadioButton();
        nurseRadio.setBounds(374,244,25,25);
        doctorRadio.setForeground(Color.white);
        nurseRadio.setBackground(new Color(0x212C58));
        add(nurseRadio);

        //RADIO BUTTON GROUP
        ButtonGroup Roles = new ButtonGroup();
        Roles.add(doctorRadio);
        Roles.add(nurseRadio);




        //CODE FORM
        JLabel codeLabel = new JLabel("<html>Department<br>Code:</html>");
        codeLabel.setFont(new Font("Helvetica", Font.PLAIN, 25));
        codeLabel.setForeground(Color.white);
        codeLabel.setBounds(64,288, 138,58);
        add(codeLabel);

        JTextField codeField = new JTextField();
        codeField.setBounds(229, 303, 230, 28);
        codeField.setBorder(BorderFactory.createEmptyBorder());
        codeField.setFont(new Font("Helvetica", Font.PLAIN, 20));
        codeField.setHorizontalAlignment(JTextField.CENTER);
        add(codeField);

        //ID FORM
        JLabel IDLabel = new JLabel("<html>Employee<br>ID:</html>");
        IDLabel.setFont(new Font("Helvetica", Font.PLAIN, 25));
        IDLabel.setForeground(Color.white);
        IDLabel.setBounds(64,361, 138,58);
        add(IDLabel);

        JTextField IDField = new JTextField();
        IDField.setBounds(229, 376, 230, 28);
        IDField.setBorder(BorderFactory.createEmptyBorder());
        IDField.setFont(new Font("Helvetica", Font.PLAIN, 20));
        IDField.setHorizontalAlignment(JTextField.CENTER);
        add(IDField);

        //ID FORM
        JLabel verifyLabel = new JLabel("<html>Verify<br>Employee ID:</html>");
        verifyLabel.setFont(new Font("Helvetica", Font.PLAIN, 25));
        verifyLabel.setForeground(Color.white);
        verifyLabel.setBounds(64,434, 155,62);
        add(verifyLabel);

        JTextField verifyField = new JTextField();
        verifyField.setBounds(229, 448, 230, 28);
        verifyField.setBorder(BorderFactory.createEmptyBorder());
        verifyField.setFont(new Font("Helvetica", Font.PLAIN, 20));
        verifyField.setHorizontalAlignment(JTextField.CENTER);
        add(verifyField);

        JButton confirmButton = new JButton(new ImageIcon("confirm_logo.png"));
        confirmButton.setBounds(734,551,161,41);
        confirmButton.setBorder(BorderFactory.createEmptyBorder());
        confirmButton.setContentAreaFilled(false);
        confirmButton.setFocusPainted(false);
        add(confirmButton);
    }
}
