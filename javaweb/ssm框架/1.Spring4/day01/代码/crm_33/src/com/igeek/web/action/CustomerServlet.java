package com.igeek.web.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.igeek.domain.Customer;
import com.igeek.service.CustomerService;

/**
 * Servlet implementation class CustomerServlet
 */
public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getParameter("method");
		if(method!= null && method.equals("addsubmit")){
			Customer customer = new Customer();
			
			//保存操作
//			ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
			//工具类
			WebApplicationContext ac = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());

			CustomerService cs = (CustomerService) ac.getBean("customerService");
			cs.save(customer);
			
		}
	}

}
