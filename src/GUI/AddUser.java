package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.Statement;

public class AddUser extends JPanel implements ActionListener, MouseListener {
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
    public void addUserForm() {
        //NAME FORM
        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setFont(new Font("Helvetica", Font.PLAIN, 25));
        nameLabel.setForeground(Color.white);
        nameLabel.setBounds(64, 133, 151, 29);
        add(nameLabel);

        JLabel surnameLabel = new JLabel("Surname");
        surnameLabel.setFont(new Font("Helvetica", Font.PLAIN, 25));
        surnameLabel.setForeground(Color.white);
        surnameLabel.setBounds(276, 168, 107, 29);
        add(surnameLabel);

        JLabel givennameLabel = new JLabel("Given Name");
        givennameLabel.setFont(new Font("Helvetica", Font.PLAIN, 25));
        givennameLabel.setForeground(Color.white);
        givennameLabel.setBounds(483, 168, 143, 29);
        add(givennameLabel);

        JLabel middlenameLabel = new JLabel("Middle Name");
        middlenameLabel.setFont(new Font("Helvetica", Font.PLAIN, 25));
        middlenameLabel.setForeground(Color.white);
        middlenameLabel.setBounds(705, 168, 153, 29);
        add(middlenameLabel);

        surnameField = new JTextField();
        surnameField.setBounds(229, 132, 200, 28);
        surnameField.setBorder(BorderFactory.createEmptyBorder());
        surnameField.setFont(new Font("Helvetica", Font.PLAIN, 20));
        surnameField.setHorizontalAlignment(JTextField.CENTER);
        add(surnameField);

        givenField = new JTextField();
        givenField.setBounds(455, 132, 200, 28);
        givenField.setBorder(BorderFactory.createEmptyBorder());
        givenField.setFont(new Font("Helvetica", Font.PLAIN, 20));
        givenField.setHorizontalAlignment(JTextField.CENTER);
        add(givenField);

        middleField = new JTextField();
        middleField.setBounds(680, 132, 200, 28);
        middleField.setBorder(BorderFactory.createEmptyBorder());
        middleField.setFont(new Font("Helvetica", Font.PLAIN, 20));
        middleField.setHorizontalAlignment(JTextField.CENTER);
        add(middleField);

        //Dept FORM
        JLabel deptLabel = new JLabel("Department:");
        deptLabel.setFont(new Font("Helvetica", Font.PLAIN, 25));
        deptLabel.setForeground(Color.white);
        deptLabel.setBounds(64, 200, 138, 29);
        add(deptLabel);

        String[] department_list = {
                "--",
                "Cardiology",
                "Gastroenterology",
                "Gynecology",
                "Nephrology",
                "Neurology",
                "Oncology",
                "Ophthalmology",
                "Orthopaedics",
                "Otolaryngology",
                "Urology"};
        dept = new JComboBox<>(department_list);
        dept.setBounds(229, 200, 229, 28);
        dept.setFont(new Font("Helvetica", Font.PLAIN, 20));
        add(dept);
        dept.addMouseListener(this);


        //ROLE FORM
        JLabel roleLabel = new JLabel("Role:");
        roleLabel.setFont(new Font("Helvetica", Font.PLAIN, 25));
        roleLabel.setForeground(Color.white);
        roleLabel.setBounds(64, 244, 138, 29);
        add(roleLabel);

        JLabel DocLabel = new JLabel("Doctor");
        DocLabel.setFont(new Font("Helvetica", Font.PLAIN, 25));
        DocLabel.setForeground(Color.white);
        DocLabel.setBounds(262, 244, 138, 29);
        add(DocLabel);

        JLabel nurseLabel = new JLabel("Nurse");
        nurseLabel.setFont(new Font("Helvetica", Font.PLAIN, 25));
        nurseLabel.setForeground(Color.white);
        nurseLabel.setBounds(407, 244, 138, 29);
        add(nurseLabel);

        doctorRadio = new JRadioButton();
        doctorRadio.setBounds(229, 244, 25, 25);
        doctorRadio.setForeground(Color.white);
        doctorRadio.setBackground(new Color(0x212C58));
        add(doctorRadio);

        nurseRadio = new JRadioButton();
        nurseRadio.setBounds(374, 244, 25, 25);
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
        codeLabel.setBounds(64, 288, 138, 58);
        add(codeLabel);

        codeField = new JTextField();
        codeField.setBounds(229, 303, 230, 28);
        codeField.setBorder(BorderFactory.createEmptyBorder());
        codeField.setFont(new Font("Helvetica", Font.PLAIN, 20));
        codeField.setHorizontalAlignment(JTextField.CENTER);
        codeField.setEditable(false);
        add(codeField);

        //ID FORM
        JLabel IDLabel = new JLabel("<html>Employee<br>ID:</html>");
        IDLabel.setFont(new Font("Helvetica", Font.PLAIN, 25));
        IDLabel.setForeground(Color.white);
        IDLabel.setBounds(64, 361, 138, 58);
        add(IDLabel);

        IDField = new JTextField();
        IDField.setBounds(229, 376, 230, 28);
        IDField.setBorder(BorderFactory.createEmptyBorder());
        IDField.setFont(new Font("Helvetica", Font.PLAIN, 20));
        IDField.setHorizontalAlignment(JTextField.CENTER);
        add(IDField);

        //ID FORM
        JLabel verifyLabel = new JLabel("<html>Verify<br>Employee ID:</html>");
        verifyLabel.setFont(new Font("Helvetica", Font.PLAIN, 25));
        verifyLabel.setForeground(Color.white);
        verifyLabel.setBounds(64, 434, 155, 62);
        add(verifyLabel);

        verifyField = new JTextField();
        verifyField.setBounds(229, 448, 230, 28);
        verifyField.setBorder(BorderFactory.createEmptyBorder());
        verifyField.setFont(new Font("Helvetica", Font.PLAIN, 20));
        verifyField.setHorizontalAlignment(JTextField.CENTER);
        add(verifyField);

        confirmButton = new JButton(new ImageIcon("confirm_logo.png"));
        confirmButton.setBounds(734, 551, 161, 41);
        confirmButton.setBorder(BorderFactory.createEmptyBorder());
        confirmButton.setContentAreaFilled(false);
        confirmButton.setFocusPainted(false);
        add(confirmButton);
        confirmButton.addActionListener(this);
    }

        public void Transfer(){
            //Input Variables
            surname = surnameField.getText();
            firstname = givenField.getText();
            middlename = middleField.getText();
            deptcode = codeField.getText();
            EmpID = IDField.getText();
            Verification = verifyField.getText();
            if(doctorRadio.isSelected()){
                Position = "Doctor";
            }
            if(nurseRadio.isSelected()){
                Position = "Nurse";
            }
            department = (String)dept.getSelectedItem();

        }

        public void InputUser(){
            DatabaseConnection connectNow = new DatabaseConnection();
            Connection connectDB = connectNow.getConnection();

            //Input Database
            String insertFields = "INSERT INTO accounts(LastName,GivenName,MiddleName,Position,Username,DepartmentCode,"+
                    "Department) VALUES ('";
            String insertValue = surname + "','" + firstname + "','" + middlename + "','" + Position + "','" + EmpID + "','" +
                    deptcode + "','" + department + "')";
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
        public void clearinputuser(){
            surnameField.setText("");
            givenField.setText("");
            middleField.setText("");
            codeField.setText("");
            IDField.setText("");
            verifyField.setText("");
            dept.setSelectedIndex(0);
        }
        @Override
        public void actionPerformed(ActionEvent e){
            Transfer();
            if(EmpID.equals(Verification)){
                InputUser();
                JOptionPane.showMessageDialog(null, "User Created Successfully.");
                clearinputuser();
            }
            else{
                JOptionPane.showMessageDialog(null, "Emp ID not the Same with Verification.");
                IDField.setText("");
                verifyField.setText("");
            }
        }

    private JTextField surnameField,givenField,middleField,codeField,IDField,verifyField;
    private JComboBox<String> dept;
    private String surname,firstname,middlename,deptcode,department,Position,EmpID,Verification;
    private JRadioButton doctorRadio,nurseRadio;
    private JButton confirmButton;

    @Override
    public void mouseClicked(MouseEvent e) {
        if (dept.getSelectedItem().equals("Cardiology")){
            codeField.setText("Cardiology123");
        }
        else if (dept.getSelectedItem().equals("Gastroenterology")){
            codeField.setText("Gastroenterology123");
        }
        else if (dept.getSelectedItem().equals("Gynecology")){
            codeField.setText("Gynecology123");
        }
        else if (dept.getSelectedItem().equals("Nephrology")){
            codeField.setText("Nephrology123");
        }
        else if (dept.getSelectedItem().equals("Neurology")){
            codeField.setText("Neurology123");
        }
        else if (dept.getSelectedItem().equals("Oncology")){
            codeField.setText("Oncology123");
        }
        else if (dept.getSelectedItem().equals("Ophthalmology")){
            codeField.setText("Ophthalmology123");
        }
        else if (dept.getSelectedItem().equals("Orthopaedics")){
            codeField.setText("Orthopaedics123");
        }
        else if (dept.getSelectedItem().equals("Otolaryngology")){
            codeField.setText("Otolaryngology123");
        }
        else if (dept.getSelectedItem().equals("Urology")){
            codeField.setText("Urology123");
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (dept.getSelectedItem().equals("Cardiology")){
            codeField.setText("Cardiology123");
        }
        else if (dept.getSelectedItem().equals("Gastroenterology")){
            codeField.setText("Gastroenterology123");
        }
        else if (dept.getSelectedItem().equals("Gynecology")){
            codeField.setText("Gynecology123");
        }
        else if (dept.getSelectedItem().equals("Nephrology")){
            codeField.setText("Nephrology123");
        }
        else if (dept.getSelectedItem().equals("Neurology")){
            codeField.setText("Neurology123");
        }
        else if (dept.getSelectedItem().equals("Oncology")){
            codeField.setText("Oncology123");
        }
        else if (dept.getSelectedItem().equals("Ophthalmology")){
            codeField.setText("Ophthalmology123");
        }
        else if (dept.getSelectedItem().equals("Orthopaedics")){
            codeField.setText("Orthopaedics123");
        }
        else if (dept.getSelectedItem().equals("Otolaryngology")){
            codeField.setText("Otolaryngology123");
        }
        else if (dept.getSelectedItem().equals("Urology")){
            codeField.setText("Urology123");
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (dept.getSelectedItem().equals("Cardiology")){
            codeField.setText("Cardiology123");
        }
        else if (dept.getSelectedItem().equals("Gastroenterology")){
            codeField.setText("Gastroenterology123");
        }
        else if (dept.getSelectedItem().equals("Gynecology")){
            codeField.setText("Gynecology123");
        }
        else if (dept.getSelectedItem().equals("Nephrology")){
            codeField.setText("Nephrology123");
        }
        else if (dept.getSelectedItem().equals("Neurology")){
            codeField.setText("Neurology123");
        }
        else if (dept.getSelectedItem().equals("Oncology")){
            codeField.setText("Oncology123");
        }
        else if (dept.getSelectedItem().equals("Ophthalmology")){
            codeField.setText("Ophthalmology123");
        }
        else if (dept.getSelectedItem().equals("Orthopaedics")){
            codeField.setText("Orthopaedics123");
        }
        else if (dept.getSelectedItem().equals("Otolaryngology")){
            codeField.setText("Otolaryngology123");
        }
        else if (dept.getSelectedItem().equals("Urology")){
            codeField.setText("Urology123");
        }

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (dept.getSelectedItem().equals("Cardiology")){
            codeField.setText("Cardiology123");
        }
        else if (dept.getSelectedItem().equals("Gastroenterology")){
            codeField.setText("Gastroenterology123");
        }
        else if (dept.getSelectedItem().equals("Gynecology")){
            codeField.setText("Gynecology123");
        }
        else if (dept.getSelectedItem().equals("Nephrology")){
            codeField.setText("Nephrology123");
        }
        else if (dept.getSelectedItem().equals("Neurology")){
            codeField.setText("Neurology123");
        }
        else if (dept.getSelectedItem().equals("Oncology")){
            codeField.setText("Oncology123");
        }
        else if (dept.getSelectedItem().equals("Ophthalmology")){
            codeField.setText("Ophthalmology123");
        }
        else if (dept.getSelectedItem().equals("Orthopaedics")){
            codeField.setText("Orthopaedics123");
        }
        else if (dept.getSelectedItem().equals("Otolaryngology")){
            codeField.setText("Otolaryngology123");
        }
        else if (dept.getSelectedItem().equals("Urology")){
            codeField.setText("Urology123");
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (dept.getSelectedItem().equals("Cardiology")){
            codeField.setText("Cardiology123");
        }
        else if (dept.getSelectedItem().equals("Gastroenterology")){
            codeField.setText("Gastroenterology123");
        }
        else if (dept.getSelectedItem().equals("Gynecology")){
            codeField.setText("Gynecology123");
        }
        else if (dept.getSelectedItem().equals("Nephrology")){
            codeField.setText("Nephrology123");
        }
        else if (dept.getSelectedItem().equals("Neurology")){
            codeField.setText("Neurology123");
        }
        else if (dept.getSelectedItem().equals("Oncology")){
            codeField.setText("Oncology123");
        }
        else if (dept.getSelectedItem().equals("Ophthalmology")){
            codeField.setText("Ophthalmology123");
        }
        else if (dept.getSelectedItem().equals("Orthopaedics")){
            codeField.setText("Orthopaedics123");
        }
        else if (dept.getSelectedItem().equals("Otolaryngology")){
            codeField.setText("Otolaryngology123");
        }
        else if (dept.getSelectedItem().equals("Urology")){
            codeField.setText("Urology123");
        }
    }
}
