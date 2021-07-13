package GUI;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class PieChartForm extends JFrame{
    private JButton drawPieChartButton;
    private JPanel graphPanel;
    private JPanel rootPanel;

    public PieChartForm(){
        this.setContentPane(rootPanel);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setSize(1000,700);
        this.setTitle("View Records by Department");
        this.setVisible(true);

        JFreeChart pieChart = ChartFactory.createPieChart("Number of Patients per Department", createDataSet());
        ChartPanel chartPanel = new ChartPanel(pieChart);
        graphPanel.removeAll();
        graphPanel.add(chartPanel, BorderLayout.CENTER);
        graphPanel.revalidate();
    }

    public int getValue(int j){

        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connect = connectNow.getConnection();

        String Cardio = "SELECT COUNT(*) FROM patientinfo WHERE department = '"+deptset[j]+"'";
        try {
            Statement st = connect.createStatement();
            ResultSet rs = st.executeQuery(Cardio);
            if(rs.next()) {
                count = rs.getInt("COUNT(*)");
                System.out.println(count);
            }
        }
        catch(Exception e){
            e.getCause();
            e.printStackTrace();
        }
        return count;
    }


    @SuppressWarnings("removal")
    private PieDataset createDataSet(){
        DefaultPieDataset dataset = new DefaultPieDataset();
        for(i=0;i>10;i++){
            dataset.setValue(deptset[i], new Double(getValue(i)));
        }
        return dataset;
    }
    public int i;
    public int count;
    public String[] deptset = {
            "Cardiology",
            "Gastroenterology",
            "Gynecology",
            "Nephrology",
            "Neurology",
            "Oncology",
            "Ophthalmology",
            "Orthopaedics",
            "Otolaryngology",
            "Urology"
    };

}
