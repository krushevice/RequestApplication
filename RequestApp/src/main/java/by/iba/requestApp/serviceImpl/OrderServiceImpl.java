package by.iba.requestApp.serviceImpl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.iba.requestApp.dao.OrderDao;
import by.iba.requestApp.service.OrderService;
import by.iba.requestApp.viewBean.RequestBean;

@Service
public class OrderServiceImpl implements OrderService{
	@Autowired
	private OrderDao orderDao;

	@Override
	public boolean insertOrder(RequestBean rb) throws SQLException {
		return orderDao.insertOrder(rb);	
	}
	
	public List<RequestBean> selectAllOrders() throws SQLException {
		return orderDao.selectAllOrders();
	}
}
