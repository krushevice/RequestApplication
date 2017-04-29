package by.iba.requestApp.delegate;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import by.iba.requestApp.service.OrderService;
import by.iba.requestApp.viewBean.RequestBean;

@Component
public class OrderDelegate {
	@Autowired
	private OrderService orderService;
	
	public boolean insertOrder(RequestBean rb) throws SQLException {
		return orderService.insertOrder(rb);
	}
	
	public List<RequestBean> selectAllOrders() throws SQLException {
		return orderService.selectAllOrders();
	}
	/*
	public boolean selectAllOrders() throws SQLException {
		return orderService.selectAllOrders();
	}*/
}
