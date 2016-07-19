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
		// TODO Auto-generated method stub
		return areaMapper.insertSelective(area);
	}

	public void deleteArea(int id) {
		// TODO Auto-generated method stub

	}

	public Area selectAreaById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Area selectParentArea(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Area> selectAreaByLevel(int level) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Area> selectChildrenArea(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
