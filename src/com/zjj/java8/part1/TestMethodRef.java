package com.zjj.java8.part1;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.*;

/**
 * @author zhijiaju
 * @version 1.0
 * @date 2020/6/26 13:19
 */
public class TestMethodRef {

    /*
     * 一、方法引用：若 Lambda 体中的功能，已经有方法提供了实现，可以使用方法引用
     * 			  （可以将方法引用理解为 Lambda 表达式的另外一种表现形式）
     *
     * 1. 对象的引用 :: 实例方法名
     *
     * 2. 类名 :: 静态方法名
     *
     * 3. 类名 :: 实例方法名
     *
     * 注意：
     * 	 ①方法引用所引用的方法的参数列表与返回值类型，需要与函数式接口中抽象方法的参数列表和返回值类型保持一致！
     * 	 ②若Lambda 的参数列表的第一个参数，是实例方法的调用者，第二个参数(或无参)是实例方法的参数时，格式： ClassName::MethodName
     *
     * 二、构造器引用 :构造器的参数列表，需要与函数式接口中参数列表保持一致！
     *
     * 1. 类名 :: new
     *
     * 三、数组引用
     *
     * 	类型[] :: new;
     *
     *
     */


    //对象的引用 :: 实例方法名
    @Test
    public void test1(){
        Employee emp = new Employee();
        Consumer<String> com=emp::setName;
        com.accept("颤三");
        System.out.println(emp.getName());


    }

    //2. 类名 :: 静态方法名
    @Test
    public void test2(){
        Comparator<Integer> com=Integer::compare;
        int compare = com.compare(1, 2);
        System.out.println(compare);

    }

    //3. 类名 :: 实例方法名
    @Test
    public void test3(){

        BiPredicate<String,String> bp=String::equals;
        boolean test = bp.test("q", "q");
        System.out.println(test);
    }

    //构造器引用
    @Test
    public void test4(){
        Supplier<Employee> sup=Employee::new;
        Employee employee = sup.get();
        System.out.println(employee);

    }

    @Test
    public void test5(){
        Function<String,Employee> fun=Employee::new;
        System.out.println(fun.apply("里斯"));
        BiFunction<String,Integer,Employee> fun1=Employee::new;
        System.out.println(fun1.apply("张三",1));

    }

    //数组引用
    @Test
    public void test6(){
        Function<Integer,String[]> fun=(e)->new String[2];
        Function<Integer,String[]> fun1=String[]::new;
        System.out.println(fun1.apply(10).length);

    }



}
