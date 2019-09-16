package com.bingley.dbapplicaion;


import com.bingley.base.log.LogUtil;
import com.bingley.dbapplicaion.db.DbUtil;
import com.bingley.dbapplicaion.db.test.Clazz;
import com.bingley.dbapplicaion.db.test.ClazzDao;
import com.bingley.dbapplicaion.db.test.DaoSession;
import com.bingley.dbapplicaion.db.test.DbManager;
import com.bingley.dbapplicaion.db.test.FriendClass;
import com.bingley.dbapplicaion.db.test.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bingley
 * @date 2019/9/11.
 */
public class TestMessage {



    public static void testGreenDao() {
        List<Clazz> clazzList = new ArrayList<>();
        List<Student> studentList = new ArrayList<>();
        // test greendao  第一种封装
        DbUtil dbUtil = DbUtil.getInstance(MyApplication.context());
        // 第二种封装
        DbManager dbManager = DbManager.getInstance(MyApplication.context()); // 这个应该放在初始化的myapplication

        DaoSession daoSession = DbManager.getDaoSession(MyApplication.context());
        int studenId = 10;
        long id = 0;
        for (int i = 1; i < 4; i++) {
            Clazz clazz = new Clazz();
            clazz.setName(i + "班");
            clazz.setId(id++);



            // 一对一
            FriendClass friendClass = new FriendClass((long) 1, "好朋友班级");
            // (1) 单个对象 保存
            dbUtil.insertOrReplace(friendClass);
            //long insert = dbUtil.getDaoSession().getClazzDao().insert(friendClass2);
            //Long friendFlag = dbUtil.insertToLong(friendClass);
            clazz.setFriendClassId(friendClass.getId());  // friendClass 注入到class
           // clazz.setFriendClass(friendClass);

            // 一对多 TODO
            // 如何添加到studentList 添加给Clazz
          //  long userIdinser = dbUtil.getDaoSession().getClazzDao().insert(clazz);

            //daoSession.getStudentDao().insertOrReplaceInTx(studentList);

            //ClazzDao clazzDao = dbUtil.getDaoSession().getClazzDao();
            for (int j = 0; j < 5; j++) {
                Student student = new Student();
                student.setAge(18 + j);
                student.setId(id++);
                student.setStudentID(studenId++);
                student.setName("Ralf");
                student.setClazID(clazz.getId()); // 这个就是把student信息注入到class中
               // student.setClazID(userIdinser);

                studentList.add(student);



            }

            clazzList.add(clazz);

        }

        // 接下来进行增删改查操作

        // 删除
        //dbUtil.deleteAll(Clazz.class);

        // 增

        // (2) 多个对象通过list
        dbUtil.insertOrReplaceInTx(clazzList);
        dbUtil.insertOrReplaceInTx(studentList);



        // 改


        // 查
        //LogUtil.e("testGreenDao",dbUtil.count());

        List<Clazz> clazzes = dbUtil.getQueryBuilder(Clazz.class).list();
        List<Student> list = dbUtil.getQueryBuilder(Student.class).list();
        LogUtil.e("dbutils查询到的数据数量是"+list.size());
        Clazz clazz = clazzes.get(0);
        LogUtil.e("查询到的getFriendClass是--getFriendClass"+ clazz.getFriendClass());
        LogUtil.e("查询到的数据数量是--clazzes"+clazzes.size()+"它的子学生有"+clazzes.get(0).getStudentList().size());


        List<Clazz> list1 = dbUtil.getQueryBuilder(Clazz.class).where(ClazzDao.Properties.Name.like("2%")).list();
        LogUtil.e("listClazz"+list1.size());

        /*查询FriendClass表下的name为1班的队友信息*/
        //dbUtil.getQueryBuilder(FriendClass.class).where(FriendClassDao.Properties.Id.like())
    }
}
