package com.wen.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;

/**
 * @author wencun
 * @date 2018年4月8日 下午4:33:33
 * @version 1.0
 * @since JDK 1.8
 */
public class Algorithm {
    
        /**
         * 随机指定范围内N个不重复的数 (利用Set的特征，只能存放不同的值) 
         * @author wencun
         * @date: 2018年4月9日 上午9:37:51
         * @param min 指定范围最小值
         * @param max 指定范围最大值
         * @param n   随机数个数
         * @param set
         */
    public static void randomSet(int min, int max, int n, Set<Integer> set) {  
          if (n > (max - min + 1) || max < min) {  
              return;  
          }  
          for (int i = 0; i < n; i++) {  
              // 调用Math.random()方法  
              int num = (int) (Math.random() * (max - min)) + min;  
              set.add(num);// 将不同的数存入Set中  
          }  
          int setSize = set.size();  
          // 如果存入的数小于指定生成的个数，则调用递归再生成剩余个数的随机数，如此循环，直到达到指定大小  
          if (setSize < n) {  
           randomSet(min, max, n - setSize, set);// 递归  
          }  
      }  
      
      
      
      @Test
    public void algorithm() throws Exception {
        Set<Integer> set = new TreeSet<Integer>();//升序
        //Set<Integer> set = new HashSet<Integer>();
        randomSet(1, 100, 10, set);
        System.out.println(set);       
        ArrayList<Integer> arrayList = new ArrayList<>(set);
        System.out.println(arrayList);
        Collections.reverse(arrayList);
        System.out.println("逆序"+arrayList);
        int size = arrayList.size();
        int n=size/2;
        System.out.println(n);        
        List<Integer> l1=new ArrayList<Integer>(size);
        for(int i=0;i<size;i++) {
           l1.add(arrayList.get(i));                     
           if(i==n) {//如果size为奇数
               break;
           }
           l1.add(arrayList.get(size-1)); 
           size--;
        }
        System.out.println(l1);             
    }
      
      
}
