package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import javax.swing.JFrame;

public class AddForm extends JFrame implements ActionListener {

    public AddForm() {
        super("Add Form");

        setNavPanel();

    }

    public void setNavPanel(){
        NavPanel = new JPanel();
        NavPanel.setLayout(null);
        NavPanel.setBackground(Color.DARK_GRAY);

        NavPanel.add(add);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == )
    }

    public JPanel NavPanel, DisplayPanel;
    public JButton addButton, searchButton;
    public JLabel greetingL, summaryL;
}
