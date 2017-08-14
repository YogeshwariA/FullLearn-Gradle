document.onreadystatechange = function() {
	showDashboard();
};

function showDashboard() {
	getUserDetails();

	getChallengeInfo(0);
	getChallengeInfo(4);
	getChallengeInfo(12);
}
const monthNames = [ "Jan", "Feb", "Mar", "Apl", "May", "June", "July", "Aug", "Sep","Oct", "Nov", "Dec" ];
function getUserDetails() {
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		var state = xhttp.readyState;
		if (state == 0 || state == 1 || state == 2 || state == 3) {

			document.getElementById('loader_avg_4').style.display = 'inline-block';
			document.getElementById('loader_avg_12').style.display = 'inline-block';

		}

		xhttp.onload = function() {

			document.getElementById('loader_avg_4').style.display = 'none';
			document.getElementById('loader_avg_12').style.display = 'none';

			try {
				var userDetail = JSON.parse(xhttp.responseText);
                console.log(userDetail);
				document.getElementById('change_color_4').classList.add(getColor(userDetail.fourWeekAvg));
				document.getElementById('change_color_12').classList.add(getColor(userDetail.twelveWeekAvg));

				show(userDetail);

			} catch (err) {
				document.getElementById('error_avg_4').innerHTML = err.stack;
				document.getElementById('error_avg_12').innerHTML = err.stack;
			}

		};
	}

	xhttp.open("GET", '/api/user_stats', true);
	xhttp.setRequestHeader('content-type', 'application/json');
	xhttp.send();
}

function show(userDetail) {
	fourWeekAvg = document.getElementById('fourWeekAvg').innerHTML = showTime(userDetail.fourWeekAvg);
	twelveWeekAvg = document.getElementById('twelveWeekAvg').innerHTML = showTime(userDetail.twelveWeekAvg);
}

function showTime(givenMins) {
	if (isNaN(givenMins)) {
		return '';
	}
	const
	minsPerHour = 60;
	let respString = '';
	var hours = Math.floor(givenMins / minsPerHour);
	var mins = givenMins % minsPerHour;
	if (hours > 0) {
		respString = hours + 'hrs ';
	}
	if (mins > 0) {
		respString += mins + 'mins';
	} else {
		respString = mins + ' mins'
	}
	return respString;
}

function getChallengeInfo(week) {
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		var state = xhttp.readyState;
		if (state == 0 || state == 1 || state == 2 || state == 3) {
			document.getElementById('loader_' + week).style.display = 'inline-block';

		}
		xhttp.onload = function() {
			document.getElementById('loader_' + week).style.display = 'none';
			try {
				var userDetails = JSON.parse(xhttp.responseText);
				console.log(userDetails);
				getChallengeDetails(userDetails, week);
				getDetails(userDetails, week);
				changeColor(userDetails, week);
			} catch (err) {
				document.getElementById('error-0' + week).innerHTML = err.stack;
				console.error(err.stack);

			}
		};
	}
	xhttp.open("GET", '/api/challenge?week=' + week, true);
	xhttp.setRequestHeader('content-type', 'application/json');
	xhttp.send();
}
function getChallengeDetails(userDetails, week) {
	var challengeDetails = userDetails.challenges_details;
	var challengeInfo={}, innerHtml = '';
	for ( var key in challengeDetails) {
		challengeInfo = challengeDetails[key];
		 	innerHtml += '<li>' +'<a title="' + key + '"  href="'+challengeInfo['link']+'" target="_blank">' + key + '</a>'+ '<span>' + challengeInfo['mins'] + "</span>" + '</li>';
	}
	document.getElementById("challenge_details_" + week).innerHTML = innerHtml;
}
function getStartDate(startDate, endYear) {
	var dateStart = startDate.getDate();
	var startMonth = monthNames[startDate.getMonth()];
	var startYear = startDate.getFullYear();
	var startDateString = '';
	if (endYear == startYear) {
		startDateString = dateStart + ' ' + startMonth;
		return startDateString;
	} else {
		startDateString = dateStart + ' ' + startMonth + ' ' + startYear;
		return startDateString;
	}

}
function getEndDate(endDate) {
	var dateEnd = endDate.getDate();
	console.log(dateEnd);
	var endMonth = monthNames[endDate.getMonth()];
	var endYear = endDate.getFullYear();

	var endDateString = dateEnd + ' ' + endMonth + ' ' + endYear;
	return endDateString;
}
function getDetails(userDetails, week) {
	try {
		var startDate = new Date(userDetails.startDate);
		if (week == 0) {
			var endDate = new Date();
		} else {
			var endDate = new Date(userDetails.endDate);
		}

		var startDateString = getStartDate(startDate, endDate.getFullYear());
		var endDateString = getEndDate(endDate);
		if ((startDate.getDate() == endDate.getDate())&& (monthNames[startDate.getMonth()] == monthNames[endDate.getMonth()])&& (startDate.getFullYear() == endDate.getFullYear())) {
			var date = "Today";
		} else {
			var date = startDateString + " - " + endDateString;
		}
		document.getElementById('date-' + week).innerHTML = date;
		thisWeek = document.getElementById('change_time_' + week).innerHTML = showTime(userDetails.minutes);

	} catch (err) {
		console.error('Error while building the date : ' + err.stack);
	}
}
function changeColor(userDetails, week) {
	document.getElementById('color_for_' + week).classList.add(getColor(userDetails.minutes));
}
function getColor(avgMins) {
	if (avgMins > 150) {
		return 'green';
	} else if (avgMins <= 150 && avgMins >= 75) {
		return 'orange';
	} else {
		return 'red';
	}
}
