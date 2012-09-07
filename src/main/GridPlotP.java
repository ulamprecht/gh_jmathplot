

import static org.math.array.DoubleArray.increment;

import javax.swing.JFrame;

import org.math.plot.Plot3DPanel;

/**
 * 3d chart of formula P = PF/(PF+RWL)
 *
 * @author uwe.lamprecht
 */
public final class GridPlotP {
    public static void main(String[] args) {

        // define your data

        // range for pf
        double[] x = increment(1.0, 0.25, 5.0);

        // range for rwl
        double[] y = increment(0.0, 0.25, 5.0);

        double[][] dataSet = calc(x, y);
        double[][] dataSetWithAlpha = calcUseAlpha(x, y);

        // create your PlotPanel (you can use it as a JPanel) with a legend at
        // SOUTH
        Plot3DPanel plot = new Plot3DPanel("SOUTH");

        // add grid plot to the PlotPanel
        plot.addGridPlot("P = PF/(PF+RWL)", x, y, dataSet);
        plot.addGridPlot("P = PF/(PF+alpha*RWL), alpha=0.5", x, y, dataSetWithAlpha);
        plot.setAxisLabel(0, "PF");
        plot.setAxisLabel(1, "RWL");
        plot.setAxisLabel(2, "P");

        // put the PlotPanel in a JFrame like a JPanel
        JFrame frame = new JFrame("P,PF,RWL chart");
        frame.setSize(600, 600);
        frame.setContentPane(plot);
        frame.setVisible(true);

    }

    private static double calc(double x, double y) {
        double z = x / (x + y);
        return z;
    }

    // grid version of the function
    private static double[][] calc(double[] x, double[] y) {
        double[][] z = new double[y.length][x.length];
        for (int i = 0; i < x.length; i++)
            for (int j = 0; j < y.length; j++)
                z[j][i] = calc(x[i], y[j]);
        return z;
    }

    private static double calcUseAlpha(double x, double y) {
        double z = x / (x + 0.5 * y);
        return z;
    }

    // grid version of the function
    private static double[][] calcUseAlpha(double[] x, double[] y) {
        double[][] z = new double[y.length][x.length];
        for (int i = 0; i < x.length; i++)
            for (int j = 0; j < y.length; j++)
                z[j][i] = calcUseAlpha(x[i], y[j]);
        return z;
    }
}