package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class LoginForm extends JFrame{
    private JPasswordField DepCodeInput;
    private JLabel Label1;
    private JPanel panel1;
    private JButton LoginButton;
    private JLabel Label2;
    private JFrame Frame;

    public LoginForm(){
        Frame =new JFrame("Login");
        Frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        Frame.setPreferredSize(new Dimension(300,250));
        Frame.setResizable(false);

        Frame.add(panel1);

        Frame.pack();
        Frame.setLocationRelativeTo(null);
        Frame.setVisible(true);
        LoginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                char[] DeptCode = DepCodeInput.getPassword();
                char[] correctDeptCode = new char[] {'1','2','3','4','5'};
                if (Arrays.equals(DeptCode, correctDeptCode)){
                    JOptionPane.showMessageDialog(null,"Hello World");
                } else {
                    JOptionPane.showMessageDialog(null,"Wrong Password");
                }
            }
        });
    }
}
