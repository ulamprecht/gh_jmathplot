package jmathplot;

import static java.lang.Math.PI;
import static java.lang.Math.cos;
import static java.lang.Math.sin;
import static org.math.array.DoubleArray.increment;

import javax.swing.JFrame;

import org.math.plot.Plot3DPanel;

public class GridPlotsExample2 {
    public static void main(String[] args) {

        // define your data
        double[] x = increment(1.0, 0.25, 5.0); // x = 0.0:0.1:1.0
        double[] y = increment(0.1, 0.25, 5.0);// y = 0.0:0.05:1.0

        double[][] z4 = f4(x, y);
        double[][] z5 = f5(x, y);

        // create your PlotPanel (you can use it as a JPanel) with a legend at
        // SOUTH
        Plot3DPanel plot = new Plot3DPanel("SOUTH");

        // add grid plot to the PlotPanel
        // plot.addGridPlot("z=cos(PI*x)*sin(PI*y)", x, y, z1);
        // plot.addGridPlot("z=sin(PI*x)*cos(PI*y)", x, y, z2);
        // plot.addGridPlot("z=(x/(1-x))*y", x, y, z3);
        plot.addGridPlot("z = x/(x+y)", x, y, z4);
        plot.addGridPlot("z = x/(x+0.5y)", x, y, z5);

        // put the PlotPanel in a JFrame like a JPanel
        JFrame frame = new JFrame("a plot panel");
        frame.setSize(600, 600);
        frame.setContentPane(plot);
        frame.setVisible(true);

    }

    // P=PF/(PF+a * Rwl))
    public static double f4(double x, double y) {
        // Plot(x/(1-x)*1, Color = Purple);

        double z = x / (x + y);
        return z;
    }

    // grid version of the function
    public static double[][] f4(double[] x, double[] y) {
        double[][] z = new double[y.length][x.length];
        for (int i = 0; i < x.length; i++)
            for (int j = 0; j < y.length; j++)
                z[j][i] = f4(x[i], y[j]);
        return z;
    }

    public static double f5(double x, double y) {
        // Plot(x/(1-x)*1, Color = Purple);

        double z = x / (x + 0.5 * y);
        return z;
    }

    // grid version of the function
    public static double[][] f5(double[] x, double[] y) {
        double[][] z = new double[y.length][x.length];
        for (int i = 0; i < x.length; i++)
            for (int j = 0; j < y.length; j++)
                z[j][i] = f5(x[i], y[j]);
        return z;
    }

}