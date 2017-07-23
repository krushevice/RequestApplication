package by.iba.requestApp.daoImpl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import by.iba.requestApp.dao.OrderDao;
import by.iba.requestApp.viewBean.OrderBean;
import by.iba.requestApp.viewBean.RequestBean;
import by.iba.requestApp.viewBean.StageBean;

@Repository
public class OrderDaoImpl implements OrderDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional(propagation=Propagation.REQUIRED )
	public boolean insertOrder(RequestBean rb) {
		Session session = sessionFactory.openSession();
	    Transaction tx = session.beginTransaction();
		String querySQL = "select max(id) from RequestBean";
		Query query = session.createQuery(querySQL);
		List list = query.list();
		int id = 0;
		if(list.size()>0){
			id = (Integer) list.get(0) + 1;
		}		
	    rb.setId(id);
	    Date date=new Date();
	    SimpleDateFormat spl=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    String d=spl.format(date);

		//date=spl.parse(d);

	    rb.setDate(date);	    
	    session.save(rb);
	    StageBean st = getOrderStages(rb);
	    session.save(st);
	    tx.commit();
	    session.close();
	    return true;
	}
	
	public boolean selectOrder(RequestBean rb) {
		Session session = sessionFactory.openSession();		
	    Transaction tx = session.beginTransaction();	    
	    int id=-1;
		String querySQL = "select max(id) from RequestBean";
		Query query = session.createQuery(querySQL);
		List list = query.list();
		if(list.size()>0){
			id = (Integer) list.get(0) + 1;
		}		
	    rb.setId(id);
	    session.save(rb);
	    tx.commit();
	    session.close();
	    return true;
	}
	
	@Override
	public List<OrderBean> selectAllOrders(){		
		Session session = sessionFactory.openSession();		
		Transaction tx = session.beginTransaction();		
		List<OrderBean> requestsList = (List<OrderBean>)session.createQuery("from OrderBean").list();
        for(OrderBean s: requestsList){
            //System.out.println("Details : " + s);
        }
		tx.commit();
		session.close();
		return requestsList;
	}
	/*public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}*/

	@Override
	public List<OrderBean> selectOrdersByUserId(int id) {
		Session session = sessionFactory.openSession();		
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("from OrderBean where user_id =:id");
		query.setParameter("id", id);
		List list = query.list();
		tx.commit();
		session.close();
		return list;
	}

	@Override
	public StageBean getOrderStages(RequestBean rb) {
		StageBean st = new StageBean();
		st.setOrderId(rb.getId());
		st.setStageOne(1);
		if (rb.getCount()>10 || rb.getPrice()>100){
			st.setStageTwo(1);
		}
		if (rb.getCount()>100 || rb.getPrice()>1000){
			st.setStageThree(1);
		}
		return st;
	}

	@Override
	public boolean insertOrderStages(RequestBean rb) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void deleteOrder(int orderId) {		
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();    
		Query query = session.createQuery("delete OrderBean where id = :id");
		query.setParameter("id", orderId);
		int result = query.executeUpdate();
		query = session.createQuery("delete StageBean where id = :id");
		query.setParameter("id", orderId);
		int result2 = query.executeUpdate();		
		if(result!=1 || result2!=1){
			tx.rollback();
		}else{		
			tx.commit();
		}
		session.close();
	}
}
