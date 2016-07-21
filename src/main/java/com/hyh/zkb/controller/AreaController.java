package com.hyh.zkb.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
public class AreaController {

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
		Map<String, Object> map = new HashMap<>();
		if (result == 1) {
			map.put(Constants.F_STATUS, Constants.OK);
		} else {
			map.put(Constants.F_STATUS, Constants.FAILED);
		}
		return JSON.toJSONString(map);
	}

	@ResponseBody
	@RequestMapping("/selectAreaByLevel")
	@OperationLogger(id = "areaController.selectAreaByLevel", type = OperationType.SEARCH)
	public String selectAreaByLevel(
			@RequestParam(value = "level", required = false, defaultValue = "2") Integer level) {
		List<Area> result = areaService.selectAreaByLevel(level);
		Map<String, Object> map = new HashMap<>();
		if (result == null || result.size() == 0) {
			map.put(Constants.F_STATUS, Constants.FAILED);
		} else {
			map.put(Constants.F_RESULT, Constants.OK);
		}
		map.put(Constants.F_RESULT, result);
		return JSON.toJSONString(map);
	}

	@ResponseBody
	@RequestMapping("/selectParentArea")
	@OperationLogger(id = "areaController.selectParentArea", type = OperationType.SEARCH)
	public String selectParentArea(@RequestParam(value = "id", required = false, defaultValue = "1") Integer id) {
		Area result = areaService.selectParentArea(id);
		Map<String, Object> map = new HashMap<>();
		if (result == null) {
			map.put(Constants.F_STATUS, Constants.FAILED);
		} else {
			map.put(Constants.F_STATUS, Constants.OK);
		}
		map.put(Constants.F_RESULT, result);
		return JSON.toJSONString(map);
	}

	@ResponseBody
	@RequestMapping("/selectChildrenArea")
	@OperationLogger(id = "areaController.selectChildrenArea", type = OperationType.SEARCH)
	public String selectChildrenArea(@RequestParam(value = "id", required = false, defaultValue = "1") Integer id) {
		List<Area> result = areaService.selectChildrenArea(id);
		Map<String, Object> map = new HashMap<>();
		if (result == null || result.size() == 0) {
			map.put(Constants.F_STATUS, Constants.FAILED);
		} else {
			map.put(Constants.F_STATUS, Constants.OK);
		}
		map.put(Constants.F_RESULT, result);
		return JSON.toJSONString(map);
	}

}
