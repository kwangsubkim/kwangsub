package nhndeview;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FakeCounterServlet
 */
public class FakeCounterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static int count = 0;
	static int register = 0;
	static int submit = 0;
	static int complete = 0;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FakeCounterServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init");
	}


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// template.jsp로 포워딩하자	---->	반드시 절대주소가 나와야 한다.(getServletContext)

		//		RequestDispatcher dispatcher = super.getServletContext().getRequestDispatcher("/index.jsp");
		RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
		
		String path = request.getServletPath();
		if (path.equals("/register")) {
			register += 1;
			count +=1;
			setCount(request);
			dispatcher.forward(request, response);
		} else if (path.equals("/submit")) {
			submit += 1;
			count +=1;
			setCount(request);
			dispatcher.forward(request, response);
		} else if (path.equals("/complete")) {
			complete += 1;
			count +=1;
			setCount(request);
			dispatcher.forward(request, response);
		} else if (path.equals("/index")) {
			setCount(request);
			dispatcher.forward(request, response);
		} else if (path.equals("/reset")) {
			count = 0;
			register = 0;
			submit = 0;
			complete = 0;
			setCount(request);
			response.sendRedirect("/index");
		}
		
			
	}
	
	private void setCount(HttpServletRequest request) {
		request.setAttribute("count", count);
		request.setAttribute("register", register);
		request.setAttribute("submit", submit);
		request.setAttribute("complete", complete);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
		IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
		
		String path = request.getServletPath();
		if (path.equals("/submit")) {
			submit += 1;
			count +=1;
		}

		request.setAttribute("count", count);
		request.setAttribute("register", register);
		request.setAttribute("submit", submit);
		request.setAttribute("complete", complete);
		dispatcher.forward(request, response);
	}

}
