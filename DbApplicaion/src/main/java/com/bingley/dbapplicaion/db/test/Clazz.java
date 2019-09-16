package com.bingley.dbapplicaion.db.test;

import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.ToMany;
import org.greenrobot.greendao.annotation.ToOne;
import org.greenrobot.greendao.annotation.Unique;

import java.util.List;

/**
 * 一个独立的班级
 * @author bingley
 * @date 2019/7/30.
 */
@Entity(nameInDb = "Clazz")
public class Clazz{

    @Unique
    @Id(autoincrement = true)
    private Long id;

    private String name;


    // 一对一 注解的话
    @ToOne(joinProperty = "friendClassId")
    private FriendClass friendClass;
    private Long friendClassId;



    // 一对多 注解，采用 referencedJoinProperty 方式，clazID 为学生的班级号
    @ToMany(referencedJoinProperty = "clazID")
   // @Convert(columnType = String.class, converter = StudentConverter.class)
    private List<Student> studentList;



    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    @Generated(hash = 909266378)
    private transient ClazzDao myDao;

    @Generated(hash = 349353470)
    private transient Long friendClass__resolvedKey;

    @Generated(hash = 320359401)
    public Clazz(Long id, String name, Long friendClassId) {
        this.id = id;
        this.name = name;
        this.friendClassId = friendClassId;
    }

    @Generated(hash = 1166360579)
    public Clazz() {
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 128553479)
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 1942392019)
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 713229351)
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }

    public Long getFriendClassId() {
        return this.friendClassId;
    }

    public void setFriendClassId(Long friendClassId) {
        this.friendClassId = friendClassId;
    }

    /** To-one relationship, resolved on first access. */
    @Generated(hash = 1927381236)
    public FriendClass getFriendClass() {
        Long __key = this.friendClassId;
        if (friendClass__resolvedKey == null || !friendClass__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            FriendClassDao targetDao = daoSession.getFriendClassDao();
            FriendClass friendClassNew = targetDao.load(__key);
            synchronized (this) {
                friendClass = friendClassNew;
                friendClass__resolvedKey = __key;
            }
        }
        return friendClass;
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 1873192525)
    public void setFriendClass(FriendClass friendClass) {
        synchronized (this) {
            this.friendClass = friendClass;
            friendClassId = friendClass == null ? null : friendClass.getId();
            friendClass__resolvedKey = friendClassId;
        }
    }



    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 438144174)
    public List<Student> getStudentList() {
        if (studentList == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            StudentDao targetDao = daoSession.getStudentDao();
            List<Student> studentListNew = targetDao._queryClazz_StudentList(id);
            synchronized (this) {
                if (studentList == null) {
                    studentList = studentListNew;
                }
            }
        }
        return studentList;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated(hash = 1628625923)
    public synchronized void resetStudentList() {
        studentList = null;
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 2098165323)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getClazzDao() : null;
    }



}
