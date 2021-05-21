package GUI;

import javax.swing.*;
import java.awt.*;

public class AddForm extends JFrame {

    private JPanel AddRecordForm;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField7;
    private JTextField textField8;
    private JTextField textField9;
    private JRadioButton maleRadioButton;
    private JRadioButton femaleRadioButton;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JComboBox comboBox3;
    private JButton submitButton;
    private JButton resetButton;
    private JTextArea textArea1;
    private JFrame frame;

    public AddForm(){
        frame =new JFrame("Add Patient Form");
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(1000,400));
        frame.setResizable(false);

        frame.add(AddRecordForm);

        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

}
