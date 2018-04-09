package com.gtm.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="topic")
public class Topic {

	@Id
	private int topicid;
	private String topicname;
	private String topicsource;
	private String topictype;
	private String topicrequire;
	private String topicintroduce;
	private int topiclimit;
	private int teacherid;
	private int realnum;
	
	
	public Topic()
	{
		
	}

	public Topic(String topicname, String topicsource,
			String topictype, String topicrequire, String topicintroduce,
			int topiclimit, int teacherid) {
		super();
		this.topicname = topicname;
		this.topicsource = topicsource;
		this.topictype = topictype;
		this.topicrequire = topicrequire;
		this.topicintroduce = topicintroduce;
		this.topiclimit = topiclimit;
		this.teacherid = teacherid;
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

	public int getRealnum() {
		return realnum;
	}

	public void setRealnum(int realnum) {
		this.realnum = realnum;
	}

	@Override
	public String toString() {
		return "Topic [topicid=" + topicid + ", topicname=" + topicname
				+ ", topicsource=" + topicsource + ", topictype=" + topictype
				+ ", topicrequire=" + topicrequire + ", topicintroduce="
				+ topicintroduce + ", topiclimit=" + topiclimit
				+ ", teacherid=" + teacherid + ", realnum=" + realnum + "]";
	}
	
	
	
}
