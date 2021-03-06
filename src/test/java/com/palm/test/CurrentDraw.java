package com.palm.test;   

import org.apache.log4j.Logger;
import com.alibaba.fastjson.JSON;
import com.jersey.bean.GetDrawInfoReq;
import com.palm.utils.HttpRequestUtils;
import com.palm.zson.Zson;
import com.palm.zson.ZsonResult;

/**     
 * Description: 查询当前期 
 * @author   lingming.zeng  
 * @since    JDK 1.8   
 * Copyright (c) 2016, o2o-lottery All Rights Reserved.         
 */
public class CurrentDraw {
	
	private static Logger logger = Logger.getLogger(CurrentDraw.class);
	private static String currentDraw;
	
	public static String getCurrentDraw(String gameId,String domain) throws Exception {
		logger.info("查询当前期");
		GetDrawInfoReq loginInfo = new GetDrawInfoReq();
		loginInfo.setGameId(gameId);
		//发送查询当前期请求，得到返回的json串
		String response = HttpRequestUtils.httpPost(JSON.toJSONString(loginInfo),domain);
		//解析json中的当前期
		Zson z = new Zson();
		ZsonResult zr = z.parseJson(response);
		currentDraw = zr.getValues("//drawNo").get(0).toString();
		//返回当前期
		return currentDraw;
	}
}
   
