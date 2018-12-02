package com.jung.listener;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import com.jung.entity.LoginCache;
/**
 * 
 * @author jung
 *
 */
@WebListener
public class sessionAttributeListener implements HttpSessionAttributeListener {
	
	private final String LOGIN_SESSION = "userID"; //登录成功后的id
	
    public void attributeAdded(HttpSessionBindingEvent event)  { 
         if(event.getName().equals(LOGIN_SESSION)) {
        	 String name = (String)event.getValue();
        	 HttpSession  httpSession = event.getSession();
        	 String sessionId = httpSession.getId();
        	 
        	 String tempSessionId = LoginCache.getLoginCacheInstance().getSessionIdByUserName(name);
        	 if(tempSessionId!=null) {
        		 HttpSession tempSession = LoginCache.getLoginCacheInstance().getHttpSessionBySessionId(tempSessionId);
        		 tempSession.invalidate();
        	 }
        	 LoginCache.getLoginCacheInstance().setUserNameToSessionId(name,sessionId);
        	 LoginCache.getLoginCacheInstance().setSessionIdToInstance(sessionId, httpSession);
        	 System.out.println("这里执行了");
         }
    }
    public void attributeRemoved(HttpSessionBindingEvent event)  { 
         // TODO Auto-generated method stub
    }

    public void attributeReplaced(HttpSessionBindingEvent event)  { 
         // TODO Auto-generated method stub
    }
	
}
