package com.example.filedown.mapper;

import com.example.filedown.entity.DownWx;

public interface DownWxMapper {
    /**
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Long id);

    /**
     *
     * @mbggenerated
     */
    int insert(DownWx record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(DownWx record);

    /**
     *
     * @mbggenerated
     */
    DownWx selectByPrimaryKey(Long id);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(DownWx record);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(DownWx record);
}