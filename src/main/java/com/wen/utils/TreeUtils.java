package com.wen.utils;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import org.apache.commons.collections4.CollectionUtils;
import org.junit.Test;

/**
 * @author wencun
 * @date 2018年9月7日 上午9:17:43
 * @version 1.0
 * @since JDK 1.8
 */
public class TreeUtils {
    
    /**
     * 递归；
     * @author wencun
     * @date: 2018年9月7日 下午2:46:34
     * @param sourseList
     * @param resultList
     * @param parentid
     * @return
     */
    public static List<TreeNode> recursionList(List<TreeNode> sourseList, List<TreeNode> resultList,BigInteger parentid) {
        List<TreeNode> currentList=new ArrayList<>();
        if(CollectionUtils.isEmpty(sourseList)) {
            return resultList;
        }
        for(TreeNode node:sourseList) {
            if(Objects.equals(parentid, node.getParentId())) {
                currentList.add(node);
            }
        }
        if(CollectionUtils.isNotEmpty(currentList)) {
            resultList.addAll(currentList);
            for(TreeNode node:currentList) {
                recursionList(sourseList, resultList, node.getId());
            }
        }
        return resultList;
    }
    
    
    @Test
    public void testTree() throws Exception {
       List<TreeNode> children=new ArrayList<>();
    TreeNode t1=new TreeNode(new BigInteger("1"), "树1", new BigInteger("0"), children);
    TreeNode t2=new TreeNode(new BigInteger("2"), "树2", new BigInteger("0"), children);
    TreeNode t3=new TreeNode(new BigInteger("3"), "树3", new BigInteger("0"), children);
    TreeNode t4=new TreeNode(new BigInteger("4"), "树11", new BigInteger("1"), children);
    TreeNode t5=new TreeNode(new BigInteger("5"), "树22", new BigInteger("2"), children);
    TreeNode t6=new TreeNode(new BigInteger("6"), "树33", new BigInteger("3"), children);
    TreeNode t7=new TreeNode(new BigInteger("7"), "树44", new BigInteger("4"), children);
    TreeNode t8=new TreeNode(new BigInteger("8"), "树55", new BigInteger("5"), children);
    TreeNode t9=new TreeNode(new BigInteger("9"), "树66", new BigInteger("6"), children);
    List<TreeNode> sourseList=Arrays.asList(t1,t4,t7);
    System.err.println("递归树1："+recursionList(sourseList, new ArrayList<>(), BigInteger.ZERO));
    Tree tree = new Tree(sourseList);
    tree.buildChildNodes(t1);
    System.err.println("递归子节点："+t1);
    List<TreeNode> buildTree = tree.buildTree();
    System.err.println("构建递归树3："+buildTree);
    }
}
