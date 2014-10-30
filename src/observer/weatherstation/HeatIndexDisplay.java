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
public class HeatIndexDisplay extends JFrame 
implements Observer, DisplayElement
{
    private final boolean DEBUG = false;
    private JTextArea txtAreaContent;
    private Container c;
    protected Observable observable;
    float heatIndex = 0.0f;

    public HeatIndexDisplay(Observable observable) {
        initDisplay();
        StartWeatherStation.openWindows++;
        if(DEBUG) System.out.println(StartWeatherStation.openWindows);
        this.observable = observable;
        observable.addObserver(this);
    }

    // Just an initialization routine for the GUI
    private void initDisplay() {
        c = this.getContentPane();
        c.setBackground(Color.YELLOW);
        this.setLayout(new FlowLayout());
        txtAreaContent = new JTextArea(6,20);
        txtAreaContent.append(" ");
        txtAreaContent.setBackground(Color.YELLOW);
        txtAreaContent.setForeground(Color.RED);
        Font f = new Font("SansSerif", Font.PLAIN, 16);
        txtAreaContent.setFont(f);
        c.add(this.txtAreaContent);
        this.setBounds(350, 200, 300, 150);
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
                    float t = weatherData.getTemperature();
                    float rh = weatherData.getHumidity();
                    heatIndex = (float)
                            (
                            (16.923 + (0.185212 * t)) + 
                            (5.37941 * rh) - 
                            (0.100254 * t * rh) + 
                            (0.00941695 * (t * t)) + 
                            (0.00728898 * (rh * rh)) + 
                            (0.000345372 * (t * t * rh)) - 
                            (0.000814971 * (t * rh * rh)) +
                            (0.0000102102 * (t * t * rh * rh)) - 
                            (0.000038646 * (t * t * t)) + 
                            (0.0000291583 * (rh * rh * rh)) +
                            (0.00000142721 * (t * t * t * rh)) + 
                            (0.000000197483 * (t * rh * rh * rh)) - 
                            (0.0000000218429 * (t * t * t * rh * rh)) +
                            (0.000000000843296 * (t * t * rh * rh * rh)) -
                            (0.0000000000481975 * (t * t * t * rh * rh * rh)));
                    display();
            }
    }

    // A generic display method dicated by an interface so that all observers
    // have a display behavior
    public void display() {
        String msg = "\nHeat index is: " + heatIndex;
        txtAreaContent.selectAll();
        txtAreaContent.replaceSelection(msg);
        repaint();
    }
}
