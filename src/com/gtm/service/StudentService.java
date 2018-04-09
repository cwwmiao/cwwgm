package com.gtm.service;

import java.util.List;

import com.gtm.bean.Studentmsg;
import com.gtm.bean.Studenttopicmsg;
import com.gtm.model.Student;

public interface StudentService {

	Student findByUsernameAndPassword(String username, String password);
	
	int findflagbyid(int studentid);

	Student findflagbyid2(int studentid);

	void apply(Student st, int topicid);

	void updateapply(Student st, int topicid);

	List<Student> findstudentbyid(int topicid);

	void updateStudentflag1(Integer integer);

	void updateStudentflag2(Integer integer);

	List<Studentmsg> findstudentbyname(String name, int teacherid);

	void updatescore(double score, int studentid);

	Studenttopicmsg findbystudentid(int studentid);

}
