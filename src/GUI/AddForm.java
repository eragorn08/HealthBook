package GUI;

import javax.swing.*;
import java.awt.*;

public class AddForm extends JFrame {

    private JPanel AddRecordForm;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JFrame frame;

    public AddForm(){
        frame =new JFrame("Add Patient Form");
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(1000,500));
        frame.setResizable(false);

        frame.add(AddRecordForm);

        frame.pack();
        frame.setVisible(true);
    }

}
