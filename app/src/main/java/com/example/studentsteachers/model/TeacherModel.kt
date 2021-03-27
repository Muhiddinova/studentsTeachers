package com.example.studentsteachers.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName="teacher")
data class TeacherModel (

        val teacherName:String="",
        val teacherAge:Int=0,
        val subject:String="",
        @PrimaryKey(autoGenerate = true)
        val teacherId: Int = 0

        )
