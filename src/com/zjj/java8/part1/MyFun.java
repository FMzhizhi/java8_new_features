package com.zjj.java8.part1;

/**
 * @author zhijiaju
 * @version 1.0
 * @date 2020/6/26 10:00
 */
@FunctionalInterface
public interface MyFun<T> {
    Integer getValue(T t);;
}
