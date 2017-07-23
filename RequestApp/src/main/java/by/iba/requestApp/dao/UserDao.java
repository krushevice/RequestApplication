package by.iba.requestApp.dao;

import java.sql.SQLException;

public interface UserDao {
	public boolean isValidUser(String username, String password);
	public boolean insertUser(String username, String password);
	public String getUserRole(String username, String password);
	public String getUserRoleById(int id);
	public int getUserIdByName(String username, String password);
}
