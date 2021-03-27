package com.example.studentsteachers.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.studentsteachers.model.TeacherModel

@Dao
interface TeacherDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTeacher(teacherModel: TeacherModel):Long

    @Query("Select * from teacher ORDER BY teacherName ASC")
    fun getAlphabetizadTeacher(): LiveData<List<TeacherModel>>



}