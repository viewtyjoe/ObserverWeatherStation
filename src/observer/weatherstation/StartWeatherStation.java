package observer.weatherstation;

import java.util.Timer;
import java.util.TimerTask;

/**
 * This is the pretend weather station described in "Head First Desing Patterns"
 * Chapter 2 -- the Observer Pattern. The Subject (also called the 'Observable'
 * or 'Publisher') is the WeatherData class. This class just updates the data
 * in the WeatherData object to simulate a real weather station.
 */
public class StartWeatherStation extends TimerTask {
    protected static int openWindows;
    protected static WeatherData weatherData;
    protected int temp = 80;
    protected int humidity = 65;
    protected float pressure = 30.4f;
    protected int updateCount;
    // If you have trouble with the display not showing any data, try
    // changing the START_DELAY to another value, say 800. Then do a
    // clean and build. Usually this gets things right.
    private static final int START_DELAY = 1000; // 500 ms = 1/2 second
    private static final int UPDATE_DELAY = 1000 * 3; // 3000 ms = 3 sec.
    
    public static void main(String[] args) {
        StartWeatherStation ws = new StartWeatherStation();
        
        // The Observable (publisher, subject)
        weatherData = new WeatherData();
        
        // The Observers (subscribers) -- each are passed the observable so
        // that they can subscribe to the WeatherData service
        CurrentConditionsDisplay currentConditions = new CurrentConditionsDisplay(weatherData);
        StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);
        ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);
        
        // Notice how flexible this system is ... we can add another observer
        // at anytime with little code change. Go ahead, uncomment the next line:
        HeatIndexDisplay heatIndexDisplay = new HeatIndexDisplay(weatherData);

    // Use a Java Timer service to update the weather station
    // every 5 seconds, starting in 0.5 seconds
    // NOTE: this calls the run() method below
    Timer timer = new Timer();
    timer.schedule(ws, START_DELAY, UPDATE_DELAY);
  }
    
  /**
   * Implements TimerTask's abstract run method.
   */
  public void run(){
      // Just increment or decrement the settings for
      // demo purposes
      weatherData.setMeasurements(temp++, humidity++, pressure--);
      updateCount++;
      // Stop the program after 10 updates
      if(updateCount > 20) System.exit(0);
  }        
  
}
