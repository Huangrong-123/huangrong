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
		
	      //1.��ȡҪ���ص��ļ��ľ���·��
		String path = request.getServletContext().getRealPath("/down/hello");
	       //2.��ȡҪ���ص��ļ���
		String flieName = path.substring(path.lastIndexOf("\\")+1);
		System.out.println(flieName);
		//3.����content-disposition��Ӧͷ��������������ص���ʽ���ļ�
		//����content-disposition��Ӧͷ�������������������ʽ�򿪣�����ע���ļ��ַ��������ʽ������utf-8����Ȼ���������
		response.setHeader("content-disposition", "attachment;filename="+URLEncoder.encode(flieName,"UTF-8"));
		//4.��ȡҪ���ص��ļ�������
	    //�ַ���������FileReader in = new FileReader(path);
		InputStream  in =new FileInputStream(path);
		int len =0;
		//5.�������ݻ�����
		byte[] buffer = new byte[1024];
		//6.ͨ��response�����ȡOutputStream��
		//��д�ļ����ع���ʱ�Ƽ�ʹ��OutputStream��������ʹ��Printwriter��
		//��ΪOutputStream�����ֽ��������Դ����������͵�����
		//��Printwriter�����ַ�����ֻ�ܴ����ַ����ݣ�����ַ��������ֽ����ݣ��ᵼ��������ʧ
		//�ַ���д������Printwriter out=response��getWriter������
		ServletOutputStream outputStream = response.getOutputStream();
		//7.��FileInputstream��д�뵽buffer������
		while ((len=in.read(buffer))!=-1) {
			//8.ʹ��OutputStream��������������������ͻ��������
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
