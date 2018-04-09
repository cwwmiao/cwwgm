package com.gtm.dao.impl;

import org.springframework.stereotype.Repository;

import com.gtm.dao.StudentDao;
import com.gtm.model.Student;


@Repository("studentDaoImpl")
@SuppressWarnings("unchecked")
public class StudentDaoImpl extends BaseDaoImpl<Student> implements StudentDao{

}
