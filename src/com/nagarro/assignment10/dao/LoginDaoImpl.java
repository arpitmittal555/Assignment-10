package com.nagarro.assignment10.dao;

public class LoginDaoImpl implements LoginDao {

	@Override
	public boolean checkUser(String userName, String password) {
		boolean retval = false;
		if (("user").equals(userName) && ("user").equals(password)) {
			retval = true;
		}
		return retval;
	}

	@Override
	public boolean checkAdmin(String userName, String password) {
		boolean retval = false;
		if (("admin").equals(userName) && ("admin").equals(password)) {
			retval = true;
		}
		return retval;
	}

}
