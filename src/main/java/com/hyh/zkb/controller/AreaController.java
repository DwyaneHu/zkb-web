package com.hyh.zkb.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hyh.zkb.model.Area;
import com.hyh.zkb.service.IAreaService;


@Controller
@RequestMapping("/area")
public class AreaController{
	
	@Autowired
	IAreaService areaService;
	
	
	@ResponseBody
	@RequestMapping("/addArea")
	public String addArea(@RequestParam(value = "name",required = false) String name,
						  @RequestParam(value = "level",required = false) Integer level,
						  @RequestParam(value = "parentId" , required = false) Integer parentId){
		Area area =new Area();
		System.out.println(name);
		area.setName(name);
		area.setLevel(level);
		area.setParentId(parentId);
		
		Integer result = areaService.addArea(area);
		return result.toString();
	}
	
}
