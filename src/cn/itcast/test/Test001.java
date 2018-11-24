package cn.itcast.test;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.ArrayList;
import java.util.Arrays;

public class Test001 {


    //底层采用数组方式
    //如可保证集合存放无限大小---数组扩容技术
    public static void main(String[] args) {
        Object[] objects =  {1,2};
        System.out.println(objects.length);
        //返回的数组,将原来长度为2的数组扩容到长度为10,原来本身的数据不变;
        Object[] copyNewObject = Arrays.copyOf(objects,10);
        System.out.println(copyNewObject.length);

        //参数 src 原数组, srcPos 起始位置, dest 目标数组,  destPos 目标起始位置 length 复制长度
        //System.arraycopy(src,srcPos,dest,destPos,length);
        int[] fun = {0,1,2,3,4,5,6,7,8,9};
        System.arraycopy(fun,0,fun,3,3);
        System.out.println( Arrays.toString(fun));
    }
}
