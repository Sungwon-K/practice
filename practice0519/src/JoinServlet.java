

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class JoinServlet
 */
@WebServlet("/JoinServlet")
public class JoinServlet extends HttpServlet {	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JoinServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String pw = request.getParameter("pw");
		String email = request.getParameter("email");
		String emailYN = request.getParameter("emailYN");
		String job = request.getParameter("job");
		String introduce = request.getParameter("introduce");
		String picture = request.getParameter("picture");
		
		PrintWriter out = response.getWriter();
		out.println("id : "+id);
		out.println("<br>name : "+name);
		out.println("<br>pw : "+pw);
		out.println("<br>email : "+email);
		if(emailYN==null) {
			out.println("<br>이메일 수신 여부 : 선택사항 없음");
		}else {
			out.println("<br>이메일 수신 여부 : "+emailYN);
		}
		
		String hobbys[] = request.getParameterValues("hobby");
		out.print("<br>취미 : ");
		if(hobbys==null) {
			out.println("선택사항 없음");
		}else {
			for(String hobby : hobbys) {
				out.println(hobby + " ");
			}
		}		
	
		out.println("<br>직업 : "+job);		
		out.println("<br>자기소개 : "+ introduce);
		
		out.println("<br>"+picture);
		
		out.println("<br><a href = 'javascript:history.back()'>이전</a>");
	}

}
