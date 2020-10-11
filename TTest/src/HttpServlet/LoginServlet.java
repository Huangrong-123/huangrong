package HttpServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//       
//    
//    public LoginServlet() {
//        super();
//       
//    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
        response.setContentType("textml; charset=UTF-8");
        
        String uname=request.getParameter("uname");
        String password=request.getParameter("password");
        String vcode	=request.getParameter("vcode");
        HttpSession session = request.getSession();
        String code=(String) session.getAttribute("verifyCode");
        System.out.println(code);
        if(vcode.equals(code)){
            if(uname.equals("admin")){
             	if(password.equals("123")){
    	        	request.getSession().setAttribute("uname", uname);
    	        	request.getRequestDispatcher("main.jsp").forward(request, response);
            	}else {
            		request.setAttribute("text", "抱歉，您输入的密码不正确");
            		request.getRequestDispatcher("error.jsp").forward(request, response);
    			}
            }else{
            	request.setAttribute("text", "抱歉，您输入的用户名不存在");
        		request.getRequestDispatcher("error.jsp").forward(request, response);
            }
        }else{
         	request.setAttribute("text", "抱歉，您输入的验证码不正确");
    		request.getRequestDispatcher("error.jsp").forward(request, response);
   
        }
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
