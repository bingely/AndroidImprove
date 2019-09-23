package com.bingley.dbapplicaion.dbgreen.test;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Unique;

/**
 * 一个班级下的学生
 * @author bingley
 * @date 2019/7/30.
 */
@Entity(nameInDb = "Student")
public class Student {
    @Unique
    @Id(autoincrement = true)
    private Long id;

    // 修改字段在数据库中的名字
    @Property(nameInDb = "studentID")
    private int studentID;

    // 一对多 字段关联 属性
    private long clazID;

    private String name;
    private int age;



    @Generated(hash = 380070227)
    public Student(Long id, int studentID, long clazID, String name, int age) {
        this.id = id;
        this.studentID = studentID;
        this.clazID = clazID;
        this.name = name;
        this.age = age;
    }
    @Generated(hash = 1556870573)
    public Student() {
    }
    public int getStudentID() {
        return this.studentID;
    }
    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public long getClazID() {
        return this.clazID;
    }
    public void setClazID(long clazID) {
        this.clazID = clazID;
    }
    public int getAge() {
        return this.age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
}
