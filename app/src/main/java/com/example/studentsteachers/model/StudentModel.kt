package com.example.studentsteachers.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName="student")
data class StudentModel(


    val studentName: String = "",
    val studentAge: Int = 0,
    val course: String = "",
    val faculty: String = "",
    var techId: Int = -1,
    @PrimaryKey(autoGenerate = true)
    val studentId: Int=0
)

