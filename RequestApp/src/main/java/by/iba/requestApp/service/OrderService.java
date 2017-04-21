package by.iba.requestApp.service;

import java.sql.SQLException;

import by.iba.requestApp.viewBean.RequestBean;

public interface OrderService {
	
	public boolean insertOrder(RequestBean rb) throws SQLException;
}
