/**
 * 
 */
package com.wen.demo;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author wencun
 * @date 2018年2月22日 上午9:49:37
 * @version 1.0
 * @since JDK 1.8
 */
public class Staff2 {
    private String name;
    private int age;
    private BigDecimal salary;
    private int sex;
    private Date time;
  
    /**
     * @return the sex
     */
    public int getSex() {
        return sex;
    }
    /**
     * @param sex the sex to set
     */
    public void setSex(int sex) {
        this.sex = sex;
    }
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * @return the age
     */
    public int getAge() {
        return age;
    }
    /**
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }
    /**
     * @return the salary
     */
    public BigDecimal getSalary() {
        return salary;
    }
    /**
     * @param salary the salary to set
     */
    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }
    /**
     * @param name
     * @param age
     * @param salary
     */
    public Staff2(String name, int age, BigDecimal salary) {
        super();
        this.name = name;
        this.age = age;
        this.salary = salary;
    }
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Staff2 [name=" + name + ", age=" + age + ", salary=" + salary + ", sex=" + sex + ", time=" + time + "]";
    }
    /**
     * @param name
     * @param age
     * @param salary
     * @param sex
     */
    public Staff2(String name, int age, BigDecimal salary, int sex) {
        super();
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.sex = sex;
    }
    /**
     * 
     */
    public Staff2() {
        super();
    }
    
    
    
    
    
}
