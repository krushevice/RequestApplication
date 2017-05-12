package by.iba.requestApp.daoImpl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import by.iba.requestApp.dao.StageDao;
import by.iba.requestApp.viewBean.StageBean;

@Repository
public class StageDaoImpl implements StageDao{
	
	@Autowired
	private SessionFactory sessionFactory; 

	@Override
	public List<StageBean> selectOrderStages(int orderId) throws SQLException {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
	    Query query = session.createQuery("from StageBean where id = :id");
		query.setParameter("id", orderId);
		List list = query.list();
		tx.commit();
		session.close();

		return list;
	}

	@Override
	public List<StageBean> selectAllOrdersStages() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateOrderStage(int orderId) {
		// TODO Auto-generated method stub
		
	}

}
