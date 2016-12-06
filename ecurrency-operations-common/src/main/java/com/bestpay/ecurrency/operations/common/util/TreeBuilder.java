package com.bestpay.ecurrency.operations.common.util;

import com.bestpay.ecurrency.operations.common.model.Node;
import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 类描述
 * <p>
 * 方法描述列表
 * </p>
 * User: Jwxa Date: 2016/11/15 ProjectName: ecurrency-operations Version: 1.0
 */
public class TreeBuilder<T extends Node> {

    /**
     * 将集合建立成树结构
     *
     * @param dirs
     * @return
     */
    @SuppressWarnings("unchecked")
    public List<T> buildListToTree(List<T> dirs) {
        List<T> roots = findRoots(dirs);
        List<T> notRoots = (List<T>) CollectionUtils.subtract(dirs, roots);
        for (T root : roots) {
            root.setChildren(findChildren(root, notRoots));
        }
        return roots;
    }

    /**
     * 找出集合中的根元素
     *
     * @param allNodes
     * @return
     */
    public List<T> findRoots(List<T> allNodes) {
        List<T> results = new ArrayList<>();
        for (T node : allNodes) {
            boolean isRoot = true;
            for (T comparedOne : allNodes) {
                if (node.getParentId() == comparedOne.getId()) {
                    isRoot = false;
                    break;
                }
            }
            if (isRoot) {
                node.setLevel(0);
                results.add(node);
                node.setRootId(node.getId());
            }
        }
        return results;
    }

    /**
     * 递归找子目录
     *
     * @param root
     * @param allNodes
     * @return
     */
    @SuppressWarnings("unchecked")
    private List<T> findChildren(Node root, List<T> allNodes) {
        List<T> children = new ArrayList<>();

        for (T comparedOne : allNodes) {
            if (comparedOne.getParentId() == root.getId()) {
                comparedOne.setParent(root);
                comparedOne.setLevel(root.getLevel() + 1);
                children.add(comparedOne);
            }
        }
        List<T> notChildren = (List<T>) CollectionUtils.subtract(allNodes, children);
        for (T child : children) {
            List<T> tmpChildren = findChildren(child, notChildren);
            if (tmpChildren == null || tmpChildren.size() < 1) {
                child.setLeaf(true);
            } else {
                child.setLeaf(false);
            }
            child.setChildren(tmpChildren);
        }
        return children;
    }


}
