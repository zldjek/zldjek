package dao;

import java.sql.*;
import java.util.*;
import javax.naming.*;
import javax.sql.*;
import static db.JdbcUtil.*;
import vo.*;

public class MypageDAO {
	public static MypageDAO instance;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	private MypageDAO() {}
	
	public static MypageDAO getInstance() {
		if(instance == null){
			instance = new MypageDAO();
		}
		return instance;
	}
	public void setConnection(Connection con) {
		this.con = con;
	}
	public MypageDTO selectMyInfo(String id) {
		
		MypageDTO mb = null;
		
		try  {
			String sql = "SELECT * FROM user_info WHERE id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
				if(rs.next()) {
					mb=new MypageDTO();
					mb.setId(rs.getString("id"));
					mb.setName(rs.getString("name"));
					mb.setPasswd(rs.getString("passwd"));
					mb.setAddress(rs.getString("address"));
					mb.setPhone(rs.getString("phone"));
					mb.setEmail(rs.getString("email"));
					
					System.out.println("회원정보저장완료!");
				}
				System.out.println("SQL구문실행완료!");
			} catch(Exception e) {
				System.out.println("selectMyInfo 에러: " + e.getMessage());			
			} finally {
				close(rs);
				close(pstmt);
		}
		
		return mb;
	}
	public int updateMyInfo(MypageDTO member) {
		
		int insertCount = 0;
		
		try {
			String sql="INSERT INTO MEMBER1 VALUES (?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getName());
			pstmt.setString(3, member.getPasswd());
			pstmt.setString(4, member.getAddress());
			pstmt.setString(5, member.getPhone());
			pstmt.setString(6, member.getEmail());
			
			insertCount = pstmt.executeUpdate();
			
		} catch(Exception e) {
			System.out.println("joinMember 에러: " + e.getMessage());			
		} finally {
			close(pstmt);
		}
		
		return insertCount;
	}
	public int deleteMyInfo(String id) {
		int deleteCount = 0;

		try {
			String sql = "DELETE user_info WHERE id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			
			deleteCount = pstmt.executeUpdate();
		} catch(Exception e) {
			System.out.println("deleteMember 에러: " + e.getMessage());	
		} finally {
			close(pstmt);
		}
		
		return deleteCount;
	}
}
