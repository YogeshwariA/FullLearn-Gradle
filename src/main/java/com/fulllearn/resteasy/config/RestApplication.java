package com.fulllearn.resteasy.config;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import com.fulllearn.servlet.UserChallenge;
import com.fulllearn.servlet.UserStats;
public class RestApplication extends Application{

	private Set<Object> singletons=new HashSet<Object>();
	
	public RestApplication()
	{
		singletons.add(new JacksonConfig());
		singletons.add(new UserChallenge());
		singletons.add(new UserStats());
	}
	
	@Override
	public Set<Object> getSingletons() {
		// TODO Auto-generated method stub
		return singletons;
	}
	
	
}
