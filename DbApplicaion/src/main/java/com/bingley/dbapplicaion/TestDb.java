package com.bingley.dbapplicaion;


import android.arch.persistence.room.Room;
import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import com.bingley.base.log.LogUtil;
import com.bingley.dbapplicaion.dbflow.AppDataBase;
import com.bingley.dbapplicaion.dbflow.User2Model;
import com.bingley.dbapplicaion.dbgreen.DbCallBack;
import com.bingley.dbapplicaion.dbgreen.DbUtil;
import com.bingley.dbapplicaion.dbgreen.test.Clazz;
import com.bingley.dbapplicaion.dbgreen.test.ClazzDao;
import com.bingley.dbapplicaion.dbgreen.test.FriendClass;
import com.bingley.dbapplicaion.dbgreen.test.Student;
import com.bingley.dbapplicaion.dbgreen.test.StudentDao;
import com.bingley.dbapplicaion.dbroom.AppDatabase;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.sql.language.From;
import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.raizlabs.android.dbflow.structure.database.DatabaseWrapper;
import com.raizlabs.android.dbflow.structure.database.transaction.ITransaction;
import com.raizlabs.android.dbflow.structure.database.transaction.Transaction;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author bingley
 * @date 2019/9/11.
 */
public class TestDb {

    public static void initDb() {

    }


    // 查
    public static void searchAction() {
        // test greendao  第一种封装
        DbUtil dbUtil = AppContext.getDbUtil();

        LogUtil.e("searchAction--总共有Clazz",dbUtil.count(Clazz.class)+"");

        // 在数据库数据是以集合的形式保存的

        // 单条查询
        Clazz clazz = dbUtil.queryById(Clazz.class, 11);
        if (clazz != null) {
            LogUtil.e("searchAction--单条查询到的getFriendClass是--getFriendClass"+ clazz.getFriendClass());
        }

        // 它不包含在Clazz中的FriendClass的记录
        List<FriendClass> friendClasses = dbUtil.queryAll(FriendClass.class);
        LogUtil.e("searchAction--总共有FriendClass",dbUtil.count(FriendClass.class)+"");
        for (FriendClass friendClass : friendClasses) {
            LogUtil.e( "searchAction--dbutils查询FriendClass " + friendClass.toString());
        }


        // 查询所有的班级
        List<Clazz> clazList  = dbUtil.getQueryBuilder(Clazz.class).list();
        for (Clazz tempClazz : clazList) {
            LogUtil.e( "searchAction--dbutils查询所有的班级,[1] " + tempClazz.toString());
        }
        // 查询所有学生
        List<Student> list = dbUtil.getQueryBuilder(Student.class).list();
        LogUtil.e("searchAction--查询所有学生的数据数量是"+list.size());



        LogUtil.e("searchAction--查询所有学生--clazList "+clazList .size()+"它的子学生有"+clazList .get(0).getStudentList().size());
        LogUtil.e("searchAction--查询到的数据数量是--newStudent它的子学生有"+clazList .get(0).getNewStudentList().size());

        // 条件查询 (包含的东西多)
        final List<Student> students = dbUtil.queryRaw(Student.class, "where studentID = ?", new String[]{"12"});
        LogUtil.e("searchAction--原生查询到的数据数量是--Student它的子学生有"+students.size());

        List<Clazz> list1 = dbUtil.getQueryBuilder(Clazz.class).where(ClazzDao.Properties.Name.like("2%")).list();
        LogUtil.e("searchAction--条件查询listClazz"+list1.size());

        /*查询FriendClass表下的name为1班的队友信息*/
        //dbUtil.getQueryBuilder(FriendClass.class).where(FriendClassDao.Properties.Id.like())

        // 异步查询
        DbCallBack<Student> studentDbCallBack = new DbCallBack<Student>() {
            @Override
            public void onSuccess(List<Student> result) {
                if (result != null && result.size() > 0) {
                    LogUtil.e("异步查询", "[4]总的数量 " + result.size());
                    for (Student student1 : result) {
                        // 为啥是空的 ？？？
                        if (student1 != null) {
                            LogUtil.e("异步查询", "[4] " + student1.toString());
                        } else {
                            LogUtil.e("异步查询student1==null", "[4] " + result.get(0));
                        }

                    }
                }
            }

            @Override
            public void onFailed() {

            }

            @Override
            public void onNotification(boolean result) {

            }
        };

        dbUtil.setDbCallBack(studentDbCallBack)
                .queryAsync(Student.class, StudentDao.Properties.StudentID.eq(19));


        // // 批量异步条件查询 TODO
        // 批量同步条件查询 TODO


        // 多表查询
        QueryBuilder<Student> builder2 = dbUtil.getQueryBuilder(Student.class);
        builder2.join(StudentDao.Properties.ClazID, Clazz.class)
                .where(ClazzDao.Properties.Id.eq(1));
        List<Student> studentList1 = builder2.list();
        for (Student student2 : studentList1) {
            LogUtil.e("多表查询" + student2.toString());
        }
    }

    // 增
    public static void addAction() {
        List<Clazz> clazzList = new ArrayList<>();
        List<Student> studentList = new ArrayList<>();
        List<Student> newStudentList = new ArrayList<>();

        DbUtil dbUtil = AppContext.getDbUtil();
        int studenId = 10;
        long id = 0;
        for (int i = 1; i < 4; i++) {
            Clazz clazz = new Clazz();
            clazz.setName(i + "班");
            clazz.setId(id++);



            // 一对一
            FriendClass friendClass = new FriendClass((long) 1, "好朋友班级");
            // (1) 单个对象 保存
            //dbUtil.insertOrReplace(friendClass);
            //long insert = dbUtil.getDaoSession().getClazzDao().insert(friendClass2);
            //Long friendFlag = dbUtil.insertToLong(friendClass);
            clazz.setFriendClassId(friendClass.getId());  // friendClass 注入到class
           // clazz.setFriendClass(friendClass);

            // 一对多
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
                student.setClazID(clazz.getId()); // 第一种解决方案：这个就是把student信息注入到class中

                studentList.add(student);


            }

            for (int j = 0; j < 5; j++) {
                Student student = new Student();
                student.setAge(18 + j);
                student.setId(id++);
                student.setStudentID(studenId++);
                student.setName("Ralf");

                newStudentList.add(student);

            }
            clazz.setNewStudentList(newStudentList); // 第二种解决方案这个就是把student信息注入到class中---通过setxxx

            clazzList.add(clazz);

        }

        FriendClass friendClass = new FriendClass((long) 100, "好朋友班级好好");
        // (1) 单个对象 保存
        dbUtil.insertOrReplace(friendClass);   // 重复的id的不能再添加
        // (2) 多个对象通过list
        dbUtil.insertOrReplaceInTx(clazzList);
        dbUtil.insertOrReplaceInTx(studentList);
        //dbUtil.insertOrReplaceInTx(newStudentList);
    }

    // 删除
    public static void delteAction() {
        DbUtil dbUtil = AppContext.getDbUtil();
        if (dbUtil.count(Clazz.class) > 0) {
            dbUtil.deleteAll(Clazz.class);
        }

        if (dbUtil.count(FriendClass.class) > 0) {
            dbUtil.deleteAll(FriendClass.class);
        }


        // 伴随就是查的动作
        LogUtil.e("delteAction"+dbUtil.count(Clazz.class));

    }


    public static void testRoom(Context context) {

        // 单例设计模式 TODO  因为每个Roomdatabase实例都相当消耗性能，并且您很少需要访问多个实例。
        AppDatabase db = Room.databaseBuilder(AppContext.context(),
                AppDatabase.class, "testRoomDb").build();
    }


    public static void testDbFlowAdd() {
        /*FlowManager.init(FlowConfig.builder()
                .addDatabaseConfig(DatabaseConfig.builder(AppDatabase.class)
                        .databaseName("AppDatabase")
                        .build())
                .build());*/

        // 单次保存
        User2Model userModel=new User2Model();
        userModel.setName("UserModel");
        userModel.setAge(new Random().nextInt(100));
        userModel.save();



        // 批量保存（批量保存）
        FlowManager.getDatabase(AppDataBase.class).beginTransactionAsync(new ITransaction() {
            @Override
            public void execute(DatabaseWrapper databaseWrapper) {
                for (int i=0;i<100;i++){
                    User2Model userModel=new User2Model();
                    userModel.setName("UserModel");
                    userModel.setAge(new Random().nextInt(100));
                    userModel.save(databaseWrapper);
                }
            }
        }).success(new Transaction.Success() {
            @Override
            public void onSuccess(@NonNull Transaction transaction) {
                Log.e("批量保存","onSuccess()");
            }
        }).error(new Transaction.Error() {
            @Override
            public void onError(@NonNull Transaction transaction, @NonNull Throwable error) {
                Log.e("批量保存","onError()");
            }
        }).build().execute();

        //userModel.update();
        //userModel.delete();
    }


    public static void testDbFlowSearch() {
        From<User2Model> user2ModelFrom = SQLite.select().from(User2Model.class);

        List<User2Model> user2Models1 = user2ModelFrom.queryList();


//        List<User2Model> user2Models= user2ModelFrom.where(User2Model_Table.age.greaterThan(18),User2Model_Table.name.eq("UserModel"))
//                .orderBy(OrderBy.fromNameAlias(NameAlias.of("id")))
//                .groupBy(NameAlias.of("id"))
//                .queryList();
//        if (user2Models.size()!=0){
//            for (User2Model user2Model:user2Models){
//                LogUtil.e("DBFLOW","id="+user2Model.getId()+",name="+user2Model.getName()+",age="+user2Model.getAge());
//            }
//        }else{
//            LogUtil.e("DBFLOW"+"为空");
//        }
    }
}
