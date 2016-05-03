/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arduinouno;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Date;

import javax.swing.Timer;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.StandardXYItemRenderer;
import org.jfree.data.time.Millisecond;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;

/**
 *
 * @author zerg
 */
public class TimeChartGenerator extends ApplicationFrame implements ActionListener {

    private double value0 = 0;
    private double value1 = 0;
    private double value2 = 0;
    private double value3 = 0;
    private double value4 = 0;
    private double value5 = 0;

    private ArduinoUno mainClass;

    /**
     * The time series data.
     */
    private final TimeSeries series;
    private TimeSeries series0;
    private TimeSeries series1;
    private TimeSeries series2;
    private TimeSeries series3;
    private TimeSeries series4;
    private TimeSeries series5;
    private Boolean[] analogInputs;
    private XYPlot plot;

    final public ChartPanel chartPanel;

    /**
     * Timer to refresh graph after every 1/4th of a second
     */
    private final Timer timer = new Timer(50, this);
    private final SerialReader serialLink;

    /**
     * Constructs a new dynamic chart application.
     *
     * @param title the frame title.
     * @param theSerialLink
     * @param analogInputs
     */
    public TimeChartGenerator(final String title, final SerialReader theSerialLink, Boolean[] analogInputs) {

        super(title);
        this.analogInputs = analogInputs;
        TimeSeriesCollection dataset = null, dataset0 = null, dataset1 = null, dataset2 = null, dataset3 = null, dataset4 = null, dataset5 = null;
        this.series = new TimeSeries("offset", Millisecond.class);

        //Serie de datos para el offset hacia la izquierda - (Magia)
        dataset = new TimeSeriesCollection(this.series);

        if (analogInputs[0]) {
            this.series0 = new TimeSeries("Read A0", Millisecond.class);
            //Serie de datos A0
            dataset0 = new TimeSeriesCollection(this.series0);
        }
        if (analogInputs[1]) {
            this.series1 = new TimeSeries("Read A1", Millisecond.class);
            //Serie de datos A1
            dataset1 = new TimeSeriesCollection(this.series1);
        }
        if (analogInputs[2]) {
            this.series2 = new TimeSeries("Read A2", Millisecond.class);
            //Serie de datos A2
            dataset2 = new TimeSeriesCollection(this.series2);
        }
        if (analogInputs[3]) {
            this.series3 = new TimeSeries("Read A3", Millisecond.class);
            //Serie de datos A3
            dataset3 = new TimeSeriesCollection(this.series3);
        }
        if (analogInputs[4]) {
            this.series4 = new TimeSeries("Read A4", Millisecond.class);
            //Serie de datos A4
            dataset4 = new TimeSeriesCollection(this.series4);
        }
        if (analogInputs[5]) {
            this.series5 = new TimeSeries("Read A5", Millisecond.class);
            //Serie de datos A5
            dataset5 = new TimeSeriesCollection(this.series5);
        }

        final JFreeChart chart = createChart(dataset, dataset0, dataset1, dataset2, dataset3, dataset4, dataset5);
        timer.setInitialDelay(1000);
        //Sets background color of chart
        chart.setBackgroundPaint(Color.LIGHT_GRAY);
        //Create Chartpanel for chart area
        chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(800, 500));
        timer.start();
        this.serialLink = theSerialLink;

    }

    public ChartPanel getChartpanel() {
        return this.chartPanel;
    }

    /**
     * Creates a sample chart.
     *
     * @param dataset the dataset.
     *
     * @return A sample chart.
     */
    private JFreeChart createChart(final XYDataset dataset, final XYDataset dataset0, final XYDataset dataset1, final XYDataset dataset2, final XYDataset dataset3, final XYDataset dataset4, final XYDataset dataset5) {
        final JFreeChart result = ChartFactory.createTimeSeriesChart(
                "Arduino Serial Reader",
                "Time",
                "Value",
                dataset,
                true,
                true,
                false
        );

        plot = result.getXYPlot();

        //Set Graph Parameters
        plot.setBackgroundPaint(new Color(0xffffe0));
        plot.setDomainGridlinesVisible(true);
        plot.setDomainGridlinePaint(Color.lightGray);
        plot.setRangeGridlinesVisible(true);
        plot.setRangeGridlinePaint(Color.lightGray);

        ValueAxis xaxis = plot.getDomainAxis();
        xaxis.setAutoRange(true);
        xaxis.setTickLabelsVisible(false);

        //Domain axis would show data of 30 seconds for a time
        xaxis.setFixedAutoRange(30000.0);  // 30 seconds

        xaxis.setVerticalTickLabels(false);

        ValueAxis yaxis = plot.getRangeAxis();
        yaxis.setRange(0.0, 6.0);

        if (dataset0 != null) {
            plot.setDataset(1, dataset0);
            plot.setRenderer(1, new StandardXYItemRenderer());
        }
        if (dataset1 != null) {
            plot.setDataset(2, dataset1);
            plot.setRenderer(2, new StandardXYItemRenderer());
        }
        if (dataset2 != null) {
            plot.setDataset(3, dataset2);
            plot.setRenderer(3, new StandardXYItemRenderer());
        }
        if (dataset3 != null) {
            plot.setDataset(4, dataset3);
            plot.setRenderer(4, new StandardXYItemRenderer());
        }
        if (dataset4 != null) {
            plot.setDataset(5, dataset4);
            plot.setRenderer(5, new StandardXYItemRenderer());
        }
        if (dataset5 != null) {
            plot.setDataset(6, dataset5);
            plot.setRenderer(6, new StandardXYItemRenderer());
        }

        return result;
    }

    /**
     *
     * @param e the action event.
     */
    @Override
    public void actionPerformed(final ActionEvent e) {

        Date date = new Date();
        int offsetGraphTime = 15; //offset in seconds
        Millisecond graphTime = new Millisecond(new Date(date.getTime() - offsetGraphTime * 1000));
        Millisecond now = new Millisecond(date);

        this.series.add(now, null);

        if (series0 != null) {
            this.value0 = Double.parseDouble(serialLink.getValueReadA0()) * 5 / 1023;
            series0.add(graphTime, value0);
            ArduinoUno.theMainWindow.updateA0Reading(value0);
        }
        if (series1 != null) {
            this.value1 = Double.parseDouble(serialLink.getValueReadA1()) * 5 / 1023;
            series1.add(graphTime, value1);
            ArduinoUno.theMainWindow.updateA1Reading(value1);
        }
        if (series2 != null) {
            this.value2 = Double.parseDouble(serialLink.getValueReadA2()) * 5 / 1023;
            series2.add(graphTime, value2);
            ArduinoUno.theMainWindow.updateA2Reading(value2);
        }
        if (series3 != null) {
            this.value3 = Double.parseDouble(serialLink.getValueReadA3()) * 5 / 1023;
            series3.add(graphTime, value3);
            ArduinoUno.theMainWindow.updateA3Reading(value3);
        }
        if (series4 != null) {
            this.value4 = Double.parseDouble(serialLink.getValueReadA4()) * 5 / 1023;
            series4.add(graphTime, value4);
            ArduinoUno.theMainWindow.updateA4Reading(value4);
        }
        if (series5 != null) {
            this.value5 = Double.parseDouble(serialLink.getValueReadA5()) * 5 / 1023;
            series5.add(graphTime, value5);
            ArduinoUno.theMainWindow.updateA5Reading(value5);
        }

    }

    public void triggerA0(Boolean state) {

    }

    public Double[][] getPlotInfo() {
        
        //Get the length to plot from dummy signal "offset"
        XYDataset theDataset;
        theDataset = plot.getDataset(0);
        
        int dataLenght = theDataset.getItemCount(0);
        int datasets = plot.getDatasetCount();

        Double[][] dataVector = new Double[dataLenght][datasets - 1];

        for (int j = 1; j < datasets; j++) {
            theDataset = plot.getDataset(j);
            int i = 0;
            while (i < dataLenght) {
                Double value = theDataset.getYValue(0, i);
                dataVector[i][j-1] = value;
                i++;
            }
        }

        return dataVector;
    }
}
