package com.jung.entity;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

public class LoginCache {
	private static LoginCache loginCache = new LoginCache();
	//通过登录名来获得SessionID
	private Map<String,String> userNameToSessionId = new  HashMap<String,String>();
	//通过SessionID来获得Session对象
	private Map<String,HttpSession> sessionIdToInstance = new HashMap<String,HttpSession>();
	private LoginCache() {
	}
	public static LoginCache getLoginCacheInstance() {
		return loginCache;
	}
	public String getSessionIdByUserName(String userName) {
		return userNameToSessionId.get(userName);
	}
	public HttpSession getHttpSessionBySessionId(String sessionId) {
		return sessionIdToInstance.get(sessionId);
	}
	public void setUserNameToSessionId(String userName,String sessionId) {
		this.userNameToSessionId.put(userName, sessionId);
	}
	public void setSessionIdToInstance(String sessionId,HttpSession session) {
		this.sessionIdToInstance.put(sessionId, session);
	}

	
	
	
}
