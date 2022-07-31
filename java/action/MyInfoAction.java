package action;

import java.io.*;

import javax.servlet.http.*;

import svc.*;
import vo.*;

public class MyInfoAction implements Action{
	 public ActionForward execute(HttpServletRequest request,HttpServletResponse response) 
			 	throws Exception{
				 	
				 	HttpSession session = request.getSession();
			   		String id = (String)session.getAttribute("id");
			   		
			   		ActionForward forward = null;
			   		
			   		if(id == null) {
			   			forward = new ActionForward();
						forward.setRedirect(true);
						forward.setPath("./memberLogin.me");
			   		} else if(!id.equals("admin")) {
			   			response.setContentType("text/html;charset=UTF-8");
				   		PrintWriter out = response.getWriter();
				   		out.println("<script>");
				   		out.println("alert('');");
				   		out.println("location.href='./memberLogin.me';");
				   		out.println("</script>");
			   		} else {
			   			forward = new ActionForward();
			   			String infoId = request.getParameter("id");
			   			MyInfoService myInfoService = new MyInfoService();
			   			MypageDTO myInfo = myInfoService.getMyInfo(infoId);
			   			request.setAttribute("myInfo", myInfo);
			   			forward.setPath("/myInfo.jsp");
			   		}
			   		return forward;
			}
		}

