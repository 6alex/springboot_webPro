package com.wen.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**   
 * @Description:     json树形结构工具类      
 * @author: Alex.wen  
 * @date:   2019年5月11日 下午3:27:09
 */
public class JsonArrayTreeUtils {
    Object    id;
    Object    parentId;
    JSONArray nodes = new JSONArray();

    public JsonArrayTreeUtils(JSONArray nodes, Object id, Object parentId) {
        super();
        this.nodes = nodes;
        this.id = id;
        this.parentId = parentId;
    }

    /**
     * 构建树形结构
     *
     * @return
     */
    public JSONArray buildTree() {
        JSONArray treeNodes = new JSONArray();
        JSONArray rootNodes = getRootNodes();
        for (Object rootNode : rootNodes) {
            JSONObject obj = (JSONObject) rootNode;
            buildChildNodes(obj);
            treeNodes.add(obj);
        }
        return treeNodes;
    }

    /**
     * 递归子节点
     *
     * @param node
     */
    public void buildChildNodes(JSONObject node) {
        JSONArray children = getChildNodes(node);
        if (!children.isEmpty()) {
            for (Object child : children) {
                JSONObject obj = (JSONObject) child;
                buildChildNodes(obj);
            }
            node.put("children", children);
        }
    }

    /**
     * 获取父节点下所有的子节点
     *
     * @param nodes
     * @param pnode
     * @return
     */
    public JSONArray getChildNodes(JSONObject pnode) {
        JSONArray childNodes = new JSONArray();
        for (Object n : nodes) {
            JSONObject obj = (JSONObject) n;
            if (pnode.get(id).equals(obj.get(parentId))) {
                childNodes.add(obj);
            }
        }
        return childNodes;
    }

    /**
     * 判断是否为根节点
     *
     * @param nodes
     * @param inNode
     * @return
     */
    public boolean rootNode(JSONObject node) {
        boolean isRootNode = true;
        for (Object n : nodes) {
            JSONObject obj = (JSONObject) n;
            if (node.get(parentId).equals(obj.get(id))) {
                isRootNode = false;
                break;
            }
        }
        return isRootNode;
    }

    /**
     * 获取集合中所有的根节点
     *
     * @param nodes
     * @return
     */
    public JSONArray getRootNodes() {
        JSONArray rootNodes = new JSONArray();
        for (Object n : nodes) {
            JSONObject obj = (JSONObject) n;
            if (rootNode(obj)) {
                rootNodes.add(obj);
            }
        }
        return rootNodes;
    }
}
