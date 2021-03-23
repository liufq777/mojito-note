package com.mojito.common;

import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Bean对象转换工具
 *
 * @author liufengqiang
 * @date 2020-10-25 10:00:13
 */
public class BaseHelper {

    public static <T, R> T r2t(R resource, Class<T> target) {
        if (resource != null) {
            try {
                T t = target.newInstance();
                BeanUtils.copyProperties(resource, t);
                return t;
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static <T, R> List<T> r2t(List<R> resourceList, Class<T> target) {
        List<T> tList = new ArrayList<>();
        if (!CollectionUtils.isEmpty(resourceList)) {
            resourceList.forEach(resource -> {
                T t1 = r2t(resource, target);
                tList.add(t1);
            });
        }
        return tList;
    }
}
