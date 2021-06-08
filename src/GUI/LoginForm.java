package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginForm extends JFrame implements ActionListener{

    public LoginForm() {
        super("Health Book");

        SetDisplayPanel();
        SetDisplayContainer();

        setVisible(true);
        setSize(1280, 720);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    public void SetDisplayPanel(){
        DisplayPanel = new JPanel();
        DisplayPanel.setLayout(null);
        DisplayPanel.setBackground(Color.getHSBColor(238, 130, 238));

        //Login
        DisplayPanel.add(DisplayTitle = new JLabel("LOG IN"));

        DisplayTitle.setBounds(200,80,480,50);

        DisplayTitle.setFont(new Font("Arial",Font.PLAIN,48));

        //Text Fields
        DisplayPanel.add(DeptCode = new JTextField("Dept Code"));

        DeptCode.setBounds(150,200,250,40);

        DisplayPanel.add(EmpID = new JTextField("Employee ID"));

        EmpID.setBounds(150,260,250,40);

        //Submit Button
        DisplayPanel.add(Login = new JButton("Sign In"));

        Login.setBounds(180,380,200,60);

        Login.setFont(new Font("Arial",Font.PLAIN,40));

        Login.addActionListener(this);

        DisplayPanel.setBounds(380,50,560,580);
        DisplayPanel.setVisible(true);
        getContentPane().add(DisplayPanel);
    }

    public void SetDisplayContainer(){
        DisplayContainer = new JPanel();
        DisplayContainer.setLayout(null);
        DisplayContainer.setBackground(Color.gray);

        DisplayContainer.setBounds(0,0,320, 180);
        getContentPane().add(DisplayContainer);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String Code = DeptCode.getText();
        String CorrectCode = "Cardiology12345";
        if (e.getSource() == Login) {
            if (Code.equals(CorrectCode)) {
                setVisible(false);
                MainMenu mainMenu = new MainMenu();
            } else {
                JOptionPane.showMessageDialog(null, "Wrong Department Code");
            }
        }
    }

    public JPanel DisplayPanel, DisplayContainer;
    public JTextField DeptCode, EmpID;
    public JLabel DisplayTitle;
    public JButton Login;
}
