package GUI;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

import javax.swing.*;
import java.awt.*;

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



    @SuppressWarnings("removal")
    private static PieDataset createDataSet(){
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue( "Cardiology", new Double(10));
        dataset.setValue( "Gastroenterology", new Double(10));
        dataset.setValue( "Gynecology", new Double(10));
        dataset.setValue( "Nephrology", new Double(10));
        dataset.setValue( "Neurology", new Double(10));
        dataset.setValue( "Oncology", new Double(10));
        dataset.setValue( "Ophthalmology", new Double(10));
        dataset.setValue( "Orthopaedics", new Double(10));
        dataset.setValue( "Otolaryngology", new Double(10));
        dataset.setValue( "Urology", new Double(10));
        return dataset;
    }

}
