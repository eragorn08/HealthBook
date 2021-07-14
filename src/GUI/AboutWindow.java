package GUI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AboutWindow extends JFrame{
    public AboutWindow(){
        setLayout(null);
        setSize(854,480);
        setUndecorated(true);

        setVisible(true);




        JPanel title_panel = new JPanel();
        title_panel.setLayout(null);
        title_panel.setBackground(new Color(0x212C58));
        title_panel.setBounds(0, 0, 854, 104);
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
        back_button.setBounds(22, 26, 86, 63);
        back_button.addActionListener(e -> dispose());
        title_panel.add(back_button);

        JLabel about_title = new JLabel("About This Software");
        about_title.setForeground(Color.white);
        about_title.setFont(new Font("Helvetica", Font.PLAIN, 36));
        about_title.setVisible(true);
        about_title.setBounds(264, 36, 327, 54);
        title_panel.add(about_title);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        //panel.setBorder(new EmptyBorder(new Insets(23, 40, 100, 40)));
        panel.setBackground(new Color(0x212C58));
        panel.setVisible(true);
        panel.setBounds(0, 104, 854, 376);
        add(panel);

        panel.add(roundedpanel = new PatientInformation.RoundedPanel(50,new Color(0x4d5579)));
        roundedpanel.setOpaque(false);
        roundedpanel.setBorder(BorderFactory.createEmptyBorder());
        roundedpanel.setLayout(null);

        roundedpanel.add(logo = new JLabel(new ImageIcon("aboutsymbol.png")));
        logo.setBounds(309, 14, 90, 123);

        roundedpanel.add(healthbook =new JLabel(new ImageIcon("aboutlabel.png")));
        healthbook.setBounds(195, 153, 418, 45);

    }






    public JButton back_button;
    public PatientInformation.RoundedPanel roundedpanel;
    public JLabel logo, healthbook;
    public int X,Y;
}
