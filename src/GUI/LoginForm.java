package GUI;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class LoginForm extends JFrame implements ActionListener{

    public LoginForm() {
        super("Health Book");
        try {
            GraphicsEnvironment ge =
                    GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("BebasNeue-Regular.otf")));
        } catch (IOException |FontFormatException e) {
            return;
        }

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
        DisplayPanel.setBackground(new Color(0xF1F1F1));

        //logo
        try {
            String path = System.getProperty("user.dir");
            BufferedImage logo_icon = ImageIO.read(new File(String.format("%s\\src\\GUI\\images\\SIGNIN_LOGO.png",path)));
            JLabel icon = new JLabel(new ImageIcon(logo_icon));
            icon.setBounds(179,22,90,59);
            DisplayPanel.add(icon);

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        //Login
        DisplayPanel.add(DisplayTitle = new JLabel("SIGN IN"));

        DisplayTitle.setBounds(174,81,480,50);

        DisplayTitle.setFont(new Font("Bebas Neue",Font.PLAIN,45));

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

        DisplayPanel.setBounds(416,54,448,510);
        DisplayPanel.setVisible(true);
        getContentPane().add(DisplayPanel);
    }

    public void SetDisplayContainer(){
        DisplayContainer = new JPanel();
        DisplayContainer.setLayout(null);
        DisplayContainer.setBackground(new Color(0x283469));

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
