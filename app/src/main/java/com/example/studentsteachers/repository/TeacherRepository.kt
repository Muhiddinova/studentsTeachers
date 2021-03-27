package com.example.studentsteachers.repository

import androidx.lifecycle.LiveData
import com.example.studentsteachers.database.TeacherDao
import com.example.studentsteachers.database.TeacherSpinerList
import com.example.studentsteachers.model.StudentModel
import com.example.studentsteachers.model.TeacherModel

class TeacherRepository(private val dataSourse:TeacherDao) {
    suspend fun insertTeacher(teacher:TeacherModel): Long {
        return dataSourse.insertTeacher(teacher)
    }
    fun getTeacher():LiveData<List<TeacherModel>>{
        return dataSourse.getAlphabetizadTeacher()
    }

}