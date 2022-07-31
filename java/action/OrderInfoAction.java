package action;

import java.io.*;

import javax.servlet.http.*;

import svc.*;
import vo.*;

public class OrderInfoAction implements Action{
	public ActionForward execute(HttpServletRequest request,HttpServletResponse response) 
		 	throws Exception{
			 	
			 	HttpSession session = request.getSession();
		   		String num = (String)session.getAttribute("num");
		   		
		   		ActionForward forward = null;
		   		
		   		if(num == null) {
		   			forward = new ActionForward();
					forward.setRedirect(true);
					forward.setPath("orderInfo.bo");
		   		} else if(!num.equals("admin")) {
		   			response.setContentType("text/html;charset=UTF-8");
			   		PrintWriter out = response.getWriter();
			   		out.println("<script>");
			   		out.println("alert('');");
			   		out.println("location.href='orderInfo.bo';");
			   		out.println("</script>");
		   		} else {
		   			forward = new ActionForward();
		   			String infoNum = request.getParameter("num");
		   			OrderInfoService orderInfoService = new OrderInfoService();
		   			OrderDTO order = orderInfoService.getOrder(infoNum);
		   			request.setAttribute("order", order);
		   			forward.setPath("/orderInfo.jsp");
		   		}
		   		return forward;
		}
}

