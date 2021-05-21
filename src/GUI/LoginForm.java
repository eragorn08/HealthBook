package GUI;

import javax.swing.*;
import java.awt.*;

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
        Frame.setPreferredSize(new Dimension(250,200));
        Frame.setResizable(false);

        Frame.add(panel1);

        Frame.pack();
        Frame.setLocationRelativeTo(null);
        Frame.setVisible(true);
    }
}
