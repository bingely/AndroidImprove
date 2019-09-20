package com.bingley.dbapplicaion.db.test;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Unique;

/**
 * 定义为同年级的班级
 * @author bingley
 * @date 2019/9/12.
 */
@Entity(nameInDb = "FriendClass")
public class FriendClass {

    @Unique
    @Id(autoincrement = true)
    private Long id;

    private String name;

    @Generated(hash = 1942018908)
    public FriendClass(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Generated(hash = 1105406185)
    public FriendClass() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "FriendClass{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
