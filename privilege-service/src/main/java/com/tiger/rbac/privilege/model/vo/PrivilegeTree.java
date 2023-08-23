package com.tiger.rbac.privilege.model.vo;

import lombok.Data;

import java.util.List;

/**
 * @Author Zenghu
 * @Date 2023年07月10日 21:43
 * @Description
 * @Version: 1.0
 **/
@Data
public class PrivilegeTree {
    private static final long serialVersionUID = 7925697502258531635L;
    private Integer id;
    private String name;
    private String title;
    private String path;
    private List<PrivilegeTree> children;
}
