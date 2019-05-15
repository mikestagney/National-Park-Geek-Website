<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

 <div id="main-content"> 

	
		<div class="parkList">
			<div class="container">
				<c:forEach var="park" items="${parkList}">

					<div class="childParkList">
						<div class="row">
							<c:url var="imageUrl" value="/img/parks/${park.parkimgcode}.jpg" />


							<c:url var="detailUrl" value="/park?parkcode=${park.parkcode}" />

							<div class="col">
								<a class="listPicBox" href="${detailUrl}"><div
										class="listPic">
							<figure class="filter">				<img class="listPic2" src="${imageUrl}" /></figure>
									</div></a>
							</div>
							<div class="col">
								<div class="childParkList2">
									<div class="name">${park.parkname}, ${park.state}</div> <br>
									<div class="description">${park.parkdescription}</div>
								</div>
							</div>
						</div>
					</div>

				</c:forEach>
			</div>
		</div>

	</table>
</div>












<c:import url="/WEB-INF/jsp/common/footer.jsp" />