package com.gtm.action;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.gtm.model.Teacher;
import com.gtm.service.TeacherService;
import com.opensymphony.xwork2.ActionSupport;

import net.sf.json.JSONObject;

@Controller("teacherAction")
@Scope("prototype")
public class TeacherAction extends ActionSupport{
	
	@Resource
	private TeacherService teacherService;
	private String username;
	private String password;
	private Map<String, Object> dataMap;
	private JSONObject json;
	
	private Teacher teacher;
	public String login(){
		teacher=teacherService.findByUsernameAndPassword(username,password);
		//System.out.println(teacher);
		dataMap=new HashMap<String, Object>();
		dataMap.put("teacher",teacher);
		json=JSONObject.fromObject(dataMap);
		return SUCCESS;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Map<String, Object> getDataMap() {
		return dataMap;
	}
	public void setDataMap(Map<String, Object> dataMap) {
		this.dataMap = dataMap;
	}
	public JSONObject getJson() {
		return json;
	}
	public void setJson(JSONObject json) {
		this.json = json;
	}
	
	
}
