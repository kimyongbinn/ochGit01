package och01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Add3
 */
@WebServlet("/Add3")
public class Add3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Add3() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */									// 요청 받는 객체				화면에 보여주는 객체		
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("doGet 여기왔네");
		//parameter 받기 
		int num = Integer.parseInt(request.getParameter("num"));
		// html에서는 text 타입으로 받기 때문에 int형으로 바꿈
		String loc = request.getParameter("loc");
		System.out.println("num -> " + num);
		System.out.println("loc -> " + loc);
		// 목표 : 1부터 누적값 전달
		int sum = 0;
		for(int i=0; i<=num; i++) {
			sum += i;
		}
		System.out.println("sum -> " + sum);
		
		// Encoding 적용
		response.setContentType("text/html;charset=utf-8");
		// get 방식은 request Encoding 안해줘도됨
		//request.setCharacterEncoding("utf-8");
		
		// 공식 --> 사용자 Browser에 보여주는 객체
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.printf("<h1>1부터 %d까지 합계</h1>",num);
		out.printf("<h4>LOC --> %s</h4>",loc);
		out.println(sum);
		out.println("</body></html>");
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		System.out.println("doPost 여기왔네");
		
		// request 받기 전에 코딩해줘야 실행할때 안 깨짐
		// 시기 -> request parameter 받기 전
		request.setCharacterEncoding("utf-8");
		
		int num = Integer.parseInt(request.getParameter("num"));
		// html에서는 text 타입으로 받기 때문에 int형으로 바꿈
		String loc = request.getParameter("loc");
		System.out.println("num -> " + num);
		System.out.println("loc -> " + loc);
		// 목표 : 1부터 누적값 전달
		int sum = 0;
		for(int i=0; i<=num; i++) {
			sum += i;
		}
		System.out.println("sum -> " + sum);
		
		// Encoding 적용
		response.setContentType("text/html;charset=utf-8");
		
		// 공식 --> 사용자 Browser에 보여주는 객체
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.printf("<h1>1부터 %d까지 Post 합계</h1>",num);
		out.printf("<h4>LOC --> %s</h4>",loc);
		out.println(sum);
		out.println("</body></html>");
		out.close();

	}

}
