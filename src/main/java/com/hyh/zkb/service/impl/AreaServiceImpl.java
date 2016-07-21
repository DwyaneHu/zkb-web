package com.hyh.zkb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hyh.zkb.dao.AreaMapper;
import com.hyh.zkb.model.Area;
import com.hyh.zkb.service.IAreaService;

@Service
public class AreaServiceImpl implements IAreaService {

	@Autowired
	private AreaMapper areaMapper;

	public int addArea(Area area) {
		return areaMapper.insertSelective(area);
	}

	public int deleteArea(int id) {
		return areaMapper.deleteByPrimaryKey(id);
	}

	public Area selectAreaById(int id) {
		return areaMapper.selectByPrimaryKey(id);
	}

	public Area selectParentArea(int id) {
		return areaMapper.selectParentArea(id);
	}

	public List<Area> selectAreaByLevel(int level) {
		return areaMapper.selectAreaByLevel(level);
	}

	public List<Area> selectChildrenArea(int id) {
		return areaMapper.selectChildrenArea(id);
	}

}
