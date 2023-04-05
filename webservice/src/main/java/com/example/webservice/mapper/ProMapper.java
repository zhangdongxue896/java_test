package com.example.webservice.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.webservice.model.Prospector;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProMapper extends BaseMapper<Prospector> {
}
