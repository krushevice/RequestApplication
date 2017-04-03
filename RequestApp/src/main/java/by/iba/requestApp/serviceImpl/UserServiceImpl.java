package by.iba.requestApp.serviceImpl;

import java.sql.SQLException;

import by.iba.requestApp.dao.UserDao;
import by.iba.requestApp.service.UserService;

public class UserServiceImpl implements UserService {

	private UserDao userDao;

	public UserDao getUserDao() {
		return this.userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public boolean isValidUser(String username, String password) throws SQLException {
		return userDao.isValidUser(username, password);
	}

	@Override
	public void insertUser(String username, String password) throws SQLException {
		userDao.insertUser(username, password);	
	}

}
