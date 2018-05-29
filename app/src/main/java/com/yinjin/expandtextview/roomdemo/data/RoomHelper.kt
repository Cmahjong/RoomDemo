package com.yinjin.expandtextview.roomdemo.data

import android.arch.persistence.room.Room
import android.content.Context

/**
 * desc:
 * time: 2018/5/28
 * @author yinYin
 */
object RoomHelper {
    fun getDatabase(context: Context): UserRoomDatabase = Room.databaseBuilder(context, UserRoomDatabase::class.java, "user_room").build()
}