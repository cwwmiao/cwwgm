package com.gtm.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gtm.dao.TeacherDao;
import com.gtm.model.Teacher;
import com.gtm.service.TeacherService;
@Service("teacherService")
public class TeacherServiceImpl implements TeacherService{
	@Resource
	private TeacherDao teacherDao;

	@Override
	public Teacher findByUsernameAndPassword(String username, String password) {
		String sql="from Teacher where username = ? and password = ?";
		return (Teacher) teacherDao.object(sql, new Object[]{username,password});
	}
	
	

}
