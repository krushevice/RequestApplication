package by.iba.requestApp.serviceImpl;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import by.iba.requestApp.dao.UserDao;
import by.iba.requestApp.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	@Transactional
	public boolean isValidUser(String username, String password) throws SQLException {
		return userDao.isValidUser(username, password);
	}
	@Transactional
	public boolean insertUser(String username, String password) throws SQLException {
		return userDao.insertUser(username, password);	
	}
	@Override
	public String getUserRole(String username, String password) {
		return userDao.getUserRole(username, password);	
	}
	@Override
	public String getUserRoleById(int id) {
		return userDao.getUserRoleById(id);
	}
	@Override
	public int getUserIdByName(String username, String password) {
		return userDao.getUserIdByName(username, password);	
	}

}
