package npgeek.model;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;



@Component
public class JdbcSurveyDAO implements SurveyDAO{
	
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public JdbcSurveyDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<String> getAllSurveyPosts() {
		List<String> allSurveys = new ArrayList<>();
		String sqlSelectAllSurveys = "SELECT survey_result.parkcode, COUNT(survey_result.parkcode), parkname FROM survey_result JOIN park ON park.parkcode = survey_result.parkcode GROUP BY survey_result.parkcode, parkname ORDER BY COUNT(survey_result.parkcode) DESC, parkname";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectAllSurveys);
		while(results.next()) {
			allSurveys.add(results.getString("parkname"));
			allSurveys.add(results.getString("count"));
		
	        }
	        return allSurveys;
	
	}

	@Override
	public List<Survey> getAllParkSurveyPosts() {
		List<Survey> allParkSurveys = new ArrayList<>();
		String sqlSelectAllSurveys = "SELECT parkname, survey_result.parkcode, COUNT(survey_result.parkcode) FROM survey_result JOIN park ON park.parkcode = survey_result.parkcode GROUP BY parkname, survey_result.parkcode ORDER BY COUNT(survey_result.parkcode) DESC, parkname";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectAllSurveys);
		while(results.next()) {
			allParkSurveys.add(mapRowToSurvey(results));
		
		
	        }
	        return allParkSurveys;
	
	}
	
	
	
	
	@Override
	public void save(Survey survey) {
		Integer id = getNextId();
		String sqlInsertSurvey = "INSERT INTO survey_result(surveyid, parkcode, emailaddress, state, activitylevel) VALUES (?,?,?,?,?)";
		jdbcTemplate.update(sqlInsertSurvey, id, survey.getParkcode(),  survey.getEmailaddress(), survey.getState(), survey.getActivitylevel());
		survey.setSurveyid(id);
	}

	private Integer getNextId() {

		String sqlSelectNextId = "SELECT NEXTVAL('seq_surveyid')";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectNextId);
		Integer id = null;
		if(results.next()) {
			id = results.getInt(1);
		} else {
			throw new RuntimeException("Something strange happened, unable to select next survey post id from sequence");
		}
		return id;
	}

	private Survey mapRowToSurvey(SqlRowSet row) {
		Survey survey = new Survey();
		survey.setParkcode(row.getString("parkcode"));
		survey.setParkimgcode(row.getString("parkcode").toLowerCase());
		survey.setParkname(row.getString("parkname"));
		survey.setCount(row.getInt("count"));


		return survey;

	}
}
