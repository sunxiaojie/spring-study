package com.sxj.conmon.util;


import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TreeUtil {
    public static void main(String[] args) {
        List<Tree> treeList = new ArrayList<>();
        treeList.add(new Tree(0, -1));
        treeList.add(new Tree(1, 0));
        treeList.add(new Tree(2, 0));
        treeList.add(new Tree(3, 1));
        treeList.add(new Tree(4, 1));
        treeList.add(new Tree(5, 2));
        treeList.add(new Tree(6, 2));
        treeList.add(new Tree(7, 2));
        System.out.println(createTree(0,treeList, Tree::getId, Tree::getParentId, Tree::setChildList));
    }

    /**
    * 树形结构工具类
    * @param id             根对象主键Id
    * @param treeList       原始数据列表
    * @param getId          获取主键ID动作
    * @param getParentId    获取父主键ID动作
    * @param setChildList   子类对象赋值动作
    * @return  根对象
    * @author Sxj
    * @date 2019/9/12
    */
    static <T> T createTree(Object id, List<T> treeList, Function<T, Object> getId, Function<T, Object> getParentId, BiConsumer<T, List<T>> setChildList) {
        if (CollectionUtils.isEmpty(treeList)) {
            return null;
        }
        Map<Object, T> treeMap = treeList.stream().collect(Collectors.toMap(getId, Function.identity()));
        T tree = treeMap.get(id);
        if (null == tree) {
            return null;
        }
        Map<Object, List<T>> treeParentMap = treeList.stream().collect(Collectors.groupingBy(getParentId));
        List<T> trees = treeParentMap.get(id);
        if (CollectionUtils.isEmpty(trees)) {
            return tree;
        }
        setChildList.accept(tree, trees);
        List<T> childTreeList = new ArrayList<>();
        for (T t : trees) {
            Object objectId = getId.apply(t);
            if (null == objectId) {
                continue;
            }
            T childTree = createTree(objectId, treeList, getId, getParentId, setChildList);
            if (childTree == null) {
                continue;
            }
            childTreeList.add(childTree);
        }
        if (!CollectionUtils.isEmpty(childTreeList)) {
            setChildList.accept(tree, childTreeList);
        }
        return tree;
    }
}
class Tree {
    private Integer id;
    private Integer parentId;
    private List<Tree> childList;

    @Override
    public String toString() {
        return "Tree{" +
                "id=" + id +
                ", parentId=" + parentId +
                ", childList=" + childList +
                '}';
    }

    public Tree(Integer id, Integer parentId) {
        this.id = id;
        this.parentId = parentId;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Tree> getChildList() {
        return childList;
    }

    public void setChildList(List<Tree> childList) {
        this.childList = childList;
    }
}
