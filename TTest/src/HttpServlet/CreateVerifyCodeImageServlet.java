package HttpServlet;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/CreateVerifyCodeImageServlet")
public class CreateVerifyCodeImageServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//       
//  
//    public CreateVerifyCodeImageServlet() {
//        super();
//    
//    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CreateVerificationCodeImage c=new CreateVerificationCodeImage();
		String vCode=c.createCode();
		HttpSession session=request.getSession();
		session.setAttribute("verifyCode", vCode);
		System.out.println(vCode);
		response.setContentType("img/jpg");
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		BufferedImage image=c.CreateImage(vCode);
		ServletOutputStream out=response.getOutputStream();
		ImageIO.write(image, "JPG", out);
		out.flush();
		out.close();
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
