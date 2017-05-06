package by.iba.requestApp.delegate;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import by.iba.requestApp.service.UserService;

@Component
public class LoginDelegate {
	@Autowired
	private UserService userService;

	public boolean isValidUser(String username, String password) throws SQLException {
		return userService.isValidUser(username, password);
	}
	
	public boolean insertUser(String username, String password) throws SQLException {
		return userService.insertUser(username, password);
	}
	
	public String getUserRole(String username, String password) throws SQLException {
		return userService.getUserRole(username, password);
	}
	
	public String getUserRoleById(int id) throws SQLException {
		return userService.getUserRoleById(id);
	}

	public int getUserIdByName(String username, String password) {
		return userService.getUserIdByName(username, password);
	}
}
