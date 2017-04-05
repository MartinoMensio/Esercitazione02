package it.polito.ai.lab2;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.Filter;
import javax.servlet.annotation.WebFilter;

import org.hibernate.*;

@WebFilter("/*")
public class HibernateSessionRequestFilter implements Filter {

	private SessionFactory sf = HibernateUtil.getSessionFactory();

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		Session s = sf.getCurrentSession();
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			request.setAttribute("session", s);
			chain.doFilter(request, response);
			tx.commit();
		} catch (Throwable ex) {
			if (tx != null)
				tx.rollback();
			throw new ServletException(ex);
		} finally {
			if (s != null && s.isOpen())
				s.close();
			s = null;
		}

	}

	public void destroy() {
	}

	public void init(FilterConfig filterConfig) throws ServletException {
	}

}
