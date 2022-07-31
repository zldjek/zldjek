package svc;

import java.sql.*;
import static db.JdbcUtil.*;
import dao.*;
import vo.*;

public class MyInfoService {
	
	public MypageDTO getMyInfo(String id) {
		
		Connection con = getConnection();
		MypageDAO userDAO = MypageDAO.getInstance();
		userDAO.setConnection(con);
		MypageDTO user = userDAO.selectMyInfo("Id");
		close(con);
		return user;
	}
}
