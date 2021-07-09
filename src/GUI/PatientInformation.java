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

public class PatientInformation extends JFrame implements ActionListener {
    public RoundedPanel body_panel, vitalsigns;
    public JButton back_button;
    public JPanel panel;
    public int X = 0;
    public int Y = 0;

    public PatientInformation() {
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
        title_panel.setBounds(0, 0, 1280, 100);
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

        JLabel patient_details = new JLabel("Patient Details");
        patient_details.setForeground(Color.white);
        patient_details.setFont(new Font("Helvetica", Font.PLAIN, 40));
        patient_details.setVisible(true);
        patient_details.setBounds(510, 30, 260, 54);
        title_panel.add(patient_details);

        panel = new JPanel();
        add(panel);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(new EmptyBorder(new Insets(23, 40, 100, 40)));
        panel.setBackground(new Color(0x212C58));
        panel.setVisible(true);
        panel.setBounds(0, 77, 1280, 643);
        info();
        panel.add(Box.createRigidArea((new Dimension(5,15))));
        vitalSigns();
        panel.add(Box.createRigidArea((new Dimension(5,20))));


    }
    public void vitalSigns(){
        // pwede mo ito i edit para may varibles na sila
        // ako na lang mag concatinate
        // VARIABLES FOR VITAL SIGNS//
        String bp = "110/80";
        String temp = "36.5°C";
        String pulse = "110/80";
        String pain = "110/80";
        //////////////////////////////
        panel.add(vitalsigns = new RoundedPanel(50,new Color(0x4d5579)));
        vitalsigns.setOpaque(false);
        vitalsigns.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        c.weightx = 1.0;
        c.weighty = 1.0;

        vitalsigns.setVisible(true);

        //Vital Signs Title
        JLabel vitalSignsLabel = new JLabel("Vital Signs");
        vitalSignsLabel.setFont(new Font("Helvetica", Font.BOLD, 25));
        vitalSignsLabel.setForeground(Color.white);
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 0.5;
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(13, 33, 2, 0);
        vitalsigns.add(vitalSignsLabel, c);
        c.weightx = 1.0;

        //Blood Pressure
        JLabel bpLabel = new JLabel("Blood Pressure: " + bp);
        bpLabel.setFont(new Font("Helvetica", Font.PLAIN, 20));
        bpLabel.setForeground(Color.white);
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(15, 33, 2, 0);
        c.gridx = 0;
        c.gridy = 1;
        vitalsigns.add(bpLabel, c);



        //Body Temperature
        JLabel tempLabel = new JLabel("Body Temperature: " + temp);
        tempLabel.setFont(new Font("Helvetica", Font.PLAIN, 20));
        tempLabel.setForeground(Color.white);
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(15, 33, 2, 0);
        c.gridx = 0;
        c.gridy = 2;
        vitalsigns.add(tempLabel, c);



        //Pulse Rate
        JLabel pulseLabel = new JLabel("Pulse Rate: " + pulse);
        pulseLabel.setFont(new Font("Helvetica", Font.PLAIN, 20));
        pulseLabel.setForeground(Color.white);
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(15, 33, 2, 0);
        c.gridx = 0;
        c.gridy = 3;
        vitalsigns.add(pulseLabel, c);



        //Level of Pain:
        JLabel painLabel = new JLabel("Level of Pain: " + pain);
        painLabel.setFont(new Font("Helvetica", Font.PLAIN, 20));
        painLabel.setForeground(Color.white);
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(15, 33, 14, 0);
        c.gridx = 0;
        c.gridy = 4;
        vitalsigns.add(painLabel, c);


    }

    public void info() {
        // pwede mo ito i edit para may varibles na sila
        // ako na lang mag concatinate
        // VARIABLES FOR BASIC DETAILS//
        String name = "De Villa, Jerevon Cruz";
        String sex = "Male";
        String address = "Rt. Rev. G. Aglipay, Mandaluyong, Metro Manila";
        String birth = "11/25/2001";
        String bloodtype = "O-";
        String age = "19";
        String height = "166 cm";
        String weight = "54 kg";
        String no = "2";
        String date = "01/21/2021";
        //////////////////////////////
        panel.add(body_panel = new RoundedPanel(50,new Color(0x4d5579)));
        body_panel.setOpaque(false);
        body_panel.setBorder(BorderFactory.createEmptyBorder());
        body_panel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        c.weightx = 1.0;
        c.weighty = 1.0;
        body_panel.setVisible(true);

        //Basic Details Title
        JLabel basicDetails = new JLabel("Basic Details");
        basicDetails.setFont(new Font("Helvetica", Font.BOLD, 25));
        basicDetails.setForeground(Color.white);
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 0.5;
        c.insets = new Insets(20, 33, 2, 0);
        c.gridx = 0;
        c.gridy = 0;
        body_panel.add(basicDetails, c);
        c.weightx = 1.0;


        //Name
        JLabel nameLabel = new JLabel("Name: " + name);
        nameLabel.setFont(new Font("Helvetica", Font.PLAIN, 20));
        nameLabel.setForeground(Color.white);
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(15, 33, 2, 0);
        c.gridx = 0;
        c.gridy = 1;
        body_panel.add(nameLabel, c);



        //Sex
        JLabel sexLabel = new JLabel("Sex: " + sex);
        sexLabel.setFont(new Font("Helvetica", Font.PLAIN, 20));
        sexLabel.setForeground(Color.white);
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(15, 33, 2, 0);
        c.gridx = 0;
        c.gridy = 2;
        body_panel.add(sexLabel, c);



        //Address
        JLabel addressLabel = new JLabel("Address: " + address);
        addressLabel.setFont(new Font("Helvetica", Font.PLAIN, 20));
        addressLabel.setForeground(Color.white);
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(15, 33, 2, 0);
        c.gridx = 0;
        c.gridy = 3;
        body_panel.add(addressLabel, c);


        //Date of Birth:
        JLabel birthLabel = new JLabel("Date of Birth: " + birth);
        birthLabel.setFont(new Font("Helvetica", Font.PLAIN, 20));
        birthLabel.setForeground(Color.white);
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(15, 33, 2, 0);
        c.gridx = 0;
        c.gridy = 4;
        body_panel.add(birthLabel, c);


        //Blood Type:
        JLabel bloodTypeLabel = new JLabel("Blood Type: " + bloodtype);
        bloodTypeLabel.setFont(new Font("Helvetica", Font.PLAIN, 20));
        bloodTypeLabel.setForeground(Color.white);
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(15, 33, 2, 0);
        c.gridx = 0;
        c.gridy = 5;
        body_panel.add(bloodTypeLabel, c);


        //Age:
        JLabel ageLabel = new JLabel("Age: " + age);
        ageLabel.setFont(new Font("Helvetica", Font.PLAIN, 20));
        ageLabel.setForeground(Color.white);
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(15, 33, 2, 0);
        c.gridx = 0;
        c.gridy = 6;
        body_panel.add(ageLabel, c);


        //Height
        JLabel heightLabel = new JLabel("Height: " + height);
        heightLabel.setFont(new Font("Helvetica", Font.PLAIN, 20));
        heightLabel.setForeground(Color.white);
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(15, 33, 2, 0);
        c.gridx = 0;
        c.gridy = 7;
        body_panel.add(heightLabel, c);


        //Weight
        JLabel weightLabel = new JLabel("Weight: " + weight);
        weightLabel.setFont(new Font("Helvetica", Font.PLAIN, 20));
        weightLabel.setForeground(Color.white);
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(15, 33, 14, 0);
        c.gridx = 0;
        c.gridy = 8;
        body_panel.add(weightLabel, c);



        //Patient No.:
        JLabel patientNoLabel = new JLabel("Patient No.: " + no);
        patientNoLabel.setFont(new Font("Helvetica", Font.PLAIN, 20));
        patientNoLabel.setForeground(Color.white);
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(15, 33, 5, 0);
        c.gridx = 2;
        c.gridy = 1;
        body_panel.add(patientNoLabel, c);


        //Date:
        JLabel DateLabel = new JLabel("Date: " + date);
        DateLabel.setFont(new Font("Helvetica", Font.PLAIN, 20));
        DateLabel.setForeground(Color.white);
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(15, 33, 5, 0);
        c.gridx = 2;
        c.gridy = 2;
        body_panel.add(DateLabel, c);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back_button) {
            dispose();
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


