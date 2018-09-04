package com.wen.demo;

import org.junit.Test;

/**
 * @author wencun
 * @date 2018年4月9日 上午10:45:23
 * @version 1.0
 * @since JDK 1.8
 */
public class DiGui {
     /**
     * 递归阶乘
     * @author wencun
     * @date: 2018年4月9日 上午10:52:59
     * @param n
     * @return
     */
    public static int jiecheng(int n) {
         if(n==1||n==0) {
            return n; 
         }
        return n*jiecheng(n-1);
         
     }
    
    /**
     * 求1+2+3+4+5+6+7……+n的和
     * @author wencun
     * @date: 2018年4月9日 上午10:59:44
     * @param n
     * @return
     */
    public static int leijia(int n) {
        if(n<1) {
            return n;  
        }
        return n+leijia(n-1);
        
    }
    
    /**
     * 斐波拉契数列n项值
     * @author wencun
     * @date: 2018年4月9日 上午11:08:39
     * @return
     */
    public static int feibolaqi(int n) {
        int first=0;
        int second=1;
        int third=0;
        for(int i=1;i<n;i++) {
            third=first+second;
            first=second;
            System.out.println(second);
            second=third;
        }
        return third;
        
    }
     
     @Test
    public void jiecheng() throws Exception {
        int jiecheng = DiGui.jiecheng(5);
        System.out.println(jiecheng);
    }
     
     @Test
    public void leijia() throws Exception {
        int leijia = leijia(5);
        System.out.println(leijia);
    }
     
     @Test
    public void feibolaqi() throws Exception {
         int feibolaqi = feibolaqi(10);
         System.out.println(feibolaqi);
    }
     
     
}
