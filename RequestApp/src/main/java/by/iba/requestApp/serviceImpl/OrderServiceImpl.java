package by.iba.requestApp.serviceImpl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.iba.requestApp.dao.OrderDao;
import by.iba.requestApp.service.OrderService;
import by.iba.requestApp.viewBean.OrderBean;
import by.iba.requestApp.viewBean.RequestBean;
import by.iba.requestApp.viewBean.StageBean;

@Service
public class OrderServiceImpl implements OrderService{
	@Autowired
	private OrderDao orderDao;

	@Override
	public boolean insertOrder(RequestBean rb) throws SQLException {
		return orderDao.insertOrder(rb);	
	}
	
	public List<OrderBean> selectAllOrders() throws SQLException {
		return orderDao.selectAllOrders();
	}

	@Override
	public List<OrderBean> selectOrdersByUserId(int id) {
		return orderDao.selectOrdersByUserId(id);
	}

	@Override
	public boolean insertOrderStages(RequestBean rb) {
		return orderDao.insertOrderStages(rb);
	}
}
