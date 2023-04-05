package com.example.mapper;

import com.example.pojo.User;
import tk.mybatis.mapper.common.Mapper;


/**
 * @Author: Gyx
 * @Date: 2021/4/19 14:58
 * 该类需要继承Mapper接口，传入实体类作为泛型。
 * 如进行的数据库操作是简单的增、删、改、查操作，则无需编写方法，tk-mybatis中提供了这些操作的方法。
 * 如果需要进行复杂查询就需要自己参考SpringBoot整合mybatis的相关配置进行mapper.xml文件的配置
 */
public interface UserMapper extends Mapper<User> {
}


