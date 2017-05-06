package by.iba.requestApp.daoImpl;

import java.sql.SQLException;
import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import by.iba.requestApp.dao.UserDao;
import by.iba.requestApp.viewBean.LoginBean;

@Repository
public class UserDaoImpl implements UserDao {
	
	@Autowired
	private SessionFactory sessionFactory; 

	public boolean isValidUser(String username, String password) throws SQLException {

		boolean inTransaction = TransactionSynchronizationManager.isActualTransactionActive();
		System.out.println("tran = " + inTransaction);
		Session session = sessionFactory.getCurrentSession();
	Transaction tx = session.beginTransaction();
	    Query query = session.createQuery("from LoginBean where username = :username and password = :password");
		query.setParameter("username", username);
		query.setParameter("password", password);
		List list = query.list();
		System.out.println("list = " + list);
	tx.commit();
		session.close();
		if(list.size()>0){
			return true;
		}

		return false;
	}

	public boolean insertUser(String username, String password) throws SQLException {

		Session session = sessionFactory.getCurrentSession();
	Transaction tx = session.beginTransaction();
	    int id = lastId(session)+1;
	    LoginBean lb = new LoginBean();
	    if(id>0){
	    	lb.setId(id);
		    lb.setUsername(username);
		    lb.setPassword(password);
		    lb.setRole("user");
		    session.save(lb);
	tx.commit();
	    }else{
	    	tx.rollback();
	    }

	    return true;
		
	}
	
	public int lastId(Session session) throws SQLException{
		String querySQL = "select max(id) from LoginBean";
		Query query = session.createQuery(querySQL);
		List list = query.list();
		if(list.size()>0){
			return (Integer) list.get(0);
		}
		return -1;
	}

	@Override
	public String getUserRole(String username, String password) {

		Session session = sessionFactory.getCurrentSession();
	Transaction tx = session.beginTransaction();
	    Query query = session.createQuery("select role from LoginBean where username = :username and password = :password");
		query.setParameter("username", username);
		query.setParameter("password", password);
		List list = query.list();
	tx.commit();
		session.close();
		if(list.size()>0){
			return (String) list.get(0);
		}

		return "";
	}
	
	public String getUserId(String username, String password) {

		Session session = sessionFactory.getCurrentSession();
	Transaction tx = session.beginTransaction();
	    Query query = session.createQuery("select id from LoginBean where username = :username and password = :password");
		query.setParameter("username", username);
		query.setParameter("password", password);
		List list = query.list();
	tx.commit();
		session.close();
		if(list.size()>0){
			return (String) list.get(0);
		}

		return "";
	}

	@Override
	public String getUserRoleById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		    Query query = session.createQuery("select role from LoginBean where id = :id");
			query.setParameter("id", id);
			List list = query.list();
		tx.commit();
			session.close();
			if(list.size()>0){
				return (String) list.get(0);
			}
			return "";
	}

	@Override
	public int getUserIdByName(String username, String password) {

			Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		    Query query = session.createQuery("select id from LoginBean where username = :username and password = :password");
			query.setParameter("username", username);
			query.setParameter("password", password);
			List list = query.list();
		tx.commit();
			session.close();
			if(list.size()>0){
				return (Integer) list.get(0);
			}

			return 0;
	}

}
