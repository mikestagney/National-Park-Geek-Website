package npgeek.model;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

public class Survey {
	
	private Integer surveyid;
	private String parkcode;
	
	@Email(message="invalid email")
	@NotBlank(message="invaild email")
	private String emailaddress;
	@NotNull(message="please select a state")
	private String state;
	@NotBlank(message="please select an activity level")
	private String activitylevel;
	private String parkname;
	private int count;
	private String parkimgcode;
	
	public Integer getSurveyid() {
		return surveyid;
	}
	public void setSurveyid(Integer surveyid) {
		this.surveyid = surveyid;
	}
	public String getParkcode() {
		return parkcode;
	}
	public void setParkcode(String parkcode) {
		this.parkcode = parkcode;
	}
	public String getEmailaddress() {
		return emailaddress;
	}
	public void setEmailaddress(String emailaddress) {
		this.emailaddress = emailaddress;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getActivitylevel() {
		return activitylevel;
	}
	public void setActivitylevel(String activitylevel) {
		this.activitylevel = activitylevel;
	}
	public String getParkname() {
		return parkname;
	}
	public void setParkname(String parkname) {
		this.parkname = parkname;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getParkimgcode() {
		return parkimgcode;
	}
	public void setParkimgcode(String parkimgcode) {
		this.parkimgcode = parkimgcode;
	}

}
