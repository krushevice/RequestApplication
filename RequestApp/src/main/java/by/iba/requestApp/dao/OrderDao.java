package by.iba.requestApp.dao;

import java.sql.SQLException;

import by.iba.requestApp.viewBean.RequestBean;

public interface OrderDao {

	public boolean insertOrder(RequestBean rb) throws SQLException;

}
