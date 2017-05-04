package by.iba.requestApp.daoImpl;

import java.util.ArrayList;
import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import by.iba.requestApp.dao.OrderDao;
import by.iba.requestApp.viewBean.RequestBean;

@Repository
public class OrderDaoImpl implements OrderDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional(propagation=Propagation.REQUIRED )
	public boolean insertOrder(RequestBean rb) {

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
	    System.out.println("rb="+rb);
	    session.save(rb);
	    System.out.println("end");
	  
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
	    System.out.println("rb="+rb);
	    session.save(rb);
	    System.out.println("end");
	  
	    //session.flush();
	    tx.commit();
	    session.close();
	    return true;
	}
	
	
	public List<RequestBean> selectAllOrders(){
		
		Session session = sessionFactory.openSession();		
		Transaction tx = session.beginTransaction();
		
		/*String querySQL = "from RequestBean";*/
		/*String querySQL = "select a.id, a.product_id, b.name, a.product_type, c.product_type_name, a.count, a.price "
				+ "from orders a "
				+ "join product_name b on a.product_id = b.id "
				+ "join product_type c on a.product_id=c.product_id and a.product_type=c.product_type";*/
		Query query = session.createQuery("from RequestBean");
		List list = query.list();
		tx.commit();
		session.close();
		return list;
	}
	/*public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}*/
	
	
	/*DataSource dataSource;

	public DataSource getDataSource() {
		return this.dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}*/
	
	/*public boolean insertOrder(String product, String productType, int count, int price) {
		System.out.println("start");
		Session session = sessionFactory.openSession();
	    Transaction tx = session.beginTransaction();
	    int id = 1;
	    System.out.println("start tran");
	    RequestBean lb = new RequestBean();
	    lb.setId(id);
	    lb.setProduct(productType);
	    lb.setProductType(productType);
	    lb.setCount(count);
	    lb.setPrice(price);
	    session.save(lb);
	    System.out.println("end tran");
	    tx.commit();
	    session.close();
	    System.out.println("end");
	    return true;
	}*/

}
