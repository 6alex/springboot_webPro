package com.wen.utils;

import java.math.BigInteger;
import java.util.List;

/**
 * @author wencun
 * @date 2018年9月6日 下午8:16:08
 * @version 1.0
 * @since JDK 1.8
 */
public class TreeNode {

    BigInteger id;
    String name;
    BigInteger parentId;
    List<TreeNode> children;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigInteger getParentId() {
        return parentId;
    }

    public void setParentId(BigInteger parentId) {
        this.parentId = parentId;
    }

    public List<TreeNode> getChildren() {
        return children;
    }

    public void setChildren(List<TreeNode> children) {
        this.children = children;
    }

    /**
     * @param id
     * @param name
     * @param parentId
     * @param children
     */
    public TreeNode(BigInteger id, String name, BigInteger parentId, List<TreeNode> children) {
        super();
        this.id = id;
        this.name = name;
        this.parentId = parentId;
        this.children = children;
    }

    @Override
    public String toString() {
        return "TreeNode [id=" + id + ", name=" + name + ", parentId=" + parentId + ", children=" + children + "]";
    }

}
