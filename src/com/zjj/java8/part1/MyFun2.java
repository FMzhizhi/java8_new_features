package com.zjj.java8.part1;

/**
 * @author zhijiaju
 * @version 1.0
 * @date 2020/6/26 11:10
 */
@FunctionalInterface
public interface MyFun2<T,R> {
    R getValue(T t1,T t2);
}
