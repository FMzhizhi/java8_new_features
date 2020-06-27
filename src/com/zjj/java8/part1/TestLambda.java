package com.zjj.java8.part1;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author zhijiaju
 * @version 1.0
 * @date 2020/6/26 11:00
 */
public class TestLambda {

    List<Employee> emps = Arrays.asList(
            new Employee(101, "张三", 18, 9999.99),
            new Employee(102, "李四", 59, 6666.66),
            new Employee(103, "王五", 28, 3333.33),
            new Employee(104, "赵六", 8, 7777.77),
            new Employee(105, "田七", 38, 5555.55)
    );

    @Test
    public void test1(){
        Collections.sort(emps,(x,y)->{
            if (x.getAge()==y.getAge()){
                return x.getName().compareTo(y.getName());
            }else {
                return Integer.compare(x.getAge(),y.getAge());
            }
        });
        emps.forEach(System.out::println);
    }

    @Test
    public void test2(){
        op(1L,2L,(x,y)->x+y);
    }

    public void op(Long l1,Long l2,MyFun2<Long,Long> mf){
        System.out.println(mf.getValue(l1,l2));
    }
}
