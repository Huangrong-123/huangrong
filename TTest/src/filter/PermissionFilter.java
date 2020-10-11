package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class PermissionFilter
 */
@WebFilter("/PermissionFilter")
public class PermissionFilter implements Filter {
	private String notCheckPath; 

   
    public PermissionFilter() {
        // TODO Auto-generated constructor stub
    }

	
	public void destroy() {
		
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request =(HttpServletRequest)req;
		String path = request.getServletPath();
		System.out.println("�����ַuri��"+path);
		if (notCheckPath.indexOf(path)==-1) {
			HttpSession session =request.getSession();
			System.out.println("role:"+session.getAttribute("role"));
			if (session.getAttribute("role").equals("2")) {
				request.setAttribute("text", "û�з���Ȩ��");
				request.getRequestDispatcher("login/error.jsp").forward(request, resp);
			}else {
				chain.doFilter(req, resp);
				System.out.println("ͨ����֤��");
			}
		}else {
			chain.doFilter(req, resp);
			System.out.println("��ַ����Ҫ����");
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
