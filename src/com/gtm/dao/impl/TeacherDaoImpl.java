package com.gtm.dao.impl;
import org.springframework.stereotype.Repository;

import com.gtm.dao.TeacherDao;
import com.gtm.model.Teacher;

@Repository("teacherDaoImpl")
@SuppressWarnings("unchecked")
public class TeacherDaoImpl extends BaseDaoImpl<Teacher> implements TeacherDao{

}

