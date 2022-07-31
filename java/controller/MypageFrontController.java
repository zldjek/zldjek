package controller;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;

import action.*;
import action.Action;
import vo.*;

@WebServlet("*.bo")
public class MypageFrontController extends HttpServlet {
    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String  RequestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = RequestURI.substring(contextPath.length());
		ActionForward forward = null;
		Action action = null;
		
		if(command.equals("/mypage.bo")) {
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("/mypage.jsp");
		}else if(command.equals("/myInfo.bo")) {
			forward=new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/myInfo.jsp");
		}else if(command.equals("/myInfoUpdate.bo")){
			action = new MyInfoAction();
				try {
					forward = action.execute(request, response);
				} catch(Exception e) {
				  e.printStackTrace();
				}
		}else if(command.equals("/myInfoDelete.bo")){
			action = new MyInfoDeleteAction();
				try{
					forward=action.execute(request, response);
				}catch(Exception e){
					e.printStackTrace();
				}
		}else if(command.equals("/myInfoUpdate.bo")){
			action = new MyInfoUpdateAction();
				try{
					forward=action.execute(request, response);
				}catch(Exception e){
					e.printStackTrace();
				}
		}else if(command.equals("/orderInfo.bo")){
			action = new OrderInfoAction();
				try{
					forward=action.execute(request, response);
				}catch(Exception e){
					e.printStackTrace();
				}
		}else if(command.equals("/orderLookup.bo")){
			action = new OrderLookupAction();
				try{
					forward=action.execute(request, response);
				}catch(Exception e){
					e.printStackTrace();
				}
		}else if(command.equals("/orderCancel.bo")){
			action = new OrderCancelAction();
				try{
					forward=action.execute(request, response);
				}catch(Exception e){
					e.printStackTrace();
				}
		} else if(command.equals("/orderInquiry.bo")){
			action = new OrderInquiryAction();
			try{
				forward=action.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		if(forward != null){
			if(forward.isRedirect()){
				response.sendRedirect(forward.getPath());
			}else{
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}
		}
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doProcess(request,response);
	}

}
