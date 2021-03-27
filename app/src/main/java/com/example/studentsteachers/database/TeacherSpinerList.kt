package com.example.studentsteachers.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.studentsteachers.model.StudentModel
import com.example.studentsteachers.model.StudentTeacher

@Dao
interface TeacherSpinerList {

    @Query("Select * from student where techId =0")
    fun getStudentName():LiveData<List<StudentModel>>

}