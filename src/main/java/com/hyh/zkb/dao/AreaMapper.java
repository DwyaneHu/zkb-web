package com.hyh.zkb.dao;


import java.util.List;

import com.hyh.zkb.model.Area;

public interface AreaMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Area record);

    int insertSelective(Area record);

    Area selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Area record);

    int updateByPrimaryKey(Area record);
    
    Area selectParentArea(Integer id);
    
    List<Area> selectAreaByLevel(Integer level);
    
    List<Area> selectChildrenArea(Integer id);
    
    
}