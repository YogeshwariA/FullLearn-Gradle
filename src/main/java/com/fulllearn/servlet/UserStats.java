package com.fulllearn.servlet;

import java.io.IOException;

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
import com.fulllearn.model.AWStatsData;
import com.fulllearn.model.AWStatsResponse;
import com.fulllearn.model.User;

@Path("/user_stats")
public class UserStats {
	private static final ObjectMapper MAPPER = new ObjectMapper();

	@GET
	@Produces("application/json")
	public Response getUserDetails(@Context HttpServletRequest req) throws IOException {
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");
		String userId = user.getId();
		// String userId ="25c01d98-46f7-408a-87b1-e0339551a5ed" ;
		String jsonResponse = HttpConnectionHelper.getJson("GET",
				Constants.FULL_LEARN_API + "/api/learn/stats/userId/" + userId, null, null);
		System.out.println("User stats: " + jsonResponse);

		try {
			if (jsonResponse != null && !jsonResponse.isEmpty()) {
				AWStatsResponse statsResponse = MAPPER.readValue(jsonResponse, AWStatsResponse.class);
				AWStatsData data = statsResponse.getData();
				return Response.ok(data).build();
			}
		} catch (Exception e) {
			return Response.status(Response.Status.NOT_FOUND).entity("Something went wrong.Try again!. ").build();

		}
		return null;
	}

}
