package cn.itcast.ext.arraylist;
/*
* 自定义List接口
*/
public interface ExtList <E> {

    void add(E e);

    E get(int index);

    int getSize();

    void add(int index, E e);

    int remove(int index);

    boolean remove(E e);

}
