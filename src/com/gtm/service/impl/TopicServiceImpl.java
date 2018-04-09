package com.gtm.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;












import com.gtm.bean.Topicmsg;
import com.gtm.dao.TopicDao;
import com.gtm.model.Topic;
import com.gtm.service.TopicService;
import com.gtm.util.Pager;
import com.gtm.util.THreadLocalUtil;



@Service("topicService")
public class TopicServiceImpl implements TopicService{

	@Resource
	private TopicDao topicDao;

	@Override
	public void addtopic(String topicname, String topicsource,
			String topictype, String topicrequire, String topicintroduce,
			int topiclimit, int teacherid) {
		Topic topic=new Topic(topicname,  topicsource,
				 topictype,  topicrequire,  topicintroduce,
				 topiclimit,  teacherid);
		topicDao.add(topic);
				
	}

	@Override
	public Pager<Topic> findmytopic(int teacherid, String topicname, int pageNum) {
		String sql="from Topic where teacherid = "+teacherid;
		if(!topicname.equals("")){
			sql+=" and topicname = '"+topicname+"'";
		}
		THreadLocalUtil.setPageOffset((pageNum-1)*10);
		THreadLocalUtil.setPageSize(10);
		System.out.println(sql);
		return topicDao.pager(sql);
	}

	@Override
	public Topic findbyid(int topicid) {
		String sql="from Topic where topicid = "+topicid;
		return (Topic) topicDao.object(sql);
	}

	@Override
	public void updatetopic(String topicname, String topicsource,
			String topictype, String topicrequire, String topicintroduce,
			int topiclimit, int topicid) {
		Topic topic=findbyid(topicid);
		topic.setTopicintroduce(topicintroduce);
		topic.setTopiclimit(topiclimit);
		topic.setTopicname(topicname);
		topic.setTopicrequire(topicrequire);
		topic.setTopicsource(topicsource);
		topic.setTopictype(topictype);
		topicDao.update(topic);
		
	}

	@Override
	public Pager<Topicmsg> findalltopic(String topicsource, String topictype,
			int pageNum) {
		String s="select t.* ,te.name as teachername from teacher as te,topic as t where te.teacherid=t.teacherid ";
		//String sql="from Topic where 1 = 1 ";
		if(!topicsource.equals("")){
			s+=" and t.topicsource = '"+topicsource+"'";
		}
		if(!topictype.equals("")){
			s+=" and t.topictype = '"+topictype+"'";
		}
		THreadLocalUtil.setPageOffset((pageNum-1)*10);
		THreadLocalUtil.setPageSize(10);
		System.out.println(s);
		return topicDao.pagerBySql(s, null, Topicmsg.class, false);
	}
	
	@Override
	public Topicmsg findmytopic2(int topicid) {
		String s="select t.* ,te.name as teachername from teacher as te,topic as t where te.teacherid=t.teacherid and t.topicid = "+topicid;		
		return (Topicmsg) topicDao.ListBySql(s, null, Topicmsg.class, false).get(0);
	}

	@Override
	public void updaterealnum(int length, int topicid) {
		Topic topic=findbyid(topicid);
		int old=topic.getRealnum();
		int new1=old+length;
		topic.setRealnum(new1);
		topicDao.update(topic);
		
	}

}
