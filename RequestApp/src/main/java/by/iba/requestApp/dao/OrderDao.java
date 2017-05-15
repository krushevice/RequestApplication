package by.iba.requestApp.dao;

import java.sql.SQLException;
import java.util.List;

import by.iba.requestApp.viewBean.OrderBean;
import by.iba.requestApp.viewBean.RequestBean;
import by.iba.requestApp.viewBean.StageBean;

public interface OrderDao {

	public boolean insertOrder(RequestBean rb) throws SQLException;
	
	public List<OrderBean> selectAllOrders() throws SQLException;

	public List<OrderBean> selectOrdersByUserId(int id);

	public boolean insertOrderStages(RequestBean rb);

	StageBean getOrderStages(RequestBean rb);

	public void deleteOrder(int orderId);

}
