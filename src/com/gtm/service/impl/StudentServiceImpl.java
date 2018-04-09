package com.gtm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gtm.bean.Studentmsg;
import com.gtm.bean.Studenttopicmsg;
import com.gtm.dao.StudentDao;
import com.gtm.model.Student;
import com.gtm.model.Topic;
import com.gtm.service.StudentService;

@Service("studentService")
public class StudentServiceImpl implements StudentService{
	
	@Resource
	private StudentDao studentDao;
	

	@Override
	public Student findByUsernameAndPassword(String username, String password) {
		String sql="from Student where username = '"+username+"' and password = '"+password+"'";
		Student s= (Student) studentDao.object(sql, new Object[]{});
		return s;
	}


	@Override
	public int findflagbyid(int studentid) {
		String sql="from Student where studentid = '"+studentid+"'";
		Student s= (Student) studentDao.object(sql);
		int ss=s.getFlag();
		return ss;
	}
	
	
	public Student findbyid(int studentid) {
		String sql="from Student where studentid = "+studentid;
		return (Student) studentDao.object(sql);
		
	}

	@Override
	public Student findflagbyid2(int studentid) {
		return findbyid( studentid);
	}

	@Override
	public void apply(Student st, int topicid) {
//		st.setFlag(1);
//		st.setTopicid(topicid);
		st.setName("22");
		studentDao.update(st);
		
	}


	@Override
	public void updateapply(Student st, int topicid) {
		// TODO Auto-generated method stub
		st.setFlag(1);
		st.setTopicid(topicid);
		studentDao.update(st);
	}


	@Override
	public List<Student> findstudentbyid(int topicid) {
		String sql="from Student where topicid = '"+topicid+"' and flag != 2";
		return studentDao.list(sql);
	}


	@Override
	public void updateStudentflag1(Integer integer) {
		Student student=findbyid(integer);
		student.setFlag(2);
		studentDao.update(student);
		
		
	}


	@Override
	public void updateStudentflag2(Integer integer) {
		Student student=findbyid(integer);
		student.setFlag(0);
		student.setTopicid(0);
		studentDao.update(student);
		
	}


	@Override
	public List<Studentmsg> findstudentbyname(String name,int teacherid) {
		// TODO Auto-generated method stub
		String sql="select s.* ,t.topicname from student as s,topic as t,teacher as te where s.flag=2 and s.topicid=t.topicid and t.teacherid="+teacherid;
		if(!name.equals("")){
			sql+=" and s.name='"+name+"'";
		}
		sql+=" group by s.studentid";
		return studentDao.ListBySql(sql, null, Studentmsg.class, false);
	}


	@Override
	public void updatescore(double score, int studentid) {
		// TODO Auto-generated method stub
		String hql="from Student where studentid="+studentid;
		Student student=(Student) studentDao.object(hql);
		student.setScore(score);
		studentDao.update(student);
		
	}


	@Override
	public Studenttopicmsg findbystudentid(int studentid) {
		String sql="select s.score as score,t.topicname as topicname,te.name as teachername from student as s,topic as t,teacher as te where s.studentid= "+studentid
				+" and s.topicid=t.topicid and t.teacherid =te.teacherid";
		return (Studenttopicmsg) studentDao.ListBySql(sql, null, Studenttopicmsg.class, false).get(0);
	}

}
