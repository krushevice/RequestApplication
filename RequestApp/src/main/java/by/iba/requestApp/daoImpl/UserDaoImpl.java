package by.iba.requestApp.daoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import by.iba.requestApp.dao.UserDao;
import by.iba.requestApp.viewBean.LoginBean;

public class UserDaoImpl implements UserDao {
	
	SessionFactory sessionFactory = new Configuration()
            .configure() // configures settings from hibernate.cfg.xml
            .buildSessionFactory();

	DataSource dataSource;

	public DataSource getDataSource() {
		return this.dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public boolean isValidUser(String username, String password) throws SQLException {
				
		Session session = sessionFactory.openSession();
	    
	    Query query = session.createQuery("from LoginBean where username = :username and password = :password");
		query.setParameter("username", username);
		query.setParameter("password", password);
		List list = query.list();
		session.close();
		if(list.size()>0){
			return true;
		}

		return false;
				
		  /*String query = "Select count(1) from user where username = ? and password = ?";
		  PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
		  pstmt.setString(1, username); 
		  pstmt.setString(2, password); 
		  ResultSet resultSet = pstmt.executeQuery(); 
		  if(resultSet.next()) 
			  return (resultSet.getInt(1) > 0); 
		  else 
			  return false;*/
		 
		/*if (username.equals("admin") && password.equals("135")) {
			return true;
		} else {
			return false;
		}*/
	}

	@Override
	public boolean insertUser(String username, String password) throws SQLException {
/*		System.out.println("daoImpl insertUser");
		SessionFactory sessionFactory;
	    sessionFactory = new Configuration()
	            .configure() // configures settings from hibernate.cfg.xml
	            .buildSessionFactory();*/

	    Session session = sessionFactory.openSession();
	    Transaction tx = session.beginTransaction();
	    int id = lastId(session)+1;
	   
	    LoginBean lb = new LoginBean();
	    lb.setId(id);
	    lb.setUsername(username);
	    lb.setPassword(password);
	    session.save(lb);
	    tx.commit();
	    session.close();
	    return true;


		/*try {
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
		} */
		
	}
	
	public int lastId(Session session) throws SQLException{
		String querySQL = "select max(id) from LoginBean";
		Query query = session.createQuery(querySQL);
		List list = query.list();
		if(list.size()>0){
			return (Integer) list.get(0);
		}
		return -1;
	
		 /*String query = "Select max(id) from user";
		 PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
		 ResultSet resultSet = pstmt.executeQuery();
		 if(resultSet.next()) {
			 return resultSet.getInt(1); 
		 }
		 else 
			 return -1;*/
	}

}
