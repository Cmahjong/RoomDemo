package com.yinjin.expandtextview.roomdemo.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.yinjin.expandtextview.roomdemo.bean.User

/**
 * desc:注意标
 * time: 2018/5/28
 * @author yinYin
 */
@Dao
interface UserDao {
    @Insert
    fun insert(user: User)

    @Query("DELETE FROM USER")
    fun deleteAll()

    @Query("DELETE FROM USER WHERE id=:id")
    fun delete(id: Long)

    @Query("SELECT * FROM USER")
    fun findAllUser():List<User>

    @Query("SELECT * FROM USER WHERE id=:id")
    fun findUser(id: Long):User
}