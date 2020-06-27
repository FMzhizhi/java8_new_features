package com.zjj.java8.part2;

import com.zjj.java8.part1.Employee;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author zhijiaju
 * @version 1.0
 * @date 2020/6/26 16:33
 */
public class TestStreamAPI1 {
    List<Employee> emps = Arrays.asList(
            new Employee(102, "李四", 59, 6666.66),
            new Employee(101, "张三", 18, 9999.99),
            new Employee(103, "王五", 28, 3333.33),
            new Employee(104, "赵六", 8, 7777.77),
            new Employee(104, "赵六", 8, 7777.77),
            new Employee(104, "赵六", 8, 7777.77),
            new Employee(105, "田七", 38, 5555.55)
    );

    @Test
    public void test1(){

        List<String> collect = emps.stream().map(Employee::getName).collect(Collectors.toList());
        System.out.println(collect);
        System.out.println("-------------------------------------------");

        List<String> strList = Arrays.asList("aaa", "bbb", "ccc", "ddd", "eee");

        Stream<String> stream = strList.stream()
                .map(String::toUpperCase);

        stream.forEach(System.out::println);

        Stream<Stream<Character>> stream2 = strList.stream()
                .map(TestStreamAPI1::filterCharacter);

        stream2.forEach((sm) -> {
            sm.forEach(System.out::println);
        });

        System.out.println("---------------------------------------------");

        Stream<Character> stream3 = strList.stream()
                .flatMap(TestStreamAPI1::filterCharacter).distinct();

        stream3.forEach(System.out::println);
    }

    public static Stream<Character> filterCharacter(String str){
        List<Character> list = new ArrayList<>();

        for (Character ch : str.toCharArray()) {
            list.add(ch);
        }

        return list.stream();
    }


    /*
		sorted()——自然排序
		sorted(Comparator com)——定制排序
	 */
    @Test
    public void test2(){
        emps.stream()
                .map(Employee::getName)
                .sorted()
                .forEach(System.out::println);

        System.out.println("------------------------------------");

        emps.stream()
                .sorted((x, y) -> {
                    if(x.getAge() == y.getAge()){
                        return x.getName().compareTo(y.getName());
                    }else{
                        return Integer.compare(x.getAge(), y.getAge());
                    }
                }).forEach(System.out::println);
    }
}
