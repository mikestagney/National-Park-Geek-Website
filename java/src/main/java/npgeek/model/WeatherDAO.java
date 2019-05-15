package npgeek.model;

import java.util.List;

public interface WeatherDAO {

	Weather getWeatherByCode(String parkcode);
	List<Weather> getAllWeathersByCode(String parkcode);

}
