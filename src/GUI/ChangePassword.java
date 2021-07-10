package GUI;

import javax.swing.*;
import java.awt.*;

public class ChangePassword extends JPanel{
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

        JTextField currentField = new JTextField();
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

        JTextField newField = new JTextField();
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

        JTextField verifyField = new JTextField();
        verifyField.setBounds(504, 301, 193, 28);
        verifyField.setBorder(BorderFactory.createEmptyBorder());
        verifyField.setFont(new Font("Helvetica", Font.PLAIN, 20));
        verifyField.setHorizontalAlignment(JTextField.CENTER);
        add(verifyField);

        JButton confirmButton = new JButton(new ImageIcon("confirm_logo.png"));
        confirmButton.setBounds(761,337,161,41);
        confirmButton.setBorder(BorderFactory.createEmptyBorder());
        confirmButton.setContentAreaFilled(false);
        confirmButton.setFocusPainted(false);
        add(confirmButton);


    }

}
