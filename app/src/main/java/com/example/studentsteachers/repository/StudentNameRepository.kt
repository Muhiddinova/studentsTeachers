package com.example.studentsteachers.repository

import androidx.lifecycle.LiveData
import com.example.studentsteachers.database.StudentDao
import com.example.studentsteachers.model.StudentModel

class StudentNameRepository(private val dataSourseName:StudentDao) {

    fun getStudentName(): LiveData<List<StudentModel>> {
        return dataSourseName.getStudentName()
    }
    suspend fun updateStudentTechId(studentId: Int,techId: Int){
        dataSourseName.updateStudentTechId(studentId,techId)
    }

}