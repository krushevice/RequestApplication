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

		//getCurrentSession();
		Session session = sessionFactory.openSession();
		
	  Transaction tx = session.beginTransaction();

		String querySQL = "select max(id) from RequestBean";
		Query query = session.createQuery(querySQL);
		List list = query.list();
		int id = 0;
		if(list.size()>0){
			id = (Integer) list.get(0) + 1;
		}		
	    //System.out.println("id=" + id);
	    rb.setId(id);
	    //Date date = new Date();
	    /*DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    Date date = new Date();
	    System.out.println(dateFormat.format(date));*/
	    /*System.out.println("date = " + new Date(System.currentTimeMillis()));
	    rb.setDate(new Date("2017/01/01 00:00:00"));*/
	    
	    Date date=new Date();
	    SimpleDateFormat spl=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    String d=spl.format(date);
	    try {
			date=spl.parse(d);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    System.out.println("spl = " + spl);
	    System.out.println("date =" + date);
	    rb.setDate(date);
	    
	    session.save(rb);

	    StageBean st = getOrderStages(rb);
	    session.save(st);
	    //session.flush();
	  tx.commit();
	    session.close();
	    return true;
	}
	
	public boolean selectOrder(RequestBean rb) {

		//getCurrentSession();
		Session session = sessionFactory.openSession();
		
	  Transaction tx = session.beginTransaction();
	    
	    int id=-1;
		String querySQL = "select max(id) from RequestBean";
		Query query = session.createQuery(querySQL);
		List list = query.list();
		if(list.size()>0){
			id = (Integer) list.get(0) + 1;
		}		
	    //System.out.println("id=" + id);
	    rb.setId(id);
	    session.save(rb);

	    //session.flush();
	    tx.commit();
	    session.close();
	    return true;
	}
	
	
	public List<OrderBean> selectAllOrders(){
		
		Session session = sessionFactory.openSession();		
		Transaction tx = session.beginTransaction();
		
		/*String querySQL = "select a.id, a.product_id, b.name, a.product_type, c.product_type_name, a.count, a.price "
				+ "from orders a "
				+ "join product_name b on a.product_id = b.id "
				+ "join product_type c on a.product_id=c.product_id and a.product_type=c.product_type";
		Query query = session.createQuery(querySQL);*/
		
		
		
		
		
		/*Query query = session.createQuery("from RequestBean");
		List list = query.list();
		System.out.println("list = " + list);*/
		
		
		
		
		
		
		/*String querySQL = "select a.id, a.product_id, b.name, a.product_type, c.product_type_name, a.count, a.price "
				+ "from orders a "
				+ "join product_name b on a.product_id = b.id "
				+ "join product_type c on a.product_id=c.product_id and a.product_type=c.product_type";
		SQLQuery query = session.createSQLQuery(querySQL);
		List list = query.list();*/
		
		
		/*List<RequestBean> ordersList = session.createQuery("from RequestBean r LEFT JOIN ProductBean p ON r.product_id = p.id").list();

	    for (RequestBean c : ordersList) {
	    	System.out.println("ordersList::" + c);
	    }*/
		
		List<OrderBean> requestsList = (List<OrderBean>)session.createQuery("from OrderBean").list();
        for(OrderBean s: requestsList){
            System.out.println("Details : " + s);
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
		System.out.println("selectOrdersByUserId");
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
		st.setId(rb.getId());
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

}
