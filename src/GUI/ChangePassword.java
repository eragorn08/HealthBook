package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ChangePassword extends JPanel implements ActionListener {
    public ChangePassword(){
        setLayout(null);
        setBackground(new Color(0x212C58));
        JLabel changePasswordTitle = new JLabel("Change Admin Password");
        changePasswordTitle.setFont(new Font("Helvetica", Font.PLAIN, 40));
        changePasswordTitle.setForeground(Color.white);
        changePasswordTitle.setBounds(22, 19, 460, 55);
        add(changePasswordTitle);

        JLabel currentTitle = new JLabel("Current Employee ID:");
        currentTitle.setFont(new Font("Helvetica", Font.PLAIN, 25));
        currentTitle.setForeground(Color.white);
        currentTitle.setBounds(191, 132, 284, 29);
        add(currentTitle);

        currentField = new JTextField();
        currentField.setBounds(504, 133, 193, 28);
        currentField.setBorder(BorderFactory.createEmptyBorder());
        currentField.setFont(new Font("Helvetica", Font.PLAIN, 20));
        currentField.setHorizontalAlignment(JTextField.CENTER);
        add(currentField);

        JLabel newTitle = new JLabel("New Employee ID:");
        newTitle.setFont(new Font("Helvetica", Font.PLAIN, 25));
        newTitle.setForeground(Color.white);
        newTitle.setBounds(191, 215, 284, 29);
        add(newTitle);

        newField = new JTextField();
        newField.setBounds(504, 216, 193, 28);
        newField.setBorder(BorderFactory.createEmptyBorder());
        newField.setFont(new Font("Helvetica", Font.PLAIN, 20));
        newField.setHorizontalAlignment(JTextField.CENTER);
        add(newField);

        JLabel verifyTitle = new JLabel("Verify New Employee ID:");
        verifyTitle.setFont(new Font("Helvetica", Font.PLAIN, 25));
        verifyTitle.setForeground(Color.white);
        verifyTitle.setBounds(191, 301, 284, 29);
        add(verifyTitle);

        verifyField = new JTextField();
        verifyField.setBounds(504, 301, 193, 28);
        verifyField.setBorder(BorderFactory.createEmptyBorder());
        verifyField.setFont(new Font("Helvetica", Font.PLAIN, 20));
        verifyField.setHorizontalAlignment(JTextField.CENTER);
        add(verifyField);

        confirmButton = new JButton(new ImageIcon("confirm_logo.png"));
        confirmButton.setBounds(761,337,161,41);
        confirmButton.setBorder(BorderFactory.createEmptyBorder());
        confirmButton.setContentAreaFilled(false);
        confirmButton.setFocusPainted(false);
        add(confirmButton);
        confirmButton.addActionListener(this);
    }

    public void TransferVal(){
        curEmpID = currentField.getText();
        newEmpID = newField.getText();
        verEmpID = verifyField.getText();
    }

    public void clearField(){
        currentField.setText("");
        newField.setText("");
        verifyField.setText("");
    }
    public void verifyCurEmp(){
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        String ver = "SELECT Username FROM accounts WHERE idaccounts = '"+LoginForm.id+"'";

        try{
            Statement statement = connectDB.createStatement();
            ResultSet rs = statement.executeQuery(ver);
            if(rs.next()) {
                check = rs.getString("Username");
            }
        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }


    public void verifyadmin(){
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();
        String verify = "UPDATE accounts SET Username = '" +newEmpID+ "' WHERE idaccounts = '"+LoginForm.id+"'";

        try{
            Statement statement = connectDB.createStatement();
            statement.executeUpdate(verify);
        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e){
        TransferVal();
        verifyCurEmp();
        if(curEmpID.equals(check)) {
            if (newEmpID.equals(verEmpID)) {
                verifyadmin();
                JOptionPane.showMessageDialog(null, "EmpID has Been Changed.");
                clearField();
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "New Emp ID not the Same with Verification.");
            newField.setText("");
            verifyField.setText("");
        }
    }

    private JTextField currentField,newField,verifyField;
    private String curEmpID,newEmpID,verEmpID,check;
    private JButton confirmButton;
}
