# RoomDemo
RoomDemo
Entity的参数 foreignKeys
因为SQLite是一个关系型数据库，你可以指定对象之间的关系。尽管大多数ORM库允许实体对象相互引用，但Room明确禁止。实体之间没有对象引用。

不能使用直接关系，所以就要用到foreignKeys（外键）。

@Entity(foreignKeys = @ForeignKey(entity = User.class,
                                  parentColumns = "id",
                                  childColumns = "user_id"))
class Book {
    @PrimaryKey
    public int bookId;

    public String title;

    @ColumnInfo(name = "user_id")
    public int userId;
}

导入
    implementation "android.arch.persistence.room:runtime:$room_version"
    annotationProcessor "android.arch.persistence.room:compiler:$room_version"
    kapt "android.arch.persistence.room:compiler:$room_version"
    implementation "org.jetbrains.anko:anko:0.10.5"
    implementation 'org.jetbrains.kotlinx:kotlinx-coroutines-core:0.22.5'
    
    最后两个依赖是用于做kotlin协程的
    
    基本就是很简单的 Bean->Dao ->DataBase 就ok了
    
