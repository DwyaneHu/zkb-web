package com.hyh.zkb.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/daily")
public class DailyController {
	@RequestMapping("/decideLunch")
	public String decideTheLunch(Model model){
		Map<String,String> map = new HashMap<String,String>();
		map.put("lunch", "水果色拉");
		model.addAttribute("map",map);
		return "daily/decideLunch";	
	}
}
