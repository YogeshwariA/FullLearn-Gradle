package com.fulllearn.servlet;

import java.io.IOException;
import java.util.Calendar;
import java.util.Map;
import java.util.TimeZone;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fulllearn.helper.Constants;
import com.fulllearn.helper.HttpConnectionHelper;
import com.fulllearn.model.AUResponse;
import com.fulllearn.model.ChallengeDetail;
import com.fulllearn.model.User;

@Path("/challenge")
public class UserChallenge  {
	static final ObjectMapper MAPPER = new ObjectMapper();
	
@GET
@Produces("application/json")
	public Response getChallengeDetails(@Context HttpServletRequest req) throws IOException {
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");
		System.out.println(user);
		String email =user.getLogin();
	    //String email="yogeshwari.arjunan@full.co";
		String weekAsString = req.getParameter("week");
		int week = Integer.parseInt(weekAsString);
		long startTime = getStartDate(week);	
		long endTime = getEndDate(week);
		String urlparameter = "apiKey=" + Constants.API_KEY + "&email=" + email + "&startTime=" + startTime+ "&endTime=" + endTime;
		System.out.println(urlparameter);
		String jsonResponse = HttpConnectionHelper.getJson("GET", Constants.CHALLENGE_API + "/v1/completedMinutes",urlparameter, null);
		System.out.println(jsonResponse);
		try{
			if(jsonResponse!=null && !jsonResponse.isEmpty()){
				AUResponse response = MAPPER.readValue(jsonResponse, AUResponse.class);
				if(response!=null){
					Map<String, ChallengeDetail> data = response.getData();
					if(data!=null){
						ChallengeDetail details = data.get(email);
						if(details!=null){
							details.setStartDate(startTime);
							details.setEndDate(endTime);
							return Response.ok(details).build();
						}
					}
				}
			}
		}catch(Exception e){
			return Response.status(Response.Status.NOT_FOUND).entity("Something went wrong.Try again!. ").build();
		}
		return null;
	}

	private long getStartDate(int week) {

		Calendar calendar = getStartTimeCalendarInstance();
		long result = 0;
		System.out.println(calendar.getTime());
		switch (week) {
		case 0:
			int dayOfTheWeek = calendar.get(Calendar.DAY_OF_WEEK);
			if (dayOfTheWeek == Calendar.SUNDAY) {
				calendar.add(Calendar.DATE, -(Calendar.SATURDAY - dayOfTheWeek));
				break;
			} else {
				calendar.add(Calendar.DATE, -(dayOfTheWeek - Calendar.MONDAY));
				break;
			}

		default:
			int currentWeek = calendar.get(Calendar.WEEK_OF_YEAR);
			calendar.set(Calendar.WEEK_OF_YEAR, currentWeek - week);
			calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
			break;

		}
		
		result = calendar.getTimeInMillis();
		System.out.println(week+": start time"+calendar.getTimeInMillis());
		return result;
	}

	private long getEndDate(int week) {
		Calendar calendar = getEndTimeCalendarInstance();
		System.out.println(calendar.getTime());
		long result = 0;

		switch (week) {
		case 4:
		case 12:
			int currentWeek = calendar.get(Calendar.WEEK_OF_YEAR);
			calendar.set(Calendar.WEEK_OF_YEAR, currentWeek);
			calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
			break;
		}
		System.out.println(calendar.getTime());
		result = calendar.getTimeInMillis();
		System.out.println(week + ":end time " + result);
		return result;
	}

	private Calendar getStartTimeCalendarInstance() {

		Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar;
	}

	private Calendar getEndTimeCalendarInstance() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		calendar.set(Calendar.MILLISECOND, 59);
		return calendar;
	}
}