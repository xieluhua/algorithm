package com.xielh.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class ListDistinct {

    public static void main(String[] args) {

        UserInfo info2 = new UserInfo(1,"张三",15);
        UserInfo info3 = new UserInfo(1,"王五",15);
        UserInfo info4 = new UserInfo(2,"张三",15);

        List<UserInfo> list = new ArrayList<>();
        long startTime = System.currentTimeMillis();
        ArrayList<UserInfo> distinctByNameAndAge = list.stream()
            .collect(
                Collectors.collectingAndThen(
                    Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(userInfo -> userInfo.getUserName() + userInfo.getAge()))),
                    ArrayList::new
                )
            );
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： "+(endTime-startTime)+"ns");

        if(distinctByNameAndAge.size()<list.size()){
            System.out.println("111111111111111");
        }
    }
}
