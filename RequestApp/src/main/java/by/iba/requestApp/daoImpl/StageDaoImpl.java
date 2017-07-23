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
	public List<StageBean> selectOrderStages(int orderId){
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
	public List<StageBean> selectAllOrdersStages(){
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateOrderStage(int orderId, int stage) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
	    session.update("StageBean" );
		tx.commit();
		session.close();

	}

	@Override
	public void updateOrderStage(StageBean stageBean) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
	    session.update(stageBean);//createQuery("from StageBean where id = :id");
	    tx.commit();
		session.close();
	}

	@Override
	public boolean isComplete(int orderId) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
	    Query query = session.createQuery("from StageBean sb where sb.id = :id "
	    		+ "and (sb.stageOne = 1 or sb.stageTwo = 1 or sb.stageThree = 1)");
		query.setParameter("id", orderId);
		List list = query.list();
		tx.commit();
		session.close();		
		if (list.isEmpty()){
			return true;
		}
		return false;
	}

	@Override
	public void finishOrder(int orderId) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("update OrderBean set status = 1" +
				" where id = :id");
		query.setParameter("id", orderId);
		int result = query.executeUpdate();
		if(result!=1){
			tx.rollback();
		}else{
		    tx.commit();
		}
		session.close();
	}

}
