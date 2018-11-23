package cn.itcast.ext.arraylist;

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

    public void add(Object object){
        //1、判断实际存放的数据容量是否等于elementData数组长度
        if (size == elementData.length){
            //新数组容量大小
            int newCapaCity = 2 * size;
            //将老数组的值复制到新数组里面去
            Object[] newObjects = new Object[newCapaCity];
            for(int i = 0; i < elementData.length; i++){
                newObjects[i] = elementData[i];
            }
            elementData = newObjects;
        }
        //2、使用下标进行赋值
        elementData[size++] = object;
    }

    public Object get(int index){
        rangeCheck(index);
        return elementData[index];
    }

    private void rangeCheck(int index){
        if(index >= size)
            throw new IndexOutOfBoundsException("索引越界异常");
    }

}
