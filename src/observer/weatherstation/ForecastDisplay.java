package observer.weatherstation;

import java.util.Observable;
import java.util.Observer;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * This class is an observer (subscriber) to the Observable (publisher or 
 * subject) WeatherData. Notice it requests a 'subscription' in the 
 * constructor by calling the observable.addObserver() method.
 */
public class ForecastDisplay extends JFrame 
implements Observer, DisplayElement
{
    private final boolean DEBUG = false;
    private JTextArea txtAreaContent;
    private Container c;
    protected Observable observable;
    private float currentPressure = 28.92f;  
    private float lastPressure;

    public ForecastDisplay(Observable observable) {
        initDisplay();
        StartWeatherStation.openWindows++;
        if(DEBUG) System.out.println(StartWeatherStation.openWindows);
        this.observable = observable;
        observable.addObserver(this);
    }

    // Just an initialization routine for the GUI
    private void initDisplay() {
        c = this.getContentPane();
        c.setBackground(Color.BLUE);
        this.setLayout(new FlowLayout());
        txtAreaContent = new JTextArea(6,20);
        txtAreaContent.append(" ");
        txtAreaContent.setBackground(Color.BLUE);
        txtAreaContent.setForeground(Color.WHITE);
        Font f = new Font("SansSerif", Font.PLAIN, 16);
        txtAreaContent.setFont(f);
        c.add(this.txtAreaContent);
        this.setBounds(350, 50, 300, 150);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        // A special event handler for when the window is closed
        this.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent e) {
                if (StartWeatherStation.openWindows == 1) {
                    System.exit(0);  // Terminate when the last window is closed.
                }
                StartWeatherStation.openWindows--;
            }
        });
        this.setVisible(true);
    }

    // Called by the Observable when it needs to notify its observers (this
    // is one of them!)
    public void update(Observable observable, Object arg) {
            if (observable instanceof WeatherData) {
                    WeatherData weatherData = (WeatherData)observable;
                    lastPressure = currentPressure;
                    currentPressure = weatherData.getPressure();
                    display();
            }
    }

    // A generic display method dicated by an interface so that all observers
    // have a display behavior
    public void display() {
        String msg = "Forecast: \n";
            if (currentPressure > lastPressure) {
                   msg += "\nImproving weather on the way!";
            } else if (currentPressure > 26) {
                    msg += "\nMore of the same";
            } else {
                    msg += "\nWatch out for cooler, rainy weather";
            }
        txtAreaContent.selectAll();
        txtAreaContent.replaceSelection(msg);
        repaint();
            
    }
}
