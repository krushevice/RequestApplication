package by.iba.requestApp.service;

import java.sql.SQLException;
import java.util.List;

import by.iba.requestApp.viewBean.StageBean;

public interface StageService {
	
	public List<StageBean>selectOrderStages(int orderId) throws SQLException;	
	public List<StageBean> selectAllOrdersStages() throws SQLException;
	public void updateOrderStage(int orderId, int stage);
	public void updateOrderStage(StageBean stageBean);
	public boolean isComplete(int orderId);
	public void finishOrder(int orderId);
}
