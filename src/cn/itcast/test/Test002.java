package cn.itcast.test;

import cn.itcast.ext.arraylist.ExtArrayList;
import cn.itcast.ext.arraylist.ExtList;

public class Test002 {
    public static void main(String[] args) {
        ExtList<String> list =  new ExtArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        list.add("f");
        list.add("g");
        list.add(0,"t");
        list.remove(2);
        list.remove("a");
        for (int i = 0; i< list.getSize(); i++){
            System.out.println(list.get(i));
        }
    }

}
