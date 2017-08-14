package com.fulllearn.model;

import java.util.Map;

public class ChallengeDetail {
private int minutes;
//private Map<String,Integer> challenges_details;
private Map<String,Object>  challenges_details;
private int challenges_completed;
private long startDate;
private long endDate;
public long getStartDate() {
	return startDate;
}
public void setStartDate(long startDate) {
	this.startDate = startDate;
}
public long getEndDate() {
	return endDate;
}
public void setEndDate(long endDate) {
	this.endDate = endDate;
}
public int getMinutes() {
	return minutes;
}
public void setMinutes(int minutes) {
	this.minutes = minutes;
}

public int getChallenges_completed() {
	return challenges_completed;
}
public void setChallenges_completed(int challenges_completed) {
	this.challenges_completed = challenges_completed;
}
public Map<String, Object> getChallenges_details() {
	return challenges_details;
}
public void setChallenges_details(Map<String, Object> challenges_details) {
	this.challenges_details = challenges_details;
}


}
