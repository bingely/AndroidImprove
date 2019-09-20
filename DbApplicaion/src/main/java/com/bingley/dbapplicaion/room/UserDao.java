package com.bingley.dbapplicaion.room;

import android.arch.persistence.room.Dao;

/**
 * @author bingley
 * @date 2019/9/20.
 */
@Dao
public interface UserDao {
    /*@Query("SELECT * FROM user")
    List<User> getAll();

    @Query("SELECT * FROM user WHERE uid IN (:userIds)")
    List<User> loadAllByIds(int[] userIds);

    @Query("SELECT * FROM user WHERE first_name LIKE :first AND "
            + "last_name LIKE :last LIMIT 1")
    User findByName(String first, String last);

    @Insert
    void insertAll(User... users);

    @Delete
    void delete(User user);*/
}
