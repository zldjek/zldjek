package action;

import java.io.*;

import javax.servlet.http.*;

import svc.*;
import vo.*;

public class MyInfoUpdateAction implements Action{
	 public ActionForward execute(HttpServletRequest request,HttpServletResponse response) 
			 	throws Exception{
				 
				 	HttpSession session=request.getSession();
			   		MypageDTO myInfo=new MypageDTO();
			   		
			   		myInfo.setId(request.getParameter("id"));
			   		myInfo.setName(request.getParameter("name"));
			   		myInfo.setPasswd(request.getParameter("passwd"));
			   		myInfo.setAddress(request.getParameter("address"));
			   		myInfo.setPhone(request.getParameter("phone"));
			   		myInfo.setEmail(request.getParameter("email"));
			   		
			   		MyInfoUpdateService userUpdateService = new MyInfoUpdateService();
			   		boolean updateResult = userUpdateService.myInfo(myInfo);
			   		ActionForward forward = null;
			   		if(updateResult){
			   	    forward = new ActionForward();
			   		session.setAttribute("id", myInfo.getId());
			   		forward.setRedirect(true);
			   		forward.setPath("/myInfoUpdateAction.bo");
			   		}
			   		else{
			   			response.setContentType("text/html;charset=UTF-8");
				   		PrintWriter out=response.getWriter();
				   		out.println("<script>");
				   		out.println("alert('내정보 수정실패!');");
				   		out.println("location.href='/myInfoUpdate.bo';");
				   		out.println("</script>");
			   		}
			   		return forward;
			}
		}
