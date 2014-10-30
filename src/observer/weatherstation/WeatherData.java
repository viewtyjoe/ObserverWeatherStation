package observer.weatherstation;
	
import java.util.Observable;
import java.util.Observer;
	
/**
 * This class is the Observable (the subject or publisher). It has the information
 * that the Observers (the subscribers) want. It provides this information by
 * 'notifying' the observers whenever its internal state has changed. See the
 * 'measurementsChanged()' method for an example.
 */
public class WeatherData extends Observable {
	private float temperature;
	private float humidity;
	private float pressure;
	
	public WeatherData() { }
	
	public void measurementsChanged() {
		setChanged();
		notifyObservers();
	}
	
	public void setMeasurements(float temperature, float humidity, float pressure) {
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;
		measurementsChanged();
	}
	
	public float getTemperature() {
		return temperature;
	}
	
	public float getHumidity() {
		return humidity;
	}
	
	public float getPressure() {
		return pressure;
	}
}
