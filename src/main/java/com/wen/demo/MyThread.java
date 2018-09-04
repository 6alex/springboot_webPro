package com.wen.demo;

/**
 * @author wencun
 * @date 2018年4月4日 下午5:15:08
 * @version 1.0
 * @since JDK 1.8
 */
public class MyThread implements Runnable{

       private String name;

        
        @Override
        public void run() {
            int i=1;
            while(true) {
                i++;
            System.out.println(name+"-------"+i);
            if(i==10) {
                break;
            }
            }
            
        }


        /**
         * @param name
         */
        public MyThread(String name) {
            super();
            this.name = name;
        }
  
            
   

   
      
}
