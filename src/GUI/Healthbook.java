package GUI;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;

public class Healthbook extends JFrame{

    public int posX = 0;
    public int posY = 0;

    public Healthbook()  {
        super("HealthBook");
        setHeader();
        setSize(1280, 720);
        setLayout(null);
        setResizable(false);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true);
        setVisible(true);

        try{

            for (int i = 0; i <= 100; i++){
                Thread.sleep(100);
                if(i == 0)
                    circle.setText("Opening Application");
                if(i == 26)
                    circle.setText("Starting Database");
                if(i == 51)
                    circle.setText("Managing the Queries");
                if(i == 76)
                    circle.setText("Starting the System");
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        new LoginForm();
        this.setVisible(false);
    }

    public void setHeader() {
        Border noborder = BorderFactory.createEmptyBorder();
        JLabel icon, text;
        JPanel Head = new JPanel();
        Head.setBackground(new Color(0x283469));
        Head.setBounds(0, 0, 1280, 720);
        Head.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();


        Head.setVisible(true);
        //Head.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));

        icon = new JLabel(new ImageIcon("loading_logo.png"));
        text = new JLabel(new ImageIcon("loading_label.png"));


        c.fill = GridBagConstraints.BOTH;
        c.weightx = 0.0;
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 4;
        c.insets = new Insets(40, 0, 45, 0);
        Head.add(icon,c);
        c.gridwidth = 1;
        c.insets = new Insets(0, 0, 0, 0);
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 4;
        Head.add(text,c);
        c.gridwidth = 1;

        JLabel Empty = new JLabel("WAH");
        Empty.setFont(new Font("Helvetica", Font.PLAIN, 147));
        Empty.setForeground(new Color(0x283469));
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1.0;
        c.gridwidth = 4;
        c.insets = new Insets(0, 0, 20, 0);
        c.gridx = 0;
        c.gridy = 2;
        Head.add(Empty, c);
        c.gridwidth = 1;


        JLabel space = new JLabel("asdfasdf");
        c.insets = new Insets(0, 0, 0, 0);
        c.gridx = 0;
        space.setForeground(new Color(0x283469));
        c.gridy = 3;
        Head.add(space,c);


        circle = new JLabel("Opening Application",new ImageIcon("loading_circle.gif"),JLabel.RIGHT);
        c.insets = new Insets(0, 40, 0, 0);
        circle.setForeground(Color.white);
        c.fill = GridBagConstraints.LINE_END;
        circle.setFont(new Font("Helvetica", Font.PLAIN, 36));
        circle.setHorizontalTextPosition(SwingConstants.LEFT);
        circle.setIconTextGap(18);
        circle.setAlignmentX(Component.RIGHT_ALIGNMENT);
        c.gridx = 3;
        c.gridy = 3;
        Head.add(circle,c);

        JLabel sss = new JLabel("asdfasdf");
        c.insets = new Insets(0, 0, 0, 0);
        sss.setForeground(new Color(0x283469));
        c.gridx = 1;
        c.gridy = 3;
        Head.add(sss,c);

        JLabel ssss = new JLabel("asdfasdf");
        c.insets = new Insets(0, 0, 0, 0);
        ssss.setForeground(new Color(0x283469));
        c.gridx = 2;
        c.gridy = 3;
        Head.add(ssss,c);



        JLabel Empty1 = new JLabel("WAH");
        Empty1.setFont(new Font("Helvetica", Font.PLAIN, 15));
        Empty1.setForeground(new Color(0x283469));
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1.0;
        c.weighty = 0;
        c.insets = new Insets(0, 0, 0, 0);
        c.gridx = 0;
        c.gridy = 4;
        Head.add(Empty1, c);




        add(Head);


    }





    public final CardLayout cl = new CardLayout();
    public JLabel circle;
    public JButton addButton, searchButton, homeButton, log_out, power, help, about;
    public final JPanel cardPanel = new JPanel();
}
