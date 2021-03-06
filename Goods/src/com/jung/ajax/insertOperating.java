package com.jung.ajax;

import org.json.JSONObject;

import com.jung.entity.Communication;
import com.jung.entity.LostAndFound;
import com.jung.entity.Reply;
import com.jung.sql.UserDAO;

public class insertOperating {
	private insertOperating() {
		
	}
	public static insertOperating getInstance() {
		return new insertOperating();
	}
	public JSONObject doInsert(Object obj) {
		UserDAO userDao =new UserDAO();
		JSONObject jsonObject = null;
		if(obj instanceof Communication) {
			int isTrue = userDao.insetCommunicaiton((Communication)obj);
		
			jsonObject = getResult(isTrue);		
		}
		else if(obj instanceof Reply) {
			int isTrue = userDao.insertReply((Reply)obj);
			jsonObject = getResult(isTrue);				
		}
		else if(obj instanceof LostAndFound) {
			int isTrue = userDao.insertLostAndFound((LostAndFound)obj);
			jsonObject = getResult(isTrue);	
		}else {
			jsonObject = null;
		}
   		System.out.println(jsonObject.toString());
   		return jsonObject;
	}
	public JSONObject getResult(int isTrue) {
		JSONObject jsonObject = null;
		if(isTrue == 1) {
	   		jsonObject = new JSONObject("{result:success}");
		}
		else {
			//System.out.println("fail");
	   		jsonObject = new JSONObject("{result:false}");	
		}
		return jsonObject;
	}
}
