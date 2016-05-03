/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arduinouno;

/**
 *
 * @author zerg
 */
public class ArduinoUno {

    public static MainWindow theMainWindow;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //Analog inputs A0,A1,A2,A3,A4,A5
        Boolean[] analogInputs = {true, true, false, false, false, false};

        SerialReader serialLink = new SerialReader();
        serialLink.initialize();

        theMainWindow = new MainWindow();

        final TimeChartGenerator theTimeChart = new TimeChartGenerator("Dynamic Line And TimeSeries Chart", serialLink, analogInputs);

        theMainWindow.setTheTimeChart(theTimeChart);
        theMainWindow.setChartPanel(theTimeChart.getChartpanel());
        theMainWindow.setVisible(true);

    }

    public void triggerInput(String anInput, boolean state) {
        switch (anInput) {
            case "0":
                break;
            case "1":
                break;
            case "2":
                break;
            case "3":
                break;
            case "4":
                break;
            case "5":
                break;
        }
    }

}
