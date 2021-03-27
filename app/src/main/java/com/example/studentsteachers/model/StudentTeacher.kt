package com.example.studentsteachers.model

import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity(tableName = "studentTeacher")
data class StudentTeacher (

    val studentName:String="",
    val studentAge:Int=0,
    val course:String="",
    val faculty:String="",
    val teacherName:String?,
    val subject:String?,
    var techId:Int= -1,
    @PrimaryKey(autoGenerate = true)
    val id:Int=0
)