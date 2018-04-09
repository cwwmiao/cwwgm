package com.gtm.service;

import com.gtm.bean.Topicmsg;
import com.gtm.model.Topic;
import com.gtm.util.Pager;

public interface TopicService {

	void addtopic(String topicname, String topicsource, String topictype,
			String topicrequire, String topicintroduce, int topiclimit,
			int teacherid);

	Pager<Topic> findmytopic(int teacherid, String topicname, int pageNum);

	Topic findbyid(int topicid);

	void updatetopic(String topicname, String topicsource, String topictype,
			String topicrequire, String topicintroduce, int topiclimit,
			int topicid);

	Pager<Topicmsg> findalltopic(String topicsource, String topictype, int pageNum);

	void updaterealnum(int length, int topicid);

	Topicmsg findmytopic2(int topicid);

}
