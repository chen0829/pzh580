package com.sq580.pzh580.util;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * 通用mapper
 * @Date create in 20180802
 * @author chensh
 * @param <T>
 */
public interface CommonMapper<T> extends Mapper<T>,MySqlMapper<T> {
}
