package by.iba.requestApp.service;

import java.sql.SQLException;

import org.springframework.transaction.annotation.Transactional;

public interface UserService {
	public boolean isValidUser(String username, String password) throws SQLException;
	public boolean insertUser(String username, String password) throws SQLException;
	public String getUserRole(String username, String password);
	public String getUserRoleById(int id);
	public int getUserIdByName(String username, String password);
}
