package com.tiger.rbac.common.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Author Zenghu
 * @Date 2023年07月08日 11:46
 * @Description
 * @Version: 1.0
 **/
@Data
public class PageData<T> implements Serializable {
    private int pageSize;
    private int pageNum;
    private int totalPage;
    private long total;
    private List<T> data;
}
