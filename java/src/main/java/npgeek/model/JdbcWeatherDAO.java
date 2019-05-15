package npgeek.model;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Component
public class JdbcWeatherDAO implements WeatherDAO{
	
	
private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JdbcWeatherDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	
	@Override
	public Weather getWeatherByCode(String parkcode) {
		Weather weather = null;
		String sqlSelectWeatherByCode = "SELECT * FROM weather WHERE parkcode = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectWeatherByCode, parkcode);
		if(results.next()) {
			weather = mapRowToWeather(results);
		}
		return weather;
	}
	
	@Override
	public List<Weather> getAllWeathersByCode(String parkcode) {
		List<Weather> allWeathers = new ArrayList<>();
		String sqlSelectAllWeathers = "SELECT * FROM weather WHERE parkcode = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectAllWeathers, parkcode);
		while(results.next()) {
			allWeathers.add(mapRowToWeather(results));
		}
		return allWeathers;
	}
	

	private Weather mapRowToWeather(SqlRowSet row) {
		Weather weather = new Weather();
		weather.setParkcode(row.getString("parkcode"));
		weather.setFivedayforecastvalue(row.getInt("fivedayforecastvalue"));
		weather.setLow(row.getInt("low"));
		weather.setHigh(row.getInt("high"));
		weather.setLowCelsius(row.getInt("low"));
		weather.setHighCelsius(row.getInt("high"));
		weather.setForecast(row.getString("forecast"));
		weather.setRecommendation(row.getString("forecast"), row.getInt("low"), row.getInt("high"));
		

		return weather;
	}


}
