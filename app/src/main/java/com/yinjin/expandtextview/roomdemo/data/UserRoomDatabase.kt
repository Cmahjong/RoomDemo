package com.yinjin.expandtextview.roomdemo.data

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.yinjin.expandtextview.roomdemo.bean.User
import com.yinjin.expandtextview.roomdemo.dao.UserDao

/**
 * desc:
 * time: 2018/5/28
 * @author yinYin
 */
@Database(entities = [(User::class)], version = 1,exportSchema = false)
abstract class UserRoomDatabase:RoomDatabase() {

    abstract fun userDao(): UserDao

companion object {
    private var INSTANCE: UserRoomDatabase? = null
    fun getDatabase(context: Context): UserRoomDatabase {
        if (INSTANCE == null) {
            synchronized(UserRoomDatabase::class.java) {
                if (INSTANCE == null) {
                    INSTANCE=Room.databaseBuilder(context,UserRoomDatabase::class.java,"user_room").allowMainThreadQueries().build()
                }
            }
        }
        return INSTANCE!!
    }

}

}