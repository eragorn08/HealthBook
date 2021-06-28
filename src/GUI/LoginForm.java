package GUI;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.text.Position;
import javax.xml.crypto.Data;
import javax.xml.transform.Result;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import java.net.URL;

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
            BufferedImage logo_icon = ImageIO.read(new File(String.format("%s\\SIGNIN_LOGO.png",path)));
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
        DisplayPanel.add(DeptCode = new JTextField());

        DeptCode.setBounds(150,200,250,40);

        DeptCode.setOpaque(false);

        DeptCode.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if(DeptCode.getText().trim().equals("Dept Code")) {
                    DeptCode.setText("");
                }

                DeptCode.setForeground(Color.BLACK);
            }
            @Override
            public void focusLost(FocusEvent e) {
                if(DeptCode.getText().trim().equals("")) {
                    DeptCode.setText("Dept Code");
                }

                DeptCode.setForeground(Color.LIGHT_GRAY);
            }
        });

        DisplayPanel.add(EmpID = new JTextField());

        EmpID.setBounds(150,260,250,40);

        EmpID.setOpaque(false);
        EmpID.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if(EmpID.getText().trim().equals("Dept Code")) {
                    EmpID.setText("");
                }

                EmpID.setForeground(Color.BLACK);
            }
            @Override
            public void focusLost(FocusEvent e) {
                if(EmpID.getText().trim().equals("")) {
                    EmpID.setText("Dept Code");
                }

                EmpID.setForeground(Color.LIGHT_GRAY);
            }
        });

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
        if (e.getSource() == Login) {
            validateLogin();
        }
    }

    public void GetPosition() throws SQLException {

        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connect = connectNow.getConnection();

        String Identify = "SELECT Position FROM accounts WHERE username = '" +EmpID.getText()+ "'";

        Statement st = connect.createStatement();
        ResultSet rs = st.executeQuery(Identify);
        if(rs.next()) {
            position = rs.getString("Position");
        }
    }

    public void validateLogin(){
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        String verifyLogin = "SELECT count(1) FROM accounts WHERE Department = '" +DeptCode.getText()+ "' AND username = '" +EmpID.getText()+ "'";

        try {
            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(verifyLogin);

            while(queryResult.next()){
                if (queryResult.getInt(1) == 1) {
                    GetPosition();
                    if (position.equals("Doctor")){
                        setVisible(false);
                        new MainMenuDoctor();
                    }
                    else if (position.equals("Nurse")) {
                        setVisible(false);
                        new MainMenu();
                    }
                    else if (position.equals("Admin")){
                        setVisible(false);
                        new ADMINMENU();
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Wrong Department Code or Username");
                }
            }

        }catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }

    public JPanel DisplayPanel, DisplayContainer;
    public JTextField DeptCode, EmpID;
    public JLabel DisplayTitle;
    public JButton Login;
    public String position;
    public BufferedImage home_button, logo_icon, logo_text, power_button, logout, add_button, search_button;
}
