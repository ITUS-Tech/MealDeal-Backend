package com.itus.mealdeal.models;

public class Plan {
	private String type;
	private String startDate;
	private String endDate;
	
	public Plan() {
		super();
	}
	public Plan(String type, String start, String end) {
		super();
		this.type = type;
		this.startDate = start;
		this.endDate = end;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getStart() {
		return startDate;
	}
	public void setStart(String start) {
		this.startDate = start;
	}
	public String getEnd() {
		return endDate;
	}
	public void setEnd(String end) {
		this.endDate = end;
	}
	@Override
	public String toString() {
		return "Plan [type=" + type + ", start=" + startDate + ", end=" + endDate + "]";
	}
}
