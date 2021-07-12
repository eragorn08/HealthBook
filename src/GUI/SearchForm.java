package GUI;

import com.mysql.cj.protocol.Resultset;
import com.sun.tools.javac.Main;
import jdk.jfr.Enabled;

import javax.swing.*;

import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.basic.BasicArrowButton;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.RescaleOp;
import java.sql.*;
import java.util.Arrays;


public class SearchForm extends JPanel implements ActionListener{
    public GridBagConstraints c = new GridBagConstraints();
    public DefaultTableModel model;
    public JPanel center = new JPanel();
    public JPanel north = new JPanel();
    public JTable table;
    public JComboBox<String> sort_by;
    public JLabel searchPatientTitle;
    public JButton view;
    public static String value,date;
    public SearchForm(){
        setBackground(new Color(0x212C58));
        setLayout(new BorderLayout());
        setVisible(true);
        searchformtitle();
        searchform();

    }
    public void searchformtitle(){
        searchPatientTitle = new JLabel("Search Patient");
        searchPatientTitle.setFont(new Font("Helvetica", Font.PLAIN, 40));
        searchPatientTitle.setForeground(Color.white);
        searchPatientTitle.setBorder(new EmptyBorder(23,22,0,0));
        //searchPatientTitle.setBounds(22, 19, 275, 55);
        add(searchPatientTitle, BorderLayout.NORTH);
    }

    public void searchform(){

        north.setLayout(new FlowLayout(FlowLayout.LEFT));
        north.setBackground(new Color(0x212C58));
        north.setBorder(new EmptyBorder(22,22,0,22));
        north.setVisible(true);

        add(center, BorderLayout.SOUTH);




        //search label
        JLabel search_label = new JLabel("Search:");
        search_label.setFont(new Font("Helvetica", Font.PLAIN, 20));
        search_label.setForeground(Color.WHITE);
        search_label.setBorder(BorderFactory.createEmptyBorder(0,0,0,8));
        north.add(search_label, BorderLayout.WEST);

        //search field
        JTextField search_field = new JTextField(27);
        //search_field.setBounds(105,8, 561, 40);
        search_field.setBackground(new Color(0x4b5576));
        search_field.setForeground(Color.white);
        search_field.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        search_field.setFont(new Font("Helvetica", Font.PLAIN, 25));
        north.add(search_field, BorderLayout.WEST);
        search_field.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                changedUpdate(e);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                changedUpdate(e);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                String[] t = {"",""};
                t[0] = search_field.getText();
                t[1] = sort_by.getSelectedItem().toString();
                gettableData(t);

            }
        });

        //searchBy label
        JLabel searchBy_label = new JLabel("Search By:");
        searchBy_label.setFont(new Font("Helvetica", Font.PLAIN, 20));
        searchBy_label.setForeground(Color.WHITE);
        searchBy_label.setBorder(BorderFactory.createEmptyBorder(5,15,5,5));

        //searchBy_label.setBounds(705, 12, 109, 33);
        north.add(searchBy_label);

        String[] sortBy = {"Name", "Date"};
        sort_by = new JComboBox<>(sortBy);
        sort_by.setOpaque(false);
        sort_by.setUI(new MyComboBoxUI());
        sort_by.setFont(new Font("Helvetica", Font.PLAIN, 20));
        sort_by.setBackground(new Color(0x212C58));
        sort_by.setForeground(Color.white);

        sort_by.setRenderer(new DefaultListCellRenderer(){
            @Override
            public void paint(Graphics g) {
                setBackground(new Color(0x212C58));
                setForeground(Color.white);
                super.paint(g);
            }
        });
        sort_by.setFocusable(false);

        north.add(sort_by, BorderLayout.EAST);

        sort_by.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] t = {"",""};
                t[0] = search_field.getText();
                t[1] = sort_by.getSelectedItem().toString();
                gettableData(t);
            }
        });

        center.setLayout(new GridBagLayout());
        c.weightx = 1.0;
        c.weighty = 1.0;


        center.setBackground(new Color(0x212C58));
        center.setVisible(true);
        //center.setBorder(new EmptyBorder(8,22,0,22));
        add(north, BorderLayout.CENTER);




        createTable();
        String[] empty = {"","Name"};
        gettableData(empty);


    }

    public String[] gettableData(String[] text) {
        String patientinfo;

        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        if (text[0].equals(""))
            patientinfo = "SELECT patientID, surname, givenname, middlename, datetime FROM patientinfo";
        else if (text[1].equals("Name"))
            patientinfo = "SELECT patientID, surname, givenname, middlename, datetime FROM patientinfo WHERE surname LIKE '" +text[0]+ "%'";
        else
            patientinfo = "SELECT patientID, surname, givenname, middlename, datetime FROM patientinfo WHERE datetime LIKE '" +text[0]+ "%'";
        try {
            model.setRowCount(0);
            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(patientinfo);


            while(queryResult.next()){
                int id = queryResult.getInt("patientID");
                String firstname = queryResult.getString("givenname");
                String middlename = queryResult.getString("middlename");
                String surname = queryResult.getString("surname");
                String name = surname + ", " + firstname + " " + middlename;
                Date date = queryResult.getDate("datetime");

                model.addRow(new Object[]{id,name,date});
            }

        }catch (Exception e){
            e.getCause();
            e.printStackTrace();
        }
        return text;

    }


    public void createTable(){


        table = new JTable(new DefaultTableModel());
        table.clearSelection();
        model = (DefaultTableModel) table.getModel();
        model.addColumn("Patient No.");
        model.addColumn("Name");
        model.addColumn("Date of Checkup");


        table.setFont(new Font("Helvetica", Font.PLAIN, 20));
        table.setBackground(new Color(0x4b5576));
        table.setForeground(Color.white);
        table.setRowHeight(38);
        table.setBorder(BorderFactory.createEmptyBorder());
        table.setGridColor(new Color(0x212C58));


        table.setFillsViewportHeight(true);


        Dimension dim = new Dimension(97,6);
        table.setIntercellSpacing(new Dimension(dim));

        JScrollPane pane = new JScrollPane(table);
        table.setTableHeader(new JTableHeader(table.getColumnModel()) {
             @Override
             public Dimension getPreferredSize() {
                 Dimension d = super.getPreferredSize();
                 d.height = 38;
                 return d;
             }
         }
        );
        table.getTableHeader().setFont(new Font("Helvetica", Font.PLAIN, 20));
        table.getTableHeader().setBackground(new Color(0x4b5576));
        table.getTableHeader().setForeground(Color.white);
        table.getColumnModel().getColumn(1).setPreferredWidth(250);
        table.getColumnModel().getColumn(2).setPreferredWidth(230);
        DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
        dtcr.setHorizontalAlignment(SwingConstants.CENTER);
        table.getColumn("Patient No.").setCellRenderer(dtcr);
        table.getColumn("Name").setCellRenderer(dtcr);
        table.getColumn("Date of Checkup").setCellRenderer(dtcr);


        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        view = new JButton(new ImageIcon("view.png"));
        view.addActionListener(this);

        if(table.getSelectionModel().isSelectionEmpty()){
            view.setEnabled(false);

        }


        view.setContentAreaFilled(false);
        view.setFocusPainted(false);
        view.setBorder(BorderFactory.createEmptyBorder());

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                table.clearSelection();
                view.setEnabled(false);

            }
        });

        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e) {
                view.setEnabled(true);

            }
        });
        c.fill = GridBagConstraints.BOTH;
        c.gridwidth = 3;
        c.gridheight = 3;
        c.insets = new Insets(0, 25, 0, 25);
        c.gridx = 0;
        c.gridy = 0;
        center.add(pane, c);

        c.fill = GridBagConstraints.BOTH;
        c.weightx = 0.0;
        c.weighty = 0.0;
        c.insets = new Insets(10, 800, 15, 35);
        //c.anchor = GridBagConstraints.PAGE_END;
        c.gridwidth = 2;
        c.gridx = 1;
        c.gridy = 3;
        view.setEnabled(false);

        center.add(view,c);
    }




    @Override
    public void actionPerformed(ActionEvent e){

        if(e.getSource() == view){
            int row = table.getSelectedRow();
            value = table.getModel().getValueAt(row, 0).toString();
            date = table.getModel().getValueAt(row,2).toString();
            table.clearSelection();
            new PatientInformation();
        }
    }
}
class MyComboBoxUI extends BasicComboBoxUI {
    @Override
    protected void installDefaults() {
        super.installDefaults();
        LookAndFeel.uninstallBorder(comboBox); //Uninstalls the LAF border for both button and label of combo box.
    }

    @Override
    protected JButton createArrowButton() {
        //Feel free to play with the colors:
        final Color background = new Color(0x212C58);
        final Color pressedButtonBorderColor = background;
        final Color triangle = Color.WHITE;
        final Color highlight = background;
        final JButton button = new BasicArrowButton(BasicArrowButton.SOUTH, background, pressedButtonBorderColor, triangle, highlight);
        button.setName("ComboBox.arrowButton"); //Mandatory, as per BasicComboBoxUI#createArrowButton().
        return button;
    }
}