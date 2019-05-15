package npgeek.model;

public class Weather {

	private String parkcode;
	private int fivedayforecastvalue;
	private int low;
	private int high;
	private double lowCelsius;
	private double highCelsius;
	private String forecast;
	private String recommendation;


	public String getParkcode() {
		return parkcode;
	}
	public void setParkcode(String parkcode) {
		this.parkcode = parkcode;
	}
	public int getFivedayforecastvalue() {
		return fivedayforecastvalue;
	}
	public void setFivedayforecastvalue(int fivedayforecastvalue) {
		this.fivedayforecastvalue = fivedayforecastvalue;
	}
	public int getLow() {
		return low;
	}
	public void setLow(int low) {
		this.low = low;
	}
	public int getHigh() {
		return high;
	}
	public void setHigh(int high) {
		this.high = high;
	}
	public String getForecast() {
		return forecast;
	}
	public void setForecast(String forecast) {
		this.forecast = forecast;
	}

	public double tempConverter(int temp) {
		return ((temp - 32) / 1.8);
	}
	public double getLowCelsius() {
		return lowCelsius;
	}
	public void setLowCelsius(double lowCelsius) {
		this.lowCelsius = tempConverter(low);
	}
	public double getHighCelsius() {
		return highCelsius;
	}
	public void setHighCelsius(double highCelsius) {
		this.highCelsius = tempConverter(high);
	}

	public void setRecommendation(String forecast, int low, int high) {

		this.recommendation = "";

		switch(forecast) {


		case "snow": 
			recommendation = recommendation + "Pack snowshoes ";
			break;

		case "rain": 
			recommendation = recommendation + "Pack rain gear and wear waterproof shoes ";
			break;

		case "thunderstorms": 
			recommendation = recommendation + "Seek shelter and avoid hiking on exposed ridges ";
			break;

		case "sunny": 
			recommendation = recommendation + "Pack sunblock ";
			break;

		}



		if (low < 20) {
			recommendation = recommendation + "Beware of cold exposure ";
		}

		if (high > 75) {
			recommendation = recommendation + "Bring an extra gallon of water ";
		}

		if ((high - low ) > 20 ) {
			recommendation = recommendation + "Wear breathable layers ";
		}

	

	}
	public String getRecommendation() {
		return recommendation;
	}


}





