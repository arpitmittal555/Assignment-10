package com.nagarro.assignment10.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.nagarro.assignment10.dao.LoginDao;

public class LoginServiceImpl implements LoginService {

	@Autowired
	public LoginDao loginDao;

	@Override
	public boolean checkLogin(String userName, String password, String type) {
		if (("user").equals(type)) {
			return loginDao.checkUser(userName, password);
		} else {
			return loginDao.checkAdmin(userName, password);
		}
	}

}
