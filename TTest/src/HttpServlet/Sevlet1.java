package HttpServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Sevlet1")
public class Sevlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
//    public Sevlet1() {
//        super();
//        
//    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setIntHeader("Refresh", 5);
		response.setContentType("text/html;charset=UTF-8");
		Date tasktime=new Date();
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String nowTime=df.format(tasktime);
		PrintWriter out=response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>自动刷新</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<p>当前时间："+nowTime+"</p>");
		out.println("</body>");
		out.println("<html>");
		out.flush();
		out.close();
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
