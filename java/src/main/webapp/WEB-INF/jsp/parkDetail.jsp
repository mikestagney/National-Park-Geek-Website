<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:import url="/WEB-INF/jsp/common/header.jsp" />




<div id="main-content">

	<div class="detailsParent">

		<div class="details1">
			<div class="container">
				<div class="row">
					<div class="col" id="stampBox">
						<c:url var="stampUrl" value="/img/stamp-hi.png" />
						<img id="stampImg" src="${stampUrl}" />
					</div>
				</div>
				<div class="row">
					<c:url var="imageUrl" value="/img/parks/${park.parkimgcode}.jpg" />
					<div class="col">
						<figure class="filter">
							<figure class="detailsWidePic">
								<img id="detailsImg" src="${imageUrl}" />
							</figure>
						</figure>
					</div>
				</div>
				<div class="row">
					<div class="col">
						<div class="detailName">${park.parkname},${park.state} Est.
							${park.yearfounded}</div>
					</div>
				</div>
				<div class="row">
					<div class="col">
						<div class="quote">"${park.inspirationalquote}" -
							${park.inspirationalquotesource}</div>
						<br />
						<p class="detailDescription">${park.parkdescription}</p>
						<br />
						<p class="detailInfo">
							<fmt:formatNumber type="number" value="${park.acreage}" />
							acres at
							<fmt:formatNumber type="number" value="${park.elevationinfeet}" />
							feet in elevation, with
							<fmt:formatNumber type="number" value="${park.milesoftrail}" />
							miles of trails
						</p>
						<p class="detailInfo">
							<fmt:formatNumber type="number" value="${park.numberofcampsites}" />
							campsites in a ${park.climate} climate with
							<fmt:formatNumber type="number"
								value="${park.annualvisitorcount}" />
							annual visitors
						</p>
						<p class="detailInfo">
							Featuring
							<fmt:formatNumber type="number"
								value="${park.numberofanimalspecies}" />
							different animal species
						</p>
						<p class="detailInfo">
							Entry Fee:
							<fmt:formatNumber type="currency" value="${park.entryfee}" />
						</p>
						<br />
					</div>
				</div>
				<form method="POST">
					<input type="radio" name="temp" value="fahrenheit">
					Fahrenheit <input type="radio" name="temp" value="celsius">
					Celsius <input type="submit" value="Submit">
				</form>
				<div class="row">
					<div class="col" id="today">Today</div>
					<div class="col" id="today">Tomorrow</div>
					<div class="col" id="today">Day After</div>
					<div class="col" id="today">Next Day</div>
					<div class="col" id="today">Last Day</div>
				</div>
				<div class="row">
					<c:forEach var="currentWeather" items="${weather}">
						<div class="col">
							<div class="weatherList">
								<c:url var="imageUrl"
									value="/img/weather/${currentWeather.forecast}.png" />
								<p>
									<img class="listPicWeather" src="${imageUrl}" />
								</p>
								<div class="weatherText">
									<c:if test="${temp != 'celsius'}">
										<p>High: ${currentWeather.high}°F</p>
										<p>Low: ${currentWeather.low}°F</p>
									</c:if>
									<c:if test="${temp == 'celsius'}">
										<p>
											High:
											<fmt:formatNumber type="number" maxFractionDigits="0"
												value="${currentWeather.highCelsius}" />
											°C
										</p>

										<p>
											Low:
											<fmt:formatNumber type="number" maxFractionDigits="0"
												value="${currentWeather.lowCelsius}" />
											°C
										</p>
									</c:if>
									<p>${currentWeather.forecast}</p>
									<p>${currentWeather.recommendation}</p>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
		</div>
	</div>
</div>

</div>


<c:import url="/WEB-INF/jsp/common/footer.jsp" />