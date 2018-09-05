package com.igeek.ssm.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class UserInterceptor implements HandlerInterceptor {

	// 最后执行，在执行了controller方法之后，而且ModelAndView返回之后执行
	// 处理异常，日志记录
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
	}

	// 在controller方法执行后，生成ModelAndView后，在返回ModeAndView前，执行
	// 实现每个页面都要展示的公告信息，因为可以拿到返回之前的ModelAndView，直接写入数据即可
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	// 前置执行，在进入controller之前就执行，返回值是Boolean型，作用是是否放行
	// 如果是true，就是放行，往下执行controller方法了。如果是false，就拦截
	// 登录拦截，权限拦截
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		// 获取用户的登录信息
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");

		// 判断用户是否登录
		if (username == null) {
			// 如果为空则跳转到登录页面
			response.sendRedirect("/SpringMVC02-study/user/toLogin.action");
			// 拦截
			return false;
		}

		// 如果不为空则放行
		return true;
	}

}
