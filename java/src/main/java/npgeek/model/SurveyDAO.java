package npgeek.model;

import java.util.List;


public interface SurveyDAO {
	public List<String> getAllSurveyPosts();
	public void save(Survey post);
	List<Survey> getAllParkSurveyPosts();

}
