package by.iba.requestApp.service;

import java.sql.SQLException;

public interface UserService {
	public boolean isValidUser(String username, String password) throws SQLException;
	public boolean insertUser(String username, String password) throws SQLException;
}
