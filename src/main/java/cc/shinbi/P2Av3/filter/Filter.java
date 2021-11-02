package cc.shinbi.P2Av3.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Filter
 */
@WebFilter("/Filter")
public class Filter implements javax.servlet.Filter {

	/**
	* @see HttpServlet#HttpServlet()
	*/
	public Filter() {
		super();
	}

	public void destroy() {
	// TODO Auto-generated method stub
}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// place your code here
		request.setCharacterEncoding("UTF-8");

			// pass the request along the filter chain
		chain.doFilter(request, response);
}

	/**
	* @see Filter#init(FilterConfig)
	*/
	public void init(FilterConfig fConfig) throws ServletException {
	// TODO Auto-generated method stub
	}
}
