package GUI;

import javax.swing.*;
import java.awt.*;

public class PatientInformation extends JPanel {
    public PatientInformation(){
        setBackground(new Color(0x212C58));
        setLayout(null);
        JLabel title = new JLabel("Patient Details");
        title.setForeground(Color.white);
        title.setFont(new Font("Helvetica", Font.PLAIN, 40));
        title.setBounds(365, 21, 270, 55);
        add(title);


    }
}
