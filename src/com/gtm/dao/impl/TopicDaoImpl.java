package com.gtm.dao.impl;

import org.springframework.stereotype.Repository;

import com.gtm.dao.TopicDao;
import com.gtm.model.Topic;

@Repository("topicDaoImpl")
@SuppressWarnings("unchecked")
public class TopicDaoImpl extends BaseDaoImpl<Topic> implements TopicDao{

}
