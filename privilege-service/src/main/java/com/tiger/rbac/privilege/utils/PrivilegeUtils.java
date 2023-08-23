package com.tiger.rbac.privilege.utils;

import com.tiger.rbac.privilege.model.po.Privilege;
import com.tiger.rbac.privilege.model.vo.PrivilegeTree;

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

    public static List<PrivilegeTree> buildPrivilegeTrees(List<Privilege> privileges) {
        Map<Integer, PrivilegeTree> treeNodes = new HashMap<>();
        Map<Integer, Privilege> privilegeMap = new HashMap<>();
        for (Privilege privilege : privileges) {
            privilegeMap.put(privilege.getId(), privilege);
            PrivilegeTree privilegeTree = new PrivilegeTree();
            privilegeTree.setId(privilege.getId());
            privilegeTree.setName(privilege.getName());
            privilegeTree.setTitle(privilege.getTitle());
            privilegeTree.setPath(privilege.getPath());
            privilegeTree.setChildren(new ArrayList<>());
            treeNodes.put(privilege.getId(), privilegeTree);
        }
        List<Integer> nodeIds = new ArrayList<>(treeNodes.keySet());
        for (Integer nodeId : nodeIds) {
            Privilege privilege = privilegeMap.get(nodeId);
            Long pid = privilege.getPid();
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
