package com.hyh.zkb.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.hyh.zkb.aop.log.OperationLogger;
import com.hyh.zkb.aop.log.OperationLogger.OperationType;
import com.hyh.zkb.common.Constants;
import com.hyh.zkb.model.Area;
import com.hyh.zkb.service.IAreaService;

@Controller
@RequestMapping("/area")
public class AreaController extends BaseController{

	@Autowired
	IAreaService areaService;

	@OperationLogger(id = "areaController.addArea", type = OperationType.ADD)
	@ResponseBody
	@RequestMapping("/addArea")
	public String addArea(@RequestParam(value = "name", required = true) String name,
			@RequestParam(value = "level", required = true) Integer level,
			@RequestParam(value = "parentId", required = true) Integer parentId) {
		Area area = new Area();
		area.setName(name);
		area.setLevel(level);
		area.setParentId(parentId);
		Integer result = areaService.addArea(area);
		resMap = new HashMap<>();
		if (result == 1) {
			resMap.put(Constants.F_STATUS, Constants.OK);
		} else {
			resMap.put(Constants.F_STATUS, Constants.FAILED);
		}
		return JSON.toJSONString(resMap);
	}

	@ResponseBody
	@RequestMapping("/selectAreaByLevel")
	@OperationLogger(id = "areaController.selectAreaByLevel", type = OperationType.SEARCH)
	public String selectAreaByLevel(
			@RequestParam(value = "level", required = false, defaultValue = "2") Integer level) {
		List<Area> result = areaService.selectAreaByLevel(level);
		resMap = new HashMap<>();
		if (result == null || result.size() == 0) {
			resMap.put(Constants.F_STATUS, Constants.FAILED);
		} else {
			resMap.put(Constants.F_RESULT, Constants.OK);
		}
		resMap.put(Constants.F_RESULT, result);
		return JSON.toJSONString(resMap);
	}

	@ResponseBody
	@RequestMapping("/selectParentArea")
	@OperationLogger(id = "areaController.selectParentArea", type = OperationType.SEARCH)
	public String selectParentArea(@RequestParam(value = "id", required = false, defaultValue = "1") Integer id) {
		Area result = areaService.selectParentArea(id);
		resMap = new HashMap<>();
		if (result == null) {
			resMap.put(Constants.F_STATUS, Constants.FAILED);
		} else {
			resMap.put(Constants.F_STATUS, Constants.OK);
		}
		resMap.put(Constants.F_RESULT, result);
		return JSON.toJSONString(resMap);
	}

	@ResponseBody
	@RequestMapping("/selectChildrenArea")
	@OperationLogger(id = "areaController.selectChildrenArea", type = OperationType.SEARCH)
	public String selectChildrenArea(@RequestParam(value = "id", required = false, defaultValue = "1") Integer id) {
		List<Area> result = areaService.selectChildrenArea(id);
		resMap = new HashMap<>();
		if (result == null || result.size() == 0) {
			resMap.put(Constants.F_STATUS, Constants.FAILED);
		} else {
			resMap.put(Constants.F_STATUS, Constants.OK);
		}
		resMap.put(Constants.F_RESULT, result);
		return JSON.toJSONString(resMap);
	}

}
