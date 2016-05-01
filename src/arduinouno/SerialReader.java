package arduinouno;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import java.io.IOException;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SerialReader implements SerialPortEventListener {

    public String valueReadA0 = "0";
    public String valueReadA1 = "0";
    public String valueReadA2 = "0";
    public String valueReadA3 = "0";
    public String valueReadA4 = "0";
    public String valueReadA5 = "0";

    public String getValueReadA0() {
        return valueReadA0;
    }

    public String getValueReadA1() {
        return valueReadA1;
    }

    public String getValueReadA2() {
        return valueReadA2;
    }

    public String getValueReadA3() {
        return valueReadA3;
    }

    public String getValueReadA4() {
        return valueReadA4;
    }

    public String getValueReadA5() {
        return valueReadA5;
    }

    SerialPort serialPort;
    /**
     * The port we're normally going to use.
     */
    private static final String PORT_NAMES[] = {
        "/dev/tty.usbserial-A9007UX1", // Mac OS X
        "/dev/ttyACM0", // Raspberry Pi
        "/dev/ttyUSB0", // Linux
        "COM3", // Windows
    };
    /**
     * A BufferedReader which will be fed by a InputStreamReader converting the
     * bytes into characters making the displayed results codepage independent
     */
    private BufferedReader input;
    /**
     * The output stream to the port
     */
    private OutputStream output;
    /**
     * Milliseconds to block while waiting for port open
     */
    private static final int TIME_OUT = 2000;
    /**
     * Default bits per second for COM port.
     */
    private static final int DATA_RATE = 9600;

    public void initialize() {
        // the next line is for Raspberry Pi and 
        // gets us into the while loop and was suggested here was suggested http://www.raspberrypi.org/phpBB3/viewtopic.php?f=81&t=32186
        // System.setProperty("gnu.io.rxtx.SerialPorts", "/dev/ttyACM0");

        CommPortIdentifier portId = null;
        Enumeration portEnum = CommPortIdentifier.getPortIdentifiers();

        //First, Find an instance of serial port as set in PORT_NAMES.
        while (portEnum.hasMoreElements()) {
            CommPortIdentifier currPortId = (CommPortIdentifier) portEnum.nextElement();
            for (String portName : PORT_NAMES) {
                if (currPortId.getName().equals(portName)) {
                    portId = currPortId;
                    break;
                }
            }
        }
        if (portId == null) {
            System.out.println("Could not find COM port.");
            return;
        }

        try {
            // open serial port, and use class name for the appName.
            serialPort = (SerialPort) portId.open(this.getClass().getName(),
                    TIME_OUT);

            // set port parameters
            serialPort.setSerialPortParams(DATA_RATE,
                    SerialPort.DATABITS_8,
                    SerialPort.STOPBITS_1,
                    SerialPort.PARITY_NONE);

            // open the streams
            input = new BufferedReader(new InputStreamReader(serialPort.getInputStream()));
            output = serialPort.getOutputStream();

            // add event listeners
            serialPort.addEventListener(this);
            serialPort.notifyOnDataAvailable(true);
        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }

    /**
     * This should be called when you stop using the port. This will prevent
     * port locking on platforms like Linux.
     */
    public synchronized void close() {
        if (serialPort != null) {
            serialPort.removeEventListener();
            serialPort.close();
        }
    }

    /**
     * Handle an event on the serial port. Read the data and print it.
     *
     * @param oEvent
     */
    @Override
    public synchronized void serialEvent(SerialPortEvent oEvent) {
        if (oEvent.getEventType() == SerialPortEvent.DATA_AVAILABLE) {

            try {
                String inputLine = input.readLine();
                switch (inputLine) {
                    case "A0":
                        this.valueReadA0 = input.readLine();
                        break;
                    case "A1":
                        this.valueReadA1 = input.readLine();
                        break;
                    case "A2":
                        this.valueReadA2 = input.readLine();
                        break;
                    case "A3":
                        this.valueReadA3 = input.readLine();
                        break;
                    case "A4":
                        this.valueReadA4 = input.readLine();
                        break;
                    case "A5":
                        this.valueReadA5 = input.readLine();
                        break;
                    default:
                        break;
                }
            } catch (IOException ex) {
                Logger.getLogger(SerialReader.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        // Ignore all the other eventTypes, but you should consider the other ones.
    }

    public static void main(String[] args) throws Exception {

    }
}
