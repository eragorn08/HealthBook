package GUI;

import javax.swing.*;

import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;


public class SearchForm extends JPanel {
    public SearchForm(){
        setBackground(new Color(0x212C58));
        setLayout(null);
        searchformtitle();
        searchform();

    }
    public void searchformtitle(){
        JLabel searchPatientTitle = new JLabel("Search Patient");
        searchPatientTitle.setLayout(null);
        searchPatientTitle.setFont(new Font("Helvetica", Font.PLAIN, 40));
        searchPatientTitle.setForeground(Color.white);
        searchPatientTitle.setBounds(22, 19, 275, 55);
        add(searchPatientTitle);
    }

    public void searchform(){
        JPanel form = new JPanel(new BorderLayout());
        form.setBackground(new Color(0x212C58));
        form.setBounds(0,76,994,578);
        JPanel north = new JPanel(new FlowLayout(FlowLayout.LEFT));
        north.setBackground(new Color(0x212C58));
        form.setBorder(new EmptyBorder(8,22,0,22));
        north.setVisible(true);



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

        //searchBy label
        JLabel searchBy_label = new JLabel("Search By:");
        searchBy_label.setFont(new Font("Helvetica", Font.PLAIN, 20));
        searchBy_label.setForeground(Color.WHITE);
        searchBy_label.setBorder(BorderFactory.createEmptyBorder(5,15,5,5));

        //searchBy_label.setBounds(705, 12, 109, 33);
        north.add(searchBy_label);

        String[] sortBy = {"Name", "Date"};
        JComboBox<String> sort_by = new JComboBox<>(sortBy);
        //sort_by.setBounds(826,8,99,40);
        sort_by.setFont(new Font("Helvetica", Font.PLAIN, 20));
        sort_by.setBackground(new Color(0x212C58));
        sort_by.setForeground(Color.white);
        north.add(sort_by, BorderLayout.EAST);

        JPanel center = new JPanel();
        center.setBorder(new EmptyBorder(24,0,24,0));
        center.setLayout(new GridLayout(1,1));
        center.setBackground(new Color(0x212C58));
        center.setVisible(true);
        //center.setBorder(new EmptyBorder(8,22,0,22));
        form.add(north, BorderLayout.NORTH);
        form.add(center, BorderLayout.CENTER);


        String[] columnNames = {"Patient No.", "Name", "Date of Recent Checkup"};
        Object[][] data = {
                {1, "Cruz, Danica", "January 11, 2021"},
                {2, "De Villa, Jerevon Cruz", "January 21, 2021"},
                {3, "Diaz, Florante", "January 26, 2021"},
                {4, "Ferrer, Iseah Nicole", "February 19, 2021"},
                {5, "Gomez, John Lloyd", "March 05, 2021"},
                {6, "Hernandez, Nathaniel Aldrin", "March 20, 2021"},
                {7, "Javier, Carl Andrei", "April 19, 2021"},
                {8, "Lim, Mary Elizabeth", "April 30, 2021"},
                {9, "Marquez. Athena Sophie", "May 13, 2021 "},
                {10, "Nacianceno, Mae Rose", "June 20, 2021"},
                {1, "Cruz, Danica", "January 11, 2021"},
                {2, "De Villa, Jerevon Cruz", "January 21, 2021"},
                {3, "Diaz, Florante", "January 26, 2021"},
                {4, "Ferrer, Iseah Nicole", "February 19, 2021"},
                {5, "Gomez, John Lloyd", "March 05, 2021"},
                {6, "Hernandez, Nathaniel Aldrin", "March 20, 2021"},
                {7, "Javier, Carl Andrei", "April 19, 2021"},
                {8, "Lim, Mary Elizabeth", "April 30, 2021"},
                {9, "Marquez. Athena Sophie", "May 13, 2021 "},
                {10, "Nacianceno, Mae Rose", "June 20, 2021"},
        };
        DefaultTableModel model = new DefaultTableModel(data, columnNames);

        JTable table = new JTable(model);
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
        table.getColumn("Date of Recent Checkup").setCellRenderer(dtcr);






        center.add(pane);



        form.setVisible(true);
        add(form);

    }

}
