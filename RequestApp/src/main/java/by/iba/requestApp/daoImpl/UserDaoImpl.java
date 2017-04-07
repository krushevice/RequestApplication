package by.iba.requestApp.daoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;
import by.iba.requestApp.dao.UserDao;

public class UserDaoImpl implements UserDao {

	DataSource dataSource;

	public DataSource getDataSource() {
		return this.dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public boolean isValidUser(String username, String password) throws SQLException {
		
		  String query = "Select count(1) from user where username = ? and password = ?";
		  PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
		  pstmt.setString(1, username); 
		  pstmt.setString(2, password); 
		  ResultSet resultSet = pstmt.executeQuery(); 
		  if(resultSet.next()) 
			  return (resultSet.getInt(1) > 0); 
		  else 
			  return false;
		 
		/*if (username.equals("admin") && password.equals("135")) {
			return true;
		} else {
			return false;
		}*/
	}

	@Override
	public boolean insertUser(String username, String password) throws SQLException {

		try {
			String query = "insert into user values(?,?,?)";
			PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
			//тут достать последний id в таблице
			pstmt.setString(1, ""); 
			pstmt.setString(2, username); 
			pstmt.setString(3, password);
			pstmt.execute();
			return true;
		} catch (Exception e) {
			return false;
		} 
		
	}

}
