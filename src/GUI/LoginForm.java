package GUI;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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

        setUndecorated(true);
        setVisible(true);
        getContentPane().requestFocusInWindow();
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
        DeptCode = new JTextField("Dept Code");
        DeptCode.setBounds(59,177,330,40);
        DeptCode.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLACK));
        DeptCode.setFont(new Font("Roboto", Font.PLAIN, 22));
        DeptCode.setOpaque(false);
        DeptCode.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (DeptCode.getText().equals("Dept Code")) {
                    DeptCode.setText("");
                    DeptCode.setForeground(Color.BLACK);
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (DeptCode.getText().isEmpty()) {
                    DeptCode.setForeground(Color.BLACK);
                    DeptCode.setText("Dept Code");
                }
            }
        });


        EmpID = new JTextField("Employee ID");
        EmpID.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLACK));
        EmpID.setBounds(59,283,330,40);
        EmpID.setFont(new Font("Roboto", Font.PLAIN, 22));
        EmpID.setOpaque(false);
        EmpID.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (EmpID.getText().equals("Employee ID")) {
                    EmpID.setText("");
                    EmpID.setForeground(Color.BLACK);
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (EmpID.getText().isEmpty()) {
                    EmpID.setForeground(Color.BLACK);
                    EmpID.setText("Employee ID");
                }
            }
        });


        //Submit Button
        DisplayPanel.add(Login = new JButton(new ImageIcon("signin.png")));

        Login.setBounds(59,431,330,53);
        Login.setBorder(BorderFactory.createEmptyBorder());
        Login.setFocusPainted(false);
        Login.setFont(new Font("Arial",Font.PLAIN,40));


        Login.addActionListener(this);



        DisplayPanel.setBounds(416,54,448,510);
        DisplayPanel.setVisible(true);
        DisplayPanel.add(DeptCode);
        DisplayPanel.add(EmpID);
        getContentPane().add(DisplayPanel);
    }

    public void SetDisplayContainer(){
        DisplayContainer = new JPanel();
        DisplayContainer.setLayout(null);
        DisplayContainer.setBackground(new Color(0x283469));

        DisplayContainer.setBounds(0,0,320, 180);



        //POWER_OFF
        power = new JButton(new ImageIcon("power_button.png"));
        power.setFocusPainted(false);
        power.setBackground(new Color(0x283469));
        power.setBorder(BorderFactory.createEmptyBorder());
        power.setBounds(1227,21,25,27);
        power.addActionListener(this);
        DisplayContainer.add(power);
        getContentPane().add(DisplayContainer);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Login) {
            validateLogin();
        }
        if (e.getSource() == power){
            System.exit(0);
        }
    }

    public void GetPosition() throws SQLException {

        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connect = connectNow.getConnection();

        String Identify = "SELECT * FROM accounts WHERE username = '" +EmpID.getText()+ "'";

        Statement st = connect.createStatement();
        ResultSet rs = st.executeQuery(Identify);
        if(rs.next()) {
            position = rs.getString("Position");
            ida = rs.getString("idaccounts");
            dept= rs.getString("Department");
            doc = rs.getString("LastName");
        }
        id = Integer.parseInt(ida);
    }

    public void validateLogin(){
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        String verifyLogin = "SELECT count(1) FROM accounts WHERE DepartmentCode = '" +DeptCode.getText()+ "' AND username = '" +EmpID.getText()+ "'";

        try {
            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(verifyLogin);

            while(queryResult.next()){
                if (queryResult.getInt(1) == 1) {
                    GetPosition();
                    switch (position) {
                        case "Doctor" -> {
                            setVisible(false);
                            new MainMenuDoctor();
                        }
                        case "Nurse" -> {
                            setVisible(false);
                            new MainMenu();
                        }
                        case "Admin" -> {
                            setVisible(false);
                            new ADMINMENU();
                        }
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
    public JTextField DeptCode;
    public static JTextField EmpID;
    public static int id;
    public static String dept,doc;
    public JLabel DisplayTitle;
    public JButton Login,power;
    private String position,ida;
}

