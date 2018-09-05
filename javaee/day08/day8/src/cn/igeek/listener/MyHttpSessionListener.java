package cn.igeek.listener;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class MyHttpSessionListener
 *
 */
@WebListener
public class MyHttpSessionListener implements HttpSessionListener {

    /**
     * Default constructor. 
     */
    public MyHttpSessionListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent arg0)  { 
         System.out.println("----------sessionCreated------------");
         ServletContext context = arg0.getSession().getServletContext();
 		// 获取里面的在线人数
 		Integer onlineNum = (Integer) context.getAttribute("onLineNum");
 		onlineNum = onlineNum + 1;
 		context.setAttribute("onLineNum", onlineNum);

    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent arg0)  { 
         // TODO Auto-generated method stub
    	System.out.println("----------sessionDestroyed------------");
    	ServletContext context = arg0.getSession().getServletContext();
 		// 获取里面的在线人数
 		Integer onlineNum = (Integer) context.getAttribute("onLineNum");
 		onlineNum = onlineNum - 1;
 		context.setAttribute("onLineNum", onlineNum);
    }
	
}
