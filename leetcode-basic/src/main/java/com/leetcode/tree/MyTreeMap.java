package com.leetcode.tree;

import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author: wei.wang
 * @Description:
 * @Date 2019/3/21 14:55
 * @Modified
 */
public class MyTreeMap<K, V> extends TreeMap<K, V> {
    @Override
    public String toString() {
        Iterator<Map.Entry<K,V>> i = entrySet().iterator();
        if (! i.hasNext())
            return "{}";

        StringBuilder sb = new StringBuilder();
        sb.append('{');
        for (;;) {
            Map.Entry<K,V> e = i.next();
            K key = e.getKey();
            V value = e.getValue();
            sb.append(key   == this ? "(this Map)" : key);
            //sb.append('=');
            //sb.append(value == this ? "(this Map)" : value);
            try {
                Field f = e.getClass().getDeclaredField("color");
                f.setAccessible(true);
                boolean color = f.getBoolean(e);
                sb.append(" " + (color ? "black" : "red"));
            } catch (NoSuchFieldException e1) {
                e1.printStackTrace();
            } catch (IllegalAccessException e1) {
                e1.printStackTrace();
            }
            if (! i.hasNext())
                return sb.append('}').toString();
            sb.append(',').append(' ');
        }
    }

    public static void main(String[] args) throws ClassNotFoundException {

    }
}
