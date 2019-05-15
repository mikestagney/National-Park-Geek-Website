<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<div id="main-content">
	<div class="container">
		<div class="row">
			<div class="col" id="certBox">
				<c:url var="certifiedUrl" value="/img/certified.png" />
				<img id="certImg" src="${certifiedUrl}" />
			</div>
		</div>
	</div>
	<div class="surveyBox">
		<div class="parkList">
			<div class="container">

				<div class="row justify-content-start">
					<div class="col">
						<h1 class="headerSurvey">Your National Park Survey Results!</h1>
					</div>
				</div>
				<div class="childParkList">
					<div class="row">
						<div class="col" id="surveyCountHeader">Thank you for
							filling out our National Parks survey! Check out below to see
							which park is the most popular! If a park you love isn't here,
							fill out another survey and let us know!</div>
					</div>
				</div>
				<c:forEach var="post" items="${allSurveyPosts}">
					<div class="row justify-content-start">
						<div class="col">
							<c:url var="imageUrl" value="/img/parks/${post.parkimgcode}.jpg" />
							<c:url var="detailUrl" value="/park?parkcode=${post.parkcode}" />
							<a class="listPicBox" href="${detailUrl}">
								<figure class="filter">
									<img class="listPic2" src="${imageUrl}" />
								</figure>
							</a>
						</div>
						<div class="col-4" id="parkName">${post.parkname}</div>
						<div class="col" id="surveyCount">${post.count}vote(s)</div>
						<div class="col"></div>
						<div class="col"></div>
						<br>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
</div>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />