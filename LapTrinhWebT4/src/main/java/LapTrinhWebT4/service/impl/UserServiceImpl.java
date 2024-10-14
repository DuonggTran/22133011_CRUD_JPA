package LapTrinhWebT4.service.impl;

import LapTrinhWebT4.models.UserModel;
import LapTrinhWebT4.service.IUserService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import LapTrinhWebT4.dao.*;
import LapTrinhWebT4.dao.impl.UserDaoImpl;

public class UserServiceImpl implements IUserService {
	IUserDao userDao = new UserDaoImpl();

	public UserModel login(String username, String password) {
		UserModel user = this.findByUserName(username);
		if (user != null && password.equals(user.getPassWord())) {
			return user;
		}
		return null;
	}

	private UserModel findByUserName(String username) {
		return userDao.findByUserName(username);
	}

	public UserModel get(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(UserModel user) {
		userDao.insert(user);
	}

	@Override
	public boolean register(String email, String password, String username, String fullname, String phone) {
		if (userDao.checkExistUsername(username)) {
			return false;
		}
		long millis = System.currentTimeMillis();
		java.sql.Date date = new java.sql.Date(millis);
		userDao.insert(new UserModel(email, username, fullname, password, null, 1, phone, date));
		return true;
	}

	@Override
	public boolean checkExistEmail(String email) {
		return userDao.checkExistEmail(email);
	}

	@Override
	public boolean checkExistUsername(String username) {
		return userDao.checkExistUsername(username);
	}

	@Override
	public boolean checkExistPhone(String phone) {
		return userDao.checkExistPhone(phone);
	}



	@Override
	public boolean checkFinishChangePassword(String username, String password) {
		if (!userDao.checkExistUsername(username)) {
			return false;
		}
		userDao.changePassword(username,password);
		return true;
	}
}
