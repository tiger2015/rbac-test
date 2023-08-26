package com.tiger.rbac.utils;

import com.tiger.rbac.model.po.SysPermission;
import com.tiger.rbac.model.vo.PrivilegeTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author Zenghu
 * @Date 2023年07月10日 21:47
 * @Description
 * @Version: 1.0
 **/
public class PrivilegeUtils {

    public static List<PrivilegeTree> buildPrivilegeTrees(List<SysPermission> privileges) {
        Map<Integer, PrivilegeTree> treeNodes = new HashMap<>();
        Map<Integer, SysPermission> privilegeMap = new HashMap<>();
        for (SysPermission privilege : privileges) {
            privilegeMap.put(privilege.getId(), privilege);
            PrivilegeTree privilegeTree = new PrivilegeTree();
            privilegeTree.setId(privilege.getId());
            privilegeTree.setName(privilege.getName());
            privilegeTree.setChildren(new ArrayList<>());
            treeNodes.put(privilege.getId(), privilegeTree);
        }
        List<Integer> nodeIds = new ArrayList<>(treeNodes.keySet());
        for (Integer nodeId : nodeIds) {
            SysPermission privilege = privilegeMap.get(nodeId);
            Integer pid = privilege.getPid();
            if (pid == null) continue;
            PrivilegeTree parent = treeNodes.get(pid);
            PrivilegeTree node = treeNodes.get(nodeId);
            if (parent != null && node != null) {
                parent.getChildren().add(node);
            }
        }
        // 移除所有父节点的子节点
        for (Integer nodeId : nodeIds) {
            PrivilegeTree privilegeTree = treeNodes.get(nodeId);
            List<PrivilegeTree> children = privilegeTree.getChildren();
            for (PrivilegeTree child : children) {
                treeNodes.remove(child.getId());
            }
            if (children.isEmpty()) {
                treeNodes.remove(nodeId);
            }
        }
        return new ArrayList<>(treeNodes.values());
    }


}
