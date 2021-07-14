package GUI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserDetails extends JFrame implements ActionListener, MouseListener {

    public void TransData(){
        upsurname  =  surnameTextField.getText();
        upgivenname = givenNameTextField.getText();
        upmiddlename = middleNameTextField.getText();
        if(doctorRadio.isSelected()){
            uppos = "Doctor";
        }
        if(nurseRadio.isSelected()){
            uppos = "Nurse";
        }
        updept = (String)depts.getSelectedItem();
        upcode = codeTextField.getText();
        upid = IDTextField.getText();
    }

    public void UpdateData(){
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connect = connectNow.getConnection();

        String Identify = "SELECT Username FROM accounts WHERE Username = '" +upid+ "'";

        String Source = "UPDATE accounts SET LastName = '" +upsurname+ "', GivenName = '"+upgivenname+"',MiddleName = " +
                "'"+upmiddlename+"',Position = '"+uppos+"',Username= '"+upid+"',DepartmentCode = '"+upcode+"', " +
                "Department = '"+updept+"' WHERE idaccounts = '"+AdminSearch.value+"'";
        try{
            Statement st = connect.createStatement();
            ResultSet rs = st.executeQuery(Identify);
            if(rs.next()) {
                checker = rs.getString("Username");
            }
            if(upid.equals(checker)) {
                JOptionPane.showMessageDialog(null, "EmpID is already in use please change.");
                IDTextField.setText("");
            }
            else{
                Statement statement = connect.createStatement();
                statement.executeUpdate(Source);
                JOptionPane.showMessageDialog(null, "User Information has been updated.");
                delete.setVisible(true);
                edit.setVisible(true);
                disableAllTextField();
            }
        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }

    public void GetData() {
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connect = connectNow.getConnection();

        String Identify = "SELECT * FROM accounts WHERE idaccounts = '" +AdminSearch.value+ "'";
        try{
            Statement st = connect.createStatement();
            ResultSet rs = st.executeQuery(Identify);
            if(rs.next()) {
                lastname = rs.getString("LastName");
                firstname = rs.getString("GivenName");
                midname = rs.getString("MiddleName");
                dep = rs.getString("Department");
                cod = rs.getString("DepartmentCode");
                pos = rs.getString("Position");
                id = rs.getString("Username");
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
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
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

        edit = new JButton(new ImageIcon("edit.png"));
        edit.setContentAreaFilled(false);
        edit.setFocusPainted(false);
        edit.setBorder(BorderFactory.createEmptyBorder());
        edit.addActionListener(this);
        edit.setBounds(1037,101,147,48);
        title_panel.add(edit);
        edit.addActionListener(this);

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

        //Functions
        GetData();
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
        confirm.setVisible(false);
        nurseRadio.setEnabled(false);
        doctorRadio.setEnabled(false);
        surnameTextField.setEditable(false);
        givenNameTextField.setEditable(false);
        middleNameTextField.setEditable(false);
        codeTextField.setEditable(false);
        IDTextField.setEditable(false);
        depts.setEnabled(false);
    }

    public void setAllEditable(){
        edit.setVisible(false);
        confirm.setVisible(true);
        nurseRadio.setEnabled(true);
        doctorRadio.setEnabled(true);
        surnameTextField.setEditable(true);
        givenNameTextField.setEditable(true);
        middleNameTextField.setEditable(true);
        depts.setEnabled(true);
        IDTextField.setEditable(true);
    }

    public void info() {

        panel.add(body_panel = new RoundedPanel(50,new Color(0x4d5579)));
        body_panel.setOpaque(false);
        body_panel.setBorder(BorderFactory.createEmptyBorder());
        body_panel.setLayout(new GridBagLayout());
        c = new GridBagConstraints();

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

        String[] department_list = {
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

        depts = new JComboBox<>(department_list);
        depts.setFont(new Font("Helvetica", Font.PLAIN, 20));
        depts.setSelectedItem(dep);

        depts.addMouseListener(this);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 2;
        body_panel.add(depts, c);

        //Role
        JLabel roleLabel = new JLabel("Role: ");
        roleLabel.setFont(new Font("Helvetica", Font.PLAIN, 20));
        roleLabel.setForeground(Color.white);
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(15, 33, 2, 0);
        c.gridx = 0;
        c.gridy = 3;
        body_panel.add(roleLabel, c);

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

        confirm = new JButton(new ImageIcon("confirm_logo.png"));
        confirm.setFocusPainted(false);
        confirm.setContentAreaFilled(false);
        confirm.setBorder(BorderFactory.createEmptyBorder());
        confirm.addActionListener(this);
        //confirm.setBorder(BorderFactory.createEmptyBorder());
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 4;
        c.gridy = 5;
        body_panel.add(confirm, c);

        //Transfer Data
        surnameTextField.setText(lastname);
        givenNameTextField.setText(firstname);
        middleNameTextField.setText(midname);
        codeTextField.setText(cod);
        IDTextField.setText(id);
        if (pos.equals("Doctor")){
            doctorRadio = new JRadioButton("Doctor",true);
            nurseRadio = new JRadioButton("Nurse",false);
        }
        else if(pos.equals("Nurse")){
            doctorRadio = new JRadioButton("Doctor",false);
            nurseRadio = new JRadioButton("Nurse",true);
        }

        doctorRadio.setFont(new Font("Helvetica", Font.PLAIN, 20));
        doctorRadio.setBackground(new Color(0x4d5579));
        doctorRadio.setForeground(Color.white);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 3;
        body_panel.add(doctorRadio, c);

        nurseRadio.setFont(new Font("Helvetica", Font.PLAIN, 20));
        nurseRadio.setBackground(new Color(0x4d5579));
        nurseRadio.setForeground(Color.white);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 2;
        c.gridy = 3;
        body_panel.add(nurseRadio, c);

        //RADIO BUTTON GROUP
        Roles = new ButtonGroup();
        Roles.add(doctorRadio);
        Roles.add(nurseRadio);

        delete = new JButton(new ImageIcon("deletebutton.png"));
        delete.setContentAreaFilled(false);
        delete.setFocusPainted(false);
        delete.setBorder(BorderFactory.createEmptyBorder(30,0,0,0));
        delete.addActionListener(this);
        delete.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(delete);

        //Functions
        disableAllTextField();
    }

    public void showConfirmation(){
        smallFrame = new RoundedPanel(30,new Color(0x212C58));
        smallFrame.setSize(500,300);
        smallFrame.setOpaque(false);

        smallFrame.setLayout(new FlowLayout());
        smallFrame.setVisible(true);
        smallFrame.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(smallFrame);

        //logos and titles
        JLabel x = new JLabel(new ImageIcon("x_logo.png"));
        x.setBorder(BorderFactory.createEmptyBorder());
        x.setOpaque(false);
        smallFrame.add(x);

        JLabel AreYouSure = new JLabel("Are you sure?");
        AreYouSure.setFont(new Font("Helvetica", Font.PLAIN, 40));
        AreYouSure.setForeground(Color.white);
        smallFrame.add(AreYouSure);
        JLabel message = new JLabel("<html><div style = 'text-align: center;'>Do you really want to delete" +
                " this account?<br>This process cannot be undone.</div></html>");
        message.setForeground(new Color(0x8891a6));
        message.setFont(new Font("Helvetica", Font.PLAIN, 20));
        smallFrame.add(message);

        cancel = new JButton(new ImageIcon("cancel.png"));
        cancel.setBorder(BorderFactory.createEmptyBorder());
        cancel.setContentAreaFilled(false);
        cancel.setFocusPainted(false);
        cancel.addActionListener(this);
        smallFrame.add(cancel);

        confirmdelete = new JButton(new ImageIcon("confirm_logo.png"));
        confirmdelete.setBorder(BorderFactory.createEmptyBorder());
        confirmdelete.setContentAreaFilled(false);
        confirmdelete.setFocusPainted(false);
        confirmdelete.addActionListener(this);
        smallFrame.add(confirmdelete);
    }

    public void deleterec(){
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        String delete = "DELETE FROM accounts WHERE idaccounts = '"+AdminSearch.value+"'";

        try{
            Statement statement = connectDB.createStatement();
            statement.executeUpdate(delete);
        }catch(Exception e){
            e.getCause();
            e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back_button) {
            setVisible(false);
        }

        if(e.getSource() == edit){
            delete.setVisible(false);
            setAllEditable();
        }
        if(e.getSource() == confirm){
            AdminSearch.gettableData(empty);
            TransData();
            UpdateData();
            AdminSearch.gettableData(empty);
        }

        if(e.getSource() == delete){
            edit.setVisible(false);
            delete.setVisible(false);
            showConfirmation();
        }

        if (e.getSource() == cancel){
            smallFrame.setVisible(false);
            delete.setVisible(true);
            edit.setVisible(true);
        }
        if (e.getSource() == confirmdelete){
            deleterec();
            smallFrame.setVisible(false);
            delete.setVisible(true);
            edit.setVisible(true);
            AdminSearch.gettableData(empty);
            JOptionPane.showMessageDialog(null, "User Information has been deleted!");
            dispose();
        }
    }

    public void DeptAssign(){
        if (depts.getSelectedItem().equals("Cardiology")){
            codeTextField.setText("Cardiology123");
        }
        else if (depts.getSelectedItem().equals("Gastroenterology")){
            codeTextField.setText("Gastroenterology123");
        }
        else if (depts.getSelectedItem().equals("Gynecology")){
            codeTextField.setText("Gynecology123");
        }
        else if (depts.getSelectedItem().equals("Nephrology")){
            codeTextField.setText("Nephrology123");
        }
        else if (depts.getSelectedItem().equals("Neurology")){
            codeTextField.setText("Neurology123");
        }
        else if (depts.getSelectedItem().equals("Oncology")){
            codeTextField.setText("Oncology123");
        }
        else if (depts.getSelectedItem().equals("Ophthalmology")){
            codeTextField.setText("Ophthalmology123");
        }
        else if (depts.getSelectedItem().equals("Orthopaedics")){
            codeTextField.setText("Orthopaedics123");
        }
        else if (depts.getSelectedItem().equals("Otolaryngology")){
            codeTextField.setText("Otolaryngology123");
        }
        else if (depts.getSelectedItem().equals("Urology")){
            codeTextField.setText("Urology123");
        }

    }

    //Mouse Event
    @Override
    public void mouseClicked(MouseEvent e) {
        DeptAssign();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        DeptAssign();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        DeptAssign();
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        DeptAssign();
    }

    @Override
    public void mouseExited(MouseEvent e) {
        DeptAssign();
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
    public GridBagConstraints c;
    public ButtonGroup Roles;
    public JPanel panel = new JPanel();
    public JScrollPane scrollPane = new JScrollPane(panel);
    public RoundedPanel body_panel, smallFrame;
    public String checker,lastname,firstname,midname,dep,cod,id,pos,upsurname,upgivenname,upmiddlename,uppos,updept,upcode,upid;
    public String[] empty = {"","All"};
    public JComboBox<String> depts;
    public JButton back_button, edit, confirm, delete, confirmdelete, cancel;
    public JTextField surnameTextField, givenNameTextField, middleNameTextField, deptTextField, codeTextField, IDTextField;
    public JRadioButton doctorRadio, nurseRadio;
    public int X = 0;
    public int Y = 0;
}


