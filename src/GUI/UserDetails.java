package GUI;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.font.FontRenderContext;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserDetails extends JFrame implements ActionListener {
    public JPanel panel = new JPanel();
    public JScrollPane scrollPane = new JScrollPane(panel);
    public RoundedPanel body_panel;
    public String lastname,firstname,midname;
    public JButton back_button;
    public JTextField surnameTextField, givenNameTextField, middleNameTextField, deptTextField, codeTextField, IDTextField;
    public int X = 0;
    public int Y = 0;

    public void GetData() {
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connect = connectNow.getConnection();

        System.out.println(SearchForm.value);

        String Identify = "SELECT * FROM accounts WHERE patientID = '" +SearchForm.value+ "'";
        try{
            Statement st = connect.createStatement();
            ResultSet rs = st.executeQuery(Identify);
            if(rs.next()) {
                lastname = rs.getString("surname");
                firstname = rs.getString("givenname");
                midname = rs.getString("middlename");

            }}
        catch(Exception e){
            e.getCause();
            e.printStackTrace();
        }
    }

    public UserDetails() {
        super("Patient Information");
        setSize(1280, 720);

        setUndecorated(true);
        setResizable(false);
        setVisible(true);
        setLayout(null);
        //setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));

        JPanel title_panel = new JPanel();
        title_panel.setLayout(null);
        title_panel.setBackground(new Color(0x212C58));
        title_panel.setBounds(0, 0, 1280, 169);
        add(title_panel);
        title_panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent ev) {
                X = ev.getX();
                Y = ev.getY();
            }
        });
        title_panel.addMouseMotionListener(new MouseAdapter() {

            @Override
            public void mouseDragged(MouseEvent evt) {
                setLocation(evt.getXOnScreen() - X, evt.getYOnScreen() - Y);
            }
        });

        GetData();

        back_button = new JButton(new ImageIcon("back.png"));
        back_button.setContentAreaFilled(false);
        back_button.setVisible(true);
        back_button.setFocusPainted(false);
        back_button.setBorder(BorderFactory.createEmptyBorder());
        back_button.setBounds(19, 20, 86, 63);
        back_button.addActionListener(this);
        title_panel.add(back_button);

        JLabel patient_details = new JLabel("User Details");
        patient_details.setForeground(Color.white);
        patient_details.setFont(new Font("Helvetica", Font.PLAIN, 40));
        patient_details.setVisible(true);
        patient_details.setBounds(510, 30, 260, 54);
        title_panel.add(patient_details);

        JButton edit = new JButton(new ImageIcon("edit.png"));
        edit.setContentAreaFilled(false);
        edit.setFocusPainted(false);
        edit.setBorder(BorderFactory.createEmptyBorder());
        edit.addActionListener(this);
        edit.setBounds(1037,101,147,48);
        title_panel.add(edit);


        //add(panel);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(new EmptyBorder(new Insets(23, 40, 100, 40)));
        panel.setBackground(new Color(0x212C58));
        panel.setVisible(true);
        panel.setBounds(0, 169, 1280, 551);


        scrollPane.setVisible(true);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setPreferredSize(new Dimension(1280,643));

        info();
        panel.add(Box.createRigidArea((new Dimension(5,15))));



        scrollPane = new JScrollPane(panel, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        scrollPane.setLayout(new ScrollPaneLayout());
        scrollPane.setBounds(0, 169, 1280, 551);

        add(scrollPane);


    }

    public void disableAllTextField(){
        surnameTextField.setEditable(false);
        givenNameTextField.setEditable(false);
        middleNameTextField.setEditable(false);
        deptTextField.setEditable(false);
        codeTextField.setEditable(false);
        IDTextField.setEditable(false);
    }


    public void info() {
        panel.add(body_panel = new RoundedPanel(50,new Color(0x4d5579)));
        body_panel.setOpaque(false);
        body_panel.setBorder(BorderFactory.createEmptyBorder());
        body_panel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        c.weightx = 1.0;
        c.weighty = 0.0;
        body_panel.setVisible(true);

        //Name
        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setFont(new Font("Helvetica", Font.PLAIN, 20));
        nameLabel.setForeground(Color.white);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.insets = new Insets(20, 33, 2, 0);
        c.gridx = 0;
        c.gridy = 0;
        body_panel.add(nameLabel, c);
        c.weightx = 1.0;




        //Surname
        JLabel surnameLabel = new JLabel("Surname ");
        surnameLabel.setFont(new Font("Helvetica", Font.PLAIN, 20));
        surnameLabel.setForeground(Color.white);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(15, 33, 2, 0);
        c.gridx = 1;
        c.gridy = 1;
        body_panel.add(surnameLabel, c);

        surnameTextField = new JTextField(10);
        surnameTextField.setFont(new Font("Helvetica", Font.PLAIN, 20));
        c.fill = GridBagConstraints.HORIZONTAL;
        //c.insets = new Insets(15, 33, 2, 0);
        c.gridx = 1;
        c.gridy = 0;
        body_panel.add(surnameTextField, c);

        //Given Name
        JLabel givenNameLabel = new JLabel("Given Name ");
        givenNameLabel.setFont(new Font("Helvetica", Font.PLAIN, 20));
        givenNameLabel.setForeground(Color.white);
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(15, 33, 2, 0);
        c.gridx = 2;
        c.gridy = 1;
        body_panel.add(givenNameLabel, c);

        givenNameTextField = new JTextField(10);
        givenNameTextField.setFont(new Font("Helvetica", Font.PLAIN, 20));
        c.fill = GridBagConstraints.HORIZONTAL;
        //c.insets = new Insets(15, 33, 2, 0);
        c.gridx = 2;
        c.gridy = 0;
        body_panel.add(givenNameTextField, c);


        //Middle Name
        JLabel middleNameLabel = new JLabel("Middle Name");
        middleNameLabel.setFont(new Font("Helvetica", Font.PLAIN, 20));
        middleNameLabel.setForeground(Color.white);
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(15, 33, 2, 0);
        c.gridx = 3;
        c.gridy = 1;
        body_panel.add(middleNameLabel, c);

        middleNameTextField = new JTextField(10);
        middleNameTextField.setFont(new Font("Helvetica", Font.PLAIN, 20));
        c.fill = GridBagConstraints.BOTH;
        //c.insets = new Insets(15, 33, 2, 0);
        c.gridx = 3;
        c.gridy = 0;
        body_panel.add(middleNameTextField, c);

        //Name
        JLabel Empty = new JLabel("WAAAAAAAH");
        Empty.setFont(new Font("Helvetica", Font.PLAIN, 20));
        Empty.setForeground(new Color(0x4d5579));
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1.0;
        c.insets = new Insets(20, 33, 2, 0);
        c.gridx = 4;
        c.gridy = 0;
        body_panel.add(Empty, c);





        //Department
        JLabel deptLabel = new JLabel("Department: ");
        deptLabel.setFont(new Font("Helvetica", Font.PLAIN, 20));
        deptLabel.setForeground(Color.white);
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(15, 33, 2, 0);
        c.gridx = 0;
        c.gridy = 2;
        body_panel.add(deptLabel, c);

        deptTextField = new JTextField(10);
        deptTextField.setFont(new Font("Helvetica", Font.PLAIN, 20));
        c.fill = GridBagConstraints.HORIZONTAL;
        //c.insets = new Insets(15, 33, 2, 0);
        c.gridx = 1;
        c.gridy = 2;
        body_panel.add(deptTextField, c);



        //Role
        JLabel roleLabel = new JLabel("Role: ");
        roleLabel.setFont(new Font("Helvetica", Font.PLAIN, 20));
        roleLabel.setForeground(Color.white);
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(15, 33, 2, 0);
        c.gridx = 0;
        c.gridy = 3;
        body_panel.add(roleLabel, c);

        JRadioButton doctorRadio = new JRadioButton("Doctor");
        doctorRadio.setFont(new Font("Helvetica", Font.PLAIN, 20));
        doctorRadio.setBackground(new Color(0x4d5579));
        doctorRadio.setForeground(Color.white);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 3;
        body_panel.add(doctorRadio, c);

        JRadioButton nurseRadio = new JRadioButton("Nurse");
        nurseRadio.setFont(new Font("Helvetica", Font.PLAIN, 20));
        nurseRadio.setBackground(new Color(0x4d5579));
        nurseRadio.setForeground(Color.white);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 2;
        c.gridy = 3;
        body_panel.add(nurseRadio, c);


        //RADIO BUTTON GROUP
        ButtonGroup Roles = new ButtonGroup();
        Roles.add(doctorRadio);
        Roles.add(nurseRadio);


        //Code:
        JLabel codeLabel = new JLabel("<html>Department<br>Code</html>");
        codeLabel.setFont(new Font("Helvetica", Font.PLAIN, 20));
        codeLabel.setForeground(Color.white);
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(15, 33, 2, 0);
        c.gridx = 0;
        c.gridy = 4;
        body_panel.add(codeLabel, c);

        codeTextField = new JTextField(10);
        codeTextField.setFont(new Font("Helvetica", Font.PLAIN, 20));
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 4;
        body_panel.add(codeTextField, c);


        //ID:
        JLabel EmpIDLabel = new JLabel("<html>Employee<br>ID:</html>");
        EmpIDLabel.setFont(new Font("Helvetica", Font.PLAIN, 20));
        EmpIDLabel.setForeground(Color.white);
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(15, 33, 2, 0);
        c.gridx = 0;
        c.gridy = 5;
        body_panel.add(EmpIDLabel, c);

        IDTextField = new JTextField(10);
        IDTextField.setFont(new Font("Helvetica", Font.PLAIN, 20));
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 5;
        body_panel.add(IDTextField, c);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back_button) {
            setVisible(false);
        }
    }

    static class RoundedPanel extends JPanel {
        private Color backgroundColor;
        private int cornerRadius = 15;

        public RoundedPanel(LayoutManager layout, int radius) {
            super(layout);
            cornerRadius = radius;
        }

        public RoundedPanel(LayoutManager layout, int radius, Color bgColor) {
            super(layout);
            cornerRadius = radius;
            backgroundColor = bgColor;
        }

        public RoundedPanel(int radius) {
            super();
            cornerRadius = radius;
        }

        public RoundedPanel(int radius, Color bgColor) {
            super();
            cornerRadius = radius;
            backgroundColor = bgColor;
        }
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Dimension arcs = new Dimension(cornerRadius, cornerRadius);
            int width = getWidth();
            int height = getHeight();
            Graphics2D graphics = (Graphics2D) g;
            graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            //Draws the rounded panel with borders.
            if (backgroundColor != null) {
                graphics.setColor(backgroundColor);
            } else {
                graphics.setColor(getBackground());
            }
            graphics.fillRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height); //paint background
            graphics.setColor(getForeground());
            graphics.drawRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height); //paint border
        }
    }

}


