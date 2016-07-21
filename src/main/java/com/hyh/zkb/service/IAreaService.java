package com.hyh.zkb.service;

import java.util.List;

import com.hyh.zkb.model.Area;

public interface IAreaService {
	
	int addArea(Area area);
	
	int deleteArea(int id);
	
	Area selectAreaById(int id);
	
	/**
	 * 鏍规嵁id鏌ヨ鐖剁骇鍖哄煙
	 * @param id
	 * @return
	 */
	Area selectParentArea(int id);
	
	/**
	 * 鏌ヨ鎸囧畾level鐨勫尯鍩�
	 * @param level
	 * @return
	 */
	List<Area> selectAreaByLevel(int level);
	
	/**
	 * 鏌ヨid鐨勪笅绾у尯鍩�
	 * @param id
	 * @return
	 */
	List<Area> selectChildrenArea(int id);
	
}
