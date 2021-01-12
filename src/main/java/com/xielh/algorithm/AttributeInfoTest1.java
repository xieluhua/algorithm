package com.xielh.algorithm;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class AttributeInfoTest1 {

    private static List<String> allList = new ArrayList<>();

    public static void main(String[] args) {
        String json1 = "{\"1\": [\"black\", \"red\"],\"2\": [\"64\", \"128\"]}";
        String json2 = "{\"1\": [\"black\"],\"2\": [\"256\"]}";
        Map<String, List<String>> jsonMap = JSON.parseObject(json1, HashMap.class);
        Iterator<Entry<String, List<String>>> iter = jsonMap.entrySet().iterator();
        List<List<String>> all = new ArrayList<>();
        while (iter.hasNext()) {
            all.add(iter.next().getValue());
        }

        Map<String, List<String>> jsonMap1 = JSON.parseObject(json2, HashMap.class);
        Iterator<Entry<String, List<String>>> iter1 = jsonMap1.entrySet().iterator();
        while (iter1.hasNext()) {
            all.add(iter1.next().getValue());
        }

        List<List<String>> aaa = Lists.cartesianProduct(all);

        long count = allList.stream().distinct().count();
        if (count > 0) {
            System.out.println(allList);
        } else {
            System.out.println("不重复");
        }
    }

    public static void decare(int index, List<List<String>> all, List<String> temp) {
        List<String> list = all.get(index);
        int allSize = all.size();
        int removeCount = allSize - index;
        for (int i = 0; i < list.size(); i++) {
            String value = list.get(i);
            if (i > 0) {
                for (int j = 0; j < removeCount; j++) {
                    temp.remove(temp.size() - 1);
                }
            }
            temp.add(value);
            if (index == allSize - 1) {
                allList.add(String.join("_", temp));
            }
            if (index < allSize - 1) {
                decare(index + 1, all, temp);
            }
        }
    }
}
