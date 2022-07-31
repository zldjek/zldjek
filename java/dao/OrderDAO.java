package dao;

import static db.JdbcUtil.close;

import java.sql.*;
import java.sql.Date;
import java.util.*;

import vo.*;

public class OrderDAO {
	public static OrderDAO instance;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	private OrderDAO() {}
	
	public static OrderDAO getInstance() {
		if(instance == null){
			instance = new OrderDAO();
		}
		return instance;
	}
	public void setConnection(Connection con) {
		this.con = con;
	}
	public OrderDTO selectOrderInfo(String num) {
		
		OrderDTO order = null;
		
		try  {
			String sql = "SELECT * FROM order_info WHERE num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, num);
			
			rs = pstmt.executeQuery();
				if(rs.next()) {
					order=new OrderDTO();
					order.setNum(rs.getInt("num"));
					order.setName(rs.getString("name"));
					order.setPrice(rs.getString("passwd"));
					order.setQuan(rs.getString("address"));
					order.setFile(rs.getString("phone"));
					order.setContent(rs.getString("email"));
					order.setDate(rs.getDate("date"));
					
					System.out.println("회원정보저장완료!");
				}
				System.out.println("SQL구문실행완료!");
			} catch(Exception e) {
				System.out.println("selectOrderInfo 에러: " + e.getMessage());			
			} finally {
				close(rs);
				close(pstmt);
		}
		
		return order;
	}
	public int updateOrderInfo(OrderDTO order) {
		
		int insertCount = 0;
		
		try {
			String sql="INSERT INTO order_info VALUES (?,?,?,?,?,?,now())";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, order.getNum());
			pstmt.setString(2, order.getName());
			pstmt.setString(3, order.getPrice());
			pstmt.setString(4, order.getQuan());
			pstmt.setString(5, order.getFile());
			pstmt.setString(6, order.getContent());
			pstmt.setDate(7, (Date)order.getDate());
			
			insertCount = pstmt.executeUpdate();
			
		} catch(Exception e) {
			System.out.println("joinorder 에러: " + e.getMessage());			
		} finally {
			close(pstmt);
		}
		
		return insertCount;
	}
	public int cancelOrder(String num) {
		int cancelCount = 0;

		try {
			String sql = "DELETE Order_info WHERE num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, num);
			
			cancelCount = pstmt.executeUpdate();
		} catch(Exception e) {
			System.out.println("deleteorder 에러: " + e.getMessage());	
		} finally {
			close(pstmt);
		}
		
		return cancelCount;
	}

	public ArrayList<OrderDTO> selectOrderList() {
		ArrayList<OrderDTO> orderList=new ArrayList<OrderDTO>();
		OrderDTO order = null;

		try{
			String sql="SELECT * FROM order_info";
			pstmt=con.prepareStatement(sql);
			
			if(rs.next()){
				order=new OrderDTO();
				order.setNum(rs.getInt("num"));
				order.setName(rs.getString("name"));
				order.setPrice(rs.getString("price"));
				order.setFile(rs.getString("file"));
				order.setContent(rs.getString("content"));
				order.setQuan(rs.getString("quan"));
				order.setDate(rs.getDate("date"));
				orderList.add(order);
			}
			rs=pstmt.executeQuery();
		}catch(Exception e){
			System.out.println("orderList 에러: " + e.getMessage());			
		}finally{
			close(rs);
			close(pstmt);
		}
		return orderList;
	}

	public int insertOrder(OrderDTO order) {
		String sql="INSERT INTO MEMBER1 VALUES (?,?,?,?,?,?)";
		int insertCount=0;
		
		try{
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, order.getNum());
			pstmt.setString(2, order.getName());
			pstmt.setString(3, order.getPrice());
			pstmt.setString(4, order.getQuan());
			pstmt.setString(5, order.getFile());
			pstmt.setString(6, order.getContent());
			pstmt.setDate(7, (Date)order.getDate());
			insertCount=pstmt.executeUpdate();
			
		}catch(Exception e){
			System.out.println("insertOrder 에러: " + e.getMessage());			
		}finally{
			close(pstmt);
		}
		
		return insertCount;
	}
}