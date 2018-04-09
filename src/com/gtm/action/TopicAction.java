package com.gtm.action;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.gtm.bean.Topicmsg;
import com.gtm.model.Topic;
import com.gtm.service.TopicService;
import com.gtm.util.Pager;
import com.opensymphony.xwork2.ActionSupport;

@Controller("topicAction")
@Scope("prototype")
public class TopicAction extends ActionSupport{
	
	@Resource
	private TopicService topicService;
	
	private int topicid;
	private String topicname;
	private String topicsource;
	private String topictype;
	private String topicrequire;
	private String topicintroduce;
	private int topiclimit;
	private int teacherid;
	private Map<String, Object> dataMap;
	private JSONObject json;
	private Pager<Topic> topicPage;
	private Pager<Topicmsg> topicmsgPage;
	private Topicmsg topicmsg;
	private Topic topic;
	private int pageNum;
	
	public String addTopic()
	{
		topicService.addtopic(topicname,topicsource,topictype,topicrequire,topicintroduce,topiclimit,teacherid);
		return SUCCESS;
	}
	
	public String findmytopic()
	{
		topicPage=topicService.findmytopic(teacherid,topicname,pageNum);
		//System.out.println(topicPage);
		dataMap=new HashMap<String, Object>();
		dataMap.put("topicPage",topicPage);
		json=JSONObject.fromObject(dataMap);
		return SUCCESS;
	}
	
	public String findtopicbyid()
	{
		topic=topicService.findbyid(topicid);
		dataMap=new HashMap<String, Object>();
		dataMap.put("topic",topic);
		json=JSONObject.fromObject(dataMap);
		return SUCCESS;
	}
	public String updatetopic()
	{
		topicService.updatetopic(topicname,topicsource,topictype,topicrequire,topicintroduce,topiclimit,topicid);
		return SUCCESS;
	}
	public String findalltopic()
	{
		topicmsgPage=topicService.findalltopic(topicsource,topictype,pageNum);
		dataMap=new HashMap<String, Object>();
		dataMap.put("topicPage",topicmsgPage);
		json=JSONObject.fromObject(dataMap);
		return SUCCESS;
	}
	public String findmytopic2()
	{
		topicmsg=topicService.findmytopic2(topicid);
		dataMap=new HashMap<String, Object>();
		dataMap.put("topicmsg",topicmsg);
		json=JSONObject.fromObject(dataMap);
		return SUCCESS;
	}

	public TopicService getTopicService() {
		return topicService;
	}

	public void setTopicService(TopicService topicService) {
		this.topicService = topicService;
	}

	public int getTopicid() {
		return topicid;
	}

	public void setTopicid(int topicid) {
		this.topicid = topicid;
	}

	public String getTopicname() {
		return topicname;
	}

	public void setTopicname(String topicname) {
		this.topicname = topicname;
	}

	public String getTopicsource() {
		return topicsource;
	}

	public void setTopicsource(String topicsource) {
		this.topicsource = topicsource;
	}

	public String getTopictype() {
		return topictype;
	}

	public void setTopictype(String topictype) {
		this.topictype = topictype;
	}

	public String getTopicrequire() {
		return topicrequire;
	}

	public void setTopicrequire(String topicrequire) {
		this.topicrequire = topicrequire;
	}

	public String getTopicintroduce() {
		return topicintroduce;
	}

	public void setTopicintroduce(String topicintroduce) {
		this.topicintroduce = topicintroduce;
	}

	public int getTopiclimit() {
		return topiclimit;
	}

	public void setTopiclimit(int topiclimit) {
		this.topiclimit = topiclimit;
	}

	public int getTeacherid() {
		return teacherid;
	}

	public void setTeacherid(int teacherid) {
		this.teacherid = teacherid;
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

	public Pager<Topic> getTopicPage() {
		return topicPage;
	}

	public void setTopicPage(Pager<Topic> topicPage) {
		this.topicPage = topicPage;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	public Pager<Topicmsg> getTopicmsgPage() {
		return topicmsgPage;
	}

	public void setTopicmsgPage(Pager<Topicmsg> topicmsgPage) {
		this.topicmsgPage = topicmsgPage;
	}

	public Topicmsg getTopicmsg() {
		return topicmsg;
	}

	public void setTopicmsg(Topicmsg topicmsg) {
		this.topicmsg = topicmsg;
	}
	
	
	
	

}
