package com.hyh.zkb.service;

import java.util.List;

import com.hyh.zkb.model.Area;

public interface IAreaService {
	
	int addArea(Area area);
	
	void deleteArea(int id);
	
	Area selectAreaById(int id);
	
	/**
	 * 根据id查询父级区域
	 * @param id
	 * @return
	 */
	Area selectParentArea(int id);
	
	/**
	 * 查询指定level的区域
	 * @param level
	 * @return
	 */
	List<Area> selectAreaByLevel(int level);
	
	/**
	 * 查询id的下级区域
	 * @param id
	 * @return
	 */
	List<Area> selectChildrenArea(int id);
	
}
