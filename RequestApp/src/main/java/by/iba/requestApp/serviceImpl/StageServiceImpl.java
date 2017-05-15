package by.iba.requestApp.serviceImpl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.iba.requestApp.dao.StageDao;
import by.iba.requestApp.service.StageService;
import by.iba.requestApp.viewBean.StageBean;

@Service
public class StageServiceImpl implements StageService{
	@Autowired
	private StageDao stageDao;

	@Override
	public List<StageBean> selectOrderStages(int orderId) throws SQLException {
		return stageDao.selectOrderStages(orderId);
	}

	@Override
	public List<StageBean> selectAllOrdersStages() throws SQLException {
		return stageDao.selectAllOrdersStages();
	}

	@Override
	public void updateOrderStage(int orderId, int stage) {
		stageDao.updateOrderStage(orderId, stage);
	}

	@Override
	public void updateOrderStage(StageBean stageBean) {
		stageDao.updateOrderStage(stageBean);
	}

	@Override
	public boolean isComplete(int orderId) {
		return stageDao.isComplete(orderId);
	}

	@Override
	public void finishOrder(int orderId) {
		stageDao.finishOrder(orderId);
	}

}
