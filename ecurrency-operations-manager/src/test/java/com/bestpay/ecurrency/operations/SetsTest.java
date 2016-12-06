package com.bestpay.ecurrency.operations;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import java.util.List;
import java.util.Set;


/**
 * 类描述
 * <p>
 * 方法描述列表
 * </p>
 * User: Jwxa Date: 2016/11/23 ProjectName: ecurrency-operations Version: 1.0
 */
public class SetsTest {

    public static void main(String[] args) {
        Set<Integer> s1 = Sets.newHashSet(1,2,3,4,5);//原来有的
        Set<Integer> s2 = Sets.newHashSet();//配置的

//        //Sets.union 返回set的并集
//        Set<Integer> s6 = Sets.union(s1, s2);
//        System.out.println("所有的:");
//        System.out.println(s6);//所有的{1,2,3,4}
        //Sets.intersection 返回set的交集
        Set<Integer> s5 = Sets.intersection(s1, s2); //
        System.out.println("因为本来有 所以不需要配置:");
        System.out.println(s5);//{2,3}
        //s1-s5
        //difference 返回在s1中存在，但不在s5中存在的元素
        Set<Integer> s3 = Sets.difference(s1, s5);
        System.out.println("要删除的角色：");
        System.out.println(s3);
        Set<Integer> s4 = Sets.difference(s2, s5);
        System.out.println("需要添加的");
        System.out.println(s4);

    }
}

