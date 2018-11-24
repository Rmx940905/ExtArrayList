package cn.itcast.ext.arraylist;

import java.util.Arrays;

/*
    自定义ArrayList集合
 */
public class ExtArrayList {

    //ArrayList底层采用数组存放
    private Object [] elementData;

    //默认数组容量
    private static final int DEFAULT_CAPACITY = 10;

    //记录实际ArrayList大小
    private int size;

    //ArrayList指定数组初始的容量
    public ExtArrayList(int initialCapacity){
        if(initialCapacity < 0){
            throw new IllegalArgumentException("初始容量不能小于0");
        }
        elementData = new Object[initialCapacity];
    }

    //默认初始化容量为10
    public ExtArrayList(){
        this(DEFAULT_CAPACITY);
    }


    //线程安全问题ArrayList底层每次扩容是以1.5倍
    public void add(Object object){
        //1、判断实际存放的数据容量是否等于elementData数组长度
        ensureExolicitCapaCity(size+1);
        //2、使用下标进行赋值
        elementData[size++] = object;
    }

    //将元素存入指定位置
    public void add(int index, Object object){
        rangeCheck(index);
        ensureExolicitCapaCity(size+1);
        int numMoved = size - index;
        System.arraycopy(elementData,index,elementData,index+1,numMoved);
        elementData[index]  =  object;
        size++;
    }

    //minCapaCity为最小扩容容量
    private void ensureExolicitCapaCity(int minCapaCity){
        if (size == elementData.length){
            int oldCapaCity = elementData.length;
            int newCapaCity = oldCapaCity + (oldCapaCity >> 1);
            //最小扩容容量
            if(newCapaCity - minCapaCity < 0)
                //最少保证容量和minCapaCity一样
                newCapaCity = minCapaCity;
            //将老数组的值复制到新数组里面去
            elementData = Arrays.copyOf(elementData,newCapaCity);
        }
    }

    //获取元素
    public Object get(int index){
        rangeCheck(index);
        return elementData[index];
    }

    //检查索引是否越界
    private void rangeCheck(int index){
        if(index >= size)
            throw new IndexOutOfBoundsException("索引越界异常");
    }

    //获取长度
    public int getSize(){
        return size;
    }

    //通过索引删除
    public Object remove(int index){
        //使用下标查询该值是否存在
        Object object = get(index);
        //计算删除元素后面的长度
        int numMoved  = size - index - 1;
        //删除原理 使用arraycopy往前移动数据，将最后一个变为空
        if (numMoved > 0){
            System.arraycopy(elementData,index+1,elementData,index,numMoved);
        }
        //将最后一个元素变为空
        elementData[--size] = null;
        return index;
    }

    //通过对象删除  删除元素相同时只会删除第一个
    public boolean remove(Object object){
        for (int i = 0; i<elementData.length; i++){
            Object value = elementData[i];
            if(value.equals(object)){
                remove(i);
                return true;
            }
        }
        return false;
    }

}
