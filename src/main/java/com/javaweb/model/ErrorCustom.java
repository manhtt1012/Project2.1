package com.javaweb.model;

import java.util.ArrayList;
import java.util.List;

public class ErrorCustom {
	private String name;
	List<String> detail =  new ArrayList<String>();
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getDetail() {
		return detail;
	}
	public void setDetail(List<String> detail) {
		this.detail = detail;
	}
	
	

}
