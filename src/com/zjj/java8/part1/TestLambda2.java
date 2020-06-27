package com.zjj.java8.part1;

import org.junit.Test;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @author zhijiaju
 * @version 1.0
 * @date 2020/6/26 12:53
 */
public class TestLambda2 {

   /* Java8 内置的四大核心函数式接口
    Consumer<T> :消费型接口

    void accept(T t);

    Supplier<T> :供给型接口

    T get();

    Function<T, R> :函数型接口

    R apply(T t);

    Predicate<T> :断言型接口

    boolean test(T t);*/


    //Supplier<Integer> sup  供应型接口
    @Test
    public void test1() {
        List<Integer> list = getList(10, () -> (int) (Math.random() * 100));
        list.stream().forEach(System.out::println);

    }

    //Consumer<Long> con 消费型接口
    @Test
    public void test2() {
        consumer(100L, (e) -> {
            System.out.println("消费了" + e + "元");
        });
    }

    @Test
    public void test3() {
        String strHandle = strHandle("我很丑啊，对吗？", (e) -> e.substring(0, 1));
        System.out.println(strHandle);
    }

    @Test
    public void test4() {
        boolean pred = pred("我啊", (e) -> e.contains("啊"));
        System.out.println(pred);
    }


    public boolean pred(String l, Predicate<String> predicate) {
        return predicate.test(l);
    }

    public String strHandle(String str, Function<String, String> fun) {
        return fun.apply(str);
    }

    public List<Integer> getList(int num, Supplier<Integer> sup) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            list.add(sup.get());
        }
        return list;
    }

    public void consumer(Long l1, Consumer<Long> con) {
        con.accept(l1);
    }
}
