package svc;

import java.sql.*;
import static db.JdbcUtil.*;
import dao.*;
import vo.*;

public class MyInfoUpdateService {
	public boolean myInfo(MypageDTO myInfo) {
		boolean updateSuccess = false;
		MypageDAO userDAO = MypageDAO.getInstance();
		Connection con = getConnection();
		userDAO.setConnection(con);
		int update = userDAO.updateMyInfo(myInfo);
		if(update > 0){
			updateSuccess = true;
			commit(con);
		}
		else{
			rollback(con);
		}
		close(con);
		return updateSuccess;
	}

}

