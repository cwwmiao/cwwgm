package com.gtm.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.gtm.bean.Studentmsg;
import com.gtm.bean.Studenttopicmsg;
import com.gtm.model.Student;
import com.gtm.model.Teacher;
import com.gtm.service.StudentService;
import com.gtm.service.TeacherService;
import com.gtm.service.TopicService;
import com.opensymphony.xwork2.ActionSupport;

@Controller("studentAction")
@Scope("prototype")
public class StudentAction extends ActionSupport{

	@Resource
	private StudentService studentService;
	@Resource
	private TopicService topicService;
	
	private String username;
	private String password;
	private Map<String, Object> dataMap;
	private JSONObject json;
	private int studentid;
	private int topicid;
	private List<Student> studentList;
	private List<Studentmsg> studentmsgList;
	private List<Integer> studentidlist;
	private List<Integer> delList;
	private int flag;
	private String msg;
	private File file;
	private int id;
	private String name;
	private int teacherid;
	private double score;
	
	
	String url = ServletActionContext.getServletContext().getRealPath("/")
			.replace("\\", "/");
	
	private Student student;
	private Studenttopicmsg studenttopicmsg;
	
	public String login(){
		student=studentService.findByUsernameAndPassword(username,password);
		dataMap=new HashMap<String, Object>();
		dataMap.put("student",student);
		json=JSONObject.fromObject(dataMap);
		return SUCCESS;
	}
	public String apply(){
		int flag=studentService.findflagbyid(studentid);
		String mg;
		if(flag==0)
		{
			Student st=studentService.findflagbyid2(studentid);
			//studentService.apply(st,topicid);
			studentService.updateapply(st,topicid);
			mg="申请成功";
		}
		else
		{
			mg="你已经申请过了";
		}
		dataMap=new HashMap<String, Object>();
		dataMap.put("apply",mg);
		json=JSONObject.fromObject(dataMap);
		return SUCCESS;
	}
	public String findstudentbyid()
	{
		studentList=studentService.findstudentbyid(topicid);
		dataMap=new HashMap<String, Object>();
		dataMap.put("studentList",studentList);
		json=JSONObject.fromObject(dataMap);
		return SUCCESS;
	}
	public String updateStudentflag()
	{
		for(int i=0;i<studentidlist.size();i++)
		{
			studentService.updateStudentflag1(studentidlist.get(i));
		}
		for(int i=0;i<delList.size();i++)
		{
			studentService.updateStudentflag2(delList.get(i));
		}
		int length=studentidlist.size();
		topicService.updaterealnum(length,topicid);
		return SUCCESS;
	}
	public String findtopicidbystudentid()
	{
		student=studentService.findflagbyid2(studentid);
		topicid=student.getTopicid();
		flag=student.getFlag();
		if(flag==0)
		{
			msg="还未选题";
		}
		else if(flag==1)
		{
			msg="正在审核";
		}
		else
		{
			msg="选题成功";
		}
		dataMap=new HashMap<String, Object>();
		dataMap.put("topicid",topicid);
		dataMap.put("flagmsg",msg);
		json=JSONObject.fromObject(dataMap);
		return SUCCESS;
	}
	public String findbyname()
	{
		studentmsgList=studentService.findstudentbyname(name,teacherid);
		dataMap=new HashMap<String, Object>();
		dataMap.put("studentList",studentmsgList);
		json=JSONObject.fromObject(dataMap);
		return SUCCESS;
	}
	public String getmyscore(){
		studenttopicmsg=studentService.findbystudentid(studentid);
		dataMap=new HashMap<String, Object>();
		dataMap.put("studenttopicmsg",studenttopicmsg);
		json=JSONObject.fromObject(dataMap);
		return SUCCESS;
	}
	public String upgrade(){
		studentService.updatescore(score,studentid);
		return SUCCESS;
	}
	public StudentService getStudentService() {
		return studentService;
	}
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
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
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public int getStudentid() {
		return studentid;
	}
	public void setStudentid(int studentid) {
		this.studentid = studentid;
	}
	public int getTopicid() {
		return topicid;
	}
	public void setTopicid(int topicid) {
		this.topicid = topicid;
	}
	public List<Student> getStudentList() {
		return studentList;
	}
	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}
	public List<Integer> getStudentidlist() {
		return studentidlist;
	}
	public void setStudentidlist(List<Integer> studentidlist) {
		this.studentidlist = studentidlist;
	}
	public List<Integer> getDelList() {
		return delList;
	}
	public void setDelList(List<Integer> delList) {
		this.delList = delList;
	}
	public TopicService getTopicService() {
		return topicService;
	}
	public void setTopicService(TopicService topicService) {
		this.topicService = topicService;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getTeacherid() {
		return teacherid;
	}
	public void setTeacherid(int teacherid) {
		this.teacherid = teacherid;
	}
	public List<Studentmsg> getStudentmsgList() {
		return studentmsgList;
	}
	public void setStudentmsgList(List<Studentmsg> studentmsgList) {
		this.studentmsgList = studentmsgList;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	public Studenttopicmsg getStudenttopicmsg() {
		return studenttopicmsg;
	}
	public void setStudenttopicmsg(Studenttopicmsg studenttopicmsg) {
		this.studenttopicmsg = studenttopicmsg;
	}
	
	
	
	
	
	
}
