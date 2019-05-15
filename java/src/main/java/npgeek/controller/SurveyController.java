package npgeek.controller;



import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import npgeek.model.ParkDAO;
import npgeek.model.Survey;
import npgeek.model.SurveyDAO;

@Controller
@RequestMapping("/survey")
public class SurveyController {
	@Autowired
	private SurveyDAO surveyDAO;
	@Autowired
	private ParkDAO parkDAO;

	@RequestMapping("/list")
	public String surveyMain(ModelMap modelMap) {
		modelMap.put("allPosts", surveyDAO.getAllSurveyPosts());
		modelMap.put("allSurveyPosts", surveyDAO.getAllParkSurveyPosts());

		return "surveyMain";
	}

	@RequestMapping(value = "/post/add", method = RequestMethod.GET)
	public String surveyNewMessageGet(ModelMap modelMap) {
		modelMap.put("parkList", parkDAO.getAllParks());
		
		if (modelMap.containsAttribute("survey") == false)  {
			Survey survey = new Survey();
		modelMap.put("survey", survey);	
	}
		return "surveyPost";
	
	}
		

	@RequestMapping(value = "/post/add", method = RequestMethod.POST)
	public String surveyNewMessagePost(@Valid @ModelAttribute Survey survey, BindingResult result, RedirectAttributes flash) {


		flash.addFlashAttribute("survey", survey);


		if (result.hasErrors()) {

			flash.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "survey", result);
			return "redirect:/survey/post/add";
		}
		surveyDAO.save(survey);
		return "redirect:/survey/list";
	}

}


