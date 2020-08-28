package com.ucucs.mybatis.dao;

import com.ucucs.mybatis.entity.AdjustSalary;

public interface AdjustSalaryMapper {
    int deleteByPrimaryKey(Long id);

    int insert(AdjustSalary record);

    int insertSelective(AdjustSalary record);

    AdjustSalary selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AdjustSalary record);

    int updateByPrimaryKey(AdjustSalary record);
}