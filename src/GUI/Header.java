package GUI;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Header{
    public JLabel icon;
    public JPanel head;

    Header(){
        head.setBackground(new Color(0x283469));
        head.setBounds(0,0,1280,60);
        head.setVisible(true);

        //var icon = new JLabel();
        icon.setText("Bro, do you even code?");
        //ImageIcon logo_icon = new ImageIcon("logo_icon.png");
        //icon.setIcon(logo_icon);
        icon.setBounds(15,13,61,39);

        head.add(icon);

    }
}
