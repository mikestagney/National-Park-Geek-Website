<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<style>
.error {
	color: red;
}
</style>

<div id="main-content" class="surveyMain">
<div  class="mapBox">
	<div class="surveyPostBox">


		<h1 class="headerSurveyPost">National Park Survey</h1>

		<c:url var="postAddURL" value="/survey/post/add" />


		<form:form id="survey" action="${postAddURL}" method="POST"
			modelAttribute="survey">
			<div class="postList">
				<div class="form-group row">
					<label for="parkname" class="col-sm-2 col-form-label">Favorite Park:</label>
					<form:select path="parkcode" name="parkcode">
						<c:forEach var="park" items="${parkList}">
							<div class="col-sm-10">
								<option value="${park.parkcode}">${park.parkname}</option>
							</div>
						</c:forEach>
					</form:select>
				</div>
				<div class="form-group row">
					<label for="emailaddress" class="col-sm-2 col-form-label">Your
						Email:</label>
					<div class="col-sm-10">
						<form:input path="emailaddress" />
						<form:errors path="emailaddress" class="error" />
					</div>
				</div>

				<div class="form-group row">
					<label for="state" class="col-sm-2 col-form-label">State of
						Residence:</label>
					<div class="col-sm-10">
						<form:select path="state" id="state" name="state">
							<option value="">N/A</option>
							<option value="AK">Alaska</option>
							<option value="AL">Alabama</option>
							<option value="AR">Arkansas</option>
							<option value="AZ">Arizona</option>
							<option value="CA">California</option>
							<option value="CO">Colorado</option>
							<option value="CT">Connecticut</option>
							<option value="DC">District of Columbia</option>
							<option value="DE">Delaware</option>
							<option value="FL">Florida</option>
							<option value="GA">Georgia</option>
							<option value="HI">Hawaii</option>
							<option value="IA">Iowa</option>
							<option value="ID">Idaho</option>
							<option value="IL">Illinois</option>
							<option value="IN">Indiana</option>
							<option value="KS">Kansas</option>
							<option value="KY">Kentucky</option>
							<option value="LA">Louisiana</option>
							<option value="MA">Massachusetts</option>
							<option value="MD">Maryland</option>
							<option value="ME">Maine</option>
							<option value="MI">Michigan</option>
							<option value="MN">Minnesota</option>
							<option value="MO">Missouri</option>
							<option value="MS">Mississippi</option>
							<option value="MT">Montana</option>
							<option value="NC">North Carolina</option>
							<option value="ND">North Dakota</option>
							<option value="NE">Nebraska</option>
							<option value="NH">New Hampshire</option>
							<option value="NJ">New Jersey</option>
							<option value="NM">New Mexico</option>
							<option value="NV">Nevada</option>
							<option value="NY">New York</option>
							<option value="OH">Ohio</option>
							<option value="OK">Oklahoma</option>
							<option value="OR">Oregon</option>
							<option value="PA">Pennsylvania</option>
							<option value="PR">Puerto Rico</option>
							<option value="RI">Rhode Island</option>
							<option value="SC">South Carolina</option>
							<option value="SD">South Dakota</option>
							<option value="TN">Tennessee</option>
							<option value="TX">Texas</option>
							<option value="UT">Utah</option>
							<option value="VA">Virginia</option>
							<option value="VT">Vermont</option>
							<option value="WA">Washington</option>
							<option value="WI">Wisconsin</option>
							<option value="WV">West Virginia</option>
							<option value="WY">Wyoming</option>
						</form:select>
					</div>
				</div>
				<div class="form-group row">
					<label for="activitylevel" class="col-sm-2 col-form-label">Your Activity
						level:</label>
					<div class="col-sm-10">
						<form:radiobutton path="activitylevel" value="inactive" />

						Inactive
						<form:radiobutton path="activitylevel" value="sedentary" />
						Sedentary
						<form:radiobutton path="activitylevel" value="active" />
						Active
						<form:radiobutton path="activitylevel" value="extremely active" />
						Extremely Active

						<form:errors path="activitylevel" class="error" />
					</div>
				</div>
				<div class="form-group row">
					<div class="col">
						<div class="d-flex justify-content-center">
							<input type="submit" value="Submit" class="rounded">
						</div>
					</div>
				</div>
		</form:form>
	</div>
</div>
</div>
</div>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />