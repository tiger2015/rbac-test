package com.tiger.rbac.privilege.mapper;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @Author Zenghu
 * @Date 2023年06月24日 11:14
 * @Description
 * @Version: 1.0
 **/
@Component
public class PoObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        setFieldValByName("createTime", LocalDateTime.now(), metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        setFieldValByName("modifiedTime", LocalDateTime.now(), metaObject);
    }
}
