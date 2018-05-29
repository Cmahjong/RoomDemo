package com.yinjin.expandtextview.roomdemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.yinjin.expandtextview.roomdemo.bean.User
import com.yinjin.expandtextview.roomdemo.dao.UserDao
import com.yinjin.expandtextview.roomdemo.data.RoomHelper
import com.yinjin.expandtextview.roomdemo.data.UserRoomDatabase
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.launch

class MainActivity : AppCompatActivity() {
    private val userDao:UserDao by lazy {
        UserRoomDatabase.getDatabase(this).userDao()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
            async {
                userDao.insert(User(1,"姓名1"))
                userDao.insert(User(2,"姓名2"))
                userDao.insert(User(3,"姓名3"))
                userDao.insert(User(4,"姓名4"))
                userDao.insert(User(5,"姓名5"))
                userDao.insert(User(6,"姓名6"))
            }
        button.setOnClickListener {
            launch(UI) {
                val async = async { this@MainActivity.userDao.findUser(1).name }
                tv_name.text=async.await()?:""
            }

        }
        button2.setOnClickListener {
            launch(UI) {
                val async = async { this@MainActivity.userDao.findAllUser()[2].name }
                tv_name.text=async.await()?:""
            }
        }
        button3.setOnClickListener {
            async {
                userDao.deleteAll()
            }

        }
        button4.setOnClickListener {
            async {
                userDao.delete(3)
            }

        }
    }
}
