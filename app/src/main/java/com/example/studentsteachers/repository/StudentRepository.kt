package com.example.studentsteachers.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.room.Query
import com.example.studentsteachers.database.StudentDao
import com.example.studentsteachers.model.StudentModel
import com.example.studentsteachers.model.StudentTeacher
import com.example.studentsteachers.model.TeacherModel

class StudentRepository(private val dataSourse:StudentDao) {

    private val TAG="StudentRepository"
    suspend fun insertStudent(student: StudentModel){
        dataSourse.insertStudent(student)
    }

    fun getAlpha():LiveData<List<StudentModel>>{
        Log.d(TAG, "getAlpha: $dataSourse")
        return  dataSourse.getAlphabetizad()
    }
    fun getLeftJoin():LiveData<List<StudentTeacher>>{
        Log.d(TAG, "getLeftJoin:$dataSourse ")
        return dataSourse.getLeftJoin()

    }


}