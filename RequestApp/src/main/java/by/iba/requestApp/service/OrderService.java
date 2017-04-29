package by.iba.requestApp.service;

import java.sql.SQLException;
import java.util.List;

import by.iba.requestApp.viewBean.RequestBean;

public interface OrderService {
	
	public boolean insertOrder(RequestBean rb) throws SQLException;
	
	public List<RequestBean> selectAllOrders() throws SQLException;
}
