package npgeek.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import npgeek.model.Park;
import npgeek.model.ParkDAO;
import npgeek.model.Weather;
import npgeek.model.WeatherDAO;

@Controller
public class HomeController {

	@Autowired
	private ParkDAO parkDAO;
	@Autowired
	private WeatherDAO weatherDAO;

	@RequestMapping("/")
	public String displayHomePage(ModelMap modelMap) {

		modelMap.put("parkList", parkDAO.getAllParks());

		return "parkList";
	}

	@RequestMapping(path="/park", method=RequestMethod.GET)
	public String itemDetail(ModelMap modelMap, @RequestParam String parkcode, HttpSession session) {

		if (session.getAttribute("temp") !=null) {
			session.getAttribute("temp");
		}

		Park detail = parkDAO.getParkByCode(parkcode);
		List<Weather> weather = weatherDAO.getAllWeathersByCode(parkcode);
		modelMap.put("park", detail);
		modelMap.put("weather", weather);

		return "parkDetail";
	}

	@RequestMapping(path="/park", method=RequestMethod.POST)
	public String handleTempPost(ModelMap modelMap, @RequestParam String parkcode, @RequestParam String temp, HttpSession session) {

		session.setAttribute("temp", temp);
		session.setAttribute("parkcode", parkcode);
		Park detail = parkDAO.getParkByCode(parkcode);
		List<Weather> weather = weatherDAO.getAllWeathersByCode(parkcode);
		modelMap.put("park", detail);
		modelMap.put("weather", weather);

		return "parkDetail";
	}
}
