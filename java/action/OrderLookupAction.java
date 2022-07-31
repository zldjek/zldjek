package action;

import java.io.*;
import java.util.*;

import javax.servlet.http.*;

import svc.*;
import vo.*;

public class OrderLookupAction implements Action {
	
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		HttpSession session=request.getSession();
   		String num=(String)session.getAttribute("num");
   		ActionForward forward = null;
   		if(num==null){
   			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("/orderInfo.bo");
   		}else if(!num.equals("admin")){
   			response.setContentType("text/html;charset=UTF-8");
	   		PrintWriter out=response.getWriter();
	   		out.println("<script>");
	   		out.println("alert('관리자가 아닙니다.');");
	   		out.println("location.href='./memberLogin.me");
	   		out.println("</script>");
   		}
   		else{
   	    forward = new ActionForward();
   	    OrderLookupService orderLookupService = new OrderLookupService();
   		ArrayList<OrderDTO> orderList=orderLookupService.getOrderList();
   		request.setAttribute("orderList", orderList);
   		forward.setPath("./member_list.jsp");
   		}
   		return forward;
	}
}
