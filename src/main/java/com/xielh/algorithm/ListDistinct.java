package com.xielh.algorithm;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ListDistinct {

    public static void main(String[] args) {

        UserInfo info2 = new UserInfo(1, "张三1", 15, "长沙", "");
        UserInfo info3 = new UserInfo(1, "张三2", 15, "长沙", "");
        UserInfo info4 = new UserInfo(2, "张三3", 15, "长沙", "");
        UserInfo info5 = new UserInfo(2, "张三4", 15, "长沙", "");

        UserInfo info6 = new UserInfo(2, "张三2", 12, "长沙", "");

        List<UserInfo> list = Arrays.asList(info2, info3, info4,info5,info6);
        long startTime = System.currentTimeMillis();

//        List<UserInfo> newsList = list.stream().filter(
//            distinctByKey(
//                b -> b.getUserName() + "," + b.getAge() + "," + b.getAttribute1() + "," + b
//                    .getAttribute2())).collect((Collectors.toList()));
//        System.out.println(newsList);
        long count = list.stream().filter(
            distinctByKey(
                b -> b.getUserName() + "," + b.getAge() + "," + b.getAttribute1() + "," + b
                    .getAttribute2())).count();
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ns");

        if (count < list.size()) {
            System.out.println("111111111111111");
        }
        List<UserInfo> ll = getDuplicateElements(list);
        System.out.println(ll);
    }

    /**
     * G
     * @param list
     * @param <E>
     * @return
     */
    private static <E> List<E> getDuplicateElements(List<E> list) {
        return list.stream()
            .collect(Collectors.toMap(e -> e, e -> 1, (a, b) -> a + b))
            .entrySet().stream()
            .filter(entry -> entry.getValue() > 1)
            .map(entry -> entry.getKey())
            .collect(Collectors.toList());
    }


    private static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
        Map<Object, Boolean> seen = new ConcurrentHashMap<>();
        return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }

}
