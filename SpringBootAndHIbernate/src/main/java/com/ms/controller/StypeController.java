package com.ms.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonArrayFormatVisitor;
import com.ms.pojo.Stype;
import com.ms.service.StypeService;

@Controller
@EnableAutoConfiguration
public class StypeController {
	
	@Autowired
	StypeService stypeSerivce;
	
	@ResponseBody
	@RequestMapping("/queryStypeByTypeId")
	public void queryStypeByTypeId(int typeId,HttpServletResponse response) throws IOException{
		List<Stype> slist=stypeSerivce.queryStypeByTypeId(typeId);
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");  
		PrintWriter writer=response.getWriter();
	
		JSONArray json=new JSONArray();
		for (Stype stype : slist) {
			JSONObject jo=new JSONObject();
			jo.put("stypeId", stype.getStypeId());
			jo.put("stypeName", stype.getStypeName());
			json.add(jo);
		}
		/*ObjectMapper mapper=new ObjectMapper();
		mapper.writeValueAsString(slist);*/
		/*String str=null;*/
	/*	JSONObject.toJSONString(slist);*/

		writer.print(json);
		writer.flush();
		writer.close();
		/*return slist;*/
	}
	
}
