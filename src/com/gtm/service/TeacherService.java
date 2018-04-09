package com.gtm.service;

import java.util.List;

import com.gtm.model.Teacher;
import com.gtm.util.Pager;

public interface TeacherService {

	Teacher findByUsernameAndPassword(String username, String password);

	

}
