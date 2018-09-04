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
public class Staff {
    private String name;
    private int age;
    private BigDecimal salary;
    private Date time;
  
    /**
     * @param name
     * @param age
     * @param salary
     * @param time
     */
    public Staff(String name, int age, BigDecimal salary, Date time) {
        super();
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.time = time;
    }
    /**
     * @return the time
     */
    public Date getTime() {
        return time;
    }
    /**
     * @param time the time to set
     */
    public void setTime(Date time) {
        this.time = time;
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
    public Staff(String name, int age, BigDecimal salary) {
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
        return "Staff [name=" + name + ", age=" + age + ", salary=" + salary + ", time=" + time + "]";
    }
    /**
     * 
     */
    public Staff() {
        super();
    }
    
    
    
    
    
}
