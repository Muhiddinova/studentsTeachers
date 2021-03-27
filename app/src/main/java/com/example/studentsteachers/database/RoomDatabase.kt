package com.example.studentsteachers.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import com.example.studentsteachers.model.StudentModel
import com.example.studentsteachers.model.StudentTeacher
import com.example.studentsteachers.model.TeacherModel


@Database(
    entities = [
        StudentModel::class,
        TeacherModel::class], version = 2, exportSchema = false
)
abstract class RoomDatabase : androidx.room.RoomDatabase() {
    abstract val studentDao:StudentDao
    abstract val teacherDao:TeacherDao
    abstract val teacherSpinerList:TeacherSpinerList

    companion object{
        private var INSTANCE: RoomDatabase? = null
        fun getDatabase(context: Context): RoomDatabase{
            if ( INSTANCE!=null){
                return INSTANCE!!
            }
            synchronized(this){
                val database=Room.databaseBuilder(context,RoomDatabase::class.java,"Student")
                    .build()
                INSTANCE=database
                return INSTANCE!!
            }
        }
    }


}
