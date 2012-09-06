package jmathplot;

import javax.swing.JFrame;

import org.math.plot.Plot3DPanel;

public class Example1 {
    public static void main(String[] args) {

        // Data definition
        int n = 10;
        double[][] datas1 = new double[n][3];
        double[][] datas2 = new double[n][3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                datas1[i][j] = Math.random();
                datas2[i][j] = Math.random();
            }
        }

        // PlotPanel construction
        Plot3DPanel plot = new Plot3DPanel();
        plot.addLegend("SOUTH");

        // Data plots addition
        plot.addScatterPlot("datas1", datas1);
        plot.addBarPlot("datas2", datas2);

        // put the PlotPanel in a JFrame like a JPanel
        JFrame frame = new JFrame("a plot panel");
        frame.setSize(600, 600);
        frame.setContentPane(plot);
        frame.setVisible(true);

    }

}