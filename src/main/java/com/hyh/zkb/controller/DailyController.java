package com.hyh.zkb.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/daily")
@ResponseBody
public class DailyController extends BaseController{
	@RequestMapping("/decideLunch")
	public Map<String,Object> decideTheLunch(Model model){
		resMap = new HashMap<>();
		resMap.put("lunch", "水果色拉");
		return resMap;	
	}
}
