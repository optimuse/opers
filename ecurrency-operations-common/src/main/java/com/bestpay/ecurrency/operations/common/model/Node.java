package com.bestpay.ecurrency.operations.common.model;

/**
 * 类描述
 * <p>
 * 方法描述列表
 * </p>
 * User: Jwxa Date: 2016/11/15 ProjectName: ecurrency-operations Version: 1.0
 */

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class Node implements Serializable {

    private int id;

    private int parentId;

    private Node parent;

    private List<? extends Node> children;

    private String name;

    private int level;

    private int sort;

    private int rootId;

    private String type;

    private boolean isLeaf;

    private String description;


    public Node() {
        super();
    }

    public Node(int id, int parentId, String name) {
        super();
        this.id = id;
        this.parentId = parentId;
        this.name = name;
    }


    @Override 
    public boolean equals(Object obj) { 
        if (this == obj) 
            return true; 
        if (obj == null) 
            return false; 
        if (getClass() != obj.getClass()) 
            return false; 
        Node other = (Node) obj; 
        if (id != other.id) 
            return false; 
        if (parentId != other.parentId) 
            return false; 
        return true; 
    } 

    @Override
    public String toString() {
        return "Node {id=" + id + ", parentId=" + parentId
                + ", children=" + children + ", name=" + name + "}";
    }
} 