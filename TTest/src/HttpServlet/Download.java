package HttpServlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Download")
public class Download extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//       
//   
//    public Download() {
//        super();
//       
//    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	      //1.获取要下载的文件的绝对路径
		String path = request.getServletContext().getRealPath("/down/hello");
	       //2.获取要下载的文件名
		String flieName = path.substring(path.lastIndexOf("\\")+1);
		System.out.println(flieName);
		//3.设置content-disposition响应头控制浏览器以下载的形式打开文件
		//设置content-disposition响应头，控制浏览器以下载形式打开，这里注意文件字符集编码格式，设置utf-8，不然会出现乱码
		response.setHeader("content-disposition", "attachment;filename="+URLEncoder.encode(flieName,"UTF-8"));
		//4.获取要下载的文件输入流
	    //字符流输入流FileReader in = new FileReader(path);
		InputStream  in =new FileInputStream(path);
		int len =0;
		//5.创建数据缓冲区
		byte[] buffer = new byte[1024];
		//6.通过response对象获取OutputStream流
		//编写文件下载功能时推荐使用OutputStream流，避免使用Printwriter流
		//因为OutputStream流是字节流，可以处理任意类型的数据
		//而Printwriter流是字符流，只能处理字符数据，如果字符流处理字节数据，会导致数据流失
		//字符流写入流：Printwriter out=response。getWriter（）；
		ServletOutputStream outputStream = response.getOutputStream();
		//7.将FileInputstream流写入到buffer缓冲区
		while ((len=in.read(buffer))!=-1) {
			//8.使用OutputStream将缓冲区的数据输出到客户端浏览器
			outputStream.write(buffer,0,len);
		}
		in.close();
		outputStream.close();
	
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
