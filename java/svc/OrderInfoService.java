package svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.*;

import dao.*;
import vo.*;

public class OrderInfoService {
	
	public OrderDTO getOrder(String infoNum) {
		Connection con = getConnection();
		OrderDAO orderDAO = OrderDAO.getInstance();
		orderDAO.setConnection(con);
		OrderDTO order = orderDAO.selectOrderInfo("num");
		close(con);
		return order;
	}
}