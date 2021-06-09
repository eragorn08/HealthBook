package GUI;

import javax.swing.*;
import java.awt.*;

public class Header {
    Header(){
        setHeader();
    }

    public void setHeader(){
        head = new JPanel();
        head.setBackground(new Color(0x283469));
        head.setBounds(0,0,1280,60);
        head.setVisible(true);

    }

    public JPanel head;
}
