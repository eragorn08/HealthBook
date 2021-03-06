package GUI;

import javax.swing.*;

import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;


public class AdminSearch extends JPanel implements ActionListener{

    public AdminSearch(){
        setBackground(new Color(0x212C58));
        setLayout(new BorderLayout());
        setVisible(true);
        searchtitle();
        searchform();
    }

    public void searchtitle(){
        searchPatientTitle = new JLabel("Search User");
        searchPatientTitle.setFont(new Font("Helvetica", Font.PLAIN, 40));
        searchPatientTitle.setForeground(Color.white);
        searchPatientTitle.setBorder(new EmptyBorder(23,22,0,0));
        add(searchPatientTitle, BorderLayout.NORTH);
    }

    public void searchform(){

        north.setLayout(new FlowLayout(FlowLayout.LEFT));
        north.setBackground(new Color(0x212C58));
        north.setBorder(new EmptyBorder(22,22,0,22));
        north.setVisible(true);

        add(center, BorderLayout.SOUTH);

        //search label
        JLabel search_label = new JLabel("Search Name:");
        search_label.setFont(new Font("Helvetica", Font.PLAIN, 20));
        search_label.setForeground(Color.WHITE);
        search_label.setBorder(BorderFactory.createEmptyBorder(0,0,0,8));
        north.add(search_label, BorderLayout.WEST);

        //search field
        JTextField search_field = new JTextField(18);
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
        JLabel searchBy_label = new JLabel("Department:");
        searchBy_label.setFont(new Font("Helvetica", Font.PLAIN, 20));
        searchBy_label.setForeground(Color.WHITE);
        searchBy_label.setBorder(BorderFactory.createEmptyBorder(5,15,5,5));

        north.add(searchBy_label);

        String[] sortBy = {
                "All",
                "Cardiology",
                "Gastroenterology",
                "Gynecology",
                "Nephrology",
                "Neurology",
                "Oncology",
                "Ophthalmology",
                "Orthopaedics",
                "Otolaryngology",
                "Urology"};
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

        //Functions
        createTable();
        gettableData(empty);
    }

    public static void gettableData(String[] text){
        String patientinfo;
        model.setRowCount(0);
        try {
            DatabaseConnection connectNow = new DatabaseConnection();
            Connection connectDB = connectNow.getConnection();
            if (text[1].equals("All")){
                if(text[0].equals(""))
                    patientinfo = "SELECT * FROM accounts WHERE position != 'Admin'";
                else
                    patientinfo = "SELECT * FROM accounts WHERE position != 'Admin' AND Lastname LIKE '" + text[0] + "%'";
            }else {
                if(text[0].equals(""))
                    patientinfo = "SELECT * FROM accounts WHERE position != 'Admin' AND Department = '" + text[1] + "'";
                else
                    patientinfo = "SELECT * FROM accounts WHERE position != 'Admin' AND Department = '" + text[1] + "' " +
                            "AND Lastname LIKE '" + text[0] + "%'";
            }
            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(patientinfo);

            while(queryResult.next()){
                int id = queryResult.getInt("idaccounts");
                String firstname = queryResult.getString("GivenName");
                String middlename = queryResult.getString("Middlename");
                String surname = queryResult.getString("LastName");
                String name = surname + ", " + firstname + " " + middlename;
                String position = queryResult.getString("Position");
                String dept = queryResult.getString("Department");

                model.addRow(new Object[]{id,name,position,dept});
            }


        }catch (Exception e){
            e.getCause();
            e.printStackTrace();
        }

    }

    public void createTable(){

        table = new JTable(new DefaultTableModel());
        table.clearSelection();
        model = (DefaultTableModel) table.getModel();
        model.addColumn("ID");
        model.addColumn("Name");
        model.addColumn("Role");
        model.addColumn("Department");


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
        table.getColumnModel().getColumn(0).setPreferredWidth(20);
        table.getColumnModel().getColumn(1).setPreferredWidth(220);
        DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
        dtcr.setHorizontalAlignment(SwingConstants.CENTER);

        table.getColumn("ID").setCellRenderer(dtcr);
        table.getColumn("Name").setCellRenderer(dtcr);
        table.getColumn("Role").setCellRenderer(dtcr);
        table.getColumn("Department").setCellRenderer(dtcr);


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
            new UserDetails();
        }
    }
    private static DefaultTableModel model;
    public GridBagConstraints c = new GridBagConstraints();
    public JPanel center = new JPanel();
    public JPanel north = new JPanel();
    public JTable table;
    public JComboBox<String> sort_by;
    public JLabel searchPatientTitle;
    public JButton view;
    public String[] empty = {"","All"};
    public static String value,date;
}
